package object_service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import remove_vietnamese.AccentRemover;
import util.Utils.point;
import util.Utils.sentiment;

public class Check_sentiment {
	// public ArrayList<sentiment> sentiment;
	public static util.Utils.point set_point(ArrayList<sentiment> sentiment,
			String k) {
		int negative = 0;
		int positive = 0;
		int count_negative = 0;
		int count_positive = 0;
		int max_negative = 0;
		int max_positive = 0;
		int check;
		int indexof_negative = -1;
		int indexof_positive = -1;
		for (int i = 0; i < sentiment.size(); i++) {
			String test;
			String test1;
			String s;
			String test2;
			// System.out.println(sentiment.get(i).word);
			s = k;
			s = s.replaceAll("j", "i");
			s = s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
					.toLowerCase(Locale.getDefault());
			s = " " + s + " ";
			test = " " + sentiment.get(i).word + " ";
			test2 = AccentRemover.removeAccent(sentiment.get(i).word);
			test2 = test2.trim();
			if (test.compareTo(" buồn ") == 0 || test.compareTo(" chán ") == 0) {
				test1 = test;
			} else {
				if ((printText(test2, " ") >= 2)
						|| (printText(test2, " ") >= 1 && (test2.indexOf("ko") < 0
								&& test2.indexOf(" k ") < 0
								&& test2.indexOf("không") < 0
								&& test2.indexOf("bất") < 0
								&& test2.indexOf("hok") < 0
								&& test2.indexOf("chẳng") < 0
								&& test2.indexOf("đếch") < 0 && test2
								.indexOf("đéo") < 0))) {
					test1 = AccentRemover.removeAccent(test);
				} else {
					test1 = null;
				}
			}
			if (sentiment.get(i).status == 1) {

				if (check_(s, test) == 1 && check_trung(s, test) == 1) {
					System.out.println(test);
					if (sentiment.get(i).pid != 0) {
						if (check_num(s, sentiment.get(i).word) == 1) {
							// System.out.println(sentiment.get(i).word);
							if (max_positive < sentiment.get(i).point + 2) {
								max_positive = sentiment.get(i).point + 2;
							}
						} else {
							// System.out.println(sentiment.get(i).word);
							if (max_positive < sentiment.get(i).point) {
								max_positive = sentiment.get(i).point;
							}
						}
						if (indexof_positive == -1) {
							indexof_positive = s.indexOf(test);
						} else {
							if (indexof_positive > s.indexOf(test)) {
								indexof_positive = s.indexOf(test);
							}
						}
						count_positive = count_positive + printText(s, test);

					} else {
						check = check(s, sentiment.get(i).id, sentiment);
						System.out.println("check :" + check);
						if (check == 0) {
							if (check_num(s, sentiment.get(i).word) == 1) {
								// System.out.println(sentiment.get(i).word);
								if (max_positive < sentiment.get(i).point + 2) {
									max_positive = sentiment.get(i).point + 2;
								}
							} else {
								// System.out.println(sentiment.get(i).word);
								if (max_positive < sentiment.get(i).point) {
									max_positive = sentiment.get(i).point;
								}
							}
							if (indexof_positive == -1) {
								indexof_positive = s.indexOf(test);
							} else {
								if (indexof_positive > s.indexOf(test)) {
									indexof_positive = s.indexOf(test);
								}
							}
							count_positive = count_positive
									+ printText(s, test);
							System.out.println(sentiment.get(i).word);
							System.out.println(check_(s, test));
						}
					}
				}
				if (check_(s, test1) == 1 && check_trung(s, test1) == 1) {
					if (sentiment.get(i).pid != 0) {
						if (check_num(s, test2) == 1) {
							System.out.println(test2);
							if (max_positive < sentiment.get(i).point + 2) {
								max_positive = sentiment.get(i).point + 2;
							}
						} else {
							System.out.println(sentiment.get(i).word);
							if (max_positive < sentiment.get(i).point) {
								max_positive = sentiment.get(i).point;
							}
						}
						if (indexof_positive == -1) {
							indexof_positive = s.indexOf(test1);
						} else {
							if (indexof_positive > s.indexOf(test1)) {
								indexof_positive = s.indexOf(test1);
							}
						}
						count_positive = count_positive + printText(s, test1);
						System.out.println(sentiment.get(i).word);

					} else {
						check = check(s, sentiment.get(i).id, sentiment);
						if (check == 0) {
							if (check_num(s, sentiment.get(i).word) == 1) {
								System.out.println(sentiment.get(i).word);
								if (max_positive < sentiment.get(i).point + 2) {
									max_positive = sentiment.get(i).point + 2;
								}
							} else {
								if (max_positive < sentiment.get(i).point) {
									max_positive = sentiment.get(i).point;
								}
							}
							if (indexof_positive == -1) {
								indexof_positive = s.indexOf(test1);
							} else {
								if (indexof_positive > s.indexOf(test1)) {
									indexof_positive = s.indexOf(test1);
								}
							}
							count_positive = count_positive
									+ printText(s, test1);
							System.out.println(sentiment.get(i).word);
							System.out.println(check_(s, test));

						}
					}
				}
			}
			if (sentiment.get(i).status == 2) {
				if (check_(s, test) == 1 && check_trung(s, test) == 1) {
					if (sentiment.get(i).pid != 0) {

						if (check_num(s, sentiment.get(i).word) == 1) {
							System.out.println(sentiment.get(i).word);
							if (max_negative < sentiment.get(i).point + 2) {
								max_negative = sentiment.get(i).point + 2;
							}
						} else {
							if (max_negative < sentiment.get(i).point) {
								max_negative = sentiment.get(i).point;
							}
						}
						if (indexof_negative == -1) {
							indexof_negative = s.indexOf(test);
						} else {
							if (indexof_negative > s.indexOf(test)) {
								indexof_negative = s.indexOf(test);
							}
						}
						count_negative = count_negative + printText(s, test);
						System.out.println(sentiment.get(i).word);

					} else {
						check = check(s, sentiment.get(i).id, sentiment);
						if (check == 0) {

							if (check_num(s, sentiment.get(i).word) == 1) {
								System.out.println(sentiment.get(i).word);
								if (max_negative < sentiment.get(i).point + 2) {
									max_negative = sentiment.get(i).point + 2;
								}
							} else {
								if (max_negative < sentiment.get(i).point) {
									max_negative = sentiment.get(i).point;
								}
							}
							if (indexof_negative == -1) {
								indexof_negative = s.indexOf(test);
							} else {
								if (indexof_negative > s.indexOf(test)) {
									indexof_negative = s.indexOf(test);
								}
							}

							count_negative = count_negative
									+ printText(s, test);
							System.out.println(sentiment.get(i).word);

						}
					}
				}
				if (check_(s, test1) == 1 && check_trung(s, test1) == 1) {
					if (sentiment.get(i).pid != 0) {

						if (check_num(s, sentiment.get(i).word) == 1) {
							System.out.println(sentiment.get(i).word);
							if (max_negative < sentiment.get(i).point + 2) {
								max_negative = sentiment.get(i).point + 2;
							}
						} else {
							if (max_negative < sentiment.get(i).point) {
								max_negative = sentiment.get(i).point;
							}
						}
						if (indexof_negative == -1) {
							indexof_negative = s.indexOf(test1);
						} else {
							if (indexof_negative > s.indexOf(test1)) {
								indexof_negative = s.indexOf(test1);
							}
						}
						count_negative = count_negative + printText(s, test1);
						System.out.println(sentiment.get(i).word);

					} else {
						check = check(s, sentiment.get(i).id, sentiment);
						if (check == 0) {

							if (check_num(s, sentiment.get(i).word) == 1) {
								System.out.println(sentiment.get(i).word);
								if (max_negative < sentiment.get(i).point + 2) {
									max_negative = sentiment.get(i).point + 2;
								}
							} else {
								if (max_negative < sentiment.get(i).point) {
									max_negative = sentiment.get(i).point;
								}
							}
							if (indexof_negative == -1) {
								indexof_negative = s.indexOf(test1);
							} else {
								if (indexof_negative > s.indexOf(test1)) {
									indexof_negative = s.indexOf(test1);
								}
							}
							count_negative = count_negative
									+ printText(s, test1);
							System.out.println(sentiment.get(i).word);

						}
					}
				}

			}
		}
		if (count_negative != 0) {
			negative = max_negative + ((max_negative * 2) / 7);
		}
		if (count_positive != 0) {
			positive = max_positive + ((max_positive * 2) / 7);
		}
		if (k.toLowerCase().indexOf("đáp án ") >= 0
				|| k.toLowerCase().indexOf("dap an ") >= 0
				|| k.toLowerCase().indexOf("game") >= 0) {
			negative = 0;
			positive = 0;
		}
		if (negative == 3 && k.toLowerCase().indexOf("thu pham") >= 0) {
			negative = 0;
		}
		if (k.toLowerCase().indexOf("vietcom") >= 0
				&& (k.toLowerCase().indexOf("biểu tình") >= 0 || k
						.toLowerCase().indexOf("quỵt nợ") >= 0)) {
			negative = 7;
		}
		// System.out.println("Vi tri negative " + indexof_negative);
		// System.out.println("Vi tri positive " + indexof_positive);
		point a = new point();
		a.negative = negative;
		a.positive = positive;
		a.indexof_negative = indexof_negative;
		a.indexof_positive = indexof_positive;
		System.out.println("negative" + negative);
		System.out.println("positive" + positive);
		return a;
	}

