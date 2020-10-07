package naivebayes_main;

import NaiveBayes.NaiveBayes;
import NaiveBayes_data.NaiveBayesKnowledgeBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayes_Test {

	public static String[] readLines(String url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(url), "UTF-8"));
		List<String> lines;

		lines = new ArrayList<>();
		String line;
		while ((line = in.readLine()) != null) {
			lines.add(line);

		}
		return lines.toArray(new String[lines.size()]);
	}

	public static void main(String[] args) throws IOException {
		// map of dataset files
		Map<String, URL> trainingFiles = new HashMap<>();
		Map<String, String[]> trainingExamples = new HashMap<>();
		trainingExamples.put("congrat", readLines("train/dulieuspam.txt"));
		trainingExamples.put("non-spam", readLines("train/dulieunonspam.txt"));
		NaiveBayes nb = new NaiveBayes();
		nb.setChisquareCriticalValue(6.63); // 0.01 pvalue
		nb.train(trainingExamples);

		// get trained classifier knowledgeBase
		NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("model/in_involove.txt"), "UTF-8"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("model/out_spam.txt"), "UTF-8"));
		String s;
		String s2, s3, s4;
		while ((s = in.readLine()) != null) {
			nb = null;
			trainingExamples = null;
			// Use classifie
			nb = new NaiveBayes(knowledgeBase);

			// String exampleEn = "ládsagasdada";
			// String outputEn = nb.predict(exampleEn);
			String oute = nb.predict(s);
			if (oute.compareTo("congrat") == 0) {
				// NaiveBayesKnowledgeBase spam=NaiveBayesExample.model_spam();
				// String
				// s1="Sim Mobifone cực đẹp giá rẻ vào tên chính chủ đây 0938.902.555 1600 0934.389.579 850 0934.88.1994 1500 0901.333.989 2300 0906.98.1993 1300 0934.16.2288 950 0934.75.2468 2300 0935.138.789 1300 0935.568.979 1750 0901.5.99997 2500 0906.52.9898 1600 0902.456.586 1000 0937.831.666 2800 0901.38.1102 1400 0935.72.8889 2100 0934.998.986 1500 0934.75.2468 2300 0932.013.555 1550 0932.686.579 1600 093.55.11110 1300 093.6666.827 900 0938.274.666 2600 0938.410.666 2600 0938.170.666 2800 0934.7777.13 1000 093.6666.875 950 0933.041.666 2800 0937.801.666 2800 0902.3.11117 1200 0938.294.666 2800 0932.731.666 2900 0935.616.000 850 0934.339.000 800 093.67.11110 850 0932.614.333 950 0932.720.555 1500 093.5555.210 950 0938.986.000 900 09.33333.752 3200 090.5555.796 1100 0904 100008 1200 0936 799994 1500 0906.965.333 1000 093.69.00004 1000 0903.614.333 950 0938.545.333 1400 0902.976.333 1000 0932.41111 0 1100 0934.76666 5 1100 0935.23333 0 1100 093.6666.463 950 093.6666.794 1000 093.6666.213 950 0936.415.777 1550 0934.498.777 1400 0936.471.555 1500 0936.241.555 1550 0932.614.555 1600 09015.33338 3900 0906.918.222 850 0902.319.333 1100 0938.680.222 850 0938.687.222 850 0909.454.222 1500 093.6666.010 1400 0904.994.000 1000 093.6666.920 950 0904.21111.0 900 0909.427.555 1550 0938.104.555 1550 0938.902.555 1600 0903.379.222 120 0932.054.555 1850 0902.821.333 1100 0901.5.99997 2500 0901.586.444 650 0901.598.000 800 090.484.7979 11000 0932.57.4078 900 0904.26.1357 1100 0938.669.279 1100 0934.85.9779 1200 0935.90.8383 1200 0932.43.3579 2300 0935.92.4078 900 0932.58.1357 1100 0938.883.279 950 0905.76.4078 850 0909.968.479 1750 0936.94.6879 1200 0938.989.179 1600 0932.50.9779 1200 0905.19.4078 900 090.337.4078 900 0938.15.6679 900 0935.74.9779 950 0906.44.1368 3000 0935.568.979 1750 0902.369.279 1000 0933.668.379 2300 0936.568.979 1750 0936.939.479 1750 0936.78.79.78 6200 0936.900.779 1000 0938.42.1102 1200 0932.272.179 1000 0902.75.6879 1400 0934.368.679 1500 0934.83.3579 2300 0906.45.9779 1300 0906.189.479 800 0904.432.779 850 0934.363.179 950 0904.283.179 850 0902.499.579 950 0934.111.479 850 0935.55.4078 1500 0904.898.479 950 093.676.4078 900 0936.586.379 900 0904.101.579 900 0901.783.779 950 0901.779.179 2900 0901.779.579 2700 0904.456.479 1400 0936.689.479 800 0934.398.779 1100 0904.499.379 1300 0901.778.579 1000 0901.52.7779 2300 0901.568.779 2100 0901.36.1102 1400 0901.35.1102 1400 0936.707.779 2800 0901.568.379 1600 0901.579.279 1700 0906.101.879 900 0934.81.9779 1200 0934.112.379 800 0935.50.7939 900 0936.909.279 950 0902.090.579 950 0932.44.4078 950 0903.62.7939 950 0936.589.279 800 0935.87.1102 1100 0905.73.4078 850 0936.968.479 1200 0936.505.179 900 0936.79.99.79 11500 0936.636.279 900 0935.186.486 2200 0932.709.668 900 0932.193.789 1300 0935.138.789 1300 0934.873.789 1200 0901.365.789 2800 0901.387.789 1400 0905.21.8688 1600 0901.579.268 1600 0905.81.6866 1300 090.116.8889 2300 0934.72.6686 1400 0936.739.268 850 0932.622.568 900 0938.959.268 950 0938.909.268 1000 0938.060.568 850 093.552.6866 1400 0905.684.686 1400 093.474.6866 1200 0935.186.486 2200 0906.858.468 950 0938.469.868 1000 0902.479.568 1100 0906.35.2268 900 0932.011.868 1100 0907.668.468 1750 0938 886 808 2300 0935.886.676 1100 0906.883.268 950 0938.312.668 950 0905.786.486 1400 0934.000.386 1000 0902.6688.06 1000 0907.698.268 950 0902 686660 1000 0932.586.386 1000 0938.189.568 950 0905.64.8886 2300 0935.80.6686 1450 0932.169.868 1100 0909.737.268 1000 0906.707.568 1000 0906.786.568 950 0905.727.688 1100 0932.469.668 1100 0906.94.7968 850 0938.864.866 1000 0934.72.6866 1100 0935.10.6686 1550 0938.101.886 950 0935.60.6866 1600 0905.32.6866 1300 0906.40.8668 4000 0936.599.468 1000 0936.889.468 950 0936.575.368 900 0902.668.616 900 0936.999.768 1200 0901.579.168 1600 0901.32.8886 2300 0901.303.668 1400 0901.303.688 1100 0901.32.6686 1500 0901.30.6686 1300 0936.969.468 1000 0904.479.868 1750 0909.171.686 1400 0936.929.168 1000 0935.129.688 850 0905.86.31.86 1000 0905.86.91.86 1100 0936.909.468 950 0935.886.386 1000 0909.54.6686 1400 0901.42.1368 2300 093.550.6866 1200 0934.969.686 2300 0905.04.6686 1400 0934.73.6686 1300 0938.61.2268 900 0904.469.168 1000 090.11.68886 6200 0901.52.8886 2500 0901.33.8886 4100 0901.39.8886 4100 0901.39.8868 4100 0901.33.6866 1850 0901.575.868 2000 0901.505.868 2500 0936.85.9797 1000 0934.27.3366 1000 0905.17.8988 950 0935.70.9988 1300 0934.06.5959 1400 0902.40.9669 1300 0938.51.9669 1400 0934 73 9899 1100 0934.90.98.90 1500 0936.98.95.98 2100 0902.05.05.65 1000 0936.51.9898 1750 0935.46.8383 1200 0904.27.9898 1600 0934.0.89988 1850 0932 4 98988 1500 0938.91.5599 1750 0938.97.5599 1750 0905.71.8383 1400 0932.10.7788 1400 0932.43.8998 1000 0935.60.8998 1000 0935 198998 2500 0932.455.466 1850 0935.41.5588 1300 0909.37.8988 1000 0935.80.7788 1400 0936.97.6677 1000 0906.48.2299 1000 0906.51.9669 1100 093.474.9988 1200 0905.92.7788 1400 0935.96.5599 1750 0934.78.3399 1300 0935.12.3838 2400 0906.52.9898 1600 0902.81.9998 900 0901.57.5599 1850 0934.29.7878 1100 0935.10.9669 900 0935.40.9669 900 0906.21.8383 1500 0934.98.5588 1200 0934.73.9889 1200 0935.21.9889 1400 0938.65.7788 1500 090.434.6669 900 0904.18.0707 700 0936.880.885 2600 0932.552.558 2600 0932.555.989 2300 0934.505.515 1100 0936.886.880 1750 0934.818.898 1400 0935.68.7989 950 0936.95.98.95 1500 0934.39.7788 1200 0905.63.1993 1300 0935.88.1985 2000 0905.73.1987 1200 0935.87.1980 1000 093.557.1987 1200 093.667.1994 1100 0935.42.1983 1100 093.550.1998 950 0935.17.1980 1000 0936.57.1987 1200 090.441.1987 1200 0935.43.1995 1000 090.445.1985 1300 0932.73.1982 1100 0909.62.1993 1500 090.553.1985 1300 0934.75.1986 1500 0935.57.1994 1100 0905.73.1992 1300 0905.13.1994 1200 0906.47.1994 1100 0934.91.1983 1100 093.556.1993 1200 0904.26.1983 1200 0909.27.1993 1200 0935.02.1986 1750 0906.43.1983 1200 0905.20.1992 1200 0905.36.1983 1200 0935.22.1984 1850 0932.57.1983 1200 093.556.1982 1200 0905.16.1985 1600 0938.20.1993 1100 0932.41.1982 1100 0932.55.1990 2500 0932.55.1992 2300 0935.89.1992 1300 0938.45.1992 1300 0938.87.1985 1300 0905.49.1994 1000 0902.53.1983 1100 0906.74.1982 1100 0932.64.1983 1100 0934.75.1985 1100 0935.20.1994 1000 0935.52.1986 1600 0905.94.1986 1400 0905.64.1991 1500 0935.90.1989 1400 0903.56.1990 1750 0938.77.1987 1400 0932.41.1990 1300 0934.92.1990 1200 0934.71.1990 1200 0935.32.1986 1400 0934.91.1987 1000 0932.46.1987 1100 0935.31.1980 1000 0932.58.1983 1100 090.353.1984 1100 0905.26.1987 1300 0905.40.1984 1000 0935.30.1984 1000 0934.87.1984 1000 0935.47.1983 1000 0932.40.1994 1000 0902.41.1992 1400 0902.72.1993 1400 0938.07.1980 1100 0909.76.1989 1850 0935.05.1985 1300 0935.34.1985 1200 0935.28.1984 1200 0905.66.1985 1850 0905.93.1985 1300 0905.38.1992 1400 0935.66.1996 1850 0934.02.1981 1000 0934.72.1989 1600 0934.88.1990 2000 0904.41.1983 1100 0935.33.1987 1850 0903.54.1988 1600 0906.48.1989 1750 0932.57.1992 1300 Tất cả đều là sim trả trước có giá ghi kèm bên cạnh Ai mua sim thì photo cmt ( khách hàng ở xa thì scan cmt, hoăc chụp mặt trước mặt sau cmt gửi qua facebook hay qua mail: tranduyetdz@gmail.com để mình đăng ký sim, đăng ký chính chủ cho ) Mình sẽ giao sim tân nơi, chỉ cần cung cấp cho mình tên, ngày sinh, số cmt, ngày cấp cmt để mình vào thông tin chính chủ cho là được, rồi vê chỉ cần lắp sim gọi 900 ấn phim 1 để kích hoạt là ok (khi giao sim có thể kiểm tra thông tin có chính chủ ko bằng cách gửi tin nhắn: TTTB gửi 1414 là biết ngay Mọi chi tiết xin liên hệ: SĐT: 0934.306.186 gmail:bangsodep@gmail.com Địa chỉ: Mobifone Hải Phòng";
				// System.out.println(nb.predict("Trả góp 0% với thẻ tín dụng Sacombank tại LAZADA. Liên hệ: Sacombank - Chi nhánh Đông Đô Địa chỉ: 363 Hoàng Quốc Việt, quận Cầu Giấy, TP. Hà Nội. Phòng Kinh Doanh: 04 37.915.299 PGD Lê Đức Thọ: 04.37.951.711 PGD Nguyễn Phong Sắc: 04.37.678.228 PGD Quan Hoa: 04.37.910950 PGD Tây Hồ: 04.37.590.099 Hotline: 094 222 3393"));
				// System.out.println(check_spam(spam,s1));
				out.write(s);
				System.out.println(s);
				out.write("\n");
			}
		}
		out.close();
		in.close();

	}

	public static NaiveBayesKnowledgeBase model_tag() throws IOException {
		Map<String, String[]> trainingSpam = new HashMap<>();

		trainingSpam
				.put("7",
						readLines("/root/Filter/tvplusfilter/train/dulieunonspam.txt"));
		trainingSpam.put("3",
				readLines("/root/Filter/tvplusfilter/train/congrat.txt"));
		// trainingSpam.put("7", readLines1("train/dulieunonspam.txt"));
		// trainingSpam.put("3", readLines1("train/congrat.txt"));
		// trainingSpam.put("5", readLines1("/train/order.txt"));
		// trainingSpam.put("8", readLines1("/train/recom.txt"));

		NaiveBayes nb = new NaiveBayes();
		nb.setChisquareCriticalValue(6.63); // 0.01 pvalue
		nb.train(trainingSpam);

		// get trained classifier knowledgeBase
		NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
		return knowledgeBase;

	}

	public static NaiveBayesKnowledgeBase model_spam() throws IOException {
		Map<String, String[]> trainingSpam = new HashMap<>();

		trainingSpam.put("1",
				readLines("/root/Filter/tvplusfilter/dulieuspam.txt"));
		trainingSpam.put("0",
				readLines("/root/Filter/tvplusfilter/dulieunonspam.txt"));
		// trainingSpam.put("1", readLines1("train/dulieuspam.txt"));
		// trainingSpam.put("0", readLines1("train/dulieunonspam.txt"));
		NaiveBayes nb = new NaiveBayes();
		nb.setChisquareCriticalValue(6.63); // 0.01 pvalue
		nb.train(trainingSpam);

		// get trained classifier knowledgeBase
		NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
		return knowledgeBase;
		// Use classifie
		// nb = new NaiveBayes(knowledgeBase);

		// String exampleEn = "ládsagasdada";
		// String outputEn = nb.predict(exampleEn);
	}

	public static int check_spam(NaiveBayesKnowledgeBase knowledgeBase, String s)
			throws IOException {
		int check = 0;
		NaiveBayes nb = new NaiveBayes();
		nb = new NaiveBayes(knowledgeBase);
		if (nb.predict(s).equalsIgnoreCase("1")) {
			check = 1;
		} else {
			check = 0;
		}
		return check;
	}

	public static int check_tag(NaiveBayesKnowledgeBase knowledgeBase, String s)
			throws IOException {
		int check = 0;
		NaiveBayes nb = new NaiveBayes();
		nb = new NaiveBayes(knowledgeBase);
		if (nb.predict(s).equalsIgnoreCase("8")) {
			check = 8;
		}
		if (nb.predict(s).equalsIgnoreCase("5")) {
			check = 5;
		}
		if (nb.predict(s).equalsIgnoreCase("3")) {
			check = 3;
		}
		if (nb.predict(s).equalsIgnoreCase("7")) {
			check = 7;
		}
		return check;
	}
}
