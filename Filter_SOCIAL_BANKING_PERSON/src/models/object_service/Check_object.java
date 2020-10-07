package object_service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import json_cv.object;
import util.Utils.Object;

import org.json.simple.JSONArray;

public class Check_object {
	public static int check_object(String h, String character, int status) {
		String s;
		s = h;
		s = Normalizer.normalize(
				s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
						.toLowerCase(), Normalizer.Form.NFC);
		character = Normalizer.normalize(character.replaceAll("\\p{P}", " ")
				.replaceAll("\\s+", " ").toLowerCase(), Normalizer.Form.NFC);
		int check = 0;
		if (character.toLowerCase().indexOf("bank") >= 0) {
			status = 2;
		}
		// System.out.println(s);
		if (status == 1) {
			String k = " " + s + " ";
			if (k.indexOf(" " + character + " ") >= 0
					&& k.indexOf("tòa nhà " + character) < 0
					&& k.indexOf("sát " + character) < 0
					&& k.indexOf("sát ngân hàng " + character) < 0
					&& k.indexOf("toa nha " + character) < 0
					&& k.indexOf("đối diện " + character) < 0
					&& k.indexOf("đối dien ngân hàng " + character) < 0
					&& k.indexOf("đối dien " + character) < 0
					&& k.indexOf("đối diên " + character) < 0
					&& k.indexOf("ngõ " + character) < 0
					&& k.indexOf("hẻm " + character) < 0
					&& k.indexOf("đối diện với ngân hàng " + character) < 0
					&& k.indexOf("gần ngân hàng " + character) < 0
					&& k.indexOf("gần " + character) < 0
					&& k.indexOf("sau lưng ngân hàng " + character) < 0
					&& k.indexOf("sau lưng " + character) < 0
					&& k.indexOf("kế bên ngân hàng " + character) < 0
					&& k.indexOf("kế bên " + character) < 0
					&& k.indexOf("cạnh " + character) < 0
					&& k.indexOf("cạnh ngân hàng " + character) < 0
					&& k.indexOf("đối diện ngân hàng " + character) < 0
					&& k.indexOf("sau ngân hàng " + character) < 0

					&& k.indexOf("đối diện với nh " + character) < 0
					&& k.indexOf("gần nh " + character) < 0
					&& k.indexOf("sau lưng nh " + character) < 0
					&& k.indexOf("cạnh nh " + character) < 0
					&& k.indexOf("kế bên nh " + character) < 0

					&& k.indexOf("đối diện với ngan hang " + character) < 0
					&& k.indexOf("gần ngan hang " + character) < 0
					&& k.indexOf("sau lưng ngan hang " + character) < 0
					&& k.indexOf("cạnh ngan hang " + character) < 0
					&& k.indexOf("kế bên ngan hang " + character) < 0

					&& k.indexOf("kế nh " + character) < 0
					&& k.indexOf("đối diện với " + character) < 0
					&& k.indexOf("tòa ngân hàng " + character) < 0
					&& k.indexOf("toà nhà " + character) < 0
					&& k.indexOf("tòa nhà " + character) < 0
					&& k.indexOf("toà " + character) < 0
					&& k.indexOf("tòa " + character) < 0
					&& k.indexOf("toà ngân hàng " + character) < 0
					&& k.indexOf("đối điện ngân hàng " + character) < 0
					&& k.indexOf("đối điện ngay ngân hàng " + character) < 0
					&& k.indexOf("đối điện ngay " + character) < 0
					&& k.indexOf("sát cánh ngân hàng " + character) < 0
					&& k.indexOf("sát cánh " + character) < 0
					&& k.indexOf("kế ngân hàng " + character) < 0
					&& k.indexOf("kế " + character) < 0
					&& k.indexOf("đôi diện " + character) < 0
					&& k.indexOf("đôi diện ngân hàng " + character) < 0
					&& k.indexOf("trước ngân hàng " + character) < 0
					&& k.indexOf("trước " + character) < 0

			) {
				check = check + 1;
			}
		}
		if (status == 2) {
			if (character.indexOf(" ") < 0) {
				if (s.indexOf(character) == 0
						|| character.toLowerCase().indexOf("ngân hàng") >= 0
						|| character.toLowerCase().indexOf("bank") >= 0) {
					if (((s + " ").indexOf(character + " ") >= 0 || (" " + s)
							.indexOf(" " + character) >= 0)
							&& s.indexOf("tòa nhà " + character) < 0
							&& s.indexOf("toa nha " + character) < 0
							&& s.indexOf("sát " + character) < 0
							&& s.indexOf("sát ngân hàng " + character) < 0
							&& s.indexOf("đối diện " + character) < 0
							&& s.indexOf("đối dien " + character) < 0
							&& s.indexOf("đối dien ngân hàng " + character) < 0
							&& s.indexOf("ngõ " + character) < 0
							&& s.indexOf("hẻm " + character) < 0
							&& s.indexOf("đối diện với ngân hàng " + character) < 0
							&& s.indexOf("gần ngân hàng " + character) < 0
							&& s.indexOf("gần " + character) < 0
							&& s.indexOf("sau lưng ngân hàng " + character) < 0
							&& s.indexOf("sau lưng " + character) < 0
							&& s.indexOf("kế bên ngân hàng " + character) < 0
							&& s.indexOf("kế bên " + character) < 0
							&& s.indexOf("cạnh ngân hàng " + character) < 0
							&& s.indexOf("cạnh " + character) < 0
							&& s.indexOf("đối diện ngân hàng " + character) < 0
							&& s.indexOf("sau ngân hàng " + character) < 0
							&& s.indexOf("đối diên " + character) < 0

							&& s.indexOf("đối diện với nh " + character) < 0
							&& s.indexOf("gần nh " + character) < 0
							&& s.indexOf("sau lưng nh " + character) < 0
							&& s.indexOf("cạnh nh " + character) < 0
							&& s.indexOf("kế bên nh " + character) < 0

							&& s.indexOf("đối diện với ngan hang " + character) < 0
							&& s.indexOf("gần ngan hang " + character) < 0
							&& s.indexOf("sau lưng ngan hang " + character) < 0
							&& s.indexOf("cạnh ngan hang " + character) < 0
							&& s.indexOf("kế bên ngan hang " + character) < 0
							&& s.indexOf("kế nh " + character) < 0
							&& s.indexOf("đối diện với " + character) < 0
							&& s.indexOf("tòa ngân hàng " + character) < 0
							&& s.indexOf("toà nhà " + character) < 0
							&& s.indexOf("tòa nhà " + character) < 0
							&& s.indexOf("toà " + character) < 0
							&& s.indexOf("tòa " + character) < 0
							&& s.indexOf("toà ngân hàng " + character) < 0
							&& s.indexOf("đối điện ngay ngân hàng " + character) < 0
							&& s.indexOf("đối điện ngay " + character) < 0
							&& s.indexOf("đối điện ngân hàng " + character) < 0
							&& s.indexOf("sát cánh ngân hàng " + character) < 0
							&& s.indexOf("sát cánh " + character) < 0
							&& s.indexOf("kế ngân hàng " + character) < 0
							&& s.indexOf("kế " + character) < 0
							&& s.indexOf("đôi diện " + character) < 0
							&& s.indexOf("đôi diện ngân hàng " + character) < 0
							&& s.indexOf("trước ngân hàng " + character) < 0
							&& s.indexOf("trước " + character) < 0

					) {
						check = check + 1;

					}
				} else {
					String k = " " + s + " ";
					if (k.indexOf(" " + character + " ") >= 0
							&& k.indexOf("tòa nhà " + character) < 0
							&& k.indexOf("toa nha " + character) < 0
							&& k.indexOf("sát " + character) < 0
							&& k.indexOf("sát ngân hàng " + character) < 0
							&& k.indexOf("đối diện " + character) < 0
							&& k.indexOf("đối dien ngân hàng " + character) < 0
							&& k.indexOf("đối dien " + character) < 0
							&& k.indexOf("ngõ " + character) < 0
							&& k.indexOf("hẻm " + character) < 0
							&& k.indexOf("đối diện với ngân hàng " + character) < 0
							&& k.indexOf("gần ngân hàng " + character) < 0
							&& k.indexOf("gần " + character) < 0
							&& k.indexOf("sau lưng ngân hàng " + character) < 0
							&& k.indexOf("sau lưng " + character) < 0
							&& k.indexOf("kế bên ngân hàng " + character) < 0
							&& k.indexOf("kế bên " + character) < 0
							&& k.indexOf("cạnh " + character) < 0
							&& k.indexOf("cạnh ngân hàng " + character) < 0
							&& k.indexOf("đối diện ngân hàng " + character) < 0
							&& k.indexOf("sau ngân hàng " + character) < 0
							&& k.indexOf("đối diên " + character) < 0

							&& k.indexOf("đối diện với nh " + character) < 0
							&& k.indexOf("gần nh " + character) < 0
							&& k.indexOf("sau lưng nh " + character) < 0
							&& k.indexOf("cạnh nh " + character) < 0
							&& k.indexOf("kế bên nh " + character) < 0
							&& k.indexOf("tòa nhà " + character) < 0
							&& k.indexOf("toà " + character) < 0
							&& k.indexOf("tòa " + character) < 0
							&& k.indexOf("đối diện với ngan hang " + character) < 0
							&& k.indexOf("gần ngan hang " + character) < 0
							&& k.indexOf("sau lưng ngan hang " + character) < 0
							&& k.indexOf("cạnh ngan hang " + character) < 0
							&& k.indexOf("kế bên ngan hang " + character) < 0
							&& k.indexOf("đối điện ngay ngân hàng " + character) < 0
							&& k.indexOf("kế nh " + character) < 0
							&& k.indexOf("đối diện với " + character) < 0
							&& k.indexOf("tòa ngân hàng " + character) < 0
							&& k.indexOf("toà nhà " + character) < 0
							&& k.indexOf("toà ngân hàng " + character) < 0
							&& k.indexOf("đối điện ngân hàng " + character) < 0
							&& k.indexOf("đối điện ngay " + character) < 0
							&& k.indexOf("sát cánh ngân hàng " + character) < 0
							&& k.indexOf("sát cánh " + character) < 0
							&& k.indexOf("kế ngân hàng " + character) < 0
							&& k.indexOf("kế " + character) < 0
							&& k.indexOf("đôi diện " + character) < 0
							&& k.indexOf("đôi diện ngân hàng " + character) < 0
							&& k.indexOf("trước ngân hàng " + character) < 0
							&& k.indexOf("trước " + character) < 0

					) {
						check = check + 1;
					}
				}
			}

			else {
				String k = " " + s + " ";
				if (k.indexOf(" " + character + " ") >= 0
						&& k.indexOf("tòa nhà " + character) < 0
						&& k.indexOf("toa nha " + character) < 0
						&& k.indexOf("sát " + character) < 0
						&& k.indexOf("sát ngân hàng " + character) < 0
						&& k.indexOf("đối diện " + character) < 0
						&& k.indexOf("đối dien ngân hàng " + character) < 0
						&& k.indexOf("đối dien " + character) < 0
						&& k.indexOf("đối diên " + character) < 0
						&& k.indexOf("ngõ " + character) < 0
						&& k.indexOf("hẻm " + character) < 0
						&& k.indexOf("đối diện với ngân hàng " + character) < 0
						&& k.indexOf("gần ngân hàng " + character) < 0
						&& k.indexOf("gần " + character) < 0
						&& k.indexOf("sau lưng ngân hàng " + character) < 0
						&& k.indexOf("sau lưng " + character) < 0
						&& k.indexOf("kế bên ngân hàng " + character) < 0
						&& k.indexOf("kế bên " + character) < 0
						&& k.indexOf("cạnh " + character) < 0
						&& k.indexOf("cạnh ngân hàng " + character) < 0
						&& k.indexOf("đối diện ngân hàng " + character) < 0
						&& k.indexOf("sau ngân hàng " + character) < 0
						&& k.indexOf("đối điện ngay ngân hàng " + character) < 0
						&& k.indexOf("đối diện với nh " + character) < 0
						&& k.indexOf("gần nh " + character) < 0
						&& k.indexOf("sau lưng nh " + character) < 0
						&& k.indexOf("cạnh nh " + character) < 0
						&& k.indexOf("kế bên nh " + character) < 0
						&& k.indexOf("tòa nhà " + character) < 0
						&& k.indexOf("toà " + character) < 0
						&& k.indexOf("tòa " + character) < 0
						&& k.indexOf("đối diện với ngan hang " + character) < 0
						&& k.indexOf("gần ngan hang " + character) < 0
						&& k.indexOf("sau lưng ngan hang " + character) < 0
						&& k.indexOf("cạnh ngan hang " + character) < 0
						&& k.indexOf("kế bên ngan hang " + character) < 0

						&& k.indexOf("kế nh " + character) < 0
						&& k.indexOf("đối diện với " + character) < 0
						&& k.indexOf("tòa ngân hàng " + character) < 0
						&& k.indexOf("toà nhà " + character) < 0
						&& k.indexOf("toà ngân hàng " + character) < 0
						&& k.indexOf("đối điện ngân hàng " + character) < 0
						&& k.indexOf("đối điện ngay " + character) < 0
						&& k.indexOf("sát cánh ngân hàng " + character) < 0
						&& k.indexOf("sát cánh " + character) < 0
						&& k.indexOf("kế ngân hàng " + character) < 0
						&& k.indexOf("kế " + character) < 0
						&& k.indexOf("đôi diện " + character) < 0
						&& k.indexOf("đôi diện ngân hàng " + character) < 0
						&& k.indexOf("trước ngân hàng " + character) < 0
						&& k.indexOf("trước " + character) < 0

				) {
					check = check + 1;
				}
			}

		}
		return check;
	}

