package application;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;

import filtered.Filtered;

	public class Application {
		public static String p;
		public static void main(String[] args) throws IOException {
			long start = System.currentTimeMillis();
//			String s="NgĂ¢n hà€ng QuĂ¢n Ä‘Ă´̀£i MB nĂ¢ng tiĂª̀€n làƒi vay hÄƒ̀€ng thà�ng mà€ khĂ´ng thĂ´ng bà�o cho khà�ch hà€ng MĂ´̀£t viĂª̀£c là€m khĂ´ng minh bà£ch";
//			s = Normalizer.normalize((" " + s + " "),Normalizer.Form.NFC);
//			System.out.println(s.indexOf("NgĂ¢n hĂ ng"));
			displayHelp();
			Date date = new Date();
			int time = (int) (date.getTime() / 1000);
			System.out.println(time);
			try {
				Filtered.run(args[0]);
			} catch (Exception e) {
				System.out.println("Error while tagging");
				System.out.println(e.getMessage());
			}
			long end = System.currentTimeMillis();
			long t = end - start;
			System.out.println("Tong thoi gian: " + t + " millisecond");
		}

		public static void displayHelp() {
			System.out.println("Usage:");
			System.out
					.println("\tCase 1: -0/1 (-0: run fb_post, -1: run fb_post_comment, -2: run fb_post_reply");
		}
	}


