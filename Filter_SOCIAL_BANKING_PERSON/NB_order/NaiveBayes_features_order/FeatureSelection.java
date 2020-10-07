package NaiveBayes_features_order;

import NaiveBayes_data_order.Document;
import NaiveBayes_data_order.FeatureStats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeatureSelection {

	public FeatureStats extractFeatureStats(List<Document> dataset) {
		FeatureStats stats = new FeatureStats();

		Integer categoryCount;
		String category;
		Integer featureCategoryCount;
		String feature;
		Map<String, Integer> featureCategoryCounts;
		for (Document doc : dataset) {
			++stats.n;
			category = doc.category;
			categoryCount = stats.categoryCounts.get(category);
			if (categoryCount == null) {
				stats.categoryCounts.put(category, 1);
			} else {
				stats.categoryCounts.put(category, categoryCount + 1);
			}

			for (Map.Entry<String, Integer> entry : doc.tokens.entrySet()) {
				feature = entry.getKey();
				featureCategoryCounts = stats.featureCategoryCount
						.get(feature);
				if (featureCategoryCounts == null) {

					stats.featureCategoryCount.put(feature,
							new HashMap<String, Integer>());
				}

				featureCategoryCount = stats.featureCategoryCount.get(
						feature).get(category);
				if (featureCategoryCount == null) {
					featureCategoryCount = 0;
				}

				stats.featureCategoryCount.get(feature).put(category,
						++featureCategoryCount);
			}
		}
		

		return stats;
	}

	public Map<String, Double> chisquare(FeatureStats stats,
			double criticalLevel) throws IOException {
		Map<String, Double> selectedFeatures = new HashMap<>();

		String feature;
		String category;
		Map<String, Integer> categoryList;

		int N1dot, N0dot, N00, N01, N10, N11;
		double chisquareScore;
		Double previousScore;
		 FileWriter fw = new FileWriter("trainsub/model", true);
	        BufferedWriter bw = new BufferedWriter(fw);
		for (Map.Entry<String, Map<String, Integer>> entry1 : stats.featureCategoryCount
				.entrySet()) {
			feature = entry1.getKey();
			categoryList = entry1.getValue();
			N1dot = 0;
			for (Integer count : categoryList.values()) {
				N1dot += count;
			}
				// N1 : số record có đặc trưng này 
			N0dot = stats.n - N1dot;
				// N0 : số lượng record không có đặc trưng này
			for (Map.Entry<String, Integer> entry2 : categoryList.entrySet()) {
				category = entry2.getKey();
					// Tập nhãn  : 1 và 0
				N11 = entry2.getValue();
					// N11 : số lượng các record có đặc trưng này và có nhãn 1				
				N01 = stats.categoryCounts.get(category) - N11;
					// N01 : số lượng các record không có đặc trưng này và có nhãn 1
				N00 = N0dot - N01;
					// N00 : số lượng các record không có đặc trưng này và có nhãn 0				
				N10 = N1dot - N11;
					// N10 : số lượng các record có đặc trưng này và có nhãn 0
				chisquareScore = stats.n
						* Math.pow(N11 * N00 - N10 * N01, 2)
						/ ((N11 + N01) * (N11 + N10) * (N10 + N00) * (N01 + N00));

				if (chisquareScore >= criticalLevel) {
					previousScore = selectedFeatures.get(feature);
//					System.out.println(feature);
					if (previousScore == null || chisquareScore > previousScore) {
						if(feature.length()>=3){
						selectedFeatures.put(feature, chisquareScore);
						bw.write(feature+":"+chisquareScore);
//						bw.write(feature);
						bw.write("\n");}
					}
				}
			}
		}
		bw.close();
		fw.close();
/*		int size=0;
 * Dược phẩm sẽ dùng thêm cái này
		 System.out.println(selectedFeatures.size());
		ArrayList<String> ab=new ArrayList<String>();
		for(String a : selectedFeatures.keySet()){
		for(String b : selectedFeatures.keySet()){
			if(a.compareTo(b)!=0 && a.indexOf(b)>=0){
				if(selectedFeatures.get(a)>selectedFeatures.get(b)){
				ab.add(b);
				
				}
			}
			
		}
		}
		for(int i=0;i<ab.size();i++){
			selectedFeatures.remove(ab.get(i));
//			System.out.println(ab.get(i));
		}
*/

		return selectedFeatures;
	}
	
	public Map<String, Double> chisquare1() throws IOException {
		Map<String, Double> selectedFeatures = new HashMap<>();
		String feature;
		double chisquareScore;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("/root/Filter/tvplusfilter/nb/model_order"), "UTF-8"));
		String line;
		while ((line = in.readLine()) != null ) {
			feature=line.split(":")[0];
			chisquareScore=Double.parseDouble(line.split(":")[1]);
			if(feature.length()>=3){
			selectedFeatures.put(feature, chisquareScore);}
		}
		in.close();

		return selectedFeatures;
	}
}
