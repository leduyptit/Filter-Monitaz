package NaiveBayes_main_order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.Normalizer;
import java.util.ArrayList;

import NaiveBayes_data_order.NaiveBayesModel;
import NaiveBayes_order.NaiveBayes;

public class main {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		NaiveBayesModel knowledgeBase = NaiveBayesExample_order.model_order();
	//	NaiveBayes nb = new NaiveBayes();
	//	nb = null;
	//	nb = new NaiveBayes(knowledgeBase);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("trainspam/test.txt"), "UTF-8"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("model/out_spam.txt"), "UTF-8"));
		String s;
		String s2, s3, s4;
	
		while ((s = in.readLine()) != null) {
			
			System.out.println(NaiveBayesExample_order.check_order(knowledgeBase, s));
//			System.out.println(nb.predict(s));
			}

			// String exampleEn = "ládsagasdada";
			// String outputEn = nb.predict(exampleEn);	
		out.close();
		in.close();
		long end = System.currentTimeMillis();
		System.out.println(" time :"+(end-start));
	}
}