	public static int check(String s, int a, ArrayList<sentiment> sentiment) {
		int check = 0;
		for (int i = 0; i < sentiment.size(); i++) {
			if (printText(" " + s + " ", " " + sentiment.get(i).word + " ") > 0
					&& sentiment.get(i).pid == a) {
				System.out.println(sentiment.get(i).word);
				check = 1;
				break;
			}
		}
		return check;
	}

	public static int check_(String s, String test) {
		int check = 0;
		if (test != null && printText(s, test) > 0) {
			if (test.indexOf("tốt") >= 0 || test.indexOf("thích") >= 0
					|| test.indexOf("yêu") >= 0 || test.indexOf("lỗi") >= 0
					|| test.indexOf("kiện") >= 0 || test.indexOf("buồn") >= 0
					|| test.indexOf("ủng hộ") >= 0) {
				if (printText(s, "giai" + test) == 0
						&& printText(s, "giải" + test) == 0
						// && printText(s, "giai" + test1) == 0
						// && printText(s, "giải" + test1) == 0
						&& printText(s, test + "nghiệp") == 0
						&& printText(s, test + "nghiep") == 0
						// && printText(s, test1 + "nghiệp") == 0
						// && printText(s, test1 + "nghiep") == 0
						&& printText(s, test + "thương") == 0
						&& printText(s, test + "thuong") == 0
						&& printText(s, "kích" + test) == 0
						&& printText(s, "kich" + test) == 0
						&& printText(s, test + "cầu") == 0
						&& printText(s, test + "cau") == 0
						&& printText(s, "tình" + test) == 0
						&& printText(s, "tinh" + test) == 0
						&& printText(s, test + "đáng") == 0
						&& printText(s, test + "dang") == 0
						&& printText(s, "xin" + test) == 0
						&& printText(s, "sự" + test) == 0
						&& printText(s, "su" + test) == 0
						&& printText(s, "điều" + test) == 0
						&& printText(s, "dieu" + test) == 0
						&& printText(s, "đièu" + test) == 0
						&& printText(s, test + "cười") == 0
						&& printText(s, test + "cuoi") == 0
						&& printText(s, test + "ngủ") == 0
						&& printText(s, "chia" + test) == 0) {
					check = 1;
				}

			} else {
				check = 1;
			}
		}
		return check;
	}

