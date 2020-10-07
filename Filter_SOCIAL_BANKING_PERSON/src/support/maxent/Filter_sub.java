package maxent;

import static maxent.PlainTextEventStream_sub.buildContext_2gram;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

import opennlp.maxent.GISModel;

public class Filter_sub {
	public static int check_sub(GISModel model, String s,ArrayList<String>sentiment_word)
			throws IOException, InterruptedException {
		String nor = Normalizer.normalize(s, Normalizer.Form.NFC);
		int check =0;
		for(int i=0;i<sentiment_word.size();i++){
			if(nor.toLowerCase().indexOf(sentiment_word.get(i))>=0){
				check = check+1;
				System.out.println(sentiment_word.get(i));
				break;
			}
			
		}	
		double[] result = model.eval(buildContext_2gram(nor));
		String Output = model.getBestOutcome(result);
		if(Output.indexOf("1")>=0){
			check=check+1;
		}
		return check;
	}
}
