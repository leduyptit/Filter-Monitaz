package NaiveBayes_main_order;

import NaiveBayes_data_order.NaiveBayesModel;
import NaiveBayes_order.NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayesExample_Recommend {

	public static String[] readLines(URL url) throws IOException {

		Reader fileReader = new InputStreamReader(url.openStream(), "UTF-8");
		List<String> lines;
		try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			lines = new ArrayList<>();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
		}
		return lines.toArray(new String[lines.size()]);
	}

	public static String[] readLines1(String url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(url), "UTF-8"));
		List<String> lines;

		lines = new ArrayList<>();
		String line;
		while ((line = in.readLine()) != null) {
			lines.add(line);

		}
		return lines.toArray(new String[lines.size()]);
	}

	public static void main(String[] args) throws IOException {
		// map of dataset files
		Map<String, URL> trainingFiles = new HashMap<>();
		Map<String, String[]> trainingExamples = new HashMap<>();
		trainingExamples.put("sub", readLines1("train_duocpham/sub.txt"));
		trainingExamples.put("non-sub", readLines1("train_duocpham/nosub.txt"));
		
//		trainingExamples.put("spam", readLines1("trainspam/spam.txt"));
//		trainingExamples.put("non-spam", readLines1("trainspam/nonspam.txt"));
		
		NaiveBayes nb = new NaiveBayes();
		nb.setCriticalValue(2.74); // 0.01 pvalue
		nb.train(trainingExamples);

		// get trained classifier knowledgeBase
		NaiveBayesModel knowledgeBase = nb.getmodel();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("train_duocpham/test.txt"), "UTF-8"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("model/out_spam.txt"), "UTF-8"));
		String s;
		String s2, s3, s4;
		
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new FileInputStream("train_duocpham/sentimentword.txt")));
		ArrayList<String> sentiment_word = new ArrayList<String>();
		String line2;
		while ((line2 = in2.readLine()) != null ) {
			 String nor = Normalizer.normalize(line2, Normalizer.Form.NFC);
			sentiment_word.add(nor);
		
		}
		nb = null;
		trainingExamples = null;
		// Use classifie
		nb = new NaiveBayes(knowledgeBase);
		
		while ((s = in.readLine()) != null) {
			
			 String nor = Normalizer.normalize(s, Normalizer.Form.NFC);
			int check=0;
			for(int i=0;i<sentiment_word.size();i++){
				if(nor.toLowerCase().indexOf(sentiment_word.get(i))>=0){
					System.out.println("Sentiment");
					check=check+1;
					break;
				}
				
			}
			if(check==0){
			System.out.println(nb.predict(s));}
		}
			// String exampleEn = "ládsagasdada";
			// String outputEn = nb.predict(exampleEn);

			
		
		out.close();
		in.close();

	}

	public static NaiveBayesModel model_tag() throws IOException {
		Map<String, String[]> trainingSpam = new HashMap<>();

		trainingSpam
				.put("7",
						readLines1("/root/Filter/tvplusfilter/train/dulieunonspam.txt"));
		trainingSpam.put("3",
				readLines1("/root/Filter/tvplusfilter/train/congrat.txt"));
		// trainingSpam.put("7", readLines1("train/dulieunonspam.txt"));
		// trainingSpam.put("3", readLines1("train/congrat.txt"));
		// trainingSpam.put("5", readLines1("/train/order.txt"));
		// trainingSpam.put("8", readLines1("/train/recom.txt"));

		NaiveBayes nb = new NaiveBayes();
		nb.setCriticalValue(6.63); // 0.01 pvalue
		nb.train(trainingSpam);

		// get trained classifier knowledgeBase
		NaiveBayesModel knowledgeBase = nb.getmodel();
		return knowledgeBase;

	}

	public static NaiveBayesModel model_spam() throws IOException {
		Map<String, String[]> trainingSpam = new HashMap<>();

		trainingSpam.put("1",
				readLines1("/root/Filter/tvplusfilter/dulieuspam.txt"));
		trainingSpam.put("0",
				readLines1("/root/Filter/tvplusfilter/dulieunonspam.txt"));
		// trainingSpam.put("1", readLines1("train/dulieuspam.txt"));
		// trainingSpam.put("0", readLines1("train/dulieunonspam.txt"));
		NaiveBayes nb = new NaiveBayes();
		nb.setCriticalValue(10.84); // 0.01 pvalue
		nb.train(trainingSpam);

		// get trained classifier knowledgeBase
		NaiveBayesModel knowledgeBase = nb.getmodel();
		return knowledgeBase;
		// Use classifie
		// nb = new NaiveBayes(knowledgeBase);

		// String exampleEn = "ládsagasdada";
		// String outputEn = nb.predict(exampleEn);
	}

	public static int check_spam(NaiveBayesModel knowledgeBase, String s)
			throws IOException {
		int check = 0;
		NaiveBayes nb = new NaiveBayes();
		nb = new NaiveBayes(knowledgeBase);
		if (nb.predict(s).equalsIgnoreCase("1")) {
			check = 1;
		} else {
			check = 0;
		}
		return check;
	}

	public static int check_tag(NaiveBayesModel knowledgeBase, String s)
			throws IOException {
		int check = 0;
		NaiveBayes nb = new NaiveBayes();
		nb = new NaiveBayes(knowledgeBase);
		if (nb.predict(s).equalsIgnoreCase("8")) {
			check = 8;
		}
		if (nb.predict(s).equalsIgnoreCase("5")) {
			check = 5;
		}
		if (nb.predict(s).equalsIgnoreCase("3")) {
			check = 3;
		}
		if (nb.predict(s).equalsIgnoreCase("7")) {
			check = 7;
		}
		return check;
	}
}