	public static int check_trung(String s, String test) {
		int check = 0;
		if (test.indexOf("không ") < 0 || test.indexOf("ko ") < 0
				|| test.indexOf("hok ") < 0 || test.indexOf("bất ") < 0
				|| test.indexOf("mất ") < 0 || test.indexOf("chẳng ") < 0
				|| test.indexOf("chẳng đáng ") < 0 || test.indexOf("đếch ") < 0
				|| test.indexOf("đéo ") < 0 || test.indexOf("kg ") < 0
				|| test.indexOf("k ") < 0) {
			if (printText(s, test) > 0 && printText(s, "ko" + test) == 0
					&& printText(s, "không" + test) == 0
					&& printText(s, "hok" + test) == 0
					&& printText(s, "bất" + test) == 0
					&& printText(s, "mất" + test) == 0
					&& printText(s, "chẳng" + test) == 0
					&& printText(s, "chẳng đáng" + test) == 0
					&& printText(s, "đếch" + test) == 0
					&& printText(s, "đéo" + test) == 0
					&& printText(s, "kg" + test) == 0
					&& printText(s, " k" + test) == 0) {

				check = 1;
			}
		} else {
			check = 1;
		}
		return check;
	}

	public static int check_num(String s, String a) {
		int check = 0;
		if (printText(s, " rất " + a) > 0) {
			check = 1;
		}
		if (printText(s, " quá " + a) > 0) {
			check = 1;
		}
		if (printText(s, " quá là " + a) > 0) {
			check = 1;
		}
		if (printText(s, a + " rất nhiều") > 0) {
			check = 1;
		}
		if (printText(s, a + " nhất ") > 0) {
			check = 1;
		}
		if (printText(s, " rat " + AccentRemover.removeAccent(a)) > 0) {
			check = 1;
		}
		if (printText(s, " qua " + AccentRemover.removeAccent(a)) > 0) {
			check = 1;
		}
		if (printText(s, " qua la " + AccentRemover.removeAccent(a) + " ") > 0) {
			check = 1;
		}
		if (printText(s, " cực kỳ " + AccentRemover.removeAccent(a) + " ") > 0) {
			check = 1;
		}
		if (printText(s, " " + AccentRemover.removeAccent(a) + " rat nhieu") > 0) {
			check = 1;
		}
		if (printText(s, " " + AccentRemover.removeAccent(a) + " nhat") > 0) {
			check = 1;
		}

		return check;
	}

