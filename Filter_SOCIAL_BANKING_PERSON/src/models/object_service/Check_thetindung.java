package object_service;

import java.text.Normalizer;

public class Check_thetindung {
	public static int check_full(String fb_message) {
		int check = 0;
		if (check_sdt(fb_message) == 1 || check_keyword(fb_message) == 1) {
			check = 1;
		}
		return check;
	}

	public static int check_sdt(String fb_message) {
		int check = 0;
		if (regex_number(fb_message) == 1) {
			check = 1;
		}
		return check;
	}

	public static int regex_number(String str) {
		int check = 0;
		str = str.replaceAll("\\.", "");
		str = str.replaceAll("\\-", "");
		System.out.println(str);
		str = str.replaceAll("[^0-9,-\\.]", ",");
		/** cat thanh cac phan tu thong qua dau phay */
		String[] item = str.split(",");
		// duyet cac phan tu, neu la so thi in ra
		for (int i = 0; i < item.length; i++) {
			try {
				if (item[i].length() >= 10 && item[i].length() <= 11) {
					check = 1;
				}
				Double.parseDouble(item[i]);
				System.out.println(item[i]);
			} catch (NumberFormatException e) {
			}
		}
		return check;

	}

	public static int check_keyword(String s) {
		s = " " + Normalizer.normalize((s), Normalizer.Form.NFC).toLowerCase()
				+ " ";
		int check = 0;
		if (s.toLowerCase().indexOf("muốn mua ") >= 0
				|| s.toLowerCase().indexOf("thay lõi") >= 0
				|| s.toLowerCase().indexOf("chỉ số tds") >= 0
				|| s.toLowerCase().indexOf("muon mua ") >= 0
				|| s.toLowerCase().indexOf("trả góp") >= 0
				|| s.toLowerCase().indexOf("liên hệ số nào để làm đại lý") >= 0
				|| s.toLowerCase().indexOf("giá bnhiu") >= 0
				|| s.toLowerCase().indexOf("giá bảo nhiều") >= 0
				|| s.toLowerCase().indexOf("bảo nhiều tiền") >= 0
				|| s.toLowerCase().indexOf("giá tn") >= 0
				|| s.toLowerCase().indexOf("tư vấn giúp") >= 0
				|| s.toLowerCase().indexOf("đang có nhu cầu") >= 0
				|| s.toLowerCase().indexOf("ở đâu vậy") >= 0
				|| s.toLowerCase().indexOf("nhiu 1 cái") >= 0
				|| s.toLowerCase().indexOf("nhiêu 1 cái") >= 0
				|| s.toLowerCase().indexOf("inbox mình") >= 0
				|| s.toLowerCase().indexOf("inb mình") >= 0
				|| s.toLowerCase().indexOf("inbox m") >= 0
				|| s.toLowerCase().indexOf("tra gop k") >= 0
				|| s.toLowerCase().indexOf("trả góp k") >= 0
				|| s.toLowerCase().indexOf("giá rổ") >= 0
				|| s.toLowerCase().indexOf("xin cái") >= 0
				|| s.toLowerCase().indexOf("giá nào ad") >= 0
				|| s.toLowerCase().indexOf("uống được trực tiếp chưa") >= 0
				|| s.toLowerCase().indexOf("uống được trực tieps chưa") >= 0
				|| s.toLowerCase().indexOf("gia tn") >= 0
				|| s.toLowerCase().indexOf("giá bao nhiêu") >= 0
				|| s.toLowerCase().indexOf("can mua") >= 0
				|| s.toLowerCase().indexOf("cần mua ") >= 0
				|| s.toLowerCase().indexOf("có được k") >= 0
				|| s.toLowerCase().indexOf("cho cái giá") >= 0
				|| s.toLowerCase().indexOf("bao nhiêu") >= 0
				|| s.toLowerCase().indexOf("giá cả") >= 0
				|| s.toLowerCase().indexOf("khi nào hỏng") >= 0
				|| s.toLowerCase().indexOf("thì làm sao") >= 0
				|| s.toLowerCase().indexOf("giá sao shop") >= 0
				|| s.toLowerCase().indexOf("giá bán") >= 0
				|| s.toLowerCase().indexOf("co may khoảng") >= 0
				|| s.toLowerCase().indexOf("bao tien") >= 0
				|| s.toLowerCase().indexOf("cho mình giá") >= 0
				|| s.toLowerCase().indexOf("bn vậy") >= 0
				|| s.toLowerCase().indexOf("dc gia ") >= 0
				|| s.toLowerCase().indexOf("hả bạn") >= 0
				|| s.toLowerCase().indexOf(" k ban") >= 0
				|| s.toLowerCase().indexOf("k bạn") >= 0
				|| s.toLowerCase().indexOf("giá bn") >= 0
				|| s.toLowerCase().indexOf("bn thế") >= 0
				|| s.toLowerCase().indexOf("giá bn") >= 0
				|| s.toLowerCase().indexOf("thay ở đâu") >= 0
				|| s.toLowerCase().indexOf("bảo hành thế nao") >= 0
				|| s.toLowerCase().indexOf("bao nhiu") >= 0
				|| s.toLowerCase().indexOf("máy này lọc") >= 0
				|| s.toLowerCase().indexOf("xem hàng") >= 0
				|| s.toLowerCase().indexOf("lọc đc k") >= 0
				|| s.toLowerCase().indexOf("máy lọc nước này") >= 0
				|| s.toLowerCase().indexOf("bao nhiru") >= 0
				|| s.toLowerCase().indexOf("ban the nao") >= 0
				|| s.toLowerCase().indexOf("bn vậy") >= 0
				|| s.toLowerCase().indexOf("bao tiền") >= 0
				|| s.toLowerCase().indexOf("bnhieu") >= 0
				|| s.toLowerCase().indexOf("bao nhiều tiền") >= 0
				|| s.toLowerCase().indexOf("bnhjeu") >= 0
				|| s.toLowerCase().indexOf("bnhiu") >= 0
				|| s.toLowerCase().indexOf("ad cho hỏi") >= 0
				|| s.toLowerCase().indexOf("muon mua") >= 0
				|| s.toLowerCase().indexOf("gia the nao") >= 0
				|| s.toLowerCase().indexOf("giá cả") >= 0
				|| s.toLowerCase().indexOf("báo giá") >= 0
				|| s.toLowerCase().indexOf("co may cấp") >= 0
				|| s.toLowerCase().indexOf("bao nhieu") >= 0
				|| s.toLowerCase().indexOf("xin giá") >= 0
				|| s.toLowerCase().indexOf("bn ban") >= 0
				|| s.toLowerCase().indexOf("bao gia") >= 0
				|| s.toLowerCase().indexOf("bao tin") >= 0
				|| s.toLowerCase().indexOf("may tien") >= 0
				|| s.toLowerCase().indexOf("có con nào") >= 0
				|| s.toLowerCase().indexOf("bso nhjeu") >= 0
				|| s.toLowerCase().indexOf("xin giá") >= 0
				|| s.toLowerCase().indexOf("giá ntn") >= 0
				|| s.toLowerCase().indexOf("gia bn") >= 0
				|| s.toLowerCase().indexOf("giá tiền") >= 0
				|| s.toLowerCase().indexOf("bao nhe tiên") >= 0
				|| s.toLowerCase().indexOf("có máy khoảng hơn") >= 0
				|| s.toLowerCase().indexOf("co may khoảng hơn") >= 0
				|| s.toLowerCase().indexOf("gi hả ban") >= 0
				|| s.toLowerCase().indexOf("may nao thi phu hop") >= 0
				|| s.toLowerCase().indexOf("may lao thi phu hop") >= 0
				|| s.toLowerCase().indexOf("mình mua") >= 0
				|| s.toLowerCase().indexOf("mjnh mua") >= 0
				|| s.toLowerCase().indexOf("minh muon dung") >= 0
				|| s.toLowerCase().indexOf("có con nao tầm") >= 0
				|| s.toLowerCase().indexOf("nhieu tien") >= 0
				|| s.toLowerCase().indexOf("mua máy") >= 0
				|| s.toLowerCase().indexOf("giá cả") >= 0
				|| s.toLowerCase().indexOf("nhờ tư vấn") >= 0
				|| s.toLowerCase().indexOf("inbox giá") >= 0
				|| s.toLowerCase().indexOf(" bn ") >= 0
				|| s.toLowerCase().indexOf(" bnh ") >= 0
				|| s.toLowerCase().indexOf("có nhà phân phối k") >= 0
				|| s.toLowerCase().indexOf("có bán online k") >= 0
				|| s.toLowerCase().indexOf("có bán chưa") >= 0
				|| s.toLowerCase().indexOf("ở đâu") >= 0
				|| s.toLowerCase().indexOf("bao nhjeu") >= 0
				|| s.toLowerCase().indexOf("minh muon xem") >= 0
				|| s.toLowerCase().indexOf("có bán bộ") >= 0
				|| s.toLowerCase().indexOf("co may nao") >= 0
				|| s.toLowerCase().indexOf("co loai nao") >= 0
				|| s.toLowerCase().indexOf("giá nhiu") >= 0
				|| s.toLowerCase().indexOf("giá khoảng nhiu") >= 0
				|| s.toLowerCase().indexOf("vậy hả a") >= 0
				|| s.toLowerCase().indexOf("nhìu tiền") >= 0
				|| s.toLowerCase().indexOf("xin giá sản phẩm") >= 0
				|| s.toLowerCase().indexOf("báo giá") >= 0
				|| s.toLowerCase().indexOf("có phải") >= 0
				|| s.toLowerCase().indexOf("nhiu vậy") >= 0
				|| s.toLowerCase().indexOf("gì ko") >= 0
				|| s.toLowerCase().indexOf("được ko") >= 0
				|| s.toLowerCase().indexOf("hỏi giá") >= 0
				|| s.toLowerCase().indexOf("thế nào") >= 0
				|| s.toLowerCase().indexOf("hòa bình gia bnhieu vay") >= 0
				|| s.toLowerCase().indexOf(" bnh ") >= 0
				|| s.toLowerCase().indexOf("mua hàng ở đâu") >= 0
				|| s.toLowerCase().indexOf("sdt 01666706354 mình ơ") >= 0
				|| s.toLowerCase().indexOf("cho mình địa chỉ") >= 0
				|| s.toLowerCase().indexOf("gui hang tinh le") >= 0
				|| s.toLowerCase().indexOf("cho mình hỏi") >= 0
				|| s.toLowerCase().indexOf("điểm bán") >= 0
				|| s.toLowerCase().indexOf("đại lý chính hãng tại") >= 0
				|| s.toLowerCase().indexOf("đại lý tại") >= 0
				|| s.toLowerCase().indexOf("ko vậy ạ") >= 0
				|| s.toLowerCase().indexOf("lấy ở đâu") >= 0
				|| s.toLowerCase().indexOf("ở đâu ạ") >= 0
				|| s.toLowerCase().indexOf("cho minh xin") >= 0
				|| s.toLowerCase().indexOf("nhap hang ve ban") >= 0
				|| s.toLowerCase().indexOf("minh muốn") >= 0
				|| s.toLowerCase().indexOf("mo dai ly") >= 0
				|| s.toLowerCase().indexOf("co cua hag nao ban") >= 0
				|| s.toLowerCase().indexOf("mình muốn") >= 0
				|| s.toLowerCase().indexOf("thì sao") >= 0
				|| s.toLowerCase().indexOf("mua máy") >= 0
				|| s.toLowerCase().indexOf("ko vay") >= 0
				|| s.toLowerCase().indexOf("chọn loại nào") >= 0
				|| s.toLowerCase().indexOf("có lắp đc") >= 0
				|| s.toLowerCase().indexOf("dug rat ok") >= 0
				|| s.toLowerCase().indexOf("tu van nhe") >= 0
				|| s.toLowerCase().indexOf("rất vừa ý") >= 0
				|| s.toLowerCase().indexOf("rất hài lòng") >= 0
				|| s.toLowerCase().indexOf("tư vấn") >= 0
				|| s.toLowerCase().indexOf("rất tốt") >= 0
				|| s.toLowerCase().indexOf("mua máy") >= 0
				|| s.toLowerCase().indexOf("muốn lấy máy") >= 0
				|| s.toLowerCase().indexOf("lấy ở đâu") >= 0
				|| s.toLowerCase().indexOf("mua ở đâu") >= 0
				|| s.toLowerCase().indexOf("nhap hang ve ban") >= 0
				|| s.toLowerCase().indexOf("nhập sp về bán") >= 0
				|| s.toLowerCase().indexOf("mua máy") >= 0
				|| s.toLowerCase().indexOf("có bán ko") >= 0
				|| s.toLowerCase().indexOf("inbox mình") >= 0
				|| s.toLowerCase().indexOf("inb mình") >= 0
				|| s.toLowerCase().indexOf(" inb ") >= 0
				|| s.toLowerCase().indexOf(" inbox ") >= 0
				|| s.toLowerCase().indexOf(" ib ") >= 0
				|| s.toLowerCase().indexOf("giá nhiêu") >= 0
				|| s.toLowerCase().indexOf("giá ntn") >= 0
				|| s.toLowerCase().indexOf(" gia ntn ") >= 0
				|| s.toLowerCase().indexOf("trả góp k") >= 0
				|| s.toLowerCase().indexOf("giá cả") >= 0
				|| s.toLowerCase().indexOf("gia ca") >= 0
				|| s.toLowerCase().indexOf("uống rất ngon") >= 0
				|| s.toLowerCase().indexOf("địa chỉ nào vậy") >= 0
				|| s.toLowerCase().indexOf("giá?") >= 0
				|| s.toLowerCase().indexOf("giá quả lọc") >= 0
				|| s.toLowerCase().indexOf("ở đâu bạn") >= 0
				|| s.toLowerCase().indexOf("ở đâu b ") >= 0
				|| s.toLowerCase().indexOf("có cửa hàng k") >= 0
				|| s.toLowerCase().indexOf("co cua hang o ") >= 0
				|| s.toLowerCase().indexOf("xin hỏi") >= 0
				|| s.toLowerCase().indexOf("bao lâu") >= 0
				|| s.toLowerCase().indexOf("bán ở đâu") >= 0
				|| s.toLowerCase().indexOf(" dc ko ") >= 0
				|| s.toLowerCase().indexOf("được ko") >= 0
				|| s.toLowerCase().indexOf("đc ko") >= 0
				|| s.toLowerCase().indexOf("đc k ") >= 0
				|| s.toLowerCase().indexOf("dc ko") >= 0
				|| s.toLowerCase().indexOf("dc k ") >= 0
				|| s.toLowerCase().indexOf("gui hang") >= 0
				|| s.toLowerCase().indexOf("cho mình hỏi") >= 0
				|| s.toLowerCase().indexOf("cho em hỏi") >= 0
				|| s.toLowerCase().indexOf("cho minh hoi") >= 0
				|| s.toLowerCase().indexOf("cho e hoi") >= 0
				|| s.toLowerCase().indexOf("cho e hỏi") >= 0
				|| (s.toLowerCase().indexOf("sdt") >= 0 && s.toLowerCase()
						.indexOf("mình ở") >= 0)
				|| (s.toLowerCase().indexOf("sdt") >= 0 && s.toLowerCase()
						.indexOf("mình ơ ") >= 0)
				|| (s.toLowerCase().indexOf("sdt") >= 0 && s.toLowerCase()
						.indexOf("minh o ") >= 0)
				|| s.toLowerCase().indexOf("muốn mở thẻ") >= 0
				|| s.toLowerCase().indexOf("muốn làm thẻ") >= 0
				|| s.toLowerCase().indexOf("muốn đăng ký") >= 0
				|| s.toLowerCase().indexOf("muốn đăng kí") >= 0
				|| s.toLowerCase().indexOf(" muon dk ") >= 0
				|| s.toLowerCase().indexOf("muốn gửi") >= 0
				|| s.toLowerCase().indexOf("muốn gởi") >= 0
				|| s.toLowerCase().indexOf("mo the") >= 0
				|| s.toLowerCase().indexOf("lam the") >= 0

		) {
			check = 1;

		}
		return check;
	}
}
