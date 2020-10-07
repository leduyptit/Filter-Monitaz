package language_detect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObjectFactory;

public class test2 {
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		String character = "Đặng Dung";
		character = Normalizer.normalize(character.replaceAll("\\p{P}", " ")
				.replaceAll("\\s+", " ").toLowerCase(), Normalizer.Form.NFC);
		System.out.println(character);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("input.txt"), "UTF-8"));
		ArrayList<String> input = new ArrayList<String>();
		String line;
		while ((line = in.readLine()) != null) {
			input.add(line);
		}
		in.close();

		List<LanguageProfile> languageProfiles = null;
		try {
			languageProfiles = new LanguageProfileReader().readAllBuiltIn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("lá»—i");
			e.printStackTrace();
		}

		// build language detector:
		LanguageDetector languageDetector = LanguageDetectorBuilder
				.create(NgramExtractors.standard())
				.withProfiles(languageProfiles).build();

		/*
		 * for(int j=0;j<500;j++){ String
		 * s="Fabulous personality of psp officers afzall kosar shb"; // String
		 * s=
		 * "Click for more Posted by Phim Hot Learn More Watch Again Resume Video Learn More Cáº£nh BĂ¡o TĂ¡c Háº¡i Cá»§a Game Pokemon Go 45,895 Views Phim Hot 5 hrs Cáº£nh BĂ¡o TĂ¡c Háº¡i Cá»§a Game Pokemon Go See Translationen"
		 * ; ArrayList<String> myList = new
		 * ArrayList<String>(Arrays.asList(s.split(" "))); String out = null;
		 * System.out.println(myList.size()); for(int i=0;i< myList.size();i++){
		 * System.out.println(myList.get(i)); try{
		 * out=languageDetector.getProbabilities
		 * (myList.get(i)).get(0).getLocale().getLanguage();
		 * System.out.println(out); } catch(Exception e){} if(out!=null &&
		 * out.indexOf("vi")>=0){ break; }
		 * 
		 * }
		 */
		String output = " ";
//		output=languageDetector.getProbabilities("fullname").get(0)
//					.getLocale().getLanguage();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("b.txt"), "UTF-8"));
		for (int i = 0; i < input.size(); i++) {
			System.out.println(input.get(1));
			try{
			output = languageDetector.getProbabilities(input.get(i)).get(0)
					.getLocale().getLanguage();}
			catch(Exception e){
				output=" ";
			}
			out.write(output);
			out.write("\n");
		}
		out.close();
	}

	long finish = System.nanoTime();

}
