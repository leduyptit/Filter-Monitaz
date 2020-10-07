package filtered;

import maxent.Filter_question;
import maxent.Filter_relevance;
import maxent.Model_question;
import maxent.Model_relevance;
import maxent.Model_sub;
import mysqldb.Mysql_model;
import naivebayes_main.NaiveBayes_Test;
import util.Utils.Object;
import util.Utils.Record;
import util.Utils.Record_tag;
import util.Utils.Record_tag_involove;
import util.Utils.Service;
import util.Utils.logs;
import util.Utils.point;
import util.Utils.sentiment;
import data.FilterClient;
import data.Get_Record;
import dictionary.Getlib_ob_sv;
import dictionary.Getlib_sentiment;
import NaiveBayes_data.NaiveBayesKnowledgeBase;
import NaiveBayes_data_order.NaiveBayesModel;
import NaiveBayes_main_order.NaiveBayesExample_order;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.JarException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.text.Normalizer;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;

import filtered.task1;
import opennlp.maxent.GISModel;

public class Filtered {
	public static String DEFAULT_SERVER;;
	public static String SOAP_ACTION;
	private static String className;
	private static String url;
	private static String user;
	private static String pass;
	private static String maxent;
	private static String model_involove;
	private static String input_involove;
	private static String output_involove;
	private static String model_ques;
	private static String output_ques;
	private static String limit;
	private static int p_id;
	private static Connection connection;
	private static ArrayList<Service> service;
	private static ArrayList<Object> object;
	private static ArrayList<sentiment> sentiment;
	private static ArrayList<sentiment> sen;
	private static String thread;
	private static ArrayList<String> checkques;;
	public static String p;
	private static ArrayList<Record> fb_record;
	public static long c_time;
	public static long filter_time;
	private static NaiveBayesKnowledgeBase model_tag;

