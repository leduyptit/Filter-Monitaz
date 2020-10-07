package NaiveBayes_data_order;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	public class Document {

		public Map<String, Integer> tokens;

		public String category;

		public Document() {
			tokens = new HashMap<>();
		}

	}

	public class FeatureStats {

		public int n;

		public Map<String, Map<String, Integer>> featureCategoryCount;

		public Map<String, Integer> categoryCounts;

		public FeatureStats() {
			n = 0;
			featureCategoryCount = new HashMap<>();
			categoryCounts = new HashMap<>();
		}
	}

	public class NaiveBayesModel {

		public int n = 0;

		public int c = 0;

		public int d = 0;

		public Map<String, Double> logPriors = new HashMap<>();

		public Map<String, Map<String, Double>> logLikelihoods = new HashMap<>();
	}
}
