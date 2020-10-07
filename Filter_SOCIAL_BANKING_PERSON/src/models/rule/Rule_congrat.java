package rule;

public class Rule_congrat {
	public static int rule1_congrat(String fb_message) {
		int check = 0;
		if ((fb_message.indexOf("chúc ") < 0
				&& fb_message.indexOf("chuc ") < 0)
				|| fb_message.indexOf("chúc các bạn") >= 0) {
			check = check + 1;
		}
		return check;
	}
// Can xem lai
	public static int rule2_congrat(String fb_message) {
		int check = 0;
		if ((fb_message.toLowerCase().indexOf("chúc mừng") >= 0
				|| fb_message.toLowerCase().indexOf("kính chúc") >= 0 || fb_message
				.toLowerCase().indexOf("xin chúc") >= 0)) {
			check = check + 1;

		}
		return check;
	}

}