	public static int check_object_confusion(String tmp, String character) {
		int check = 0;
		String s;
		s = tmp.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");
		System.out.println(s);
		tmp = Normalizer.normalize(tmp, Normalizer.Form.NFC).toLowerCase();
		s = Normalizer.normalize(s, Normalizer.Form.NFC).toLowerCase();
		if (character.compareTo("ngân hàng sài gòn") == 0
				|| character.compareTo("nh tmcp sài gòn") == 0
				|| character.compareTo("ngan hang sai gon") == 0
				|| character.compareTo("nh sai gon") == 0
				|| character.compareTo("ngân hàng tmcp sài gòn") == 0
				|| character.compareTo("ngân hàng thương mại cổ phần sài gòn") == 0) {
			if (s.indexOf("ngân hàng sài gòn thương tín") >= 0
					|| s.indexOf("ngân hàng sài gòn công thương") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn-hà nội") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn hà nội") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn thương tín") >= 0
					|| s.indexOf("ngân hàng sài gòn hà nội") >= 0
					|| s.indexOf("ngân hàng sài gòn - hà nội") >= 0
					|| s.indexOf("nh sai gon thuong tin") >= 0
					|| s.indexOf("nh sai gon cong thuong") >= 0
					|| s.indexOf("nh sai gon ha noi") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn thường tín") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn thương tín") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn - hà nội") >= 0
					|| s.indexOf("ngân hàng tmcp sài gòn công thương") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn ha noi") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn - ha noi") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn hà nội") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn - hà nội") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn-hà nội") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn công thương") >= 0
					|| s.indexOf("ngân hàng thương mại cổ phần sài gòn thương tín") >= 0
					|| s.indexOf("nh tmcp sai gon - ha noi") >= 0
					|| s.indexOf("nh tmcp sai gon cong thuong") >= 0) {
				check = check + 1;
			}
		}
		if (s.toLowerCase().trim().compareTo("agri bitboy") == 0
				|| s.toLowerCase().trim().compareTo("agri thắng") == 0
				|| s.toLowerCase().trim().compareTo("tee anz") == 0
				|| s.toLowerCase().trim().compareTo("agribank thắng") == 0
				|| s.toLowerCase().trim().compareTo("vân vpbank") == 0
				|| s.toLowerCase().trim().compareTo("hiền seabank") == 0
				|| s.toLowerCase().trim().compareTo("phong vpbank") == 0
				|| s.toLowerCase().trim().compareTo("huong agri") == 0
				|| s.toLowerCase().trim().compareTo("tieu mari") == 0
				|| s.toLowerCase().trim().compareTo("ngô tuấn vietcombank") == 0
				|| s.toLowerCase().trim().compareTo("dũng hsbc") == 0
				|| s.toLowerCase().trim().compareTo("cường sacombank") == 0
				|| s.toLowerCase().trim().compareTo("hong trinh vpbank") == 0
				|| s.toLowerCase().trim().compareTo("hà nội acb") == 0
				|| s.toLowerCase().trim().compareTo("tuan agribank") == 0
				|| s.toLowerCase().trim().compareTo("vietin bank tran daj") == 0
				|| s.toLowerCase().trim().compareTo("phạm tư vp bank") == 0
				|| s.toLowerCase().trim().compareTo("tai tâm sacom") == 0
				|| s.toLowerCase().trim().compareTo("hdbank hoàng") == 0
				|| s.toLowerCase().trim().compareTo("ggri mblue") == 0) {
			check = check + 1;
		}

		if (character.compareTo("standard") == 0) {
			if (s.indexOf("standard chartered") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("mb") == 0) {
			if (s.indexOf("diện tích mb") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("vietcom") == 0) {
			if (s.indexOf("vietcom education") >= 0) {
				check = check + 1;
			}
		}

		if (character.compareTo("citi") == 0) {
			if (s.indexOf("citi bank") < 0 || s.indexOf(" nh citi ") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("tech") == 0) {
			if (s.indexOf("techcombank") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("ngân hàng ngoại thương") == 0) {
			if (tmp.toLowerCase().indexOf("ngân hàng;ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng; ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng , ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng, ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng,ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng. ngoại thương") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng.ngoại thương") >= 0) {
				check = check + 1;
			}
		}

		if (character.compareTo("ngân hàng bưu điện") == 0) {
			if (tmp.toLowerCase().indexOf("ngân hàng;bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng; bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng , bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng, bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng,bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng. bưu điện") >= 0
					|| tmp.toLowerCase().indexOf("ngân hàng.bưu điện") >= 0) {
				check = check + 1;
			}
		}

		if (character.compareTo("maritime") == 0
				&& s.indexOf("maritime bank") < 0
				&& s.indexOf("maritimebank") < 0) {
			check = check + 1;
		}
		if (character.compareTo("mari") == 0) {
			if (s.indexOf("maritimebank") < 0 && s.indexOf("maritime bank") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("acb") == 0) {
			if (s.indexOf("công ty du lịch acb") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("mb") == 0) {
			if (s.indexOf("diện tích mb") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("vietbank") == 0) {
			if (s.indexOf(" vietbank ") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("nam á") == 0) {
			if (s.indexOf("đông nam á") >= 0
					&& s.indexOf("ngân hàng nam á") < 0
					&& s.indexOf("nam á bank") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("nam á") == 0) {
			if (s.indexOf("bắc phi") >= 0 && s.indexOf("nam âu") >= 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("bản việt") == 0) {
			if (s.indexOf("phiên bản việt") >= 0
					|| s.indexOf("bản việt nam") >= 0
					|| s.indexOf("nhật bản việt") >= 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("ncb") == 0) {
			if (s.indexOf("nước cân bằng") >= 0
					|| s.indexOf("nước_cân_bằng") >= 0
					|| s.indexOf("nuoccanbang") >= 0
					|| s.indexOf("nuoc can bang") >= 0
					|| s.indexOf("ncb da thần kì") >= 0
					|| s.indexOf("ncb da thần kỳ") >= 0
					|| s.indexOf("lục nam ncb") >= 0
					|| s.indexOf("new consultant bonus") >= 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("đông á") == 0
				|| character.compareTo("dong a") == 0) {
			if (s.indexOf("ngân hàng") < 0 && s.indexOf("atm") < 0
					&& s.indexOf("bank") < 0 && s.indexOf("gửi tiền") < 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("đông á") == 0
				|| character.compareTo("dong a") == 0) {
			if (s.indexOf("đại học đông á") >= 0
					|| s.indexOf("tôn đông á") >= 0
					|| s.indexOf("nhựa đông á") >= 0
					|| s.indexOf("cao đẳng đông á") >= 0
					|| s.indexOf("nhôm đông á") >= 0
					|| s.indexOf(" đh đông á") >= 0
					|| s.indexOf("mỹ tại đông á") >= 0
					|| s.indexOf(" dh đông á") >= 0
					|| s.indexOf(" cd đông á") >= 0
					|| s.indexOf(" cđ đông á") >= 0
					|| s.indexOf("dh đông á") >= 0
					|| s.indexOf("giấy đông á") >= 0
					|| s.indexOf("khu vực đông á") >= 0
					|| s.indexOf("đông á khu vực") >= 0
					|| s.indexOf("vùng đông á") >= 0
					|| s.indexOf("nước đông á") >= 0
					|| s.indexOf("gdb của đông á") >= 0
					|| s.indexOf("công nghệ đông á") >= 0
					|| s.indexOf("học sinh đông á") >= 0
					|| s.indexOf("nhôm kính đông á") >= 0
					|| s.indexOf("ngoại ngữ đông á") >= 0
					|| s.indexOf("sports dong a") >= 0
					|| s.indexOf("sports dong-a") >= 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("sacombank") == 0) {
			if (s.indexOf("nón sacombank") >= 0
					|| s.indexOf("mbh sacombank") >= 0
					|| s.indexOf("mũ bảo hiểm sacombank") >= 0
					|| s.indexOf("mũ sacombank") >= 0
					|| s.indexOf("nón bảo hiểm sacombank") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("donga") == 0) {
			if (s.indexOf("dai hoc donga") >= 0 || s.indexOf("ton donga") >= 0
					|| s.indexOf("donga university") >= 0
					|| s.indexOf("donga ilbo") >= 0
					|| s.indexOf("dhdonga") >= 0 || s.indexOf("dh donga") >= 0
					|| s.indexOf("sports donga") >= 0
					|| s.indexOf("sport donga") >= 0
					|| s.indexOf("bài báo độc quyền của donga") >= 0
					|| s.indexOf("credit donga") >= 0
					|| s.indexOf("tez donga") >= 0
					|| s.indexOf("dh donga") >= 0
					|| s.indexOf("trường donga") >= 0
					|| s.indexOf("khoa học donga") >= 0
					|| s.indexOf("donga science") >= 0
					|| s.indexOf("daihoc donga") >= 0
					|| s.indexOf("đầu tư quốc tế donga") >= 0
					|| s.indexOf("woman donga") >= 0
					|| s.indexOf("womandonga") >= 0
					|| s.indexOf("daihocdonga") >= 0
					|| s.indexOf("thammyviendonga") >= 0
					|| s.indexOf("tạp chí phụ nữ donga") >= 0
					|| s.indexOf("donga.edu.vn") >= 0
					|| s.indexOf("donga edu vn") >= 0
					|| s.indexOf("ngoại ngữ donga") >= 0) {
				check = check + 1;
			}
			if (s.indexOf("ngân hàng") < 0 && s.indexOf("ngan hang") < 0
					&& s.indexOf("bank") < 0 && s.indexOf("exo") >= 0) {
				check = check + 1;
			}
		}
		// if (character.compareTo("anz") == 0) {
		// if (s.indexOf("ngân hàng quốc tế anz") >= 0) {
		// check = check + 1;
		// }
		// }
		if (character.compareTo("ngân hàng quốc tế") == 0) {
			if (s.indexOf("ngân hàng quốc tế anz") >= 0
					|| s.indexOf("ngân hàng quốc tế shinhan") >= 0
					|| s.indexOf("những ngân hàng quốc tế như") >= 0
					|| s.indexOf("các ngân hàng quốc tế như") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("shb") == 0) {
			if (s.indexOf("sân bóng shb") >= 0
					|| s.indexOf("khu đô thị shb") >= 0
					|| s.indexOf("shb thailand") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("scb") == 0) {
			if (s.indexOf("scb/กรุง") >= 0 || s.indexOf("scb thailand") >= 0
					|| s.indexOf("scb กรุง") >= 0
					|| s.indexOf("scb siam square") >= 0
					|| s.indexOf("ไทยพาณิชย์") >= 0

			) {
				check = check + 1;
			}
		}
		if (character.compareTo("exim") == 0) {
			if (s.indexOf("exim log") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("sacombank") == 0) {
			if (s.indexOf("ống heo sacombank") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("sacom") == 0) {
			if (s.indexOf("sacom tuyền lâm") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("liên việt") == 0) {
			if (s.indexOf("auto liên việt") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("agri") == 0) {
			if (s.indexOf("vina agri") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("vietbank") == 0) {
			if (s.indexOf("baovietbank") >= 0 && s.indexOf(" vietbank") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("anh hiển") == 0
				|| character.compareTo("mr hiển") == 0
				|| character.compareTo("a hiển") == 0
				|| character.compareTo("ông hiển") == 0) {
			if (s.indexOf("ngân hàng") < 0 && s.indexOf("bank") < 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("mr hiển") == 0) {
			if (s.indexOf("nguyễn ngọc hiển") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("nam á") == 0) {
			if (s.indexOf("của ấn độ ở nam á") >= 0
					|| s.indexOf("điện tử nam á") >= 0
					|| s.indexOf("vùng nam á") >= 0
					|| s.indexOf("nước nam á") >= 0
					|| s.indexOf("ấn độ tại nam á") >= 0
					|| s.indexOf("suzuki nam á") >= 0) {
				check = check + 1;
			}
		}
		if (character.indexOf("hòa phát") >= 0
				|| character.indexOf("hoà phát") >= 0) {
			if (s.indexOf("tai nạn") >= 0
					&& s.indexOf("bệnh viện dung quất") >= 0) {
				check = 1;
			}
		}
		if (character.compareTo("hòa phát") == 0
				|| character.compareTo("hoà phát") == 0) {
			if (s.indexOf("chợ hòa phát") >= 0
					|| s.indexOf("chợ hoà phát") >= 0
					|| s.indexOf("phường hoà phát") >= 0

					|| s.indexOf(" p hoà phát") >= 0
					|| s.indexOf(" p hòa phát") >= 0
					|| s.indexOf(" p. hoà phát") >= 0
					|| s.indexOf(" p. hòa phát") >= 0
					|| (s.indexOf("tai nạn") >= 0 && s
							.indexOf("bệnh viện dung quất") >= 0)
					|| s.indexOf("cộng hòa phát lệnh") >= 0
					|| s.indexOf("phường hòa phát") >= 0
					|| s.indexOf("nguyễn hòa phát đưa tin") >= 0
					|| s.indexOf("nguyễn hoà phát đưa tin") >= 0
					|| s.indexOf("tòa nhà hòa phát") >= 0
					|| s.indexOf("tòa nhà hoà phát") >= 0
					|| s.indexOf("hồng hòa phát") >= 0
					|| s.indexOf("chồng chém vợ") >= 0
					|| s.indexOf("hài hòa phát triển") >= 0
					|| s.indexOf("hài hoà phát triển") >= 0
					|| s.indexOf("khánh hòa phát") >= 0
					|| s.indexOf("khánh hoà phát") >= 0
					|| s.indexOf("biên hòa phát triển") >= 0
					|| s.indexOf("biên hoà phát triển") >= 0
					|| s.indexOf("hòa phát biểu") >= 0
					|| s.indexOf("hoà phát biểu") >= 0
					|| s.indexOf("điều hòa phát sinh") >= 0
					|| s.indexOf("cộng hòa phát động") >= 0
					|| s.indexOf("cộng hoà phát động") >= 0
					|| s.indexOf("may mặc hòa phát") >= 0
					|| s.indexOf("may mặc hoà phát") >= 0
					|| s.indexOf("điều hoà phát sinh") >= 0
					|| s.indexOf("biên hòa phát hiện") >= 0
					|| s.indexOf("biên hoà phát hiện") >= 0

					|| s.indexOf("biên hòa phát động") >= 0
					|| s.indexOf("biên hoà phát động") >= 0

					|| s.indexOf("cộng hoà phát hiện") >= 0
					|| s.indexOf("cộng hòa phát hiện") >= 0

					|| s.indexOf("cộng hoà phát hành") >= 0
					|| s.indexOf("cộng hòa phát hành") >= 0

					|| s.indexOf("hoà phát hành bởi") >= 0
					|| s.indexOf("hòa phát hành bởi") >= 0

					|| s.indexOf("việt nam cộng hoà phát") >= 0
					|| s.indexOf("việt nam cộng hòa phát") >= 0

					|| s.indexOf("cộng hoà phát triển") >= 0
					|| s.indexOf("cộng hòa phát triển") >= 0
					|| (s.indexOf("hoà phát triển") >= 0 && s
							.indexOf("hoà phát triển khai") < 0)
					|| (s.indexOf("hòa phát triển") >= 0 && s
							.indexOf("hòa phát triển khai") < 0)

					|| s.indexOf("thiện hoà phát tâm") >= 0
					|| (s.indexOf("thành an") >= 0 && s
							.indexOf("phát hiện xác") >= 0)
					|| s.indexOf("thiện hòa phát tâm") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("ngân hàng công thương") == 0) {
			if (s.indexOf("ngân hàng công thương trung quốc") >= 0) {
				check = check + 1;
			}
		}
		if (character.length() <= 2 && character.indexOf("vcb") < 0
				&& character.indexOf("acb") < 0 && character.indexOf("anz") < 0
				&& character.indexOf("adb") < 0 && character.indexOf("ncb") < 0
				&& character.indexOf("shb") < 0 && character.indexOf("scb") < 0

		) {
			if (s.indexOf(" nh " + character) <= 0
					&& s.indexOf(" ngân hàng " + character) <= 0
					&& s.indexOf(" ngan hang " + character) <= 0
					&& s.indexOf("ngân hàng") <= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("sacombank") == 0) {
			if (s.indexOf("đoạn đường sacombank") >= 0
					|| s.indexOf("đoạn sacombank") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("fe credit") == 0 || character.compareTo("fecredit") == 0) {
			check = check +1;
		}
		if (character.compareTo("stem") == 0) {
			if (s.indexOf("giáo dục stem") >= 0
					|| s.indexOf("giao duc stem") >= 0
					|| s.indexOf("phương pháp stem") >= 0
					|| s.indexOf("phương pháp stem") >= 0
					|| s.indexOf("pp stem") >= 0
					|| s.indexOf("hội thảo quốc tế stem") >= 0
					|| s.indexOf("hoi thao quoc te stem") >= 0
					|| s.indexOf("hội thảo stem cms") >= 0
					|| s.indexOf("hoi thao stem cms") >= 0
					|| s.indexOf("hoi thao stem cms") >= 0) {
				check = check + 1;
			}
		}
		if (character.compareTo("sacombank") == 0
				|| character.compareTo("sa com bank") == 0
				|| character.compareTo("ngân hàng sài gòn thương tín") == 0
				|| character.compareTo("ngân hàng tmcp sài gòn thương tín") == 0) {
			if ((s.indexOf("giảm ngay") >= 0 && s.indexOf("cho chủ thẻ") >= 0 && s
					.indexOf("hotline") >= 0)
					|| s.indexOf("kiếm tiền trên điện thoại") >= 0
					|| (s.indexOf("hỗ trợ vay") >= 0 && (s
							.indexOf("ưu đãi từ các ngân hàng") >= 0 || s
							.indexOf("ưu đãi từ ngân hàng") >= 0))
					|| (s.indexOf("ai có thẻ ngân hàng") >= 0 && (s
							.indexOf("internet banking") >= 0 || s
							.indexOf("muốn kiếm") >= 0))
					|| (s.indexOf("ai có thẻ ngân hàng") >= 0
							&& s.indexOf("muốn có") >= 0 && s.indexOf("inbox") >= 0)) {
				check = check + 1;
			}
		}

		if (character.compareTo("tech") == 0
				// || character.compareTo("vib") == 0
				|| character.compareTo("bản việt") == 0
				|| character.compareTo("ban viet") == 0
				|| character.compareTo("ban vjet") == 0
				|| character.compareTo("bản vjệt") == 0
				|| character.compareTo("bid") == 0
				|| character.compareTo("tpb") == 0
				|| character.compareTo("dab") == 0
				|| character.compareTo("acb") == 0
				// || character.compareTo("anz") == 0
				|| character.compareTo("nam á") == 0
				|| character.compareTo("lvp") == 0
				|| character.compareTo("liên việt") == 0
				|| character.compareTo("lien viet") == 0
				|| character.compareTo("lienviet") == 0
		// || character.compareTo("vcb") == 0
		// || character.compareTo("ocb") == 0
		) {
			if (s.indexOf("ngân hàng") < 0 && s.indexOf("ngan hàng") < 0
					&& s.indexOf("bank") < 0 && s.indexOf("cho vay") < 0
					&& s.indexOf(" atm ") < 0 && s.indexOf("vay vốn") < 0
					&& s.indexOf("vay von") < 0 && s.indexOf("ngan hang") < 0) {
				check = check + 1;
			}
		}
		return check;
	}

	public static int object_td(Object object, String s) {
		int check = 0;
		if (object.cid == 18427 || object.id == 18427 || object.pid == 18427
				|| object.sid == 18427) {
			if (s.toLowerCase().indexOf("tuyển dụng") >= 0
					|| s.toLowerCase().indexOf("cần tuyển") >= 0
					|| s.toLowerCase().indexOf("vay tài chính prudential") >= 0
					|| s.toLowerCase().indexOf("tuyen dung") >= 0
					|| s.toLowerCase().indexOf("prudential finance") >= 0
					|| s.toLowerCase().indexOf("prudential") >= 0
					|| s.toLowerCase().indexOf("visa du lịch") >= 0
					|| s.toLowerCase().indexOf("visa thương mại") >= 0
					|| s.toLowerCase().indexOf("visa trung quốc") >= 0
					|| s.toLowerCase().indexOf("visa tq") >= 0
					|| s.toLowerCase()
							.indexOf(
									"cái thẻ tín dụng mỏng lét mà nuốt bao nhiêu là tiền") >= 0
					|| (s.toLowerCase().indexOf("shop") >= 0 && s.toLowerCase()
							.indexOf("trả góp") >= 0)
					|| s.toLowerCase().indexOf("can tuyen") >= 0) {
				check = 1;
			}
		}
		return check;
	}

	public static String check_comment_thetindung(String message,
			String JSONobject_post, String JSONResult_object_from_name,
			String JSONobject) {
		String out = null;
		message = message.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");
		if (JSONobject_post != null && JSONResult_object_from_name == null) {
			if (JSONobject_post.indexOf("cid\":\"18427") >= 0
					|| JSONobject_post.indexOf("\"sid\":\"18427\"") >= 0
					|| JSONobject_post.indexOf("\"pid\":\"18427\"") >= 0
					|| JSONobject_post.indexOf("\"id\":\"18427\"") >= 0) {
				if (Check_thetindung.check_full(message) == 1) {
					out = "[{\"id\":\"18427\",\"cid\":\"1\",\"sid\":\"0\",\"pid\":\"0\",\"status\":\"0\"}]";
				}
			}
		}
		if (JSONobject != null) {
			if (JSONobject.indexOf("cid\":\"18427") >= 0
					|| JSONobject.indexOf("\"sid\":\"18427\"") >= 0
					|| JSONobject.indexOf("\"pid\":\"18427\"") >= 0
					|| JSONobject.indexOf("\"id\":\"18427\"") >= 0) {
				out = null;
			}
		}
		return out;
	}

	public static String return_object(ArrayList<Object> object,
			String fb_from_name) {
		String JSONResult_object_from_name = null;
		for (int i = 0; i < object.size(); i++) {

			if (Check_object.check_object(fb_from_name.toLowerCase(),
					object.get(i).name.toLowerCase(), 1) == 1
					&& Check_object.check_object_confusion(
							fb_from_name.toLowerCase(),
							object.get(i).name.toLowerCase()) == 0
					&& Check_object.object_td(object.get(i),
							fb_from_name.toLowerCase()) == 0) {
				List<object> list4 = new ArrayList<object>();
				list4.add(new object(object.get(i).id, object.get(i).cid,
						object.get(i).sid, object.get(i).pid,
						object.get(i).status));
				JSONResult_object_from_name = JSONArray.toJSONString(list4);
				break;
			}
		}
		return JSONResult_object_from_name;
	}

	public static List<object> return_many_object(ArrayList<Object> object,
			String fb_from_name) {
		System.out
				.println("index "
						+ fb_from_name.toLowerCase().indexOf(
								"ngân hàng tmcp bản việt"));
		List<object> list4 = new ArrayList<object>();
		for (int i = 0; i < object.size(); i++) {
			if (Check_object.check_object(fb_from_name.toLowerCase(),
					object.get(i).name.toLowerCase(), 1) == 1
					&& Check_object.check_object_confusion(
							fb_from_name.toLowerCase(),
							object.get(i).name.toLowerCase()) == 0
					&& Check_object.object_td(object.get(i),
							fb_from_name.toLowerCase()) == 0) {
				System.out.print(object.get(i).name.toLowerCase());
				list4.add(new object(object.get(i).id, object.get(i).cid,
						object.get(i).sid, object.get(i).pid,
						object.get(i).status));
			}
		}
		if (list4.size() >= 2) {
			list4 = delete_duplicate(list4);
			/*
			 * ArrayList<Integer> list_delete = new ArrayList<Integer>();
			 * for(int i=0;i<list4.size();i++){
			 * System.out.println(list4.get(i).getid_object()); for(int
			 * j=0;j<list4.size();j++){ if((j!=i)
			 * &&((list4.get(i).getcid_object()==list4.get(j).getcid_object() &&
			 * list4.get(i).getstatus_object()!=0 &&
			 * list4.get(j).getstatus_object()!=0 ) ||
			 * (list4.get(i).getcid_object() == list4.get(j).getsid_object() &&
			 * list4.get(i).getstatus_object()!=0 &&
			 * list4.get(j).getstatus_object()!=0 ) ||
			 * list4.get(i).getid_object() == list4.get(j).getcid_object() ) ){
			 * list_delete.add(list4.get(j).getid_object()); } } } for(int
			 * i=0;i<list_delete.size();i++){ for(int j=0;j<list4.size();j++){
			 * if(list4.get(j).getid_object()==list_delete.get(i)){
			 * list4.remove(j); } } }
			 */
		}
		return list4;
	}

	public static List<object> delete_duplicate(List<object> list4) {
		for (int i = 0; i < list4.size(); i++) {
			for (int j = i + 1; j < list4.size();) {
				if ((list4.get(i).getcid_object() == list4.get(j)
						.getcid_object()
						&& list4.get(i).getstatus_object() != 0 && list4.get(j)
						.getstatus_object() != 0)
						|| (list4.get(i).getcid_object() == list4.get(j)
								.getsid_object()
								&& list4.get(i).getstatus_object() != 0 && list4
								.get(j).getstatus_object() != 0)
						|| list4.get(i).getid_object() == list4.get(j)
								.getcid_object()
						|| list4.get(i).getcid_object() == list4.get(j)
								.getid_object()) {
					list4.remove(j);
				} else {
					j++;
				}
			}
		}
		return list4;

	}

	public static String return_message_object(ArrayList<Object> object,
			String fb_message, int own, String JSONResult_object_page_name) {
		String JSONResult_object = null;
		int id_object = 0;
		int cid_object = 0;
		for (int i = 0; i < object.size(); i++) {
			if (Check_object.check_object(fb_message.toLowerCase(),
					object.get(i).name.toLowerCase(), 2) == 1
					&& Check_object.check_object_confusion(
							fb_message.toLowerCase(),
							object.get(i).name.toLowerCase()) == 0) {

				List<object> list = new ArrayList<object>();
				list.add(new object(object.get(i).id, object.get(i).cid, object
						.get(i).sid, object.get(i).pid, object.get(i).status));
				id_object = object.get(i).id;
				cid_object = object.get(i).cid;
				JSONResult_object = JSONArray.toJSONString(list);
				break;
			}

		}
		if (id_object != own && cid_object != own && JSONResult_object != null
				&& JSONResult_object_page_name != null) {
			JSONResult_object = JSONResult_object_page_name;
		}

		return JSONResult_object;
	}

	// Trả về vị trí của đối tượng đầu tiên mà đối tượng này k phải đối tượng
	// của page
	public static int return_indexof_firts_object(ArrayList<Object> object,
			String fb_message, int own, String JSONResult_object_page_name) {
		String JSONResult_object = null;
		int index = -1;
		int index1 = -1;
		int id_object = 0;
		int cid_object = 0;
		for (int i = 0; i < object.size(); i++) {
			if (Check_object.check_object(fb_message.toLowerCase(),
					object.get(i).name.toLowerCase(), 2) == 1
					&& Check_object.check_object_confusion(
							fb_message.toLowerCase(),
							object.get(i).name.toLowerCase()) == 0) {

				List<object> list = new ArrayList<object>();
				list.add(new object(object.get(i).id, object.get(i).cid, object
						.get(i).sid, object.get(i).pid, object.get(i).status));
				id_object = object.get(i).id;
				cid_object = object.get(i).cid;
				JSONResult_object = JSONArray.toJSONString(list);
				index1 = fb_message.toLowerCase().indexOf(
						object.get(i).name.toLowerCase());
				break;
			}

		}
		if (id_object != own && cid_object != own && JSONResult_object != null
				&& JSONResult_object_page_name != null) {
			index = index1;
		}
		return index;
	}

	public static void main(String[] args) {
		String s = "Bất thường việc chuyển nhượng cổ phần tại Ngân hàng Nam Á";
		s = Normalizer.normalize(
				s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
						.toLowerCase(), Normalizer.Form.NFC);
		System.out.println(s.toLowerCase().indexOf("ngân hàng"));
	}

}
// Cần xử lí trường hợp bài viết nói về đối tượng khác với đối tượng page
// - Xác định đối tượng thật của page
// - Xác định đối tượng của message .
// - Nếu đối tượng của message không trùng với đối tượng page thì ta sẽ tiếp tục
// kiểm tra đối tượng thứ 2 của message.
// Ưu tiên đối tượng t2 nếu trùng với đối tượng page
