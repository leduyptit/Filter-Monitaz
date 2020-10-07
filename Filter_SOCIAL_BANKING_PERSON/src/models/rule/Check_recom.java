package rule;

public class Check_recom {
	public static int check_recom(String s) {
		int check = 0;
		if (s.indexOf("cần nhân rộng ra") >= 0
				|| s.indexOf("mình có ý kiến này") >= 0
				// || s.indexOf("mình nghĩ") >= 0
				// || s.indexOf("thì nên") >= 0
				|| s.indexOf("thiếu chức năng") >= 0
				|| s.indexOf("cần thêm chức năng") >= 0
				|| s.indexOf("cần bổ sung") >= 0
				// || s.indexOf("mong rằng") > 0
				|| s.indexOf("có lẽ fải") > 0
				|| s.indexOf("mình có ý kiến") > 0
				|| s.indexOf("cần bổ sung") > 0
				|| (s.indexOf("thiết nghĩ") >= 0 && s.indexOf("nên làm") >= 0)
				|| s.indexOf("nếu thấp như") >= 0
				|| s.indexOf("sao có công cụ") >= 0
				|| s.indexOf("kiến nghị") >= 0
				|| s.indexOf("nên để") >= 0
				// || s.indexOf("góp ý") >= 0
				// || s.indexOf("đề nghị") >= 0
				// || s.indexOf("em thấy") >= 0
				|| s.indexOf("lần sau nên") >= 0
				|| s.indexOf("như thế thì sẽ") >= 0
				|| s.indexOf("sớm cập nhật") >= 0
				|| s.indexOf("đề nghị ad") >= 0
				// || s.indexOf("mong là") >= 0
				|| s.indexOf("nên bổ sung") >= 0
				// || s.indexOf("nên làm") >= 0
				|| s.indexOf("bạn cũng nên") >= 0
				|| s.indexOf("cần sớm khắc phục") >= 0
				|| s.indexOf("cần thêm chức năng") >= 0
				|| s.indexOf("có lẽ fải") >= 0
				|| s.indexOf("để group trở lên") >= 0
				|| s.indexOf("để ngân hàng trở lên") >= 0
				|| s.indexOf("để nhóm trở lên") >= 0
				|| s.indexOf("đừng giảm lãi suất") >= 0
				// ||s.indexOf("em thấy") >=0
				|| s.indexOf("hi vọng và mong chờ sự thay đổi") >= 0
				|| s.indexOf("hy vọng dịch vụ") >= 0
				|| s.indexOf("hy vọng nó sẽ") >= 0
				|| s.indexOf("mình có ý kiến") >= 0
				// ||s.indexOf("mình thấy") >=0
				|| s.indexOf("mở thêm chi nhánh đi") >= 0
				|| s.indexOf("mọi đóng góp đều") >= 0
				|| s.indexOf("mong ACB") >= 0
				|| s.indexOf("mong muốn có những đóng góp") >= 0
				|| s.indexOf("mong Techcombank") >= 0
				|| s.indexOf("nên viết tiện ích") >= 0
				|| s.indexOf("ngân hàng nên") >= 0
				|| s.indexOf("nhưng sao không mở") >= 0
				|| s.indexOf("phát triển thêm") >= 0
				|| s.indexOf("phòng marketing bố trí") >= 0
				|| s.indexOf("phòng marketing nê") >= 0
				|| s.indexOf("phòng MKT bố trí") >= 0
				|| s.indexOf("Phòng MTK nên") >= 0
				|| s.indexOf("phòng nhân sự bố trí") >= 0
				|| s.indexOf("phòng nhân sự nên") >= 0
				|| s.indexOf("sao k có công cụ") >= 0
				|| s.indexOf("sao không có công cụ") >= 0
				|| s.indexOf("sao ngân hàng k") >= 0
				|| s.indexOf("sao ngân hàng không") >= 0
				|| s.indexOf("so sánh với phòng giao dịch") >= 0
				|| s.indexOf("tai sao ngan hang k") >= 0
				|| s.indexOf("tại sao ngân hàng không") >= 0
				|| s.indexOf("thi sẽ hay hơn") >= 0
				|| s.indexOf("thiếu chức năng") >= 0
				|| s.indexOf("tôi nghĩ") >= 0
				|| s.indexOf("tôi thấy đằng nào") >= 0
				|| s.indexOf("tôi thấy rằng") >= 0
				|| s.indexOf("tuy nhiên mỗi tháng nên") >= 0) {
			check = check + 1;
		}
		return check;

	}
}
