package NaiveBayes_data_order;

import java.util.HashMap;
import java.util.Map;

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
