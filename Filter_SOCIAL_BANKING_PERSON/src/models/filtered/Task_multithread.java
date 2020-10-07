package filtered;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import language_detect.language;
import maxent.Filter_sub;
import object_service.Check_many_object;
import object_service.Check_many_service;
import object_service.Check_object;
import object_service.Check_sentiment;
import object_service.Check_service;
import opennlp.maxent.GISModel;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.JSONArray;

import com.optimaize.langdetect.LanguageDetector;

import rule.Rule_spam;
import util.Utils.Object;
import util.Utils.Service;
import util.Utils.point;
import data.FilterClient;
import data.FilterMonitazService;
import json_cv.object;
import NaiveBayes_data.NaiveBayesKnowledgeBase;
import NaiveBayes_data_order.NaiveBayesModel;

class task implements Runnable {
	private String fb_message;
	private String fb_page_name;
	private String id_conten;
	private ArrayList<Object> object;
	private ArrayList<Service> service;
	private int tag;
	private int type;
	private String post_message;
	private int involove;
	private String fb_from_name;
	private int check_spam;
	private NaiveBayesKnowledgeBase model_tag;
	private ArrayList<String> a;
	private GISModel model_sub;
	private ArrayList<String> sentiment_word;
	private NaiveBayesModel order;
	private LanguageDetector languageDetector;

	public task(String fb_message, String fb_page_name, String id_conten,
			ArrayList<Object> object, ArrayList<Service> service, int tag,
			int type, String post_message, int involove, String fb_from_name,
			ArrayList<String> b, int check_spam,
			NaiveBayesKnowledgeBase model_tag, GISModel model_sub,
			ArrayList<String> sentiment_word, NaiveBayesModel order,
			LanguageDetector languageDetector) {
		this.fb_message = fb_message;
		this.fb_page_name = fb_page_name;
		this.id_conten = id_conten;
		this.object = object;
		this.service = service;
		this.tag = tag;
		this.type = type;
		this.post_message = post_message;
		this.involove = involove;
		this.fb_from_name = fb_from_name;
		this.a = b;
		this.check_spam = check_spam;
		this.model_tag = model_tag;
		this.model_sub = model_sub;
		this.sentiment_word = sentiment_word;
		this.order = order;
		this.languageDetector = languageDetector;
	}

