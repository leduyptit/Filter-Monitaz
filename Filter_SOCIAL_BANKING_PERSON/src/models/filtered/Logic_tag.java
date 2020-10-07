package filtered;

import java.io.IOException;
import java.util.ArrayList;

import naivebayes_main.NaiveBayes_Test;
import object_service.Check_sentiment;
import rule.Check_order;
import rule.Check_question;
import rule.Check_recom;
import rule.Rule_congrat;
import NaiveBayes_data.NaiveBayesKnowledgeBase;
import NaiveBayes_data_order.NaiveBayesModel;
import NaiveBayes_features.TextTokenizer;
import NaiveBayes_main_order.NaiveBayesExample_order;
import util.Utils.Object;
import util.Utils.Service;

public class Logic_tag {
	public static int Filter_tag(String fb_message, String fb_from_name,
			String JSONResult_object_from_name, ArrayList<String> a,
			ArrayList<Object> object, ArrayList<Service> service,
			NaiveBayesKnowledgeBase model_tag,NaiveBayesModel order) throws IOException {
		int tag = 7;
		if (fb_message != null && fb_message.length() > 0) {
			if (tag == 9) {
				if (TextTokenizer.delete_http(fb_message).indexOf('?') < 0
						&& Check_question.check_question(fb_message, a) == 0) {
					tag = 7;
				}
			}
			if (Check_question.word_question(fb_message.toLowerCase()) == 1) {
				tag = 9;
			}

			if (TextTokenizer.delete_http(fb_message).indexOf('?') >= 0
					|| Check_question.check_question(fb_message, a) == 1) {
				tag = 9;
			}
//			if (JSONResult_object_from_name == null
//					&& Check_order.check_order(fb_message.toLowerCase()) == 1) {
//				tag = 5;
//			}
			if(NaiveBayesExample_order.check_order(order, fb_message)==1){
				tag = 5;
			}
			if(tag==5 && (Check_order.check_order(fb_message.toLowerCase()) != 1 || JSONResult_object_from_name != null)){
				tag=7;
			}
			if (JSONResult_object_from_name == null
					&& Check_recom.check_recom(fb_message.toLowerCase()) == 1) {
				tag = 8;
			}
			// Nếu là post thì cần kiểm tra lại xem có phải là question k

			if (tag != 9 && tag != 8 && tag != 5) {
				try {
					tag = NaiveBayes_Test.check_tag(model_tag, fb_message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (tag == 3) {
				if (JSONResult_object_from_name != null
						|| Rule_congrat.rule1_congrat(fb_message) == 1) {
					tag = 7;
				}
			}
			if (JSONResult_object_from_name == null
					&& Rule_congrat.rule2_congrat(fb_message) == 1) {
				tag = 3;
			}

			if (tag == 9
					&& (Check_sentiment.count_Text(fb_message) > 10 || fb_message
							.length() > 4000)) {
				tag = 7;
			}
		}
		return tag;
	}
}