	public static void run_test(int trangthai) throws IOException, SQLException {
		checkques = new ArrayList<String>();
		get_Config();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(
						"/root/Filter/tvplusfilter/model/checkques.txt"),
				"UTF-8"));

		String line;
		while ((line = in.readLine()) != null) {
			checkques.add(line);
		}
		in.close();
		object = new ArrayList<Object>();
		service = new ArrayList<Service>();
		int limit_int;
		limit_int = Integer.parseInt(limit);
		p = p_id + "";
		Mysql_model myConnect = new Mysql_model(className, url, user, pass,
				connection);
		myConnect.connect();
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		rs = myConnect.getselect_object();
		object = Getlib_ob_sv.lib_object(rs);
		rs1 = myConnect.getselect_service();
		service = Getlib_ob_sv.lib_service(rs1);
		rs2 = myConnect.getselectsentiment();
		sen = Getlib_sentiment.lib_sentiment(rs2);
		sentiment = Getlib_sentiment.lib(sen);
		myConnect.close();
		System.out.println("Start.....................Tvplus filter version 1");
		BufferedReader in1 = new BufferedReader(new InputStreamReader(
				new FileInputStream(
						"/root/Filter/tvplusfilter/duocpham/forum.txt"),
				"UTF-8"));

		String line1;
		model_tag = NaiveBayes_Test.model_tag();
		NaiveBayesModel order = null;
		System.out.println("abc");
		task1 task = new task1("techcombank", "sadas", "a", object, service, 7,
				0, "x", 2, "đâsda ", checkques, 0, model_tag,order);
		task.run();

	}

	

	public static void run(String text) throws SQLException, IOException, JarException,
			InterruptedException {
		try {
			checkques = new ArrayList<String>();
			get_Config();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(
							"/root/Filter/tvplusfilter/model/checkques.txt"),
					"UTF-8"));

			String line;
			while ((line = in.readLine()) != null) {
				checkques.add(line);
			}
			in.close();
			object = new ArrayList<Object>();
			service = new ArrayList<Service>();
			int limit_int;
			limit_int = Integer.parseInt(limit);
			p = p_id + "";
			Mysql_model myConnect = new Mysql_model(className, url, user, pass,
					connection);
			myConnect.connect();
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			rs = myConnect.getselect_object();
			object = Getlib_ob_sv.lib_object(rs);
			rs1 = myConnect.getselect_service();
			service = Getlib_ob_sv.lib_service(rs1);
			rs2 = myConnect.getselectsentiment();
			sen = Getlib_sentiment.lib_sentiment(rs2);
			sentiment = Getlib_sentiment.lib(sen);
			myConnect.close();
			System.out
					.println("Start.....................Tvplus filter version 1");
			model_tag = NaiveBayes_Test.model_tag();
			int check = 0;
			while (true) {
				fb_record = Get_Record.getListFull(limit_int,text);
				if (fb_record.size() == 0) {
					System.out.println("Da quet du lieu");
					break;
				}
				filter_question_relevance();
				check = check + 1;
				if (check == 1) {
					break;
				}
				if (fb_record.size() == 0) {
					System.out.println("Da quet du lieu");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			String e1 = e.getMessage();
			System.out.println(e1);
		}
	}

	public static void get_Config() {
		Properties prop = new Properties();
		try {

			prop.load(new FileInputStream(
					"/root/Filter/tvplusfilter/nganhang/config.properties_0"));
		} catch (Exception e) {
			System.out.println("Error while tagging");
		}
		DEFAULT_SERVER = prop.getProperty("DEFAULT_SERVER");
		SOAP_ACTION = prop.getProperty("SOAP_ACTION");
		className = prop.getProperty("className");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pass = prop.getProperty("pass");
		maxent = prop.getProperty("maxent");
		model_involove = prop.getProperty("model_involove");
		input_involove = prop.getProperty("input_involove");
		output_involove = prop.getProperty("output_involove");
		model_ques = prop.getProperty("model_ques");
		output_ques = prop.getProperty("output_ques");
		limit = prop.getProperty("limit");
		thread = prop.getProperty("thread");
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

	public static util.Utils.point rt_sentiment(String s) {
		point a = new point();
		a = object_service.Check_sentiment.set_point(sentiment, s);
		return a;
	}

	public static void filter_question_relevance() throws SQLException,
			IOException, InterruptedException {
		long start =System.currentTimeMillis();
		ArrayList<Record_tag_involove> record = new ArrayList<Record_tag_involove>();
		ExecutorService pool = Executors.newFixedThreadPool(50);
		NaiveBayesKnowledgeBase spam = NaiveBayes_Test.model_spam();
		NaiveBayesModel order = NaiveBayesExample_order.model_order();
		GISModel model_question = Model_question.model_question(
				"/root/Filter/tvplusfilter/maxent/ques.txt",
				"/root/Filter/tvplusfilter/maxent/noques.txt", "9", "7");
//		GISModel model_relevance = Model_relevance.model_relevance(
//				"/root/Filter/tvplusfilter/maxent/khonglienquan.txt",
//				"/root/Filter/tvplusfilter/maxent/lienquanmotchut.txt",
//				"/root/Filter/tvplusfilter/maxent/lienquan.txt",
//				"/root/Filter/tvplusfilter/maxent/ratlienquan.txt");
//		GISModel model_sub = Model_sub.model_sub("/root/Filter/tvplusfilter/maxent/sentiment.txt",
//				"/root/Filter/tvplusfilter/maxent/nosentiment.txt", "1", "0");
		GISModel model_sub = Model_sub.model_sub_file();
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new FileInputStream("/root/Filter/tvplusfilter/maxent/sentimentword.txt")));		
	
		
		ArrayList<String> sentiment_word = new ArrayList<String>();
		String line2;
		while ((line2 = in2.readLine()) != null ) {
			 String nor = Normalizer.normalize(line2, Normalizer.Form.NFC);
			sentiment_word.add(nor);
		}
		in2.close();
		
		for (int i = 0; i < fb_record.size(); i++) {
			Record_tag_involove b = new Record_tag_involove();
			b.id = fb_record.get(i).id;
			b.p_name = fb_record.get(i).page_name;
			b.message = fb_record.get(i).message;
			b.post_message = fb_record.get(i).post_message;
			b.fb_from_name = fb_record.get(i).fb_from_name;
			b.post_type = fb_record.get(i).post_type;
			b.tag = Integer.parseInt(Filter_question.check_question(
					model_question, fb_record.get(i).message));
			b.involove = 5;
			b.check_spam = NaiveBayes_Test.check_spam(spam,
					fb_record.get(i).message);
			b.post_type = fb_record.get(i).post_type;
			System.out.println("tag " + b.tag);
			System.out.println("involove " + b.involove);
			record.add(b);
		}
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
	
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < record.size(); i++) {
			task task = new task(record.get(i).message, record.get(i).p_name,
					record.get(i).id, object, service, record.get(i).tag,
					record.get(i).post_type, record.get(i).post_message,
					record.get(i).involove, record.get(i).fb_from_name,
					checkques, record.get(i).check_spam, model_tag,model_sub,sentiment_word,order,languageDetector);
			pool.submit(task);
		}
		pool.shutdown();
		  while (!pool.isTerminated()) {
	        }
	        System.out.println("Time qu�t v� update :"+(System.currentTimeMillis()-start1));
		  	System.out.println("Time kết thúc tiến trình :"+System.currentTimeMillis());
		  	System.out.println("Time hoàn thành tiến trình :"+(System.currentTimeMillis()-start));
	        System.out.println("Finished all threads");

	}

}