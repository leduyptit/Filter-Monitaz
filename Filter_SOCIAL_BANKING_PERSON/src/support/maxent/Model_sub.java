package maxent;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import opennlp.maxent.io.SuffixSensitiveGISModelReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.io.File;


public class Model_sub {
	private static BufferedReader sub;
	private static BufferedReader no_sub;
	public static GISModel model_sub(String file_sub,String file_no_sub,String tag_sub,String tag_no_sub) throws IOException {
		String line, line1;
		Collection<Learning> List = new ArrayList<Learning>();
		sub = new BufferedReader(new InputStreamReader(
				new FileInputStream(file_sub)));	
		no_sub = new BufferedReader(new InputStreamReader(
				new FileInputStream(file_no_sub)));
		while ((line = sub.readLine()) != null ) {
			String nor = Normalizer.normalize(line, Normalizer.Form.NFC).replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
						.toLowerCase(Locale.getDefault());
			List.add(new Learning(tag_sub,nor));
		}
		while ((line1 = no_sub.readLine()) != null ) {
			String nor = Normalizer.normalize(line1, Normalizer.Form.NFC).replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
					.toLowerCase(Locale.getDefault());
			List.add(new Learning(tag_no_sub,nor));
		}
		PlainTextEventStream_sub stream = new PlainTextEventStream_sub(List);
		//trainModel(EventStream eventStream, int iterations, int cutoff, boolean smoothing, boolean printMessagesWhileTraining) 
		GISModel model = GIS.trainModel(stream, 300, 1,true, false);		
		return model;
	}
	public static GISModel model_sub_file() throws IOException{
		GISModel m = (GISModel) new SuffixSensitiveGISModelReader(new File("/root/Filter/tvplusfilter/maxent/model_sub.bin.gz")).getModel();
		return m;
	}
}
