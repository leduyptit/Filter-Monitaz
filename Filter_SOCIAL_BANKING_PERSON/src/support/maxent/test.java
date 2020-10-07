package maxent;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import opennlp.maxent.io.SuffixSensitiveGISModelReader;

import org.testng.annotations.Test;

import remove_vietnamese.AccentRemover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
public class test {
	private static BufferedReader in;
	private static BufferedReader in1;
	private static BufferedReader in2;
	private static BufferedReader in3;
	private static BufferedReader in4;
	@Test
	public static   void main(String[] args) throws IOException, InterruptedException {
		String line, line1,line2,line3,line4;
		Collection<Learning> additionalList = new ArrayList<Learning>();

		in2 = new BufferedReader(new InputStreamReader(
				new FileInputStream("trainsub/sentimentword.txt")));		
		in4 = new BufferedReader(new InputStreamReader(
				new FileInputStream("trainsub/test.txt")));
		
		ArrayList<String> sentiment_word = new ArrayList<String>();
		while ((line2 = in2.readLine()) != null ) {
			 String nor = Normalizer.normalize(line2, Normalizer.Form.NFC);
			sentiment_word.add(nor);
		}
		
//		GISModel model = Model_sub.model_sub("trainsub/sentiment.txt","trainsub/nosentiment.txt","1", "0");
		GISModel model = (GISModel) new SuffixSensitiveGISModelReader(new File("trainsub/model_sub.bin.gz")).getModel();
		while ((line4 = in4.readLine()) != null ) {
		
			System.out.println(Filter_sub.check_sub(model,line4,sentiment_word));
		}
	
	
	}
}