	public void run() {
		System.out.println("id" + id_conten);
		System.out.println("message" + fb_message);
		// System.out.println("Thoi gian bat dau" + );
		/*
		 * if (fb_message .toLowerCase() .indexOf(
		 * "anh nhân viên ngân hàng dành giờ nghỉ trưa mỗi ngày để dạy chữ") >=
		 * 0) { fb_message = "ngân hàng scb tuyệt vời"; } if
		 * (fb_message.toLowerCase().indexOf("tuan usstyle") >= 0) { fb_message
		 * = fb_message + " ngân hàng vietcombank lừa đảo"; }
		 */
//		fb_message = " bảo hiểm daiichi lừa đảo";
		int own = 0;
		String JSONResult_object_from_name = null;
		String JSONResult_object_page_name = null;
		String JSONResult_object = null;
		String JSONResult_service = null;
		String JSONservice = null;
		String JSONservice_post = null;
		String JSONobject_post = null;
		int point_negative = 0;
		int point_positive = 0;
		point st;
		int check_service = 0;
		if ((fb_message != null
				&& fb_message.toLowerCase().indexOf("#donga") >= 0
				&& fb_message.toLowerCase().indexOf("😂") >= 0
				&& Check_sentiment.printText(fb_message, "😂") >= 5 && fb_message
				.length() < 30)

				|| (fb_message != null
						&& fb_message.toLowerCase().indexOf("#donga") >= 0
						&& fb_message.toLowerCase().indexOf("😂") >= 0 && fb_message
						.length() < 15)
				|| (fb_message != null
						&& fb_message.toLowerCase().indexOf("#donga") >= 0 && fb_message
						.length() < 10)

		) {
			System.out.println("nhận ra");
			fb_message = " ";
		}
		String s = fb_message.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");
		System.out.println(s);
		// System.out.println(s.toLowerCase().indexOf("ngân hàng"));
		if (fb_message != null && fb_message.length() > 0
				&& fb_message.length() < 8000) {
			System.out.println("length : " + fb_message.length());
			if (fb_from_name.toLowerCase().indexOf("hòa phát") >= 0
					|| fb_from_name.toLowerCase().indexOf("hoà phát") >= 0
					|| fb_from_name.toLowerCase().indexOf("hoa phat") >= 0
					|| fb_from_name.toLowerCase().indexOf("scb") >= 0
					|| fb_from_name.toLowerCase().indexOf("donga") >= 0) {
				JSONResult_object_from_name = null;
			} else {
				JSONResult_object_from_name = Check_object.return_object(
						object, fb_from_name);

			}
			try {
				if (fb_message.length() < 1000) {
					tag = Logic_tag.Filter_tag(fb_message, fb_from_name,
							JSONResult_object_from_name, a, object, service,
							model_tag, order);
				} else {
					tag = 7;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Tra ve full row object cua fb_post_message
			// JSONResult_object = Check_object.return_object(object,
			// fb_message);
			// JSONResult_object_page_name = Check_object.return_object(object,
			// fb_page_name);
			JSONservice = Check_many_service.return_service(service,
					fb_page_name);
			JSONResult_service = Check_many_service.return_service(service,
					fb_message);
			System.out.println("Service :" + JSONResult_service);
			// Trả về object id của page_name
			System.out.println(fb_page_name);
			object object_page_name = null;
			/*
			 * for (int i = 0; i < object.size(); i++) { if
			 * (Check_object.check_object(fb_page_name.toLowerCase(),
			 * object.get(i).name.toLowerCase(), 1) == 1 &&
			 * Check_object.check_object_confusion( fb_page_name.toLowerCase(),
			 * object.get(i).name.toLowerCase()) == 0 &&
			 * Check_object.object_td(object.get(i), fb_page_name.toLowerCase())
			 * == 0
			 * 
			 * ) { object_page_name = new object(object.get(i).id,
			 * object.get(i).cid, object.get(i).sid, object.get(i).pid,
			 * object.get(i).status); if (object.get(i).status == 1) { own =
			 * object.get(i).cid; } if (object.get(i).status == 0) { own =
			 * object.get(i).id; } break; } }
			 */
			// Xử lí trường hợp đối tượng message k phải đối tượng page
			List<object> list = new ArrayList<object>();
			try {
				list = Check_object.return_many_object(object, fb_message);
			} catch (Exception e) {
				System.out.println(e);
			}

			if (Check_many_object.check_many_object(list, own) == 0
					&& JSONResult_object_page_name != null) {
				tag = 10;
				list.add(object_page_name);
			}

			JSONResult_object = JSONArray.toJSONString(list);
			// JSONResult_object = Check_many_object.check_many_object(list,
			// own);
			System.out.println("JSONResult_object" + JSONResult_object);

			// nếu là comment thì quét đối tượng, dịch vụ của post cha
			if (type == 1 || type == 2) {

				JSONservice_post = Check_many_service.return_service(service,
						post_message);
				List<object> list1 = new ArrayList<object>();
				list1 = Check_object.return_many_object(object, post_message);
				if (Check_many_object.check_many_object(list1, own) == 0
						&& JSONResult_object_page_name != null) {
					list1.add(object_page_name);
				}
				JSONobject_post = JSONArray.toJSONString(list1);
				if (Rule_spam.rule1_spam(post_message) == 1) {
					JSONobject_post = null;
				}
			}

			if (JSONservice != null) {
				if (JSONservice.compareTo("[]") == 0) {
					JSONservice = null;
				}
			}
			if (JSONservice_post != null) {
				if (JSONservice_post.compareTo("[]") == 0) {
					JSONservice_post = null;
				}
			}
			if (JSONResult_object != null) {
				System.out.println("Json_object" + JSONResult_object);
				if (JSONResult_object.compareTo("[]") == 0) {
					JSONResult_object = null;
				}
			}

			if (JSONobject_post != null) {
				if (JSONobject_post.compareTo("[]") == 0) {
					JSONobject_post = null;
				}
			}

			// chỉnh sửa lại điểm involove
			int tag_sentiment = 1;
			if (type == 0) {
				check_spam = 0;
				long start = System.currentTimeMillis();
				int negative_old = 0;
				int positive_old = 0;
				int sentiment_service = 0;
				if (check_spam == 0 && JSONResult_object != null) {
					if (fb_message.length() < 1000) {
						if (fb_message.toLowerCase().indexOf("vcb") >= 0
								|| fb_message.toLowerCase().indexOf("vietcom") >= 0) {
							st = Filtered.rt_sentiment(fb_message);

							negative_old = st.negative;
							positive_old = st.positive;
						}
					}
					if (fb_message.toLowerCase().indexOf("hòa phát") >= 0
							|| fb_message.toLowerCase().indexOf("hoà phát") >= 0) {
						if (fb_message.toLowerCase().indexOf("dọa giết") >= 0
								|| (fb_message.toLowerCase().indexOf("đe dọa") >= 0 && fb_message
										.toLowerCase().indexOf("đỗ cao cường") >= 0)
								|| fb_message.toLowerCase().indexOf("giết tôi") >= 0
								|| fb_message.toLowerCase().indexOf(
										"bắt tôi im lặng") >= 0

						) {

							negative_old = 5;
							positive_old = 0;
						}
					}
					try {
						sentiment_service = Check_sentiment_service.sendPost(
								fb_message, id_conten);
						if (sentiment_service == 1) {
							point_positive = 5;
							point_negative = 0;
						}
						if (sentiment_service == 2) {
							point_positive = 0;
							point_negative = 5;
						}
						if (negative_old > 0
								&& negative_old >= (positive_old - 1)) {
							point_positive = 0;
							point_negative = 5;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					point_negative = 0;
					point_positive = 0;
				}
				System.out.println("postive:" + point_positive);
				System.out.println("negative:" + point_negative);

				long end = System.currentTimeMillis();
				System.out.println("Time sentiment" + (end - start));
				if (list.size() >= 2
						&& ((" " + fb_message + " ").indexOf(" hơn ") >= 0
								|| (" " + fb_message + " ").indexOf(" kém ") >= 0
								|| (" " + fb_message + " ").indexOf(" giống ") >= 0
								|| (" " + fb_message + " ").indexOf(" bằng ") >= 0
								|| (" " + fb_message + " ").indexOf(" là ") >= 0
								|| (" " + fb_message + " ").indexOf(" như ") >= 0
								|| (" " + fb_message + " ").indexOf(" tày ") >= 0
								|| (" " + fb_message + " ").indexOf(" tầy ") >= 0
								|| (" " + fb_message + " ").indexOf(" tựa ") >= 0
								|| (" " + fb_message + " ").indexOf(" hệt ") >= 0
								|| (" " + fb_message + " ")
										.indexOf("chẳng khác gì") >= 0
								|| point_negative != 0 || point_positive != 0)

				) {
					tag = 10;
				}

				// tang them negative,positive
				if (JSONResult_object_from_name != null
						|| (check_spam == 0 || JSONResult_object != null || (point_negative != 0 || point_positive != 0))) {
					System.out.println("check_spam " + check_spam);
					if (JSONResult_object == null
							&& JSONResult_object_from_name == null) {
						JSONResult_object = JSONResult_object_page_name;
					}

					if (JSONResult_service == null) {
						JSONResult_service = JSONservice;
					}

					if ((point_positive > point_negative)
							&& (tag == 5 || tag == 9)) {
						point_negative = 0;
						point_positive = 0;
					}

					if (JSONResult_object == null
							&& JSONResult_object_from_name != null) {
						JSONResult_object = JSONResult_object_from_name;
					}

					// set involove
					if (JSONResult_object == null && JSONResult_service == null
							&& (involove - 2) >= 1) {
						involove = involove - 2;
					}
					if (JSONResult_service != null && (involove + 2) <= 7) {
						involove = involove + 2;
					}

					// check lại spam
					int rule1_spam = 0;
					int spam_number = 0;
					int language_check = 0;
					int rule_spam_service = 0;
					int get_stk = 0;
					int rule1_spam_bonus = 0;
					int language_thailand = 1;
					int rule3_spam = Rule_spam.rule3_spam(fb_message,
							fb_from_name);
					if (JSONResult_object != null) {
						int spam_check = 0;
						rule1_spam = Rule_spam.rule1_spam(fb_message);
						rule1_spam_bonus = Rule_spam
								.rule1_spam_bonus(fb_message);
						spam_number = Rule_spam.spam_number(fb_message
								.toLowerCase());
						language_check = language.check(fb_message,
								languageDetector);
						language_thailand = language.check_language_thailand(
								fb_message, languageDetector);
						get_stk = Rule_spam.get_stk(fb_message.toLowerCase());
						if (fb_message.toLowerCase().indexOf("ncb") >= 0
								|| fb_message.toLowerCase().indexOf("scb") >= 0
								|| fb_message.toLowerCase().indexOf("shb") >= 0) {
							int language_object_special = language
									.check_object_special(fb_message,
											languageDetector);
							if (fb_message.toLowerCase().indexOf("missscb") >= 0
									|| fb_message.toLowerCase().indexOf(
											"miss scb") >= 0
									|| fb_message.toLowerCase().indexOf("stem") >= 0) {
								language_object_special = 0;
							}
							if (language_object_special == 1) {
								JSONResult_object = null;
							}
						}
						if (rule3_spam == 1
								&& fb_message.toLowerCase().indexOf("stem") < 0) {
							JSONResult_object = null;
						}
						int object_check = 0;
						if (point_negative != 5 || rule1_spam_bonus != 0
								|| spam_number != 0) {
							object_check = 1;
						}
						if (get_stk == 1 && rule1_spam != 0
								&& fb_message.toLowerCase().indexOf("stem") < 0) {
							JSONResult_object = null;
							spam_check = 1;
							point_negative = 0;
							point_positive = 0;
						}
						if ((language_thailand == 0 || rule1_spam_bonus == 1)&& fb_message.toLowerCase().indexOf("stem") < 0) {
							JSONResult_object = null;
							spam_check = 1;
							point_negative = 0;
							point_positive = 0;
						}
						if (object_check == 1) {

							if (rule1_spam != 0
									|| (spam_number == 1 && fb_message
											.toLowerCase().indexOf("ncb") < 0)
									|| (get_stk == 1 && fb_message
											.toLowerCase().indexOf(
													"ngân hàng quốc dân") < 0)

									|| (language_check == 1
											&& fb_message.toLowerCase()
													.indexOf("sacombank") < 0
											&& fb_message.toLowerCase()
													.indexOf("ngan hang") < 0
											&& fb_message
													.toLowerCase()
													.indexOf("internet banking") < 0
											&& fb_message.toLowerCase()
													.indexOf("kienlong bank") < 0
											&& fb_message.toLowerCase()
													.indexOf("kienlongbank") < 0
											&& fb_message.toLowerCase()
													.indexOf("kiên long bank") < 0
											&& fb_message.toLowerCase()
													.indexOf("kien long bank") < 0
											&& fb_message.toLowerCase()
													.indexOf("agribank") < 0

											&& fb_message
													.toLowerCase()
													.indexOf(
															"ngân hàng quốc dân") < 0
											&& fb_message.toLowerCase()
													.indexOf("kiênlong bank") < 0 && fb_message
											.toLowerCase().indexOf(
													"kiênlongbank") < 0)) {
								System.out.println("message spam" + rule1_spam
										+ spam_number + get_stk
										+ language_check);
								if (fb_message.toLowerCase().indexOf("stem") < 0) {
									JSONResult_object = null;
									spam_check = 1;
									point_negative = 0;
									point_positive = 0;
								}
								File file = new File(
										"/root/Filter/tvplusfilter/all/sentiment_log/spam1.csv");
								// kiểm tra nếu file chưa có thì tạo file mới
								if (!file.exists()) {
									try {
										file.createNewFile();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									FileWriter fw = null;
									try {
										fw = new FileWriter(
												file.getAbsoluteFile(), true);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									BufferedWriter bw = new BufferedWriter(fw);

									try {
										bw.write("id,message,rule_spam,stk_spam,language_check\n");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									try {
										bw.close();
										fw.close();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
								FileWriter fw1 = null;
								FileWriter fw2 = null;
								try {
									fw1 = new FileWriter(
											"/root/Filter/tvplusfilter/all/sentiment_log/spam.txt",
											true);
									fw2 = new FileWriter(
											"/root/Filter/tvplusfilter/all/sentiment_log/spam1.csv",
											true);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								BufferedWriter bw2 = new BufferedWriter(fw2);
								BufferedWriter bw1 = new BufferedWriter(fw1);
								try {
									bw2.append("\"" + id_conten + "\"");
									bw2.append(",");
									bw2.append("\""
											+ fb_message.replaceAll("\"", " ")
											+ "\"");
									bw2.append(",");
									bw2.append("\"" + rule1_spam + "\"");
									bw2.append(",");
									bw2.append("\"" + spam_number + "\"");
									bw2.append(",");
									bw2.append("\"" + language_check + "\"");
									bw2.append("\n");

									bw1.write(id_conten + "; " + fb_message);
									bw1.write("spam " + rule1_spam + " "
											+ spam_number + " "
											+ language_check);
									bw1.write("get stk:" + get_stk);
									bw1.write("\n");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									bw1.close();
									bw2.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									fw1.close();
									fw2.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						try {
							rule_spam_service = Check_spam_service.sendPost(
									fb_message, spam_check);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// if (JSONResult_object != null) {
					// if (Rule_spam.spam_stk(fb_message, list.size()) == 1) {
					// System.out.println("Spam stk");
					// JSONResult_object = null;
					// }
					// }
					// tam dung khi mo service sentiment
					if (JSONResult_object != null) {
						int check_out = Rule_spam.rule_monitaz(fb_message,
								fb_from_name);
						if (fb_message.length() < 2000) {
							int check_phone = Rule_spam.check_sdt(fb_message);
							if (check_phone == 1) {
								JSONResult_object = null;
								FileWriter fw4 = null;
								try {

									fw4 = new FileWriter(
											"/root/Filter/tvplusfilter/all/monitaz_log/log_check_phone.csv",
											true);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								BufferedWriter bw4 = new BufferedWriter(fw4);

								try {
									bw4.append("\"" + id_conten + "\"");
									bw4.append(",");
									bw4.append("\""
											+ fb_message.replaceAll("\"", " ")
											+ "\"");
									bw4.append(",");
									bw4.append("\""
											+ fb_from_name
													.replaceAll("\"", " ")
											+ "\"");
									bw4.append(",");
									bw4.append("\"" + check_phone + "\"");
									bw4.append("\n");

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									bw4.close();

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									fw4.close();

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						if (check_out != 0) {
							FileWriter fw3 = null;
							try {

								fw3 = new FileWriter(
										"/root/Filter/tvplusfilter/all/monitaz_log/log.csv",
										true);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							BufferedWriter bw3 = new BufferedWriter(fw3);

							try {
								bw3.append("\"" + id_conten + "\"");
								bw3.append(",");
								bw3.append("\""
										+ fb_message.replaceAll("\"", " ")
										+ "\"");
								bw3.append(",");
								bw3.append("\""
										+ fb_from_name.replaceAll("\"", " ")
										+ "\"");
								bw3.append(",");
								bw3.append("\"" + check_out + "\"");
								bw3.append("\n");

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								bw3.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fw3.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if (JSONResult_object != null) {
						if (Rule_spam.rule2_spam(fb_message, fb_from_name) == 1
								|| tag == 3) {
							point_negative = 0;
							point_positive = 0;
						}
					}

					// tam dung khi mo service sentiment
					/*
					 * if (point_negative != 0 || point_positive != 0) { try {
					 * tag_sentiment = Filter_sub.check_sub(model_sub,
					 * fb_message, sentiment_word); } catch (IOException |
					 * InterruptedException e) { // TODO Auto-generated catch
					 * block e.printStackTrace(); } }
					 * 
					 * int check_spam_stk = Rule_spam.spam_number(fb_message
					 * .toLowerCase()); if (check_spam_stk == 1 &&
					 * JSONResult_object != null) { JSONResult_object = null;
					 * FileWriter fw1 = null; try { fw1 = new FileWriter(
					 * "/root/Filter/tvplusfilter/all/log_rabit/spam_stk.txt",
					 * true); } catch (IOException e) { // TODO Auto-generated
					 * catch block e.printStackTrace(); } BufferedWriter bw1 =
					 * new BufferedWriter(fw1); try { bw1.write(id_conten + "; "
					 * + fb_message); bw1.write("\n"); } catch (IOException e) {
					 * // TODO Auto-generated catch block e.printStackTrace(); }
					 * try { bw1.close(); } catch (IOException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); } try {
					 * fw1.close(); } catch (IOException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); } }
					 */
					if (JSONResult_object_from_name != null) {
						point_negative = 0;
						point_positive = 0;
					}
					/*
					 * if (JSONResult_object_from_name == null &&
					 * JSONResult_object_page_name == null && JSONResult_object
					 * == null) { if
					 * ((fb_message.toLowerCase().indexOf("ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf(
					 * "khách hàng của ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "khách hàng ngân hàng")
					 * >= 0 || fb_message.toLowerCase().indexOf(
					 * "phòng giao dịch") >= 0 ||
					 * fb_message.toLowerCase().indexOf("gửi tiền") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "nhân viên ngân hàng ")
					 * >= 0 || fb_message.toLowerCase().indexOf(
					 * "làm cái thẻ ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "tài khoản bị trừ") >=
					 * 0 || fb_message.toLowerCase().indexOf( "vay ngân hàng")
					 * >= 0 || fb_message.toLowerCase().indexOf(
					 * "tẩy chay ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf(
					 * "tẩy chay cái ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "đổi ngân hàng") >= 0
					 * || fb_message.toLowerCase().indexOf( "thủ tục ngân hàng")
					 * >= 0 || fb_message.toLowerCase().indexOf("lãi suất") >= 0
					 * || fb_message.toLowerCase() .indexOf("ngoại hối") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "chứng khoán") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "đại hội cổ đông") >= 0
					 * || fb_message.toLowerCase().indexOf("sáp nhập") >= 0 ||
					 * fb_message.toLowerCase().indexOf("M&A") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "chăm sóc khách hàng")
					 * >= 0 || fb_message.toLowerCase().indexOf( "chuyển khoản")
					 * >= 0 || fb_message.toLowerCase().indexOf(
					 * "lãnh đạo ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf("cổ phiếu") >= 0 ||
					 * fb_message.toLowerCase().indexOf("cổ tức") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "thẻ thanh toán") >= 0
					 * || fb_message.toLowerCase().indexOf( "thẻ ghi nợ") >= 0
					 * || fb_message.toLowerCase().indexOf( "thẻ tín dụng") >= 0
					 * || fb_message.toLowerCase().indexOf("chủ thẻ") >= 0 ||
					 * fb_message.toLowerCase().indexOf("tiền gửi") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "dư nợ cho vay") >= 0
					 * || fb_message.toLowerCase().indexOf("kiều hối") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "hạ lãi suất cho vay")
					 * >= 0 || fb_message.toLowerCase().indexOf("cho vay") >= 0
					 * || fb_message.toLowerCase().indexOf( "thu phí thẻ") >= 0
					 * || fb_message.toLowerCase().indexOf( "thẻ ngân hàng") >=
					 * 0 || fb_message.toLowerCase().indexOf(
					 * "tài khoản ngân hàng") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "huy động vốn") >= 0 ||
					 * fb_message.toLowerCase().indexOf(
					 * "hỗ trợ doanh nghiệp nhỏ và vừa") >= 0 ||
					 * fb_message.toLowerCase().indexOf(
					 * "ưu đãi cho doanh nghiệp") >= 0 ||
					 * fb_message.toLowerCase() .indexOf("hỗ trợ dn") >= 0 ||
					 * fb_message.toLowerCase().indexOf( "hỗ trợ nông dân") >= 0
					 * || fb_message.toLowerCase().indexOf("tiền giả") >= 0 ||
					 * fb_message.toLowerCase().indexOf("tín dụng") >= 0 ||
					 * fb_message .toLowerCase().indexOf("nợ xấu") >= 0
					 * 
					 * ) && Rule_spam.rule1_spam(fb_message) == 0 &&
					 * rule_spam_service == 0 &&
					 * Rule_spam.spam_number(fb_message .toLowerCase()) != 1) {
					 * JSONResult_object =
					 * "[{\"id\":\"7897\",\"cid\":\"1\",\"sid\":\"0\",\"pid\":\"0\",\"status\":\"0\"}]"
					 * ; } // System.out.println("Bước 4"); }
					 */
					if (JSONResult_object != null) {
						/*
						 * try { Check_sentiment_service.sendPost(fb_message); }
						 * catch (Exception e1) { // TODO Auto-generated catch
						 * block e1.printStackTrace(); }
						 */
						int out_sentiment = 0;
						if (point_positive != 0 || point_negative != 0) {
							if (point_positive > point_negative) {
								out_sentiment = 1;
							} else {
								out_sentiment = 2;
							}
							if (tag_sentiment == 0) {
								out_sentiment = 0;
							}
						}

						/*
						 * if (out_sentiment == 0) { try { fw1 = new FileWriter(
						 * "/root/Filter/tvplusfilter/all/sentiment_log/neutral.txt"
						 * , true); } catch (IOException e) { // TODO
						 * Auto-generated catch block e.printStackTrace(); } }
						 * if (out_sentiment == 1) { try { fw1 = new FileWriter(
						 * "/root/Filter/tvplusfilter/all/sentiment_log/positive.txt"
						 * , true); } catch (IOException e) { // TODO
						 * Auto-generated catch block e.printStackTrace(); }
						 * 
						 * }
						 */
						if (out_sentiment == 2
						// && sentiment_service!=2
						) {
							FileWriter fw1 = null;
							try {
								fw1 = new FileWriter(
										"/root/Filter/tvplusfilter/all/sentiment_log/negative_old.txt",
										true);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							BufferedWriter bw1 = new BufferedWriter(fw1);

							try {
								bw1.write(fb_message);
								bw1.write(" sentiment service"
										+ sentiment_service);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							try {
								bw1.write("\n");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								bw1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fw1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if (fb_message.toLowerCase().indexOf("mùi hòa phát") >= 0
							|| fb_message.toLowerCase().indexOf("mùi hoà phát") >= 0
							|| (fb_message.toLowerCase().indexOf("hoà phát") >= 0 && fb_message
									.toLowerCase().indexOf("dọa dẫm") >= 0)
							|| (fb_message.toLowerCase().indexOf("hòa phát") >= 0 && fb_message
									.toLowerCase().indexOf("dọa dẫm") >= 0)
							|| (fb_message.toLowerCase().indexOf("hòa phát") >= 0 && fb_message
									.toLowerCase().indexOf("ô nhiễm") >= 0)) {
						point_positive = 0;
						point_negative = 5;
					}

					System.out.println("Sentiment " + point_positive
							+ point_negative);
					check_service = FilterClient.update_service_hung(
							JSONResult_object, JSONResult_service,
							(short) point_negative, (short) point_positive,
							id_conten, (short) type, (short) 1, (short) 7, own,
							(short) involove, tag_sentiment);

				} else {
					check_service = FilterClient.update_service_hung(null,
							null, (short) 0, (short) 0, id_conten,
							(short) type, (short) 1, (short) 6, own,
							(short) involove, tag_sentiment);
				}
			}
			System.out.println("aaaaaaa");

			// Nếu là comment thì truyền dữ liệu post vào.
			if (type == 1 || type == 2) {
				if (check_spam == 0 || JSONResult_object != null
						|| JSONResult_service != null
						|| JSONResult_object_from_name != null || tag == 9
						|| tag == 5 || tag == 3 || tag == 8) {
					st = Filtered.rt_sentiment(fb_message);
					point_negative = st.negative;
					point_positive = st.positive;
					if (list.size() >= 2
							&& ((" " + fb_message + " ").indexOf(" hơn ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" kém ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" giống ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" bằng ") >= 0
									|| (" " + fb_message + " ").indexOf(" là ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" như ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" tày ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" tầy ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" tựa ") >= 0
									|| (" " + fb_message + " ")
											.indexOf(" hệt ") >= 0
									|| (" " + fb_message + " ")
											.indexOf("chẳng khác gì") >= 0
									|| point_negative != 0 || point_positive != 0)

					) {
						System.out.println(fb_message);
						tag = 10;
					}

					if (point_negative != 0 || point_positive != 0 || tag == 9
							|| tag == 5 || tag == 3 || tag == 8
							|| JSONResult_service != null
							|| JSONResult_object != null) {
						if (JSONResult_object == null) {
							if (JSONobject_post != null) {
								JSONResult_object = JSONobject_post;
							} else {
								if (JSONResult_object_from_name != null) {
									JSONResult_object = JSONResult_object_from_name;
								} else {
									if (JSONResult_object_page_name != null) {
										JSONResult_object = JSONResult_object_page_name;
									}
								}
							}

						}
						if (JSONResult_service == null) {
							JSONResult_service = JSONservice_post;
						}
						if ((JSONResult_object == null)
								&& JSONResult_service == null
								&& (involove - 2) >= 1) {
							involove = involove - 2;
						}
						if (JSONResult_service != null && (involove + 2) <= 7) {
							involove = involove + 2;
						}
						if ((JSONResult_object != null)
								&& JSONResult_service == null
								&& (involove + 2) <= 5) {
							involove = involove + 2;
						}
						if (fb_message.toLowerCase().indexOf("game") >= 0) {
							involove = 3;
						}

					}

					if (involove == 0) {
						involove = 1;
					}
					if ((point_positive > point_negative)
							&& (tag == 5 || tag == 9)) {
						point_negative = 0;
						point_positive = 0;
					}
					if (JSONResult_object != null) {
						if (Rule_spam.rule1_spam(fb_message) == 1) {
							System.out.println("Spam"
									+ Rule_spam.rule1_spam(fb_message));
							JSONResult_object = null;
						}
					}
					// if (JSONResult_object != null) {
					// if (Rule_spam.spam_stk(fb_message, list.size()) == 1) {
					// JSONResult_object = null;
					// }
					// }
					if (JSONResult_object != null) {
						if (Rule_spam.rule2_spam(fb_message, fb_from_name) == 1
								|| tag == 3) {
							System.out.println("rule 2 spam");
							point_negative = 0;
							point_positive = 0;
						}
					}
					if (JSONResult_object != null) {
						if (language.check(fb_message, languageDetector) == 1
								&& fb_message.toLowerCase()
										.indexOf("sacombank") < 0
								&& fb_message.toLowerCase().indexOf(
										"internet banking") < 0) {
							System.out.println("language english");
							JSONResult_object = null;
							point_negative = 0;
							point_positive = 0;
						}
					}
					if (point_negative != 0 || point_positive != 0) {
						try {
							tag_sentiment = Filter_sub.check_sub(model_sub,
									fb_message, sentiment_word);
						} catch (IOException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (JSONResult_object_from_name != null) {
						if (tag == 8) {
							JSONResult_object = JSONResult_object_from_name;
							check_service = FilterClient.update_service_hung(
									JSONResult_object, JSONResult_service,
									(short) 0, (short) 0, id_conten,
									(short) type, (short) 1, (short) 7, own,
									(short) involove, tag_sentiment);
						} else {
							JSONResult_object = JSONResult_object_from_name;
							check_service = FilterClient.update_service_hung(
									JSONResult_object, JSONResult_service,
									(short) 0, (short) 0, id_conten,
									(short) type, (short) 1, (short) tag, own,
									(short) involove, tag_sentiment);
						}
					} else {
						check_service = FilterClient.update_service_hung(
								JSONResult_object, JSONResult_service,
								(short) point_negative, (short) point_positive,
								id_conten, (short) type, (short) 1,
								(short) tag, own, (short) involove,
								tag_sentiment);
					}

				}
				String JSONResult_object_td = Check_object
						.check_comment_thetindung(fb_message, JSONobject_post,
								JSONResult_object_from_name, JSONResult_object);
				System.out.println("JSONResult_object_td: "
						+ JSONResult_object_td);
				if (JSONResult_object_td != null) {
					try {
						check_service = FilterClient.update_service_hung(
								JSONResult_object_td, JSONResult_service,
								(short) point_negative, (short) point_positive,
								id_conten, (short) type, (short) 1,
								(short) tag, own, (short) involove,
								tag_sentiment);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			System.out.println("object :" + JSONResult_object);
			System.out.println("object name :" + JSONResult_object_from_name);
			System.out.println("object post :" + JSONobject_post);
			System.out.println("object page name :"
					+ JSONResult_object_page_name);

			// Update du lieu
			long start = System.currentTimeMillis();
			TTransport transport2;
			transport2 = new TSocket("192.168.1.230", 2714);
			TProtocol protocol2 = new TBinaryProtocol(transport2);
			FilterMonitazService.Client client2 = new FilterMonitazService.Client(
					protocol2);
			try {
				transport2.open();
			} catch (TTransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (check_service == 0) {
				System.out.println("Update Mongo");
				try {
					client2.updateEs(id_conten, "is_filtered_banking");
				} catch (TException e) {
					e.printStackTrace();
				}
			}
			transport2.close();
			long end = System.currentTimeMillis();
			long t = end - start;
			System.out.println("Time update 1 record: " + t + " millisecond");
		} else {
			System.out.println("Update Suscess");
			TTransport transport3;
			transport3 = new TSocket("192.168.1.230", 2714);
			TProtocol protocol2 = new TBinaryProtocol(transport3);
			FilterMonitazService.Client client3 = new FilterMonitazService.Client(
					protocol2);
			try {
				transport3.open();
			} catch (TTransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				client3.updateEs(id_conten, "is_filtered_banking");
			} catch (TException e) {
				e.printStackTrace();
			}
			transport3.close();

		}

	}
	// sửa lỗi mention type , kiểm tra cả dược phẩm
}
