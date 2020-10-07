package NaiveBayes_order;

import NaiveBayes_data_order.Document;
import NaiveBayes_data_order.FeatureStats;
import NaiveBayes_data_order.NaiveBayesModel;
import NaiveBayes_features_order.FeatureSelection;
import NaiveBayes_features_order.TextTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NaiveBayes {
	private double  Critical_values = 10.83;

	private NaiveBayesModel model;

	public NaiveBayes(NaiveBayesModel model) {
		this.model = model;
	}

	public NaiveBayes() {
		this(null);
	}

	public NaiveBayesModel getmodel() {
		return model;
	}

	public double getCriticalValue() {
		return Critical_values;
	}

	public void setCriticalValue(double  Critical_values) {
		this. Critical_values =  Critical_values;
	}

	private List<Document> preprocessDataset(
			Map<String, String[]> trainingDataset) {
		List<Document> dataset = new ArrayList<>();

		String category;
		String[] text;
		
		Document doc;

		Iterator<Map.Entry<String, String[]>> it = trainingDataset.entrySet()
				.iterator();

		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = it.next();
			category = entry.getKey();
			text = entry.getValue();

			for (int i = 0; i < text.length; ++i) {
				doc = TextTokenizer.tokenize(text[i]);
				doc.category = category;
				dataset.add(doc);
			}
		}
		
		return dataset;
	}

	private FeatureStats selectFeatures(List<Document> dataset) throws IOException {
		FeatureSelection featureExtractor = new FeatureSelection();

		FeatureStats stats = featureExtractor.extractFeatureStats(dataset);

//		Map<String, Double> selectedFeatures = featureExtractor.chisquare(
	//			stats, Critical_values);
		//Đọc từ file model có sẵn
		Map<String, Double> selectedFeatures = featureExtractor.chisquare1(
			);

		Iterator<Map.Entry<String, Map<String, Integer>>> it = stats.featureCategoryCount
				.entrySet().iterator();
		while (it.hasNext()) {
			String feature = it.next().getKey();
			if (selectedFeatures.containsKey(feature) == false) {

				it.remove();
			}
		}

		return stats;
	}

	public void train(Map<String, String[]> trainingDataset,
			Map<String, Double> categoryPriors) throws IllegalArgumentException, IOException {
		List<Document> dataset = preprocessDataset(trainingDataset);

		FeatureStats featureStats = selectFeatures(dataset);

		model = new NaiveBayesModel();
		model.n = featureStats.n;
		model.d = featureStats.featureCategoryCount.size();

		if (categoryPriors == null) {

			model.c = featureStats.categoryCounts.size();
			model.logPriors = new HashMap<>();

			String category;
			int count;
			for (Map.Entry<String, Integer> entry : featureStats.categoryCounts
					.entrySet()) {
				category = entry.getKey();
				count = entry.getValue();

				model.logPriors.put(category,
						Math.log((double) count / model.n));
			}
		} else {

			model.c = categoryPriors.size();

			if (model.c != featureStats.categoryCounts.size()) {
				throw new IllegalArgumentException(
						"model invalid.");
			}

			String category;
			Double priorProbability;
			for (Map.Entry<String, Double> entry : categoryPriors.entrySet()) {
				category = entry.getKey();
				priorProbability = entry.getValue();
				if (priorProbability == null) {
					throw new IllegalArgumentException(
							"Probability invalid");
				} else if (priorProbability < 0 || priorProbability > 1) {
					throw new IllegalArgumentException(
							"Probability invalid");
				}

				model.logPriors.put(category,
						Math.log(priorProbability));
			}
		}

		Map<String, Double> featureOccurrencesInCategory = new HashMap<>();

		Integer occurrences;
		Double featureOccSum;
		for (String category : model.logPriors.keySet()) {
			featureOccSum = 0.0;
			for (Map<String, Integer> categoryListOccurrences : featureStats.featureCategoryCount
					.values()) {
				occurrences = categoryListOccurrences.get(category);
				if (occurrences != null) {
					featureOccSum += occurrences;
				}
			}
			featureOccurrencesInCategory.put(category, featureOccSum);
			
		}

		String feature;
		Integer count;
		Map<String, Integer> featureCategoryCounts;
		double logLikelihood;
		for (String category : model.logPriors.keySet()) {
			for (Map.Entry<String, Map<String, Integer>> entry : featureStats.featureCategoryCount
					.entrySet()) {
				feature = entry.getKey();
				featureCategoryCounts = entry.getValue();
				//Feature
//				System.out.println("feature  : "+feature);
				count = featureCategoryCounts.get(category);
				if (count == null) {
					count = 0;
				}

				logLikelihood = Math
						.log((count + 1.0)
								/ (featureOccurrencesInCategory.get(category) + model.d));
				if (model.logLikelihoods.containsKey(feature) == false) {
					model.logLikelihoods.put(feature,
							new HashMap<String, Double>());
				}
				model.logLikelihoods.get(feature).put(category,
						logLikelihood);
				//category+lokelikehood
//				System.out.println("category  : "+model.logLikelihoods.get(feature));
				
			}
		}
		
		featureOccurrencesInCategory = null;
	}


	public void train(Map<String, String[]> trainingDataset) throws IllegalArgumentException, IOException {
		train(trainingDataset, null);
	}

	public String predict(String text) throws IllegalArgumentException {
		if (model == null) {
			throw new IllegalArgumentException(
					"Need training model.");
		}

		Document doc = TextTokenizer.tokenize(text);
//		System.out.println(doc.tokens);

		String category;
		String feature;
		Integer occurrences;
		Double logprob;

		String maxScoreCategory = null;
		Double maxScore = Double.NEGATIVE_INFINITY;


		for (Map.Entry<String, Double> entry1 : model.logPriors
				.entrySet()) {
			category = entry1.getKey();
			logprob = entry1.getValue();

			for (Map.Entry<String, Integer> entry2 : doc.tokens.entrySet()) {
				feature = entry2.getKey();

				if (!model.logLikelihoods.containsKey(feature)) {
					continue;
				}
//				System.out.println("feature :"+feature);
				occurrences = entry2.getValue();

				logprob += occurrences
						* model.logLikelihoods.get(feature).get(
								category);
//				System.out.println("loglike :"+logprob);
			}

			if (logprob > maxScore) {
				maxScore = logprob;
				maxScoreCategory = category;
			}
		}

		return maxScoreCategory;
	}
}
