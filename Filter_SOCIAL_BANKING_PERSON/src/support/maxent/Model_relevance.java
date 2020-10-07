package maxent;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;


public class Model_relevance {
	private static BufferedReader relevance_1;
	private static BufferedReader relevance_3;
	private static BufferedReader relevance_5;
	private static BufferedReader relevance_7;
	public static GISModel model_relevance(String relevance1,String relevance3,String relevance5,String relevance7) throws IOException {
		String line1,line3,line5,line7;
		Collection<Learning> List = new ArrayList<Learning>();
		relevance_1 = new BufferedReader(new InputStreamReader(
				new FileInputStream(relevance1)));
		relevance_3 = new BufferedReader(new InputStreamReader(
				new FileInputStream(relevance3)));
		relevance_5 = new BufferedReader(new InputStreamReader(
				new FileInputStream(relevance5)));
		relevance_7 = new BufferedReader(new InputStreamReader(
				new FileInputStream(relevance7)));

		while ((line1 = relevance_1.readLine()) != null ) {
			List.add(new Learning("1",line1));
		}
		while ((line3 = relevance_3.readLine()) != null ) {
			List.add(new Learning("3",line3));
		}
		while ((line5 = relevance_5.readLine()) != null ) {
			List.add(new Learning("5",line5));
		}
		while ((line7 = relevance_7.readLine()) != null ) {
			List.add(new Learning("7",line7));
		}
		
		PlainTextEventStream stream = new PlainTextEventStream(List);
		//trainModel(EventStream eventStream, int iterations, int cutoff, boolean smoothing, boolean printMessagesWhileTraining) 
		GISModel model = GIS.trainModel(stream, 200, 1,true, false);		
		return model;
	}
}
