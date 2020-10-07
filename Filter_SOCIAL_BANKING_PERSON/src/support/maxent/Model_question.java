package maxent;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;


public class Model_question {
	private static BufferedReader ques;
	private static BufferedReader no_ques;
	public static GISModel model_question(String file_question,String file_no_question,String tag_quest,String tag_no_quest) throws IOException {
		String line, line1;
		Collection<Learning> List = new ArrayList<Learning>();
		ques = new BufferedReader(new InputStreamReader(
				new FileInputStream(file_question)));	
		no_ques = new BufferedReader(new InputStreamReader(
				new FileInputStream(file_no_question)));
		while ((line = ques.readLine()) != null ) {
			List.add(new Learning(tag_quest,line));
		}
		while ((line1 = no_ques.readLine()) != null ) {
			List.add(new Learning(tag_no_quest,line1));
		}
		PlainTextEventStream stream = new PlainTextEventStream(List);
		//trainModel(EventStream eventStream, int iterations, int cutoff, boolean smoothing, boolean printMessagesWhileTraining) 
		GISModel model = GIS.trainModel(stream, 200, 1,true, false);		
		return model;
	}
}
