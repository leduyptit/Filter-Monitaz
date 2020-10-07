package language_detect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;

public class language {
	public static int check(String s, LanguageDetector languageDetector) {
		int tmp = 1;
		String out = null;
		double count = 0;
		double size = 0;
		if (s != null) {
			ArrayList<String> myList = new ArrayList<String>(Arrays.asList(s
					.split(" ")));
			size = myList.size();
			for (int i = 0; i < myList.size(); i++) {
				try {
					out = languageDetector.getProbabilities(myList.get(i))
							.get(0).getLocale().getLanguage();
				} catch (Exception e) {
				}
				if (out != null && out.indexOf("vi") >= 0) {
					System.out.println(myList.get(i));
					count = count + 1;
					// break;
				}
			}
		}
		if (out != null && count != 0 && size != 0) {
			System.out.println(size);
			double check_count = count / size;
			System.out.println(check_count);
			if (check_count >= 0.2) {
				tmp = 0;
			}
		}

		return tmp;
	}

	public static int check_object_special(String s,
			LanguageDetector languageDetector) {
		int tmp = 1;
		String out = null;
		double count = 0;
		double size = 0;
		if (s != null) {
			ArrayList<String> myList = new ArrayList<String>(Arrays.asList(s
					.split(" ")));
			size = myList.size();
			for (int i = 0; i < myList.size(); i++) {
				try {
					out = languageDetector.getProbabilities(myList.get(i))
							.get(0).getLocale().getLanguage();
				} catch (Exception e) {
				}
				if (out != null && out.indexOf("vi") >= 0) {
					System.out.println(myList.get(i));
					count = count + 1;
					break;
				}
			}
		}
		if (count != 0) {
			tmp = 0;

		}

		return tmp;
	}

	public static int check_language_thailand(String s,
			LanguageDetector languageDetector) {
		int tmp = 1;
		String out = null;
		double count = 0;
		double size = 0;
		double count_en_th = 0;
		int count_vn = 0;
		if (s != null) {
			ArrayList<String> myList = new ArrayList<String>(Arrays.asList(s
					.split(" ")));
			size = myList.size();
			for (int i = 0; i < myList.size(); i++) {
				try {
					out = languageDetector.getProbabilities(myList.get(i))
							.get(0).getLocale().getLanguage();
				} catch (Exception e) {
				}
				if (out != null && out.indexOf("th") >= 0) {
					System.out.println(myList.get(i));

					count = count + 1;
					// break;
				}
				if (out != null
						&& (out.indexOf("th") >= 0 || out.indexOf("en") >= 0)) {

					count_en_th = count_en_th + 1;
					// break;
				}
				if (out != null && out.indexOf("vi") >= 0) {

					count_vn = count_vn + 1;
					// break;
				}

			}
		}
		System.out.println(count_vn);
		if (out != null && count != 0 && size != 0) {
			System.out.println(size);
			double check_count = count / size;
			System.out.println(check_count);
			if (check_count >= 0.15) {
				tmp = 0;
			}
		}
		if (out != null && count_vn != 0 && size != 0) {
			System.out.println("Size" + size);
			double check_count = count_vn / size;
			System.out.println("Check_count" + check_count);
			if (check_count < 0.05 && size >= 20) {
				tmp = 0;
			}
		}
		if (count_vn == 0 && size >= 10) {
			tmp = 0;
		}
		if (out != null && count_en_th != 0 && size != 0) {
			System.out.println(size);
			double check_count_en_th = count_en_th / size;
			System.out.println(check_count_en_th);
			if (check_count_en_th >= 0.7) {
				tmp = 0;
			}
		}

		return tmp;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		List<LanguageProfile> languageProfiles = null;
		try {
			languageProfiles = new LanguageProfileReader().readAllBuiltIn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// build language detector:
		LanguageDetector languageDetector = LanguageDetectorBuilder
				.create(NgramExtractors.standard())
				.withProfiles(languageProfiles).build();

		// create a text object factory

		for (int j = 0; j < 1; j++) {
			String s = "Fabulous personality of psp officers afzall kosar shb"; // System.out.println(check(s,
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								// languageDetector));
			System.out.println("language" + check_object_special(s, languageDetector));
			/*
			 * String s=
			 * "Click for more Posted by Phim Hot Learn More Watch Again Resume Video Learn More Cáº£nh BĂ¡o TĂ¡c Háº¡i Cá»§a Game Pokemon Go 45,895 Views Phim Hot 5 hrs Cáº£nh BĂ¡o TĂ¡c Háº¡i Cá»§a Game Pokemon Go See Translationen"
			 * ; ArrayList<String> myList = new
			 * ArrayList<String>(Arrays.asList(s.split(" "))); String out =
			 * null; System.out.println(myList.size()); for(int i=0;i<
			 * myList.size();i++){ System.out.println(myList.get(i)); try{
			 * out=languageDetector
			 * .getProbabilities(myList.get(i)).get(0).getLocale
			 * ().getLanguage(); System.out.println(out); } catch(Exception e){}
			 * if(out!=null && out.indexOf("vi")>=0){ break; }
			 * 
			 * } System.out.println(out);
			 * System.out.println(languageDetector.getProbabilities(
			 * "TĂ i xáº¿ xe buĂ½t Ä‘Æ°a Ä‘Ă³n há»�c sinh mĂ£i mĂª pokemon gĂ¢y tai náº¡n PokĂ©monÂ Go Player Crashes Into School While Driving A 19-year-old driver from Australia has crashed their car into a local school while trying to play PokĂ©mon Go. kotaku.com By Alex Walker"
			 * ).get(0).getLocale().getLanguage());
			 */
		}
		long finish = System.nanoTime();
		System.out.println("time " + (finish - start));
	}
}