	public static int printText(String s, String character) {
		int count = 0;
		if (character != null) {
			Pattern pattern = Pattern.compile(character);
			Matcher matcher = pattern.matcher(s);
			while (matcher.find()) {
				count++;
			}
		}
		return count;
	}

	public static int count_Text(String s) {
		int count = 0;
		char[] stringToCharArray = s.toCharArray();

		for (char output : stringToCharArray) {
			if (output == '?') {
				count = count + 1;
			}
		}
		return count;
	}

	public static point setpoints_compare_objects(int indexof_object,
			int indexof_negative, int indexof_positive, int point_negative,
			int point_positive) {
		System.out.println("Du lieu" + indexof_object + indexof_negative
				+ indexof_positive + point_negative + point_positive);
		int negative = 0;
		int positive = 0;

		if (indexof_negative == -1 && indexof_positive != -11) {
			// BIDV tốt hơn agribank (page agribank)
			if (indexof_object < indexof_positive) {
				negative = point_positive;
			}
			if (indexof_object > indexof_positive) {
				positive = point_positive;
			}

		}
		if (indexof_negative != -1 && indexof_positive == -1) {
			// BIDV xấu hơn agribank (page agribank)
			if (indexof_object < indexof_negative) {
				positive = point_negative;
			}
			if (indexof_object > indexof_negative) {
				negative = point_negative;
			}
		}
		if (indexof_negative != -1 && indexof_positive != -1) {

			if (indexof_negative < indexof_positive) {
				if (indexof_object < indexof_negative) {
					// BIDV xấu hơn agribank nhưng dịch vụ lại tốt hơn rất
					// nhiều.
					// (page agribank).
					if (point_negative < point_positive) {
						negative = point_positive;
					}
					// BIDV xấu hơn agribank nhưng dịch vụ cũng chỉ tạm thôi, k
					// bằng
					// agribank (page agribank)
					else {
						positive = point_negative;
					}
				} else {
					// BIDV xấu hơn agribank nhưng dịch vụ lại tốt hơn rất
					// nhiều.
					// (page bidv).
					if (point_negative < point_positive) {
						positive = point_positive;
					} else {
						negative = point_negative;
					}

				}
			}

			if (indexof_positive < indexof_negative) {
				if (indexof_object < indexof_positive) {
					// BIDV tốt hơn agribank nhưng dịch vụ cũng kém hơn chút.
					// (page
					// agribank).
					if (point_negative < point_positive) {
						negative = point_positive;
					}
					// BIDV tốt hơn agribank nhưng dịch vụ tệ hơn nhiều quá.
					// (page
					// agribank).
					else {
						positive = point_negative;
					}
				} else {
					// BIDV tốt hơn agribank nhưng dịch vụ kém hơn một chút.
					// (page
					// bidv).
					if (point_negative < point_positive) {
						positive = point_positive;
					}
					// BIDV tốt hơn agribank nhưng dịch vụ kém hơn nhiều quá.
					// (page
					// bidv).
					else {
						negative = point_negative;
					}

				}
			}
		}
		point a = new point();
		a.negative = negative;
		a.positive = positive;
		a.indexof_negative = indexof_negative;
		a.indexof_positive = indexof_positive;
		System.out.println("negative" + negative);
		System.out.println("positive" + positive);
		return a;
	}

	public static void main(String[] args) throws IOException {

		System.out.println(check_("xin lỗi , điều kiện , sự kiện, thiếu sót",
				" kiện "));
	}
}
