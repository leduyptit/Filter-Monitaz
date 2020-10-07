package maxent;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import static maxent.PlainTextEventStream.buildContext;

public class Classifier {
	private static BufferedReader in;
	private static BufferedReader in1;
	private static BufferedReader in2;
	private static BufferedReader in3;
	private static BufferedReader in4;
	@Test
	public static   void main(String[] args) throws IOException {
		String line, line1,line2,line3,line4;
		Collection<Learning> additionalList = new ArrayList<Learning>();
//		in = new BufferedReader(new InputStreamReader(
//				new FileInputStream("ques.txt")));	
//		in1 = new BufferedReader(new InputStreamReader(
//				new FileInputStream("noques.txt")));
//		in2 = new BufferedReader(new InputStreamReader(
//				new FileInputStream("ques_.txt")));

		in = new BufferedReader(new InputStreamReader(
				new FileInputStream("ratlienquan.txt")));	
		in1 = new BufferedReader(new InputStreamReader(
				new FileInputStream("lienquan.txt")));
		in2 = new BufferedReader(new InputStreamReader(
				new FileInputStream("lienquanmotchut.txt")));	
		in3 = new BufferedReader(new InputStreamReader(
				new FileInputStream("khonglienquan.txt")));	
		
		
		in4 = new BufferedReader(new InputStreamReader(
				new FileInputStream("ques.txt")));
		
		while ((line = in.readLine()) != null ) {
			additionalList.add(new Learning("rat lien quan",line));
		}
		while ((line1 = in1.readLine()) != null ) {
			additionalList.add(new Learning("lien quan",line1));
		}
		while ((line2 = in2.readLine()) != null ) {
			additionalList.add(new Learning("lien quan mot chut",line2));
		}
		while ((line3 = in3.readLine()) != null ) {
			additionalList.add(new Learning("khong lien quan",line3));
		}
		PlainTextEventStream stream = new PlainTextEventStream(additionalList);
		//trainModel(EventStream eventStream, int iterations, int cutoff, boolean smoothing, boolean printMessagesWhileTraining) 
		GISModel model = GIS.trainModel(stream, 1000, 1,true, false);
		while ((line4 = in4.readLine()) != null ) {
		double[] result = model.eval(buildContext(line4));
		String bestOutcome = model.getBestOutcome(result);
		System.out.println(bestOutcome);
	}}
}
