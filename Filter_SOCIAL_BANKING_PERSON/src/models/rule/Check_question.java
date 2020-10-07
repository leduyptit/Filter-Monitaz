package rule;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import remove_vietnamese.AccentRemover;

public class Check_question {

	public static int word_question(String fb_message) {
		int check = 0;
		if (fb_message.toLowerCase().indexOf("cho mình hỏi") >= 0
				|| fb_message.toLowerCase().indexOf("cho em hỏi") >= 0
				|| fb_message.toLowerCase().indexOf("cho minh hoi") >= 0
				|| fb_message.toLowerCase().indexOf("cho e hoi") >= 0
				|| fb_message.toLowerCase().indexOf("cho e hỏi") >= 0
				|| fb_message.toLowerCase().indexOf("xin hỏi") >= 0
				|| fb_message.toLowerCase().indexOf("fai lm sao") >= 0
				|| fb_message.toLowerCase().indexOf("làm thế nào") >= 0
				|| fb_message.toLowerCase().indexOf("vậy hả ") >= 0) {
			check=check+1;
		}
		return check;
	}
	public static int printText(String s, String character) {
		int count = 0;
		Pattern pattern = Pattern.compile(character);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			count++;
		}
		return count;
	}
	public static int check_question(String s,ArrayList<String> a){
		int check =0;
		for(int i=0;i<a.size();i++){
			String k=AccentRemover.removeAccent(a.get(i));
			String tmp=s.replaceAll("\\."," .").replaceAll("\\,"," ,").replaceAll("\\?"," ?").replaceAll("\\'"," '").toLowerCase();
			if(printText(tmp, a.get(i))>0 || printText(tmp, k)>0 ){
				check=check+1;
				break;
			}
		}
		return check;
		
	}
}
