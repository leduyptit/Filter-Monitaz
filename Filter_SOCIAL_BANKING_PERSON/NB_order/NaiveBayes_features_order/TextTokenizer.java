package NaiveBayes_features_order;


import NaiveBayes_data_order.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import remove_vietnamese.AccentRemover;

public class TextTokenizer {

	public static String preprocess(String s) {
		s = s.replaceAll("[0-9\\-\\+\\.]{9,15}", " sdt ");
		s = s.replaceAll("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", " email ");
		s = s.replaceAll(
				"(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?",
				" website ");
		s = s.trim().replaceAll("\\s+", " ");
		return s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
				.toLowerCase(Locale.getDefault());
	}

	public static String[] extractKeywords(String text) {
		return text.split(" ");
	}

	public static Map<String, Integer> getKeywordCounts(String[] keywordArray) {
		Map<String, Integer> counts = new HashMap<>();

		Integer counter;
		for (int i = 0; i < keywordArray.length; ++i) {
			counter = counts.get(keywordArray[i]);
			if (counter == null) {
				counter = 0;
			}
			counts.put(keywordArray[i], ++counter); // increase counter for the
													// keyword
		}

		return counts;
	}
	public static Map<String, Integer> getKeywordCounts_2gram(String[] keywordArray) {
		Map<String, Integer> counts = new HashMap<>();

		Integer counter;
		for (int i = 0; i < keywordArray.length-1; ++i) {
			counter = counts.get((keywordArray[i]+" "+keywordArray[i+1]));
			if (counter == null) {
				counter = 0;
			}
			counts.put(keywordArray[i]+" "+keywordArray[i+1], ++counter);
			
			counter = counts.get((AccentRemover.removeAccent(keywordArray[i]))+" "+(AccentRemover.removeAccent(keywordArray[i+1])));
			if (counter == null) {
				counter = 0;
			}
			counts.put((AccentRemover.removeAccent(keywordArray[i]+" "+keywordArray[i+1])), ++counter);
			
		}
		for (int i = 0; i < keywordArray.length-2; ++i) {
			counter = counts.get(AccentRemover.removeAccent(keywordArray[i]+" "+keywordArray[i+1]+" "+keywordArray[i+2]));
			if (counter == null) {
				counter = 0;
			}
			counts.put(AccentRemover.removeAccent(keywordArray[i]+" "+keywordArray[i+1]+" "+keywordArray[i+2]), ++counter);
			
			counter = counts.get((keywordArray[i]+" "+keywordArray[i+1]+" "+keywordArray[i+2]));
			if (counter == null) {
				counter = 0;
			}
			counts.put(keywordArray[i]+" "+keywordArray[i+1]+" "+keywordArray[i+2], ++counter);
		}
		for (int i = 0; i < keywordArray.length; ++i) {
			counter = counts.get(keywordArray[i]);
			if (counter == null) {
				counter = 0;
			}
			counts.put(keywordArray[i], ++counter); 
		}

		return counts;
	}

	public static Document tokenize(String text) {
		String preprocessedText = preprocess(text);
		String[] keywordArray = extractKeywords(preprocessedText);
		Document doc = new Document();
//		doc.tokens = getKeywordCounts(keywordArray);
		doc.tokens = getKeywordCounts_2gram(keywordArray);
		
//		System.out.println(doc.tokens);
		return doc;
	}

	public static String delete_http(String s) {
		s = s.replaceAll("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", " email ");
		s = s.replaceAll(
				"(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?",
				" website ");
		return s;
	}

	public static void main(String[] args) throws IOException {
		String s = " #MS_Games MSI vui mừng thông báo Danh sách kết quả những người trúng thưởng minigame #THỬ_TÀI_CÙNG_Ô_CHỮ_MSI tuần trước với đáp án là MSTRADE. 👏 Xin chúc mừng các bạn có tên và link fb sau đây: 👏 🏆 Bạn Trang https://www.facebook.com/nyoko.nguyen.1?fref=ufi 🏆 Bạn Hoàng https://www.facebook.com/hkthtg?fref=ufi 🏆 Bạn Hải https://www.facebook.com/tranhai9328?fref=ufi 🏆 Bạn Oanh https://www.facebook.com/hanhphuc.ditim.505?fref=ufi Những người chơi có tên trong danh sách trúng thưởng phía trên vui lòng inbox cho fanpage các thông tin: Họ và tên, Số điện thoại, Địa chỉ để MSI liên hệ trao thưởng. Các bạn sẽ có 01 TUẦN (đến hết ngày 09/10/2015) để gửi thông tin xác nhận nhận thưởng nhé 🎁 🎁 🎁";
		Map<String, Integer> counts = new HashMap<>();
		String[] a;
		System.out.println(tokenize(s));
		System.out.println("yêu em".indexOf("yêu em"));
		String k="anh:2.3544";
		System.out.println(k.split(":")[0]);
		System.out.println(k.split(":")[1]);
		Double h=Double.parseDouble(k.split(":")[1]);
		System.out.println(h);
		
		 
	}
}
