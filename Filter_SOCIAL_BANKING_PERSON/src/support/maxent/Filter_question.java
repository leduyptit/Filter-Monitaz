package maxent;

import static maxent.PlainTextEventStream.buildContext;
import java.io.IOException;
import opennlp.maxent.GISModel;

public class Filter_question {
	public static String check_question(GISModel model, String s)
			throws IOException, InterruptedException {
		double[] result = model.eval(buildContext(s));
		String Output = model.getBestOutcome(result);
		return Output;
	}
}
