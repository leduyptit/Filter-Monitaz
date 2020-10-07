package rule;

public class Check_order {
	public static int check_order(String s) {
		int check = 0;
		if ((s.toLowerCase().indexOf("muốn mở thẻ") >= 0
				&& s.toLowerCase().indexOf("bạn muốn mở thẻ") < 0
				&& s.toLowerCase().indexOf("khách hàng muốn mở thẻ") < 0
				&& s.toLowerCase().indexOf("bạn khi muốn mở thẻ") < 0 && s
				.toLowerCase().indexOf("khách hàng khi muốn mở thẻ") < 0)

				|| (s.toLowerCase().indexOf("muốn vay") >= 0
						&& s.toLowerCase().indexOf("bạn muốn vay") < 0
						&& s.toLowerCase().indexOf("khách hàng muốn vay") < 0
						&& s.toLowerCase().indexOf("bạn khi muốn vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi muốn vay") < 0)

				|| (s.toLowerCase().indexOf("muon vay") >= 0
						&& s.toLowerCase().indexOf("bạn muon vay") < 0
						&& s.toLowerCase().indexOf("khách hàng muon vay") < 0
						&& s.toLowerCase().indexOf("bạn khi muon vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi muon vay") < 0)

				|| (s.toLowerCase().indexOf("muôn vay") >= 0
						&& s.toLowerCase().indexOf("bạn muôn vay") < 0
						&& s.toLowerCase().indexOf("bạn khi muôn vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi muôn vay") < 0)
				// tí sửa lại
				|| (s.toLowerCase().indexOf("muốn vay") >= 0
						&& s.toLowerCase().indexOf("bạn muốn vay") < 0
						&& s.toLowerCase().indexOf("bạn khi muốn vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi muốn   vay") < 0)

				|| (s.toLowerCase().indexOf("có nhu cầu mua") >= 0
						&& s.toLowerCase().indexOf("bạn có nhu cầu mua") < 0
						&& s.toLowerCase().indexOf("bạn khi có nhu cầu mua") < 0 && s
						.toLowerCase().indexOf("khách hàng khi có nhu cầu mua") < 0)

				|| (s.toLowerCase().indexOf("có nhu cầu mở thẻ") >= 0
						&& s.toLowerCase().indexOf("bạn có nhu cầu mở thẻ ") < 0
						&& s.toLowerCase().indexOf("bạn khi có nhu cầu mở thẻ") < 0 && s
						.toLowerCase().indexOf(
								"khách hàng khi có nhu cầu mở thẻ") < 0)

				|| (s.toLowerCase().indexOf("có nhu cầu vay") >= 0
						&& s.toLowerCase().indexOf("bạn có nhu cầu vay") < 0
						&& s.toLowerCase().indexOf("bạn khi có nhu cầu vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi có nhu cầu vay") < 0)

				|| (s.toLowerCase().indexOf("co nhu cau vay") >= 0 && s
						.toLowerCase().indexOf("bạn co nhu cau vay") < 0)
				|| s.toLowerCase().indexOf("co vay được không") >= 0
				|| (s.toLowerCase().indexOf("cần vay") >= 0
						&& s.toLowerCase().indexOf("bạn cần vay") < 0
						&& s.toLowerCase().indexOf("bạn khi cần vay") < 0
						&& s.toLowerCase().indexOf("khách hàng cần vay") < 0 && s
						.toLowerCase().indexOf("khách hàng khi cần vay") < 0)

				|| s.toLowerCase().indexOf("hồ sơ vay như thế nào") >= 0
				|| s.toLowerCase().indexOf("thủ tục vay như thế nào") >= 0
				|| s.toLowerCase().indexOf("thủ tục ntn") >= 0
				|| (s.toLowerCase().indexOf("muấn vay") >= 0 && s.toLowerCase()
						.indexOf("bạn muấn vay") < 0)
				|| (s.toLowerCase().indexOf("mún vay") >= 0
						&& s.toLowerCase().indexOf("bạn mún vay") < 0
						&& s.toLowerCase().indexOf("khách hàng khi mún vay") < 0 && s
						.toLowerCase().indexOf("khách hàng cần vay") < 0)
				|| (s.toLowerCase().indexOf("mun vay") >= 0 && s.toLowerCase()
						.indexOf("bạn mun vay") < 0)

		) {
			check = check + 1;

		}
		return check;
	}
}
