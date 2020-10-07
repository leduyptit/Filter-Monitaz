package rule;

import java.awt.List;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import object_service.Check_sentiment;

public class Rule_spam {
	public static int rule_spam_ct(String fb_message) {
		int check = 0;
		if (fb_message.indexOf("#donga") >= 0 && fb_message.length() < 12) {
			check = 1;
		}
		String fb_message1 = Normalizer.normalize(
				(" "
						+ fb_message.replaceAll("\\p{P}", " ")
								.replaceAll("\\s+", " ")
								.toLowerCase(Locale.getDefault()) + " "),
				Normalizer.Form.NFC).toLowerCase();
		if ((fb_message1.indexOf("ai có") >= 0 && fb_message1
				.indexOf("trong tài khoản còn tiền k") >= 0)
				|| ((fb_message1.indexOf("ai có tk") >= 0 || fb_message1
						.indexOf("có ai tk") >= 0) && (fb_message1
						.indexOf("chuyển lại vào tk") >= 0 || fb_message1
						.indexOf("ck lại bằng") >= 0))
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("đổi giúp em") >= 0 && fb_message1
						.indexOf("em trả") >= 0)
				|| (fb_message1.indexOf("thẩm mỹ") >= 0
						&& fb_message1.indexOf("cam kết") >= 0 && fb_message1
						.indexOf("để lại") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("ck giúp") >= 0 && fb_message1
						.indexOf("cần gấp") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("mua hàng") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("đổi giúp e") >= 0 && (fb_message1
						.indexOf("e gửi lại") >= 0 || fb_message1
						.indexOf("e trả lại") >= 0))
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("cho e mượn") >= 0 && fb_message1
						.indexOf("e trả lại") >= 0)
				|| (fb_message1.indexOf("cần mua") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("chuyển tiền qua") >= 0)
				|| (fb_message1.indexOf("mình cần") >= 0
						&& fb_message1.indexOf("trả lại") >= 0 && fb_message1
						.indexOf("ai có giúp") >= 0)
				|| (fb_message1.indexOf("bạn nào có") >= 0
						&& fb_message1.indexOf("ck dùm") >= 0 && fb_message1
						.indexOf("gửi tiền mặt") >= 0)
				|| (fb_message1.indexOf("cần gấp") >= 0
						&& fb_message1.indexOf("cho em mượn") >= 0 && fb_message1
						.indexOf("gửi lại") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("chuyển giúp") >= 0 && fb_message1
						.indexOf("trả tiền mặt") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("giúp mình") >= 0 && fb_message1
						.indexOf("mình trả") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && (fb_message1
						.indexOf("cho mượn") >= 0 || fb_message1
						.indexOf("mượn đi") >= 0))
				|| (fb_message1.indexOf("bắn qua tk") >= 0 && fb_message1
						.indexOf("trả lại từ tk") >= 0)
				|| (fb_message1.indexOf("em cần đổi") >= 0 && fb_message1
						.indexOf("trả lại qua") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("em đổi lấy") >= 0)
				|| (fb_message1.indexOf("em cần") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("giúp em") >= 0)
				|| (fb_message1.indexOf("ai có tiền") >= 0 && (fb_message1
						.indexOf("ck ho minh") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf(" cần ") >= 0
						&& fb_message1.indexOf("trả lại") >= 0 && fb_message1
						.indexOf("ai có inbox") >= 0)
				|| (fb_message1.indexOf("cần gấp") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("trả tiền") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("nhờ xíu") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ xíu") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("giúp e") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ tí") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("cho em mượn") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("cho e mượn") >= 0)
				|| ((fb_message1.indexOf("ai có tk ") >= 0 || fb_message1
						.indexOf("bạn nào có thẻ") >= 0) && fb_message1
						.indexOf("nhờ tí") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("bắn hộ") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ chuyển khoản") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("nhờ chuyển khoản") >= 0)
				|| (fb_message1.indexOf("ai có tk") >= 0 && fb_message1
						.indexOf("cho e mượn") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& (fb_message1.indexOf("trả tiền mặt") >= 0 || fb_message1
								.indexOf("trả tiền qua") >= 0) && (fb_message1
						.indexOf("ck giúp") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("cho em nhờ") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("cho mượn tí") >= 0)) {
			check = 1;
		}
		return check;
	}

	public static int rule1_spam_bonus(String fb_message) {
		int check = 0;
		String fb_message1 = Normalizer.normalize(
				(" "
						+ fb_message.replaceAll("\\p{P}", " ")
								.replaceAll("\\s+", " ")
								.toLowerCase(Locale.getDefault()) + " "),
				Normalizer.Form.NFC).toLowerCase();
		String fb_message_dia = Normalizer
				.normalize(
						(" "
								+ fb_message.replaceAll("\\p{P}", " ")
										.replaceAll("\\s+", " ")
										.toLowerCase(Locale.getDefault()) + " "),
						Normalizer.Form.NFC).toLowerCase()
				.replaceAll("\\d", "").trim().replaceAll(" +", " ");
		if (get_stk(fb_message) == 1) {
			if (fb_message1.indexOf("stk") >= 0
					|| fb_message1.indexOf("số tài khoản") >= 0
					|| fb_message1.indexOf(" ck ") >= 0
					|| fb_message1.indexOf(" tk ") >= 0
					|| fb_message1.indexOf("chuyển khoản") >= 0
					|| fb_message1.indexOf("thanh lý") >= 0
					|| fb_message1.indexOf(" bán ") >= 0) {
				check = 1;
			}
		}
		if (Check_sentiment.printText(fb_message, "09") >= 10
				|| Check_sentiment.printText(fb_message, "0k") >= 20
				|| rule_spam_ct(fb_message) == 1
				|| fb_message1.indexOf("nhận làm bằng") >= 0
				|| fb_message1.indexOf("sneaker fest") >= 0
				|| fb_message1.indexOf("bán tài khoản quảng cáo") >= 0
				// || fb_message1.indexOf(" sim ") >= 0
				|| fb_message1.indexOf("khách ở xa vui lòng ck") >= 0
				|| fb_message1.indexOf("cách dạy con tự lập") >= 0
				|| fb_message1.indexOf("thammyviendonga") >= 0
				|| fb_message1.indexOf("thẩm mỹ viện đông á") >= 0
				|| fb_message1.indexOf("nhận tiền nenkin") >= 0
				|| fb_message1.indexOf("nạ tiêu độc") >= 0
				|| fb_message1.indexOf("thẩm mỹ đông á") >= 0
				|| fb_message1.indexOf("công ty cổ phần dịch vụ đông a") >= 0
				|| fb_message1.indexOf("thẩm mỹ viện đông á") >= 0
				|| fb_message1.indexOf("tmv đông á") >= 0
				|| fb_message1.indexOf("bán sub") >= 0
				|| fb_message1.indexOf("maytinhdonga") >= 0
				|| fb_message1.indexOf("khách ở xa vui lòng chuyển khoản") >= 0
				|| fb_message1.indexOf(" fun88 ") >= 0
				|| fb_message1.indexOf("share bài công đức") >= 0
				|| fb_message1.indexOf("vicoin") >= 0
				// || fb_message1.indexOf("bán sim") >= 0
				|| (fb_message1.indexOf("ví ") >= 0 && fb_message1
						.indexOf("xin chuộc lại") >= 0)

				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("cod ") >= 0)

				|| (fb_message1.indexOf("mũ bảo hiểm") >= 0
						&& fb_message1.indexOf("sacom") >= 0 && fb_message1
						.indexOf("0k") >= 0)

				|| (fb_message1.indexOf("mũ bảo hiểm") >= 0
						&& fb_message1.indexOf("sacom") >= 0
						&& fb_message1.indexOf("giá") >= 0 && fb_message1
						.indexOf("khách") >= 0)

				|| (fb_message1.indexOf("nón bảo hiểm") >= 0
						&& fb_message1.indexOf("sacom") >= 0
						&& fb_message1.indexOf("giá") >= 0 && fb_message1
						.indexOf("khách") >= 0)

				|| (fb_message1.indexOf("nón bảo hiểm") >= 0
						&& fb_message1.indexOf("sacom") >= 0 && fb_message1
						.indexOf("0k") >= 0)

				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("bao hàng") >= 0)
				|| (fb_message1.indexOf("lê diệp kiều trang") >= 0 && fb_message1
						.indexOf("facebook") >= 0)
				|| (fb_message1.indexOf("sim") >= 0
						&& fb_message1.indexOf("giá ") >= 0 && Check_sentiment
						.printText(fb_message, "09") >= 3)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("giá thuê") >= 0)
				|| (fb_message1.indexOf("tuyển sỉ") >= 0 && fb_message1
						.indexOf("ctv") >= 0)
				|| (fb_message1.indexOf("shipcod toàn quốc") >= 0)
				|| (fb_message1.indexOf("chuyên mua bán") >= 0 && fb_message1
						.indexOf("ship") >= 0)
				|| (fb_message1.indexOf("điểm bán") >= 0 && fb_message1
						.indexOf("ship") >= 0)
				|| (fb_message1.indexOf("sữa chua") >= 0 && fb_message1
						.indexOf("ship") >= 0)
				|| (fb_message1.indexOf("hàng có sẵn") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("tìm giấy tờ") >= 0 && fb_message1
						.indexOf("bị mất") >= 0)
				|| (fb_message1.indexOf("bán đất") >= 0
						&& fb_message1.indexOf("giá ") >= 0 && fb_message1
						.indexOf("vị trí") >= 0)
				|| (fb_message1.indexOf("cần sang") >= 0
						&& fb_message1.indexOf("giá ") >= 0 && fb_message1
						.indexOf("mặt bằng") >= 0)
				|| (fb_message1.indexOf("đất") >= 0
						&& fb_message1.indexOf("giá ") >= 0
						&& fb_message1.indexOf("vị trí") >= 0 && fb_message1
						.indexOf("hỗ trợ vay") < 0)
				|| (fb_message1.indexOf("rơi ") >= 0
						&& fb_message1.indexOf("giấy tờ") >= 0
						&& fb_message1.indexOf("nhặt") >= 0 && fb_message1
						.indexOf("xin lại") >= 0)
				|| (fb_message1.indexOf("ship") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("bán ") >= 0
						&& fb_message1.indexOf("mua ") >= 0 && fb_message1
						.indexOf("link game") >= 0)
				|| (fb_message1.indexOf("phanrose") >= 0 && fb_message1
						.indexOf("trà sữa") >= 0)
				|| (fb_message1.indexOf("lô đề") >= 0 && fb_message1
						.indexOf("nhận thưởng") >= 0)
				|| (fb_message1.indexOf("nhóm hiệp sĩ") >= 0 && fb_message1
						.indexOf("trước ngân hàng") >= 0)
				|| (fb_message1.indexOf("store") >= 0 && fb_message1
						.indexOf("chuyên order") >= 0)
				|| (fb_message1.indexOf("store") >= 0 && fb_message1
						.indexOf("chuyên oder") >= 0)
				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("hàng super") >= 0)
				|| (fb_message1.indexOf("cập nhật") >= 0 && fb_message1
						.indexOf("ds uh") >= 0)
				|| (fb_message1.indexOf("cập nhật") >= 0 && fb_message1
						.indexOf("ds hỗ trợ") >= 0)
				|| (fb_message1.indexOf("cập nhật quỹ") >= 0 && fb_message1
						.indexOf("ủng hộ") >= 0)
				|| (fb_message1.indexOf("tuyển lao động") >= 0
						&& fb_message1.indexOf("trả lương") >= 0 && fb_message1
						.indexOf("qua thẻ") >= 0)
				|| (fb_message1.indexOf("tuyển dụng") >= 0
						&& fb_message1.indexOf("thanh toán lương") >= 0 && fb_message1
						.indexOf("qua thẻ") >= 0)
				|| (fb_message1.indexOf("spa ") >= 0 && fb_message1
						.indexOf("triệt lông") >= 0)
				|| (fb_message1.indexOf("vietcom today") >= 0 && fb_message1
						.indexOf("xuất khẩu lao động") >= 0)
				|| (fb_message1.indexOf("kích quảng cáo") >= 0 && fb_message1
						.indexOf("tiền rút qua") >= 0)
				|| (fb_message1.indexOf("mua hàng") >= 0
						&& fb_message1.indexOf("ship hàng") >= 0 && fb_message1
						.indexOf("size") >= 0)
				|| (fb_message1.indexOf("làm rơi") >= 0
						&& fb_message1.indexOf("giấy tờ") >= 0 && fb_message1
						.indexOf("nhặt được") >= 0)

				|| (Check_sentiment.printText(fb_message, "iphone") >= 5
						&& fb_message1.indexOf("phụ kiện") >= 0 && fb_message1
						.indexOf("bảo hành") >= 0)
				|| (Check_sentiment.printText(fb_message, "gần") >= 3 && fb_message1
						.indexOf("cho thuê") >= 0)
				|| (Check_sentiment.printText(fb_message, "ipad") >= 5
						&& fb_message1.indexOf("phụ kiện") >= 0 && fb_message1
						.indexOf("bảo hành") >= 0)

				|| fb_message1.indexOf(" fun88 ") >= 0
				|| fb_message1.indexOf("tócgiảdungji") >= 0
				|| fb_message1.indexOf("giám đốc facebook việt nam") >= 0
				|| fb_message1.indexOf("hẻm ngay ngân hàng") >= 0
				|| fb_message1.indexOf("chỗ nh đông á cũng vậy") >= 0
				|| fb_message1.indexOf(" royal88 ") >= 0
				|| fb_message1.indexOf("r88vn com") >= 0
				|| fb_message1.indexOf("mua vcoin") >= 0
				|| fb_message1.indexOf("thông tin tài khoản của sư phụ") >= 0
				|| fb_message1
						.indexOf("nhận chuyển tiền online qua các ngân hàng") >= 0
				|| fb_message1.indexOf("đại lý phối chip") >= 0
				|| fb_message1.indexOf("mrdwatches") >= 0

				|| (fb_message1.indexOf("boutique") >= 0 && fb_message1
						.indexOf("đặt hàng") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("đồng hồ") >= 0 && fb_message1
						.indexOf("sale giá tốt") >= 0)
				|| (fb_message1.indexOf("ví ") >= 0 && fb_message1
						.indexOf("xin lại giấy tờ") >= 0)
				|| fb_message1.indexOf("vòng xoay vietcombank") >= 0
				|| (fb_message1.indexOf("chiếc ví ") >= 0
						&& fb_message1.indexOf("giấy tờ") >= 0 && fb_message1
						.indexOf(" mất ") >= 0)
				|| (fb_message1.indexOf("chiếc ví ") >= 0
						&& fb_message1.indexOf("giấy tờ") >= 0 && fb_message1
						.indexOf("nhặt được") >= 0)
				|| (fb_message1.indexOf("ví ") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("xin lại") >= 0)
				|| fb_message1.indexOf("tìm đồ thất lạc") >= 0
				|| (fb_message1.indexOf("rơi ví") >= 0 && fb_message1
						.indexOf("nhặt được") >= 0)
				|| (fb_message1.indexOf("ví ") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("rơi ví") >= 0 && fb_message1
						.indexOf("nhặt được") >= 0)
				|| (fb_message1.indexOf("rơi ví") >= 0 && fb_message1
						.indexOf("tìm lại") >= 0)
				|| (fb_message1.indexOf("rơi ví") >= 0 && fb_message1
						.indexOf("hậu tạ") >= 0)
				|| (fb_message1.indexOf("đấu giá") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("cỏ máu") >= 0 && fb_message1
						.indexOf("chị khách sacombank") >= 0)
				|| (fb_message1.indexOf("biểu tình") >= 0 && fb_message1
						.indexOf("phía sacombank") >= 0)
				|| fb_message1.indexOf("188bet") >= 0
				|| fb_message1.indexOf("cá cược online") >= 0
				|| (fb_message1.indexOf("stk") >= 0
						&& fb_message1.indexOf("ngân hàng đông á") >= 0 && fb_message1
						.indexOf("võ thị tý") >= 0)
				|| (fb_message1.indexOf("ai muốn") >= 0
						&& fb_message1.indexOf("quyên góp") >= 0 && fb_message1
						.indexOf("gửi tiền qua tài khoản") >= 0)
				|| (fb_message1.indexOf("ai muốn") >= 0
						&& fb_message1.indexOf("nguyên góp") >= 0 && fb_message1
						.indexOf("gửi tiền qua tài khoản") >= 0)
				|| (fb_message1.indexOf("khai trương") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("buffet") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0
						&& fb_message1.indexOf("ví ") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| (fb_message1.indexOf("chung tay giúp") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("hoàn cảnh khó khăn") >= 0
						&& fb_message1.indexOf("viện phí") >= 0 && fb_message1
						.indexOf("giúp đỡ") >= 0)
				|| (fb_message1.indexOf("gửi tiền nhanh") >= 0 && fb_message1
						.indexOf("gutina") >= 0)
				|| (fb_message1.indexOf("sát nhập") >= 0 && fb_message1
						.indexOf("hiv bank") >= 0)
				|| (fb_message1.indexOf("sáp nhập") >= 0 && fb_message1
						.indexOf("hiv bank") >= 0)
				|| (fb_message1.indexOf("visa thẳng") >= 0 && fb_message1
						.indexOf("du học") >= 0)
				|| fb_message1.indexOf("visa du học") >= 0
				|| fb_message1.indexOf("miễn visa") >= 0
				|| fb_message1.indexOf("visa nhập cảnh") >= 0
				|| fb_message1.indexOf("xin visa") >= 0
				|| fb_message1.indexOf("visa thương mại") >= 0
				|| fb_message1.indexOf("visa bắc cầu") >= 0
				|| fb_message1.indexOf("visa kỹ sư") >= 0
				|| fb_message1.indexOf("gia hạn visa") >= 0
				|| fb_message1.indexOf("chuyển đổi visa") >= 0
				|| (fb_message1.indexOf("mất giấy tờ") >= 0 && fb_message1
						.indexOf("đánh rơi") >= 0)
				|| (fb_message1.indexOf("mất giấy tờ") >= 0 && fb_message1
						.indexOf("nhặt được") >= 0)
				|| (fb_message1.indexOf("rơi đồ") >= 0 && fb_message1
						.indexOf("móc mất ví") >= 0)
				|| (fb_message1.indexOf("đánh rơi ví") >= 0 && fb_message1
						.indexOf("hậu tạ") >= 0)
				|| (fb_message1.indexOf("đánh rơi cái ví") >= 0 && fb_message1
						.indexOf("hậu tạ") >= 0)
				|| (fb_message1.indexOf("tìm giấy tờ") >= 0 && fb_message1
						.indexOf("đánh rơi") >= 0)
				|| (fb_message1.indexOf("tìm giấy tờ") >= 0 && fb_message1
						.indexOf("ví có") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("sale") >= 0)
				|| (fb_message1.indexOf("đơn hàng") >= 0 && fb_message1
						.indexOf("freeship") >= 0)
				|| (fb_message1.indexOf(" mụn ") >= 0 && fb_message1
						.indexOf("thanh dược") >= 0)
				|| (fb_message1.indexOf("đơn hàng") >= 0 && fb_message1
						.indexOf("free ship") >= 0)
				|| (fb_message1.indexOf("rơi ví") >= 0 && fb_message1
						.indexOf("ví gồm có") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("ship") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0 && fb_message1
						.indexOf("ví có") >= 0)
				|| (fb_message1.indexOf("mất ví") >= 0 && fb_message1
						.indexOf("ai nhặt được ví") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("order") >= 0 && fb_message1
						.indexOf("giá về tay") >= 0)
				|| (fb_message1.indexOf("sale") >= 0 && fb_message1
						.indexOf("ship") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0 && fb_message1
						.indexOf("nhận chốt") >= 0)
				|| (fb_message1.indexOf("rơi giấy tờ") >= 0 && fb_message1
						.indexOf("bên trong gồm") >= 0)
				|| (fb_message1.indexOf("mất bóp") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("khách sỉ") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("call") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("giá") >= 0)
				|| (fb_message1.indexOf("đóng góp") >= 0
						&& fb_message1.indexOf("từ thiện") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("mất bóp") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("giá ") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("cuddly") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| (fb_message1.indexOf("chấn thương") >= 0
						&& fb_message1.indexOf("giúp đỡ") >= 0 && fb_message1
						.indexOf("xin liên hệ") >= 0)
				|| (fb_message1.indexOf("mất bóp") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("toàn quốc") >= 0)
				|| (fb_message1.indexOf("cứu giúp") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("zalo") >= 0
						&& fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("inbox") >= 0)
				|| (fb_message1.indexOf(" ck ") >= 0
						&& fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("cod") >= 0)
				|| (fb_message1.indexOf("mtq") >= 0
						&& fb_message1.indexOf("hảo tâm") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("mất ví") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf("thanh toán") >= 0 && fb_message1
						.indexOf("like") >= 0)

				|| (fb_message1.indexOf(" ví ") >= 0
						&& fb_message1.indexOf(" rơi ") >= 0 && fb_message1
						.indexOf("bên trong có") >= 0)

				|| (fb_message1.indexOf("ship") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("sale toàn quốc") >= 0)

				|| (fb_message1.indexOf("mopi") >= 0 && fb_message1
						.indexOf("trang trí văn phòng") >= 0)

				|| (fb_message1.indexOf("ăn cắp thẻ master") >= 0 && fb_message1
						.indexOf("sử dụng tại karaoke") >= 0)

				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("đặt hàng") >= 0)
				|| (fb_message1.indexOf("ship") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("làm rơi") >= 0 && fb_message1
						.indexOf("mất giấy tờ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("call") >= 0)
				|| (fb_message1.indexOf("chia sẻ giúp đỡ") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("chủ thẻ") >= 0)
				|| (fb_message1.indexOf("ctv") >= 0
						&& fb_message1.indexOf("sỉ") >= 0 && fb_message1
						.indexOf("sản phẩm") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("hậu tạ") >= 0)
				|| (fb_message1.indexOf("danh sách ủng hộ") >= 0 && fb_message1
						.indexOf("thiện nguyện") >= 0)
				|| (fb_message1.indexOf(" bán ") >= 0 && fb_message1
						.indexOf("vcoi") >= 0)
				|| (fb_message1.indexOf("bán thẻ đt") >= 0 && fb_message1
						.indexOf("giá bán") >= 0)
				|| (fb_message1.indexOf("nhận chốt") >= 0 && fb_message1
						.indexOf("vcb") >= 0)
				|| (fb_message1.indexOf("nhận chốt") >= 0 && fb_message1
						.indexOf("sim") >= 0)
				|| fb_message1.indexOf("dịch vụ tin nhắn thương hiệu") >= 0
				|| fb_message1.indexOf("app ami") >= 0
				|| fb_message1.indexOf("chốt vcb") >= 0
				|| fb_message1.indexOf("olymp trade") >= 0
				|| fb_message1.indexOf("dịch vụ facebook") >= 0
				|| (fb_message1.indexOf("set đồ") >= 0 && fb_message1
						.indexOf("game") >= 0)) {
			check = 1;
		}
		return check;
	}

	public static int rule1_spam(String fb_message) {
		int check = 0;
		String fb_message1 = Normalizer.normalize(
				(" "
						+ fb_message.replaceAll("\\p{P}", " ")
								.replaceAll("\\s+", " ")
								.toLowerCase(Locale.getDefault()) + " "),
				Normalizer.Form.NFC).toLowerCase();
		System.out.println(fb_message1);
		System.out.println(fb_message1.length());
		String fb_message_dia = Normalizer
				.normalize(
						(" "
								+ fb_message.replaceAll("\\p{P}", " ")
										.replaceAll("\\s+", " ")
										.toLowerCase(Locale.getDefault()) + " "),
						Normalizer.Form.NFC).toLowerCase()
				.replaceAll("\\d", "").trim().replaceAll(" +", " ");
		// if (check_number(fb_message1) == 1) {
		// check = 11;
		// }
		if (Check_sentiment.printText(fb_message, "09") >= 10
				|| fb_message1.indexOf("nhận làm bằng") >= 0
				|| fb_message1.indexOf("bán tài khoản quảng cáo") >= 0
				// || fb_message1.indexOf(" sim ") >= 0
				|| fb_message1.indexOf("khách ở xa vui lòng ck") >= 0
				|| fb_message1.indexOf("khách ở xa vui lòng chuyển khoản") >= 0
				|| fb_message1.indexOf(" fun88 ") >= 0
				|| fb_message1.indexOf("hẻm ngay ngân hàng") >= 0
				|| fb_message1.indexOf(" royal88 ") >= 0
				|| fb_message1.indexOf("r88vn com") >= 0
				|| fb_message1.indexOf("mua vcoin") >= 0
				|| fb_message1.indexOf("vị trí nằm ngay ngân hàng") >= 0
				|| fb_message1.indexOf("lừa đảo mới của nhân viên bán vé tàu") >= 0
				|| fb_message1.indexOf("bán vcoin") >= 0
				|| fb_message1.indexOf("dịch vụ bảo vệ chuyên nghiệp") >= 0
				|| fb_message1.indexOf(" ship ") >= 0
				|| fb_message1.indexOf("mọi đóng góp xin gửi cho") >= 0
				|| fb_message1.indexOf("công ty việt nam toàn cầu tuyển dụng") >= 0
				|| fb_message1.indexOf("chuyển phát nhanh") >= 0
				|| fb_message1.indexOf("tuyển thu ngân") >= 0
				|| fb_message1.indexOf("tuyển dụng xuất khẩu lao động") >= 0
				|| fb_message1
						.indexOf("ngân hàng đầu tư phát triển trung quốc") >= 0
				|| (fb_message1.indexOf(" cày thuê ") >= 0 && fb_message1
						.indexOf(" acc ") >= 0)
				|| (fb_message1.indexOf("sản xuất tại") >= 0 && fb_message1
						.indexOf("myphamlinhhuong") >= 0)
				|| (fb_message1.indexOf("sản xuất tại") >= 0 && fb_message1
						.indexOf("linh hương") >= 0)
				|| (fb_message1.indexOf("hàng có sẵn") >= 0 && fb_message1
						.indexOf("boutique") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && (fb_message1
						.indexOf("cạnh ngân hàng") >= 0
						|| fb_message1.indexOf("sát ngân hàng") >= 0
						|| fb_message1.indexOf("sát bên ngân hàng") >= 0 || fb_message1
						.indexOf("cạnh bên ngân hàng") >= 0))
				|| (fb_message1.indexOf("đánh rơi 1 ví") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| (fb_message1.indexOf("kem chống nắng") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("đánh roi 1 ví") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| (fb_message1.indexOf("bán đất") >= 0 && fb_message1
						.indexOf("gần trụ sở ngân hàng") >= 0)
				|| (fb_message.toLowerCase().indexOf(" stk:") >= 0 && fb_message
						.toLowerCase().indexOf(" lh:") >= 0)
				|| (fb_message1.indexOf("set đồ") >= 0 && fb_message1
						.indexOf("game") >= 0)
				|| (fb_message1.indexOf("chuyển hộ e") >= 0 && fb_message1
						.indexOf("e gửi tiền mặt") >= 0)
				|| (fb_message1.indexOf("giúp đỡ") >= 0 && fb_message1
						.indexOf("tấm lòng nhân ái") >= 0)
				|| (fb_message1.indexOf("giá ") >= 0 && fb_message1
						.indexOf("nhập thì inbox") >= 0)
				|| (fb_message1.indexOf("tuyển gấp") >= 0 && fb_message1
						.indexOf("tòa vietcombank") >= 0)
				|| (fb_message1.indexOf("bạn nào có thẻ") >= 0 && fb_message1
						.indexOf("mình nhờ chút") >= 0)
				|| (fb_message1.indexOf("mũ bảo hiểm") >= 0 && fb_message1
						.indexOf("quà tặng từ DongA bank") >= 0)
				|| (fb_message1.indexOf("nón bảo hiểm") >= 0 && fb_message1
						.indexOf("quà tặng từ DongA bank") >= 0)
				|| (fb_message1.indexOf("trà sữa") >= 0 && fb_message1
						.indexOf("sau ngân hàng") >= 0)
				|| (fb_message1.indexOf("danh sách") >= 0 && fb_message1
						.indexOf("datakhachhang") >= 0)
				|| (fb_message1.indexOf("mọi người ai giúp được hoàn cảnh") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("cửa hàng") >= 0 && (fb_message1
						.indexOf("sát ngân hàng") >= 0 || fb_message1
						.indexOf("sát nh ") >= 0))
				|| ((fb_message1.indexOf("thông tin chi tiết") >= 0 || fb_message1
						.indexOf("nhà hảo tâm") >= 0)
						&& fb_message1.indexOf("stk") >= 0 && fb_message1
						.indexOf("ctk") >= 0)
				|| fb_message1.indexOf("cài like tự động") >= 0
				|| (fb_message1.indexOf("spa") >= 0
						&& fb_message1.indexOf("showroom") >= 0 && fb_message1
						.indexOf("khách") >= 0)
				// || (fb_message1.indexOf("nhà hàng") >= 0
				// && fb_message1.indexOf("món ngon") >= 0 && fb_message1
				// .indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("đặt áo") >= 0
						&& fb_message1.indexOf("size") >= 0 && fb_message1
						.indexOf("chuyển tiền") >= 0)
				|| (fb_message1.indexOf("rút 1 tỷ") >= 0
						&& fb_message1.indexOf("rút 500") >= 0 && fb_message1
						.indexOf("không có nhiều vậy") >= 0)
				|| (fb_message1.indexOf("rút 100") >= 0
						&& fb_message1.indexOf("rút 50") >= 0 && fb_message1
						.indexOf("không có nhiều vậy") >= 0)
				|| (fb_message1.indexOf("tòa nhà") >= 0
						&& fb_message1.indexOf("vị trí") >= 0 && fb_message1
						.indexOf("cách vietcombank") >= 0)
				|| ((fb_message1.indexOf("ngân hàng lớn liền kề như") >= 0 || fb_message1
						.indexOf("ngân hàng liền kề như") >= 0)
						&& fb_message1.indexOf("hỗ trợ vay") < 0 && fb_message1
						.indexOf("ngân hàng bảo lãnh") < 0)
				|| (fb_message1.indexOf("bán nhà") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("diện tích") >= 0)
				|| (fb_message1.indexOf("showroom") >= 0 && (fb_message1
						.indexOf("sát bên ngân hàng") >= 0 || fb_message1
						.indexOf("sát ngân hàng") >= 0))
				|| fb_message1.indexOf("trà chanh sacombank chém gió") >= 0
				|| (fb_message1.indexOf("vpbank") >= 0
						&& fb_message1.indexOf("phan thị ngọc dung") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("hết xiền") >= 0
						&& fb_message1.indexOf("stk") >= 0 && fb_message1
						.indexOf("lấy hàng") >= 0)
				|| (fb_message1.indexOf("giá alo") >= 0
						&& fb_message1.indexOf("tk") >= 0 && fb_message1
						.indexOf("ctk") >= 0)
				|| (fb_message1.indexOf("zalo") >= 0
						&& fb_message1.indexOf("mess") >= 0 && fb_message1
						.indexOf("nguyễn thị hồng trinh") >= 0)
				|| (fb_message1.indexOf("giá alo") >= 0
						&& fb_message1.indexOf("tk") >= 0 && fb_message1
						.indexOf("chủ tk") >= 0)
				|| (fb_message1.indexOf("câu chuyện") >= 0
						&& fb_message1.indexOf("cặp lá yêu thương") >= 0 && fb_message1
						.indexOf("gửi về") >= 0)
				|| (fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf("tk ngân hàng") >= 0 && fb_message1
						.indexOf("nguyễn phước minh trí") >= 0)
				|| (fb_message1.indexOf("quý gia đình") >= 0
						&& fb_message1.indexOf("tâm thư") >= 0 && fb_message1
						.indexOf("hoan hỷ") >= 0)
				|| (fb_message1.indexOf("thông tin chi tiết") >= 0
						&& fb_message1.indexOf("stk") >= 0 && fb_message1
						.indexOf("chủ tk") >= 0)
				|| (fb_message1.indexOf("lupin") >= 0 && fb_message1
						.indexOf("vui lòng liên hệ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("đối diên ngân hàng") >= 0)
				|| (fb_message1.indexOf("bạn nào còn thiếu tiền") >= 0 && fb_message1
						.indexOf("cần vốn") >= 0)
				|| (fb_message1.indexOf("tấm lòng hảo tâm") >= 0 && fb_message1
						.indexOf("mọi sự trợ giúp") >= 0)
				|| (fb_message1.indexOf("tìm người nhà hàng") >= 0 && fb_message1
						.indexOf("đối diện") >= 0)
				|| (fb_message1.indexOf("nam mô a di đà") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("giọng ca bolero") >= 0 && fb_message1
						.indexOf("đến từ vietinbank") >= 0)
				|| (fb_message1.indexOf("hoanggiamobile") >= 0 && fb_message1
						.indexOf("thông tin liên hệ") >= 0)
				|| (fb_message1.indexOf("đất nền") >= 0 && fb_message1
						.indexOf("hệ thống ngân hàng") >= 0)
				|| (fb_message1.indexOf("hoanggiamobile") >= 0 && fb_message1
						.indexOf("bán hàng") >= 0)
				|| (fb_message1.indexOf("gcode") >= 0 && fb_message1
						.indexOf("album giao dịch") >= 0)
				|| (fb_message1.indexOf("thánh nữ") >= 0
						&& fb_message1.indexOf("vietinbank") >= 0 && fb_message1
						.indexOf("bolero") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
						.indexOf("lương trả qua thẻ ngân hàng") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
						.indexOf("lương sẽ trả qua thẻ ngân hàng") >= 0)
				|| (fb_message1.indexOf("các mẫu hàng") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("xin lại giấy tờ") >= 0)
				|| (fb_message1.indexOf("atm vietcombank") >= 0 && fb_message1
						.indexOf("tẩm sẵn thuốc mê") >= 0)
				|| (fb_message1.indexOf("các mẫu hàng") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
						.indexOf("thanh toán qua ngân hàng") >= 0)
				|| (fb_message1.indexOf("nam mô a di đà") >= 0 && fb_message1
						.indexOf("chung tay") >= 0)
				|| (fb_message1.indexOf("bạn nào vừa ck") >= 0 && fb_message1
						.indexOf("inbox nha") >= 0)
				|| (fb_message1.indexOf("hệ thống cửa hàng áo") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("khai trương cafe") >= 0 && fb_message1
						.indexOf(" cách ") >= 0)
				|| (fb_message1.indexOf("giúp em chuyển tiền") >= 0 && fb_message1
						.indexOf("đưa tiền mặt") >= 0)
				|| (fb_message1.indexOf(" quán ") >= 0 && fb_message1
						.indexOf("bên hông ngân hàng") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("vietcombank tower") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("cho thuê mặt bằng") >= 0)
				|| (fb_message1.indexOf("thanh toán") >= 0
						&& fb_message1.indexOf("đấu giá") >= 0 && fb_message1
						.indexOf("ngân hàng") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0
						&& fb_message1.indexOf("làm việc tại địa chỉ") >= 0 && fb_message1
						.indexOf("sảnh ngân hàng") >= 0)
				|| (fb_message1.indexOf("tuyển nhân viên") >= 0
						&& fb_message1.indexOf("trả lương") >= 0 && (fb_message1
						.indexOf("hàng tháng qua ngân hàng") >= 0 || fb_message1
						.indexOf("hàng tháng qua tk") >= 0))
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf(" size ") >= 0
						&& fb_message1.indexOf("giao hàng") >= 0 && fb_message1
						.indexOf("thu tiền") >= 0)
				|| (fb_message1.indexOf("chuyên hàng super") >= 0 && fb_message1
						.indexOf("buôn lẻ") >= 0)
				|| (fb_message1.indexOf("cao thị huyền thương") >= 0 && fb_message1
						.indexOf("chi nhánh") >= 0)
				|| (fb_message1.indexOf("quý khách") >= 0 && fb_message1
						.indexOf("enremit") >= 0)
				|| (fb_message1.indexOf("giao dịch trên web") >= 0 && fb_message1
						.indexOf("enremit") >= 0)
				|| fb_message1.indexOf("enremit com") >= 0

				|| (fb_message1.indexOf("đổi tiền giúp") >= 0 && fb_message1
						.indexOf("em trả") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("trong tài khoản còn tiền k") >= 0)
				|| ((fb_message1.indexOf("ai có tk") >= 0 || fb_message1
						.indexOf("có ai tk") >= 0) && (fb_message1
						.indexOf("chuyển lại vào tk") >= 0 || fb_message1
						.indexOf("ck lại bằng") >= 0))
				|| ((fb_message1.indexOf("bạn nào có tk") >= 0 || fb_message1
						.indexOf("bạn nào có tài khoản") >= 0) && (fb_message1
						.indexOf("chuyển tiền giúp") >= 0 || fb_message1
						.indexOf("chuyển khoản giúp") >= 0))
				|| (fb_message1.indexOf("stk của e") >= 0 && fb_message1
						.indexOf("khách") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("kế bên ngân hàng") >= 0)
				|| (fb_message1.indexOf("mã số") >= 0
						&& fb_message1.indexOf(" acc ") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| (fb_message1.indexOf("giao dịch") >= 0
						&& fb_message1.indexOf("khách tỉnh") >= 0 && fb_message1
						.indexOf("giao hàng") >= 0)
				|| fb_message1.indexOf("thông tin nhận donate") >= 0
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("đổi giúp em") >= 0 && fb_message1
						.indexOf("em trả") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("đổi giúp e") >= 0 && (fb_message1
						.indexOf("e gửi lại") >= 0 || fb_message1
						.indexOf("e trả lại") >= 0))
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("cho e mượn") >= 0 && fb_message1
						.indexOf("e trả lại") >= 0)
				|| (fb_message1.indexOf("salon") >= 0
						&& fb_message1.indexOf(" tóc ") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| (fb_message1.indexOf("cần mua") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("chuyển tiền qua") >= 0)
				|| (fb_message1.indexOf("tuyển dụng") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("cách ngân hàng") >= 0)
				|| (fb_message1.indexOf("cho thuê phòng") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("vị trí") >= 0)
				|| (fb_message1.indexOf("trang sức") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("số tk") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0
						&& fb_message1.indexOf("cọ tiền") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("khách hàng") >= 0
						&& fb_message1.indexOf(" spa ") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("mình cần") >= 0
						&& fb_message1.indexOf("trả lại") >= 0 && fb_message1
						.indexOf("ai có giúp") >= 0)
				|| (fb_message1.indexOf("bạn nào có") >= 0
						&& fb_message1.indexOf("ck dùm") >= 0 && fb_message1
						.indexOf("gửi tiền mặt") >= 0)
				|| (fb_message1.indexOf("cần gấp") >= 0
						&& fb_message1.indexOf("cho em mượn") >= 0 && fb_message1
						.indexOf("gửi lại") >= 0)
				|| (fb_message1.indexOf("studio") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("địa chỉ") >= 0)
				|| (fb_message1.indexOf("tiền hàng") >= 0 && (fb_message1
						.indexOf(" ck ") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("bên hông ngân hàng") >= 0)
				|| (fb_message1.indexOf("mỹ phẩm") >= 0 && fb_message1
						.indexOf("vận chuyển") >= 0)
				|| (fb_message1.indexOf("ai dùng") >= 0 && fb_message1
						.indexOf("đổi tiền giúp em qua") >= 0)
				|| (fb_message1.indexOf("ai dùng") >= 0 && fb_message1
						.indexOf("đổi tien giup em qua") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("đối diện ngân hàng") >= 0)
				|| (fb_message1.indexOf("địa điểm") >= 0 && fb_message1
						.indexOf("ngõ ngân hàng") >= 0)
				|| (fb_message1.indexOf("nam á") >= 0 && fb_message1
						.indexOf("bàn về chính trị thế giới") >= 0)
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("hẻm ngân hàng") >= 0)
				|| ((fb_message1.indexOf("mong nhận được sự giúp đỡ") >= 0 || fb_message1
						.indexOf("xin nhận hỗ trợ giùm") >= 0) && fb_message1
						.indexOf(" stk ") >= 0)
				|| fb_message1.indexOf("nhặt đc 1 cmnd ơ truoc cay atm") >= 0
				|| fb_message1.indexOf(" bán win ") >= 0
				|| fb_message1.indexOf("nhận man") >= 0
				|| fb_message1.indexOf(" w88 ") >= 0
				|| fb_message1.indexOf(" bán củ ") >= 0
				|| (fb_message1.indexOf("cần tiền gấp vào tài khoản") >= 0
						&& fb_message1.indexOf("cho đi nhanh") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& (fb_message1.indexOf("freeship") >= 0 || fb_message1
								.indexOf("hàng đẹp") >= 0) && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& fb_message1.indexOf("free ship") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("a di đà phật") >= 0
						&& fb_message1.indexOf("từ thiện") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf("giá mềm") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				// || (fb_message1.indexOf(" mua ") >= 0 && fb_message1
				// .indexOf(" số tài khoản ") >= 0)
				// || fb_message1.indexOf(" bán lẻ ") >= 0
				|| (fb_message1.indexOf("bán buôn") >= 0
						&& fb_message1.indexOf("bán lẻ") >= 0 && fb_message1
						.indexOf("inbox") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("chuyển giúp") >= 0 && fb_message1
						.indexOf("trả tiền mặt") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("giúp mình") >= 0 && fb_message1
						.indexOf("mình trả") >= 0)
				|| (fb_message1.indexOf("bán buôn") >= 0
						&& fb_message1.indexOf("bán lẻ") >= 0 && fb_message1
						.indexOf("chiết khấu") >= 0)
				|| (fb_message1.indexOf("chương trình") >= 0
						&& fb_message1.indexOf("chuyển khoản") >= 0 && fb_message1
						.indexOf("tour") >= 0)
				|| fb_message1.indexOf(" steam ") >= 0
				|| fb_message1.indexOf("dịch vụ mua bán") >= 0
				|| fb_message1.indexOf("mua bán iwin") >= 0
				|| fb_message1.indexOf("đại lý chíp ") >= 0
				|| fb_message1.indexOf("sim số đẹp") >= 0
				// || fb_message1.indexOf(" bán buôn ") >= 0
				|| (fb_message1.indexOf(" thông tin mua hàng ") >= 0 && fb_message1
						.indexOf(" thông tin tài khoản ") >= 0)
				|| (fb_message1.indexOf(" sell ") >= 0 && fb_message1
						.indexOf(" cần bán ") >= 0)
				|| (fb_message1.indexOf("kêu gọi") >= 0 && fb_message1
						.indexOf("quyên góp") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && (fb_message1
						.indexOf("cho mượn") >= 0 || fb_message1
						.indexOf("mượn đi") >= 0))
				|| (fb_message1.indexOf("nợ tiền") >= 0 && fb_message1
						.indexOf("trả em đi") >= 0)
				|| (fb_message1.indexOf("bán gấp lô đất") >= 0 && fb_message1
						.indexOf("ngay sau ngân hàng") >= 0)
				|| (fb_message1.indexOf(" shop") >= 0 && fb_message1
						.indexOf(" giao hàng ") >= 0)
				|| (fb_message1.indexOf(" giúp đỡ ") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| fb_message1
						.indexOf("tiền lương sẽ được chuyển khoản hàng tuần qua ngân hàng") >= 0
				|| fb_message1.indexOf("thu vcoin") >= 0
				|| fb_message1.indexOf("mua vcoin") >= 0
				|| fb_message1.indexOf(" vcoin ") >= 0
				|| fb_message1
						.indexOf("tiền lương sẽ được chuyển khoản qua ngân hàng") >= 0
				|| fb_message1
						.indexOf("tiền lương được chuyển khoản qua ngân hàng") >= 0
				|| fb_message1.indexOf("danh sách phát tâm") >= 0
				|| fb_message1.indexOf("phát tâm phóng sanh") >= 0
				|| (fb_message1.indexOf("bắn qua tk") >= 0 && fb_message1
						.indexOf("trả lại từ tk") >= 0)
				|| (fb_message1.indexOf("em cần đổi") >= 0 && fb_message1
						.indexOf("trả lại qua") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("em đổi lấy") >= 0)
				|| (fb_message1.indexOf("em cần") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("giúp em") >= 0)
				|| (fb_message1.indexOf("cầm đồ") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("stk") >= 0
						&& fb_message1.indexOf("đơn hàng") >= 0 && fb_message1
						.indexOf("chuyển khoản vào giúp") >= 0)
				|| (fb_message1.indexOf("em cần") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("giúp em") >= 0)
				|| (fb_message1.indexOf(" mtq ") >= 0
						&& fb_message1.indexOf(" tk ") >= 0 && fb_message1
						.indexOf(" ck ") >= 0)
				|| (fb_message1.indexOf("có tk") >= 0
						&& fb_message1.indexOf("nhờ tý") >= 0 && fb_message1
						.indexOf("gửi lại") >= 0)
				|| (fb_message1.indexOf("mỹ phẩm") >= 0
						&& fb_message1.indexOf("giá bán") >= 0 && (fb_message1
						.indexOf("freeship") >= 0 || fb_message1
						.indexOf("free ship") >= 0))
				|| (fb_message1.indexOf(" đóng góp ") >= 0 && fb_message1
						.indexOf(" hỗ trợ ") >= 0)
				|| (fb_message1.indexOf("mọi người ai giúp được hoàn cảnh") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("bạn nào có thẻ") >= 0 && fb_message1
						.indexOf("mình nhờ chút") >= 0)
				|| (fb_message1.indexOf("mua hàng") >= 0 && (fb_message1
						.indexOf("đối diện") >= 0 || fb_message1
						.indexOf("đối diện nh") >= 0))
				|| (fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("hàng đảm bảo") >= 0)
				|| (fb_message1.indexOf("bán đất") >= 0 && fb_message1
						.indexOf("gần trụ sở ngân hàng") >= 0)
				|| (fb_message1.indexOf("bán nhà") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("diện tích") >= 0)
				|| (fb_message1.indexOf("cửa hàng") >= 0 && (fb_message1
						.indexOf("sát ngân hàng") >= 0 || fb_message1
						.indexOf("sát nh") >= 0))

		) {
			check = 1;
		}
		if ((fb_message1.indexOf(" ủng hộ ") >= 0 && fb_message1
				.indexOf(" hảo tâm ") >= 0)
				|| (fb_message1.indexOf("ai có tiền") >= 0 && (fb_message1
						.indexOf("ck ho minh") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("sản phẩm") >= 0 && fb_message1
						.indexOf("giảm giá ") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf(" oder ") >= 0 && fb_message1
						.indexOf("đặt cọc") >= 0)
				|| (fb_message1.indexOf(" order ") >= 0 && fb_message1
						.indexOf("đặt cọc") >= 0)
				|| (fb_message1.indexOf("né thằng này") >= 0 && fb_message1
						.indexOf("mắc lừa") >= 0)
				|| (fb_message1.indexOf("cho thuê nhà") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf("cần mua") >= 0 && fb_message1
						.indexOf("size") >= 0)
				|| (fb_message1.indexOf("hệ thống các ngân hàng") >= 0 && fb_message1
						.indexOf("khu đô thị thương mại") >= 0)
				|| (fb_message1.indexOf("hàng xách tay") >= 0 && fb_message1
						.indexOf("inbox") >= 0)
				|| (fb_message1.indexOf("vị trí đất") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| (fb_message1.indexOf("vị trí đất") >= 0
						&& fb_message1.indexOf(" lh ") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| fb_message1.indexOf(" order ") >= 0
				|| fb_message1.indexOf("tuyển ctv bán hàng") >= 0
				|| fb_message1.indexOf("bán zippo") >= 0
				|| fb_message1.indexOf("mọi sự giúp đỡ xin liên hệ") >= 0
				|| fb_message1.indexOf("bán đồ như hình") >= 0
				|| fb_message1.indexOf("trời sinh một cặp") >= 0
				|| fb_message1.indexOf("tài khoản ủng hộ") >= 0
				|| fb_message1.indexOf("lương văn nghĩa") >= 0
				|| fb_message1.indexOf("12 chòm sao") >= 0
				|| fb_message1.indexOf("bella moda") >= 0
				|| fb_message1.indexOf("shop lady") >= 0
				|| fb_message1.indexOf("cần đổi tiền") >= 0
				|| fb_message1.indexOf("12 chom sao") >= 0
				|| fb_message1.indexOf("đăng tin ngoài luồng") >= 0
				|| (fb_message1.indexOf("ma kết") >= 0
						&& fb_message1.indexOf("bạch dương") >= 0 && fb_message1
						.indexOf("sư tử") >= 0)
				|| (fb_message1.indexOf(" cần ") >= 0
						&& fb_message1.indexOf("trả lại") >= 0 && fb_message1
						.indexOf("ai có inbox") >= 0)
				|| (fb_message1.indexOf(" cần ") >= 0
						&& fb_message1.indexOf("trả lại") >= 0 && fb_message1
						.indexOf("ai có ibox") >= 0)
				|| (fb_message1.indexOf("cần gấp") >= 0
						&& fb_message1.indexOf("ai có") >= 0 && fb_message1
						.indexOf("trả tiền") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0
						&& fb_message1.indexOf("của ai") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| fb_message1.indexOf(" chạy quảng cáo ") >= 0
				|| ((fb_message1.indexOf(" stk ") >= 0 || fb_message1
						.indexOf(" tài khoản ") >= 0)
						&& fb_message1.indexOf(" chuyển khoản ") >= 0 && fb_message1
						.indexOf(" shop ") >= 0)
				|| ((fb_message1.indexOf("lớp học") >= 0 || fb_message1
						.indexOf("khai giảng") >= 0) && (fb_message1
						.indexOf("chuyển khoản") >= 0 || fb_message1
						.indexOf("tài khoản") >= 0))
				// || ((fb_message1.indexOf(" stk ") >= 0 || fb_message1
				// .indexOf(" tài khoản ") >= 0)
				// && fb_message1.indexOf(" ủng hộ ") >= 0 && fb_message1
				// .indexOf(" liên hệ ") >= 0)
				|| (fb_message1.indexOf("sỉ lẻ") >= 0
						&& fb_message1.indexOf("handmade") >= 0 && fb_message1
						.indexOf("freeship") >= 0)
				|| (fb_message1.indexOf("imess") >= 0
						&& fb_message1.indexOf("viber") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf(" ví ") >= 0
						&& fb_message1.indexOf(" mất ") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| (fb_message1.indexOf("imess") >= 0
						&& fb_message1.indexOf("viber") >= 0 && fb_message1
						.indexOf("holine") >= 0)
				|| ((fb_message1.indexOf(" stk ") >= 0 || fb_message1
						.indexOf(" tài khoản ") >= 0)
						&& fb_message1.indexOf(" mua ") >= 0
						&& fb_message1.indexOf(" liên hệ ") >= 0 && fb_message1
						.indexOf("ncb") < 0)
				|| ((fb_message1.indexOf(" stk ") >= 0 || fb_message1
						.indexOf(" tài khoản ") >= 0)
						&& fb_message1.indexOf(" đặt hàng ") >= 0 && fb_message1
						.indexOf(" giao hàng ") >= 0)
				|| (fb_message1.indexOf("sản xuất") >= 0
						&& fb_message1.indexOf("tình trạng") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("chi tiết về sản phẩm") >= 0)
				|| ((fb_message1.indexOf("cửa hàng") >= 0 || fb_message1
						.indexOf("sản phẩm") >= 0)
						&& fb_message1.indexOf(" chuyển khoản ") >= 0 && (fb_message1
						.indexOf(" tài khoản ") >= 0 || fb_message1
						.indexOf(" stk ") >= 0))) {
			check = 2;
		}
		if (((fb_message1.indexOf("chuyển khoản") >= 0 || fb_message1
				.indexOf("tài khoản") >= 0) && (fb_message1
				.indexOf("quyên góp") >= 0
				|| fb_message1.indexOf("đóng góp") >= 0 || fb_message1
				.indexOf(" từ thiện") >= 0))
				|| ((fb_message1.indexOf("chuyển khoản") >= 0 || fb_message1
						.indexOf("tài khoản") >= 0) && (fb_message1
						.indexOf("donate") >= 0
						|| (fb_message1.indexOf(" giá ") >= 0 && fb_message1
								.indexOf(" shop ") >= 0)
						|| (fb_message1.indexOf(" giá ") >= 0 && fb_message1
								.indexOf("khuyến mại") >= 0) || (fb_message1
						.indexOf(" sỉ ") >= 0 && fb_message1.indexOf("lẻ") >= 0)))
				|| ((fb_message1.indexOf("mỹ phẩm") >= 0 || fb_message1
						.indexOf(" bán ") >= 0)
						&& fb_message1.indexOf(" giá ") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("size") >= 0
						&& fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("bán") >= 0)
				|| (fb_message1.indexOf("khóa học") >= 0
						&& fb_message1.indexOf("tiếng anh") >= 0 && fb_message1
						.indexOf("tòa nhà") >= 0)
				|| (fb_message1.indexOf("ưu đãi") >= 0 && fb_message1
						.indexOf("thông tin chuyển khoản") >= 0)
				|| (fb_message1.indexOf("muốn giúp đỡ") >= 0 && fb_message1
						.indexOf("xin gửi trực tiếp") >= 0)
				|| (fb_message1.indexOf("stk") >= 0 && fb_message1
						.indexOf("khách ck") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("chuyển khoản") >= 0 && fb_message1
						.indexOf("sản phẩm") >= 0)
				|| (fb_message1.indexOf("mua rik") >= 0
						&& fb_message1.indexOf("bán rik") >= 0 && fb_message1
						.indexOf("giao dịch") >= 0)
				|| (fb_message1.indexOf(" anz ") >= 0
						&& fb_message1.indexOf("chuyển nhà") >= 0 && fb_message1
						.indexOf("vận chuyển") >= 0)
				|| (fb_message1.indexOf(" acc ") >= 0
						&& fb_message1.indexOf(" bán ") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("ielts") >= 0
						&& fb_message1.indexOf("học viên") >= 0 && fb_message1
						.indexOf("khóa học") >= 0)
				|| (fb_message1.indexOf("chuyển khoản") >= 0
						&& fb_message1.indexOf("lệ phí") >= 0 && fb_message1
						.indexOf("khóa học") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("giá") >= 0
						&& fb_message1.indexOf("hotline") >= 0 && fb_message1
						.indexOf("free") >= 0)
				|| (fb_message1.indexOf(" bán ") >= 0
						&& fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("cửa hàng") >= 0 && fb_message1
						.indexOf("iphone") >= 0)
				|| ((fb_message1.indexOf("ảnh cưới") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0) && (fb_message1
						.indexOf("tài khoản") >= 0
						|| fb_message1.indexOf(" tk ") >= 0 || fb_message1
						.indexOf(" stk ") >= 0))
				|| (fb_message1.indexOf("bán chips") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("thẻ sò") >= 0 && fb_message1
						.indexOf("bán") >= 0)
				|| (fb_message1.indexOf("tuyển học viên") >= 0 && fb_message1
						.indexOf(" ck ") >= 0)
				|| (fb_message1.indexOf("đang cần") >= 0 && fb_message1
						.indexOf("trả bằng") >= 0)
				|| ((fb_message1.indexOf("nhờ ck qua hộ") >= 0 || fb_message1
						.indexOf("nhờ ck hộ") >= 0) && fb_message1
						.indexOf("ck lại") >= 0)
				|| ((fb_message1.indexOf("thiện nguyện") >= 0
						|| fb_message1.indexOf("ủng hộ") >= 0 || fb_message1
						.indexOf("tri ân") >= 0) && (fb_message1
						.indexOf(" mtq ") >= 0 || fb_message1
						.indexOf("mạnh thường quân") >= 0))
				|| (fb_message1.indexOf("bán xu sll") >= 0 && fb_message1
						.indexOf("mua xu sll") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("xả hàng") >= 0)
				|| (fb_message1.indexOf("giá bán") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("giá tag") >= 0)
				|| (fb_message1.indexOf(" bán ") >= 0
						&& fb_message1.indexOf("khách hàng") >= 0 && fb_message1
						.indexOf("sever") >= 0)
				|| (fb_message1.indexOf("bạn đọc") >= 0
						&& fb_message1.indexOf("ủng hộ") >= 0 && fb_message1
						.indexOf("chia sẻ") >= 0)
				|| (((fb_message1.indexOf("ủng hộ") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0) || (fb_message1
						.indexOf("từ thiện") >= 0 && fb_message1
						.indexOf("góp sức") >= 0)) && (fb_message1
						.indexOf(" stk ") >= 0 || fb_message1.indexOf(" tk ") >= 0))
				|| (fb_message1.indexOf("mỹ phẩm") >= 0
						&& fb_message1.indexOf(" sỉ ") >= 0 && (fb_message1
						.indexOf("chuyển khoản") >= 0
						|| fb_message1.indexOf("tài khoản") >= 0
						|| fb_message1.indexOf(" stk ") >= 0 || fb_message1
						.indexOf(" tk ") >= 0))) {
			check = 3;
		}
		if ((fb_message1.indexOf(" chủ tk ") >= 0 && fb_message1
				.indexOf(" số tk ") >= 0)
				|| (fb_message1.indexOf(" hảo tâm ") >= 0 && fb_message1
						.indexOf("thiện pháp") >= 0)
				|| (fb_message1.indexOf("khách iu") >= 0 && fb_message1
						.indexOf("sale") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf(" bóp") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf(" ví ") >= 0)
				|| (fb_message1.indexOf("có ai dùng thẻ") >= 0 && fb_message1
						.indexOf("nhờ tý") >= 0)
				|| (fb_message1.indexOf("bán ") >= 0 && fb_message1
						.indexOf("ai mua pm") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0 && fb_message1
						.indexOf("bán hàng online") >= 0)
				|| (fb_message1.indexOf("tuyển gấp") >= 0 && fb_message1
						.indexOf("kcn") >= 0)
				|| ((fb_message1.indexOf(" đóng góp ") >= 0 || fb_message1
						.indexOf(" ủng hộ ") >= 0) && (fb_message1
						.indexOf("chuyển vào tk") >= 0
						|| fb_message1.indexOf("chuyển vào tài khoản") >= 0 || fb_message1
						.indexOf("thông qua số tài khoản") >= 0))
				|| (fb_message1.indexOf("liên hệ") >= 0 && (fb_message1
						.indexOf("số tài khoản") >= 0 || fb_message1
						.indexOf(" số tk ") >= 0))
				|| ((fb_message1.indexOf("studio") >= 0 || fb_message1
						.indexOf("ảnh viện") >= 0) && (fb_message1
						.indexOf(" tk ") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("album áo") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("đặt hàng") >= 0)
				|| (fb_message1.indexOf("bán buôn") >= 0
						&& fb_message1.indexOf("bán lẻ") >= 0 && fb_message1
						.indexOf("giao hàng") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf(" gdtt ") >= 0 && fb_message1
						.indexOf(" ai mua ") >= 0)
				|| fb_message1.indexOf(" bán nick ") >= 0
				|| (fb_message1.indexOf("đánh rơi") >= 0
						&& fb_message1.indexOf("giấy tờ tùy thân") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf(" bán ") >= 0
						&& fb_message1.indexOf("chuyển khoản") >= 0 && fb_message1
						.indexOf(" pm ") >= 0)
				|| (fb_message1.indexOf("order") >= 0
						&& fb_message1.indexOf("đặt hàng") >= 0 && fb_message1
						.indexOf("nhận hàng") >= 0)
				|| fb_message1.indexOf("vui lòng chuyển khoản theo") >= 0
				|| fb_message1.indexOf("hỗ trợ xin gửi về") >= 0
				|| fb_message1.indexOf("hỗ trợ xin gởi về") >= 0
				|| (fb_message1.indexOf("mọi hỗ trợ xin liên hệ") >= 0 && (fb_message1
						.indexOf("tài khoản") >= 0 || fb_message1
						.indexOf(" stk ") >= 0))
				|| fb_message1.indexOf("vui lòng chuyển khoản") >= 0
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && (fb_message1
						.indexOf(" tk ") >= 0 || fb_message1
						.indexOf("tài khoản") >= 0))
				|| (fb_message1.indexOf("không có tiền phẫu thuật") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("chuyển giúp") >= 0 && fb_message1
						.indexOf("bắn trả lại") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("nhờ xíu") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ xíu") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("giúp e") >= 0)
				|| (fb_message1.indexOf("niệm phật") >= 0
						&& fb_message1.indexOf("ủng hộ") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf(" mua ") >= 0
						&& fb_message1.indexOf(" bán ") >= 0 && (fb_message1
						.indexOf("gd trung gian") >= 0 || fb_message1
						.indexOf("giao dịch trung gian") >= 0))
				|| (fb_message1.indexOf("ủng hộ") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && (fb_message1
						.indexOf("giúp đỡ") >= 0
						|| fb_message1.indexOf(" phật ") >= 0 || fb_message1
						.indexOf("tấm lòng") >= 0))
				|| (fb_message1.indexOf("ai có nhu cầu") >= 0 && fb_message1
						.indexOf("địa điểm bán") >= 0)
				|| fb_message1.indexOf("gd nđt nước ngoài") >= 0
				|| fb_message1.indexOf("the saigon times daily") >= 0
				|| fb_message1.indexOf("mua bán rik") >= 0
				|| fb_message1.indexOf("hoacuctetkhanhhoa") >= 0
				|| fb_message1.indexOf("lê duẩn làm ngân hàng vietcombank") >= 0
				|| fb_message1.indexOf("chuyển khoản hộ ") >= 0
				|| fb_message1.indexOf("tăng like facebook") >= 0
				|| fb_message1.indexOf("tăng like fanpage") >= 0
				|| (fb_message1.indexOf("luyện thi chứng chỉ tiếng anh") >= 0 && fb_message1
						.indexOf("địa điểm") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ tí") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("nhiều vàng") >= 0)) {
			check = 4;
		}
		if ((fb_message1.indexOf("lô hàng") >= 0 && fb_message1
				.indexOf("bao test") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("cho em mượn") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("cho e mượn") >= 0)
				|| ((fb_message1.indexOf("ai có tk ") >= 0 || fb_message1
						.indexOf("bạn nào có thẻ") >= 0) && fb_message1
						.indexOf("nhờ tí") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("chuyên sỉ") >= 0)
				|| (fb_message1.indexOf("khách mua hàng") >= 0 && (fb_message1
						.indexOf("ck vào") >= 0 || fb_message1
						.indexOf("chuyển khoản vào") >= 0))
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("đặt mua") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("đại lý") >= 0
						&& fb_message1.indexOf("giao hàng") >= 0 && fb_message1
						.indexOf("tư vấn") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("bên trong có") >= 0)
				|| (fb_message1.indexOf("chung tay") >= 0
						&& fb_message1.indexOf("giúp đỡ") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0
						&& fb_message1.indexOf("nhận hàng") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("ai dùng") >= 0
						&& fb_message1.indexOf("chuyển cho") >= 0 && fb_message1
						.indexOf("trả lại") >= 0)
				|| (fb_message1.indexOf("sandal") >= 0
						&& fb_message1.indexOf(" giá ") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("chuyển khoản") >= 0
						&& fb_message1.indexOf(" phí ") >= 0 && fb_message1
						.indexOf("vận chuyển") >= 0)
				|| (fb_message1.indexOf("album") >= 0
						&& fb_message1.indexOf("hàng chuẩn") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0
						&& fb_message1.indexOf("giao hàng") >= 0 && fb_message1
						.indexOf("thanh toán") >= 0)
				|| (fb_message1.indexOf("học phí") >= 0
						&& fb_message1.indexOf("khóa học") >= 0 && fb_message1
						.indexOf("tiếng anh") >= 0)
				|| (fb_message1.indexOf("rossy") >= 0
						&& fb_message1.indexOf("tên") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("nam mô a di đà phật") >= 0 && fb_message1
						.indexOf("công đức") >= 0)
				|| ((fb_message1.indexOf(" tìm đồ ") >= 0
						|| fb_message1.indexOf(" tìm ví ") >= 0 || fb_message1
						.indexOf("trong ví có ") >= 0) && fb_message1
						.indexOf("liên hệ") >= 0)
				|| ((fb_message1.indexOf("shop") >= 0 || fb_message1
						.indexOf("cuongmobile") >= 0)
						&& fb_message1.indexOf("sản phẩm") >= 0 && fb_message1
						.indexOf("khuyến mãi") >= 0)
				|| (fb_message1.indexOf(" bus ") >= 0
						&& fb_message1.indexOf("chung tay") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("dịch vụ làm bằng") >= 0 && fb_message1
						.indexOf("chạy điểm nợ môn") >= 0)
				|| (fb_message1.indexOf("giá cả") >= 0
						&& fb_message1.indexOf("bao giá") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("cần đổi") >= 0
						&& fb_message1.indexOf("sang") >= 0 && fb_message1
						.indexOf("mình cần") >= 0)
				|| (fb_message1.indexOf("phòng vé") >= 0
						&& fb_message1.indexOf("hotline") >= 0 && fb_message1
						.indexOf("hình thức thanh toán") >= 0)
				|| (fb_message1.indexOf("tư vấn và hỗ trợ") >= 0
						&& fb_message1.indexOf("bảng giá") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("đặt hàng") >= 0 && fb_message1
						.indexOf("mua hàng") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("hotline") >= 0 && fb_message1
						.indexOf("album") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("hotline") >= 0 && fb_message1
						.indexOf("sản phẩm") >= 0)
				|| (fb_message1.indexOf("mua bán") >= 0 && fb_message1
						.indexOf("liên hệ trực tiếp") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("tư vấn sản phẩm") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| fb_message1.indexOf("cuongmobile") >= 0
				|| (fb_message1.indexOf("xe bus yêu thương") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("học phí") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("thông tin chuyển khoản") >= 0 && fb_message1
						.indexOf("khách hàng") >= 0)
				|| (fb_message1.indexOf("thông tin chuyển khoản") >= 0 && fb_message1
						.indexOf("xả hàng") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("bắn hộ") >= 0)
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("nhờ chuyển khoản") >= 0)) {
			check = 5;
		}
		if ((fb_message1.indexOf("sản phẩm") >= 0 && fb_message1
				.indexOf("bảo hành") >= 0)
				|| (fb_message1.indexOf("bán buôn") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("bán buôn") >= 0 && fb_message1
						.indexOf("sản phẩm") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0 && fb_message1
						.indexOf("giấy tờ") >= 0)
				|| fb_message1.indexOf("miễn phí giao hàng") >= 0
				|| fb_message1.indexOf("rơi giấy tờ") >= 0
				|| fb_message1.indexOf("thế giới xe điện") >= 0
				|| fb_message1.indexOf("shop phụ kiện") >= 0
				|| fb_message1.indexOf("hỗ trợ chương trình góp sức") >= 0
				|| fb_message1.indexOf("nhận up tim") >= 0
				|| (fb_message1.indexOf("album") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("cho thuê") >= 0 && fb_message1
						.indexOf("miễn trung gian") >= 0)
				|| (fb_message1.indexOf("album") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("freeship") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				// || (fb_message1.indexOf("khách hàng") >= 0 && fb_message1
				// .indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("phòng vé") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("học phí") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf(" tour ") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("game") >= 0 && fb_message1
						.indexOf(" acc ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("store") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("nhờ chuyển khoản") >= 0)
				|| (fb_message1.indexOf("hàng hiệu") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("giá bán") >= 0)
				// || (fb_message1.indexOf("bán căn hộ") >= 0 && fb_message1
				// .indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("chuyển khoản giúp") >= 0 && fb_message1
						.indexOf("trả tiền mặt") >= 0)
				|| fb_message1.indexOf("free nội thành") >= 0
				|| fb_message1.indexOf("ông hoàng kiều") >= 0
				|| (fb_message1.indexOf("đồng hồ") >= 0 && fb_message1
						.indexOf("mạnh dũng") >= 0)
				|| (fb_message1.indexOf("vòng tay") >= 0 && fb_message1
						.indexOf("sát bên ngân hàng") >= 0)
				|| (fb_message1.indexOf("tuyển vị trí bán hàng") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("thị trường") >= 0 && fb_message1
						.indexOf("quần đôi") >= 0)
				|| (fb_message1.indexOf("cho thuê dài hạn") >= 0 && fb_message1
						.indexOf("xung quanh có") >= 0)
				|| (fb_message1.indexOf("phật tử") >= 0 && fb_message1
						.indexOf("tịnh tài") >= 0)
				|| (fb_message1.indexOf("ai có tk") >= 0 && fb_message1
						.indexOf("cho e mượn") >= 0)
				|| (fb_message1.indexOf("mọi đóng góp") >= 0 && fb_message1
						.indexOf("xin gửi về") >= 0)
				|| (fb_message1.indexOf("là đối tác của 14 ngân hàng lớn") >= 0 && fb_message1
						.indexOf("làm việc ngay với chúng tôi") >= 0)
				|| (fb_message1.indexOf("thông tin chuyển khoản") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| fb_message1.indexOf("chi tiết tài khoản") >= 0
				|| fb_message1.indexOf("ai cần mua") >= 0
				|| fb_message1.indexOf("trung tâm nhân đạo") >= 0
				|| (fb_message1.indexOf("garden") >= 0
						&& fb_message1.indexOf("hotline") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0
						&& fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("xin lại") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("ncb") < 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("hàng") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("buôn sỉ") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf("buôn") >= 0
						&& fb_message1.indexOf("sỉ lẻ") >= 0 && fb_message1
						.indexOf("toàn quốc") >= 0)
				|| (fb_message1.indexOf("chuyển khoản") >= 0
						&& fb_message1.indexOf("đại lý") >= 0 && (fb_message1
						.indexOf("khách sỉ") >= 0 || fb_message1
						.indexOf("chủ tài khoản") >= 0))
				|| (fb_message1.indexOf("chuyển khoản") >= 0
						&& fb_message1.indexOf("đại lí") >= 0 && (fb_message1
						.indexOf("khách sỉ") >= 0 || fb_message1
						.indexOf("chủ tài khoản") >= 0))
				|| (fb_message1.indexOf("giá") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf("của ai") >= 0
						&& fb_message1.indexOf("xác nhận") >= 0 && fb_message1
						.indexOf("trả đủ") >= 0)
				|| (fb_message1.indexOf("imess") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& (fb_message1.indexOf("trả tiền mặt") >= 0 || fb_message1
								.indexOf("trả tiền qua") >= 0) && (fb_message1
						.indexOf("ck giúp") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))) {
			check = 6;
		}
		if ((fb_message1.indexOf("hotline") >= 0
				&& fb_message1.indexOf("công ty") >= 0 && fb_message1
				.indexOf("website") >= 0)
				|| (fb_message1.indexOf("hotline") >= 0
						&& fb_message1.indexOf("size") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				// || (fb_message1.indexOf(" bán ") >= 0
				// && fb_message1.indexOf(" giá ") >= 0 && fb_message1
				// .indexOf("khách hàng") >= 0)
				|| (fb_message1.indexOf(" bệnh ") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| (fb_message1.indexOf("chuyển khoản trước") >= 0 && fb_message1
						.indexOf("tài khoản") >= 0)
				|| (fb_message1.indexOf("chuyển khoản") >= 0 && fb_message1
						.indexOf("ai đặt") >= 0)
				|| (fb_message1.indexOf("chuyên cho thuê") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| fb_message1.indexOf("xuất khẩu lao động") >= 0
				|| (fb_message1.indexOf("quý khách") >= 0
						&& fb_message1.indexOf("thanh toán") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("khách") >= 0
						&& fb_message1.indexOf("store") >= 0 && fb_message1
						.indexOf("inbox") >= 0)
				|| (fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf("hảo tâm") >= 0 && fb_message1
						.indexOf("chuyển tiền") >= 0)
				|| (fb_message1.indexOf("bệnh tật") >= 0
						&& fb_message1.indexOf("ủng hộ") >= 0 && (fb_message1
						.indexOf("chuyển khoản") >= 0
						|| fb_message1.indexOf(" stk ") >= 0 || fb_message1
						.indexOf(" tk ") >= 0))
				|| (fb_message1.indexOf("cơm thiện tâm") >= 0 && fb_message1
						.indexOf("bệnh nhân nghèo") >= 0)

				|| (fb_message1.indexOf("khách buôn") >= 0 && fb_message1
						.indexOf("khách lẻ") >= 0)
				// || (fb_message1.indexOf(" giá ") >= 0 && fb_message1
				// .indexOf("iphone") >= 0)
				|| (fb_message1.indexOf(" size ") >= 0 && (fb_message1
						.indexOf(" stk ") >= 0 || fb_message1.indexOf(" tk ") >= 0))
				|| fb_message1.indexOf("giavinh ao cuoi") >= 0
				|| (fb_message1.indexOf("lạy mẫu") >= 0 && fb_message1
						.indexOf("cầu nguyện") >= 0)
				|| (fb_message1.indexOf("call") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("khách bán buôn") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf(" fb ") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("set") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0
						&& fb_message1.indexOf("thanh toán") >= 0 && fb_message1
						.indexOf("nhận hàng") >= 0)
				|| (fb_message1.indexOf(" hàng ") >= 0
						&& fb_message1.indexOf("đại lý") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| (fb_message1.indexOf("tuyển gấp") >= 0
						&& fb_message1.indexOf("lao động") >= 0 && fb_message1
						.indexOf("yêu cầu bằng cấp") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("bán buôn") >= 0
						&& fb_message1.indexOf("bán lẻ") >= 0 && fb_message1
						.indexOf("order") >= 0)
				|| (fb_message1.indexOf("buôn") >= 0
						&& fb_message1.indexOf("lẻ") >= 0 && fb_message1
						.indexOf("order") >= 0)
				|| (fb_message1.indexOf("dự án") >= 0
						&& fb_message1.indexOf("nằm gần") >= 0 && fb_message1
						.indexOf("ngân hàng lớn") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf(" khách ") >= 0)
				// || (fb_message1.indexOf("khách") >= 0 && fb_message1
				// .indexOf("shop") >= 0)
				|| (fb_message1.indexOf("link album") >= 0 && fb_message1
						.indexOf("tri ân") >= 0)
				|| (fb_message1.indexOf("giá cả") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("khách ở xa") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("cảnh báo") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("đánh rơi") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("mất giấy tờ") >= 0 && fb_message1
						.indexOf("liên lạc") >= 0)
				|| (fb_message1.indexOf("chủ tài khoản") >= 0 && fb_message1
						.indexOf("số tài khoản") >= 0)
				|| (fb_message1.indexOf("cần tiền") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf(" đt ") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf(" chốt ") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)) {
			check = 7;
		}
		if ((fb_message1.indexOf("shop") >= 0 && fb_message1.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| (fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("số tk công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("stk công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("số tài khoản công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("gửi hàng") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("hàng có sẵn") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf(" acc ") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
						.indexOf("nhân viên phục vụ") >= 0)
				|| (fb_message1.indexOf("thẩm mỹ viện") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("mien trung") >= 0 && fb_message1
						.indexOf("ung ho") >= 0)
				|| (fb_message1.indexOf(" thầy ") >= 0 && fb_message1
						.indexOf(" công đức ") >= 0)
				|| (fb_message1.indexOf("store") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("đại lý") >= 0 && fb_message1
						.indexOf("ruby") >= 0)
				|| fb_message1.indexOf("nhận order") >= 0
				|| fb_message1.indexOf("chuyên hàng xách tay") >= 0
				|| fb_message1.indexOf("rơi ví") >= 0
				|| fb_message1.indexOf("lô đề online") >= 0
				|| fb_message1.indexOf("luckyshoes") >= 0
				|| fb_message1.indexOf("nhặt được thẻ") >= 0
				|| fb_message1.indexOf("mất cái ví") >= 0
				|| fb_message1.indexOf("mất ví") >= 0
				|| fb_message1.indexOf("thương lắm miền trung") >= 0
				|| fb_message1.indexOf("thương lắmmiền trung") >= 0
				|| (fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("phạm thị huyền trang") >= 0 && fb_message1
						.indexOf("bank") >= 0)
				|| (fb_message1.indexOf("nguyễn thị dung") >= 0 && fb_message1
						.indexOf("bank") >= 0)
				|| (fb_message1.indexOf("có sẵn") >= 0 && fb_message1
						.indexOf("order") >= 0)
				|| (fb_message1.indexOf("có sẵn") >= 0 && fb_message1
						.indexOf("oder") >= 0)
				|| fb_message1.indexOf("order khách vui lòng") >= 0
				|| fb_message1.indexOf("oder khách vui lòng") >= 0
				|| (fb_message1.indexOf("like new") >= 0 && fb_message1
						.indexOf("chi tiết") >= 0)
				|| (fb_message1.indexOf("le thu thao") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| (fb_message1.indexOf("hàng có sẵn") >= 0 && fb_message1
						.indexOf("call") >= 0)
				|| (fb_message1.indexOf("đặt lịch") >= 0 && fb_message1
						.indexOf("call") >= 0)
				|| (fb_message1.indexOf("đặt hàng") >= 0 && fb_message1
						.indexOf("album") >= 0)
				|| (fb_message1.indexOf("full box") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf("khách") >= 0 && fb_message1
						.indexOf("nhận hàng") >= 0)
				|| (fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("váy cưới") >= 0)
				|| (fb_message1.indexOf("combo") >= 0 && fb_message1
						.indexOf(" váy ") >= 0)
				|| (fb_message1.indexOf("hàng hiệu") >= 0 && fb_message1
						.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("vest") >= 0 && fb_message1
						.indexOf("áodài") >= 0)
				|| (fb_message1.indexOf("vest") >= 0 && fb_message1
						.indexOf("áo dài") >= 0)
				|| (fb_message1.indexOf("sale") >= 0 && fb_message1
						.indexOf("thời trang") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf("freesize") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf("free size") >= 0)
				|| (fb_message1.indexOf(" son ") >= 0 && fb_message1
						.indexOf(" lip ") >= 0)) {
			check = 8;
		}
		if ((fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
				.indexOf("hồ sơ xin việc") >= 0)
				|| (fb_message1.indexOf(" áo ") >= 0 && fb_message1
						.indexOf("chân váy") >= 0)
				|| fb_message1.indexOf("đu size") >= 0
				|| fb_message1.indexOf("kim cương gói") >= 0
				|| fb_message1.indexOf("mình giới thiệu hàng") >= 0
				|| (fb_message1.indexOf("khuyến mại") >= 0 && fb_message1
						.indexOf("thông tin chuyển khoản") >= 0)
				|| (fb_message1.indexOf("trải nghiệm sản phẩm") >= 0 && fb_message1
						.indexOf("thông tin chuyển khoản") >= 0)
				|| ((fb_message1.indexOf("bán buôn") >= 0 || fb_message1
						.indexOf("bán lẻ") >= 0) && (fb_message1
						.indexOf("quần áo") >= 0 || fb_message1
						.indexOf("phụ kiện") >= 0))
				|| fb_message1.indexOf("đủ size") >= 0
				|| fb_message1.indexOf("pink house") >= 0
				|| fb_message1.indexOf("món ăn vặt") >= 0
				|| fb_message1.indexOf("giúp đỡ xin gửi về") >= 0
				|| fb_message1.indexOf("rớt bóp") >= 0
				|| fb_message1.indexOf("nhặt được ví") >= 0
				|| fb_message1.indexOf("nhặt được 1 ví") >= 0
				|| fb_message1.indexOf("mất bóp") >= 0
				|| fb_message1.indexOf("rơi 1 ví") >= 0
				|| fb_message1.indexOf("rơi 1 cái bóp") >= 0
				|| fb_message1.indexOf("quên ví") >= 0
				|| fb_message1.indexOf("quên 1 ví") >= 0
				|| fb_message1.indexOf("rơi 1 cái ví") >= 0
				|| fb_message1.indexOf("rơi 1 chiếc ví") >= 0
				|| fb_message1.indexOf("nhặt được chiếc bóp") >= 0
				|| fb_message1.indexOf("rơi một ví") >= 0
				|| fb_message1.indexOf(" rik ") >= 0
				|| fb_message1.indexOf(" rikvip ") >= 0
				|| fb_message1.indexOf(" ck nốt giúp e") >= 0
				|| fb_message1.indexOf("mất một cái bóp") >= 0
				|| fb_message1.indexOf("ủng hộ xin gửi về") >= 0
				|| fb_message1.indexOf("phạm thị thu thảo") >= 0
				|| fb_message1.indexOf("gửi hàng cho khách") >= 0
				|| fb_message1.indexOf("khách nào vừa ck") >= 0
				|| fb_message1.indexOf("khách nào chuyển khoản") >= 0
				|| fb_message1.indexOf("chưa chuyển khoản thì chuyển giúp") >= 0
				|| fb_message1.indexOf("hàng mới về") >= 0
				|| fb_message1.indexOf("mở lòng từ bi") >= 0
				|| fb_message1.indexOf("ai có lòng hảo tâm") >= 0
				|| fb_message1.indexOf("mọi phát tâm xin gửi về") >= 0
				|| fb_message1.indexOf("hỗ trợ đồng bào miền trung") >= 0
				|| fb_message1.indexOf("đóng góp xin gửi về") >= 0
				|| fb_message1.indexOf("đóng góp xin gởi về") >= 0
				|| fb_message1.indexOf("mọi phát tâm xin gởi về") >= 0
				|| fb_message1.indexOf("phát tâm xin gởi về") >= 0
				|| (fb_message1.indexOf("mua hàng online") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| ((fb_message1.indexOf("số tk") >= 0 || fb_message1
						.indexOf("số tài khoản") >= 0) && fb_message1
						.indexOf("tìm chủ nhân") >= 0)
				|| (fb_message1.indexOf("ủng hộ") >= 0 && fb_message1
						.indexOf("xin gửi về") >= 0)
				|| (fb_message1.indexOf("hảo tâm") >= 0 && fb_message1
						.indexOf("nhận sự giúp đỡ") >= 0)
				|| (fb_message1.indexOf("bán đất") >= 0 && fb_message1
						.indexOf("chi tiết liên hệ") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf("lê thị trà my") >= 0)
				|| (fb_message1.indexOf("thiện nguyện") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("full size") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("call") >= 0 && fb_message1
						.indexOf(" inb ") >= 0)
				|| (fb_message1.indexOf("call") >= 0 && fb_message1
						.indexOf(" inbox ") >= 0)
				|| (fb_message1.indexOf("lao động") >= 0 && fb_message1
						.indexOf("trả qua thẻ") >= 0)
				|| (fb_message1.indexOf("gửi trả tiền giúp") >= 0 && fb_message1
						.indexOf("chuyển tiền") >= 0)
				|| (fb_message1.indexOf("tùng sơn") >= 0 && fb_message1
						.indexOf("admin") >= 0)
				|| (fb_message1.indexOf("khách vui lòng") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| fb_message1.indexOf("chuyển khoản trả tớ") >= 0
				|| fb_message1.indexOf("đặt hàng vui lòng chuyển khoản") >= 0
				|| fb_message1.indexOf("xin mọi người cùng đồng hành") >= 0
				|| (fb_message1.indexOf("đồng bào miền trung") >= 0 && fb_message1
						.indexOf("cứu trợ") >= 0)
				|| (fb_message1.indexOf("miền trung") >= 0 && fb_message1
						.indexOf("cứu trợ") >= 0)
				// || (fb_message1.indexOf("đơn hàng") >= 0 && fb_message1
				// .indexOf("khách hàng") >= 0)
				|| (fb_message1.indexOf("mạnh thường quân") >= 0 && fb_message1
						.indexOf("ủng hộ") >= 0)
				|| (fb_message1.indexOf("miền trung") >= 0 && (fb_message1
						.indexOf("cứu trợ") >= 0
						|| fb_message1.indexOf("ủng hộ") >= 0
						|| fb_message1.indexOf("cứu giúp") >= 0 || fb_message1
						.indexOf("giúp đỡ") >= 0))
				|| (fb_message1.indexOf("miền trung") >= 0 && fb_message1
						.indexOf("mạnh thường quân") >= 0)) {
			check = 9;
		}
		if ((fb_message1.indexOf("thiên chúa") >= 0 && fb_message1
				.indexOf("linh mục") >= 0)
				|| (fb_message1.indexOf("miền trung") >= 0 && fb_message1
						.indexOf("manh thường quan") >= 0)
				|| (fb_message1.indexOf("khuyến mãi khi mua") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("miền trung") >= 0 && fb_message1
						.indexOf("ủng hộ") >= 0)
				|| (fb_message1.indexOf("các nhà hảo tâm") >= 0 && fb_message1
						.indexOf("chuyển tiền") >= 0)
				|| (fb_message1.indexOf("cứu trợ") >= 0 && fb_message1
						.indexOf(" lũ ") >= 0)
				|| (fb_message1.indexOf("chuyển giúp") >= 0 && fb_message1
						.indexOf("gửi tiền mặt") >= 0)
				|| (fb_message.toLowerCase().indexOf("stk 1 ") >= 0 && fb_message
						.toLowerCase().indexOf("stk 2 ") >= 0)
				|| (fb_message.toLowerCase().indexOf("giá inbox") >= 0 && fb_message
						.toLowerCase().indexOf("ship") >= 0)
				|| (fb_message.toLowerCase().indexOf("cần đổi") >= 0 && fb_message
						.toLowerCase().indexOf("chuyển vào") >= 0)
				|| (fb_message.toLowerCase().indexOf("hotline") >= 0 && fb_message
						.toLowerCase().indexOf("sold out") >= 0)
				|| (fb_message.toLowerCase().indexOf("oder") >= 0 && fb_message
						.toLowerCase().indexOf("inbox") >= 0)
				|| (fb_message.toLowerCase().indexOf("chuyển khoản giúp") >= 0 && fb_message
						.toLowerCase().indexOf("gửi tiền mặt") >= 0)
				|| (fb_message.toLowerCase().indexOf("chuyển khoản giúp") >= 0 && fb_message
						.toLowerCase().indexOf("gửi luôn tiền mặt") >= 0)
				|| (fb_message.toLowerCase().indexOf("bạn đặt") >= 0 && fb_message
						.toLowerCase().indexOf("xin thông tin") >= 0)

				|| fb_message1.indexOf("rơi 1 bóp") >= 0
				|| fb_message1.indexOf("rơi bóp") >= 0
				|| fb_message1.indexOf("chuyển khoản giúp mình") >= 0

				|| fb_message1.indexOf("mọi đóng góp xin chuyển") >= 0
				|| fb_message1.indexOf("đồng bào miền trung") >= 0
				|| fb_message1.indexOf(" cứu miền trung") >= 0
				|| fb_message1.indexOf("giúp miền trung") >= 0
				|| fb_message1.indexOf("giup miền trung") >= 0
				|| fb_message1.indexOf("miền trung đáng thương") >= 0
				|| fb_message1.indexOf("hàng có sẵn ") >= 0
				|| fb_message1.indexOf("có sẵn tại") >= 0
				|| fb_message1.indexOf("giao hàng tận nơi") >= 0
				|| fb_message1.indexOf("có sẵn tại shop") >= 0
				|| fb_message1.indexOf("số tài khoản của mình") >= 0
				|| fb_message1.indexOf("tuyển gấp lao động") >= 0
				|| fb_message1.indexOf("bán buôn bán lẻ") >= 0
				|| fb_message1.indexOf("gửi hàng cả nước") >= 0
				|| fb_message1.indexOf("nhiều mẫu cao cấp") >= 0
				|| fb_message1.indexOf("mua thẻ định danh") >= 0
				// || fb_message1.indexOf("inbox mình") >= 0
				|| fb_message1.indexOf("tìm giấy tờ") >= 0
				|| fb_message1.indexOf("mua nhiều có fix") >= 0
				|| (fb_message1.indexOf("tuyển lao động") >= 0 && fb_message1
						.indexOf("trả lương đầy đủ qua thẻ ngân hàng") >= 0)
				|| (fb_message1.indexOf("đổi giúp") >= 0 && fb_message1
						.indexOf("gửi lại tiền mặt") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf("áo kenzo") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0 && fb_message1
						.indexOf("quan tâm ib") >= 0)
				|| (fb_message1.indexOf(" giá ") >= 0 && fb_message1
						.indexOf("quan tâm inbox") >= 0)
				|| (fb_message1.indexOf("đây là stk") >= 0 && fb_message1
						.indexOf("sau khi em nhận") >= 0)
				|| (fb_message1.indexOf("thêm tiền") >= 0 && fb_message1
						.indexOf("chung tay góp sức") >= 0)
				|| (fb_message1.indexOf("tài khoản") >= 0 && fb_message1
						.indexOf("nguyễn hoài dương") >= 0)
				|| (fb_message1.indexOf("nhà hảo tâm") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("chung tay quyên góp") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf(" stk ") >= 0 && fb_message1
						.indexOf("ck trc") >= 0)
				|| (fb_message1.indexOf("nhờ xíu") >= 0 && fb_message1
						.indexOf("trả tiền mặt") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("cho em nhờ") >= 0)
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("cho mượn tí") >= 0)
				|| fb_message1.indexOf(" xéo ngân hàng") >= 0
				|| (fb_message1.indexOf("ai có thẻ") >= 0 && fb_message1
						.indexOf("cho e nhờ") >= 0)
				|| (fb_message1.indexOf("ai xài thẻ") >= 0 && fb_message1
						.indexOf("nhờ xíu") >= 0)
				|| (fb_message1.indexOf("nhóm đã nhận") >= 0 && fb_message1
						.indexOf("từ tài khoản") >= 0)
				|| (fb_message1.indexOf("mọi sự đóng góp") >= 0 && fb_message1
						.indexOf("cứu giúp") >= 0)
				|| (fb_message1.indexOf("tìm giấy tờ") >= 0 && fb_message1
						.indexOf(" thẻ ") >= 0)
				|| (fb_message1.indexOf("nhặt được") >= 0 && fb_message1
						.indexOf("cho mình xin lại") >= 0)
				|| (fb_message1.indexOf("hảo tâm hỗ trợ") >= 0 && fb_message1
						.indexOf("liên lạc") >= 0)
				|| (fb_message1.indexOf("sỉ số lượng") >= 0 && fb_message1
						.indexOf("đại lý") >= 0)
				|| (fb_message1.indexOf("ai đặt") >= 0 && fb_message1
						.indexOf("ck trc") >= 0)
				|| (fb_message1.indexOf("ai có tiền") >= 0 && (fb_message1
						.indexOf("bắn trả") >= 0 || fb_message1
						.indexOf("trả lại luôn") >= 0))
				|| (fb_message1.indexOf("ai có tk") >= 0 && fb_message1
						.indexOf("e nhờ") >= 0)
				|| (fb_message1.indexOf("ai có tiền trong tài khoản") >= 0 && fb_message1
						.indexOf("chuyển hộ") >= 0)
				|| (fb_message1.indexOf("còn nợ tiền") >= 0 && fb_message1
						.indexOf("tự chuyển trả giùm") >= 0)
				|| (fb_message1.indexOf("ai có tk") >= 0 && fb_message1
						.indexOf("cần đổi") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("em cần") >= 0
						&& fb_message1.indexOf("em trả") >= 0 && fb_message1
						.indexOf("gửi phí") >= 0)
				|| (fb_message1.indexOf("giúp em") >= 0
						&& fb_message1.indexOf("gửi tiền mặt") >= 0 && fb_message1
						.indexOf(" ck ") >= 0)
				|| ((fb_message1.indexOf("bạn nào có") >= 0 || fb_message1
						.indexOf("ai có") >= 0)
						&& fb_message1.indexOf("cần gấp") >= 0 && (fb_message1
						.indexOf("trả phí") >= 0 || fb_message1
						.indexOf("gửi phí") >= 0))
				|| (fb_message1.indexOf("ai có tài khoản") >= 0 && fb_message1
						.indexOf("chuyển khoản giúp") >= 0)
				|| (fb_message1.indexOf("share giúp") >= 0 && fb_message1
						.indexOf("trường hợp bé") >= 0)
				|| (fb_message1.indexOf("đơn đặt hàng") >= 0 && fb_message1
						.indexOf("giá") >= 0)
				|| (fb_message1.indexOf("socola") >= 0 && fb_message1
						.indexOf("giá ") >= 0)
				|| (fb_message1.indexOf("có hàng") >= 0 && fb_message1
						.indexOf("size") >= 0)
				|| (fb_message1.indexOf("gdtt") >= 0 && fb_message1
						.indexOf("or chuyển khoản") >= 0)
				|| (fb_message1.indexOf("ck sớm") >= 0 && fb_message1
						.indexOf("nội dung chuyển") >= 0)
				|| (fb_message1.indexOf("hàng đã cập bến") >= 0 && fb_message1
						.indexOf("khách") >= 0)
				|| (fb_message1.indexOf("mất giấy tờ") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf(" son ") >= 0 && fb_message1
						.indexOf("đủ màu") >= 0)
				|| (fb_message1.indexOf("bạn nào có") >= 0 && fb_message1
						.indexOf("trả tiền mặt") >= 0)
				|| (fb_message1.indexOf("thiện nguyện") >= 0 && fb_message1
						.indexOf("mọi sự giúp đỡ xin gửi") >= 0)
				|| (fb_message1.indexOf("mạnh thường quân") >= 0 && fb_message1
						.indexOf("gửi vào") >= 0)
				|| (fb_message1.indexOf("còn nợ tiền") >= 0 && (fb_message1
						.indexOf("ckhoan giùm") >= 0 || fb_message1
						.indexOf("chuyển khoản giùm") >= 0))
				|| (fb_message1.indexOf("mạnh thường quân") >= 0 && fb_message1
						.indexOf("gởi vào") >= 0)
				|| (fb_message1.indexOf("vay thế chấp") >= 0 && fb_message1
						.indexOf("điều kiện vay") >= 0)
				|| (fb_message1.indexOf("tìm trọ") >= 0 && fb_message1
						.indexOf("giá cả") >= 0)
				|| (fb_message1.indexOf("tìm phòng trọ") >= 0 && fb_message1
						.indexOf("giá cả") >= 0)
				|| (fb_message1.indexOf("cho mượn chuyển tiền") >= 0 && fb_message1
						.indexOf("trả lại tiền mặt") >= 0)
				|| (fb_message1.indexOf("thay máu cho bé") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| fb_message1.indexOf("hoàn cảnh khó khăn cần giúp") >= 0
				|| (fb_message1.indexOf("tuyển") >= 0
						&& fb_message1.indexOf("nhân viên kinh doanh") >= 0 && fb_message1
						.indexOf("yêu cầu") >= 0)
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && (fb_message1
						.indexOf("địa chỉ") >= 0
						|| fb_message1.indexOf(" sip ") >= 0 || fb_message1
						.indexOf("ship") >= 0))
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("em nhờ") >= 0 && fb_message1
						.indexOf("vào tk") >= 0)
				|| (fb_message1.indexOf("hotline") >= 0
						&& fb_message1.indexOf("địa chỉ") >= 0 && fb_message1
						.indexOf("mua hàng") >= 0)
				|| (fb_message1.indexOf("hotline") >= 0
						&& fb_message1.indexOf("inbox") >= 0 && fb_message1
						.indexOf(" son ") >= 0)
				|| (fb_message1.indexOf("nhà hàng") >= 0
						&& fb_message1.indexOf("phục vụ") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("có tấm lòng") >= 0
						&& fb_message1.indexOf("chuyển khoản") >= 0 && fb_message1
						.indexOf("chuyển tới") >= 0)
				|| (fb_message1.indexOf("set") >= 0
						&& fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf(" lẻ ") >= 0)
				|| (fb_message1.indexOf("cần đổi") >= 0
						&& fb_message1.indexOf("sang") >= 0 && fb_message1
						.indexOf("đổi giúp") >= 0)
				|| (fb_message1.indexOf("liên hệ") >= 0
						&& fb_message1.indexOf(" sỉ ") >= 0 && fb_message1
						.indexOf(" lẻ ") >= 0)
				|| (fb_message1.indexOf("hotline") >= 0
						&& fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("viber") >= 0)
				|| (fb_message1.indexOf("còn tiền ở") >= 0
						&& fb_message1.indexOf("nhờ chút") >= 0 && fb_message1
						.indexOf("gửi tiền mặt") >= 0)
				|| (fb_message1.indexOf("sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf("địa chỉ") >= 0)
				|| (fb_message1.indexOf("sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf("stk") >= 0)
				|| (fb_message1.indexOf("sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf("ctk") >= 0)
				|| fb_message1.indexOf("mạnh thường quân giúp đỡ") >= 0
				|| (fb_message1.indexOf("sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf("đại lý") >= 0)
				|| (fb_message1.indexOf("sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("có tài khoản") >= 0
						&& fb_message1.indexOf("cho em vay") >= 0 && fb_message1
						.indexOf("trả lại bằng") >= 0)
				|| (fb_message1.indexOf("shop") >= 0
						&& fb_message1.indexOf("liên hệ") >= 0 && fb_message1
						.indexOf("size") >= 0)
				|| (fb_message1.indexOf("khởi nghiệp") >= 0
						&& fb_message1.indexOf("điều kiện tham gia") >= 0 && fb_message1
						.indexOf("chuyển khoản ngay") >= 0)
				|| (fb_message1.indexOf("share") >= 0
						&& fb_message1.indexOf("thông tin tài khoản") >= 0 && fb_message1
						.indexOf("giúp đỡ") >= 0)
				|| (fb_message1.indexOf("tuyển dụng") >= 0
						&& fb_message1.indexOf("hồ sơ") >= 0 && fb_message1
						.indexOf("tài khoản ngân hàng") >= 0)
				|| (fb_message1.indexOf("ai có") >= 0
						&& fb_message1.indexOf("chuyển hộ") >= 0 && fb_message1
						.indexOf("chuyển lại") >= 0)
				|| (fb_message1.indexOf("bắn giúp") >= 0
						&& fb_message1.indexOf("mượn tạm") >= 0 && fb_message1
						.indexOf("trả lại") >= 0)
				|| fb_message1.indexOf("tìm giấy tờ") >= 0
				|| fb_message1.indexOf("sẵn cả bộ áo") >= 0
				|| fb_message1.indexOf("nhờ chuyển khoản dùm") >= 0
				|| fb_message1.indexOf("mượn tài khoản") >= 0
				|| fb_message1.indexOf("mượn tài khỏan") >= 0
				|| fb_message1.indexOf("liên hệ mình kiếm chút tiền") >= 0
				|| fb_message1.indexOf("bán xubigcom") >= 0
				|| fb_message1.indexOf("gửi tiền mặt hoặc trả lại") >= 0
				|| fb_message1.indexOf(" rơi giấy tờ") >= 0
				|| fb_message1.indexOf(" roi giấy tờ") >= 0
				|| fb_message1.indexOf("bán xu bigcom") >= 0
				|| fb_message1.indexOf("ai nợ em tiền hàng") >= 0
				|| fb_message1.indexOf("tuyển gấp thợ") >= 0
				|| fb_message1.indexOf("tuyển nhân viên kinh doanh") >= 0
				|| fb_message1.indexOf("phòng cho thuê") >= 0
				|| fb_message1.indexOf("phòng trọ") >= 0
				|| fb_message1.indexOf("cho thuê phòng trọ") >= 0
				|| fb_message1.indexOf("sữa rửa mặt trị mụn") >= 0
				|| fb_message1.indexOf("phòng cho nữ thuê") >= 0
				|| fb_message1.indexOf("phòng cho nam thuê") >= 0
				|| fb_message1.indexOf("việc hot đầu năm") >= 0
				|| fb_message1.indexOf("game powerball") >= 0
				|| (fb_message1.indexOf("lucky shoes") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("ai đổi giúp") >= 0 && (fb_message1
						.indexOf("ck lại") >= 0 || fb_message
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("ai đổi giùm") >= 0 && (fb_message1
						.indexOf(" ck ") >= 0 || fb_message1
						.indexOf("chuyển khoản") >= 0))
				|| (fb_message1.indexOf("ai có tiền") >= 0 && (fb_message1
						.indexOf("ck hộ mình") >= 0 || fb_message1
						.indexOf("ck ho minh") >= 0))
				|| (fb_message1.indexOf("thanh lý") >= 0 && fb_message1
						.indexOf("giao dịch qua") >= 0)
				|| (fb_message1.indexOf("đám cưới") >= 0 && fb_message1
						.indexOf("mọi người") >= 0)
				|| (fb_message1.indexOf("bán đất") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf("bán hàng") >= 0)
				|| (fb_message1.indexOf("lucky shoes") >= 0 && fb_message1
						.indexOf("hotline") >= 0)

		) {
			check = 10;
		}
		int count_bank = Check_sentiment.printText(fb_message1.toLowerCase(),
				"ngân hàng")
				+ (Check_sentiment.printText(fb_message1.toLowerCase(),
						"ngan hang"))
				+ (Check_sentiment.printText(fb_message1.toLowerCase(), "bank"));
		System.out.print("count" + count_bank);
		if (fb_message1.indexOf("ngân hàng bảo lãnh") >= 0
				|| fb_message1.indexOf("ngân hàng cho vay") >= 0
				|| fb_message1.indexOf("phát hành thẻ tín dụng") >= 0
				|| fb_message1.indexOf("làm thẻ vay ngân hàng") >= 0
				|| fb_message1.indexOf("chính sách ngân hàng") >= 0
				|| fb_message1.indexOf("hỗ trợ khách hàng vay vốn") >= 0
				|| fb_message1.indexOf("hỗ trợ vay") >= 0
				|| fb_message1.indexOf("vay tín chấp ngân hàng") >= 0
				|| fb_message1.indexOf("vay tín chấp") >= 0
				|| fb_message1.indexOf("vay tiêu dùng") >= 0
				|| fb_message1.indexOf("hỗ trợ lãi suất") >= 0
				|| fb_message1.indexOf("gói cho vay") >= 0
				|| fb_message1.indexOf("bảo lãnh cho vay") >= 0
				|| fb_message1.indexOf("nhu cầu vay") >= 0
				|| fb_message1.indexOf("ví việt") >= 0
				|| fb_message1.indexOf("hỗ trợ bên ngân hàng") >= 0
				|| fb_message1.indexOf("hỗ trợ tài chính") >= 0
				|| fb_message1.indexOf("đại án ngân hàng") >= 0
				|| (fb_message1.indexOf("lãi suất cố định") >= 0 && fb_message1
						.indexOf("ngân hàng") >= 0)
				|| (fb_message1.indexOf("vcb") >= 0 && fb_message1
						.indexOf("bị hack") >= 0)
				|| (fb_message1.indexOf("tài trợ vốn") >= 0 && fb_message1
						.indexOf("ngân hàng") >= 0)
				|| (fb_message1.indexOf("chương trình từ thiện") >= 0 && fb_message1
						.indexOf("định kỳ hàng năm") >= 0)
				|| fb_message1.indexOf("vay mua nhà") >= 0
				|| fb_message1.indexOf("hỗ trợ cho vay") >= 0
				|| fb_message1.indexOf("thép hòa phát") >= 0
				|| count_bank >= 20
				|| fb_message1.indexOf("nhận chạy vay vốn ngân hàng") >= 0
				|| (fb_message1.indexOf("tuyển dụng") >= 0 && fb_message1
						.indexOf("chuyên viên ngân hàng") >= 0)) {
			check = 0;
		}
		return check;
	}

	public static int rule3_spam(String fb_message, String fb_from_name) {
		int check = 0;
		// if (fb_from_name.toLowerCase().indexOf("tiếng anh") >= 0
		// || fb_from_name.toLowerCase().indexOf("shop") >= 0) {
		// check = 1;
		// }
		if (fb_from_name.toLowerCase().indexOf("hãng phim vietcom") >= 0
				|| fb_from_name.toLowerCase().indexOf("vietcomfilm") >= 0) {
			check = 1;
		}
		if (fb_message.toLowerCase().indexOf("hãng phim vietcom") >= 0
				|| fb_message.toLowerCase().indexOf("vietcomfilm") >= 0) {
			check = 1;
		}
		return check;
	}

	public static int spam_stk(String fb_message, int count_object) {
		int check = 0;
		String fb_message1 = Normalizer.normalize(
				(" "
						+ fb_message.replaceAll("\\p{P}", " ")
								.replaceAll("\\s+", " ")
								.toLowerCase(Locale.getDefault()) + " "),
				Normalizer.Form.NFC).toLowerCase();
		if ((fb_message1.indexOf(" sip ") >= 0 && fb_message1
				.indexOf("liên hệ") >= 0)
				|| fb_message1.indexOf("thông tin ck") >= 0
				|| ((fb_message1.indexOf("adidaphat") >= 0 || fb_message1
						.indexOf("a di đà phật") >= 0) && (fb_message1
						.indexOf("tài khoản") >= 0 || fb_message1
						.indexOf(" tk ") >= 0))
				|| (fb_message1.indexOf(" ủng hộ ") >= 0 && (fb_message1
						.indexOf("tài khoản") >= 0
						|| fb_message1.indexOf(" tk ") >= 0 || fb_message1
						.indexOf(" stk ") >= 0))
				|| (fb_message1.indexOf(" sỉ ") >= 0
						&& fb_message1.indexOf(" lẻ ") >= 0 && (fb_message1
						.indexOf("tài khoản") >= 0
						|| fb_message1.indexOf(" tk ") >= 0 || fb_message1
						.indexOf(" stk ") >= 0))
				|| (fb_message1.indexOf("zalo") >= 0 && (fb_message1
						.indexOf("tài khoản") >= 0
						|| fb_message1.indexOf(" tk ") >= 0 || fb_message1
						.indexOf(" stk ") >= 0)) || (count_object >= 2 && (
				// fb_message1.indexOf("tài khoản") >= 0
				// ||
				fb_message1.indexOf(" tk ") >= 0
						// || fb_message1.indexOf(" stk ") >= 0
						|| (fb_message1.indexOf("giao lưu") >= 0 || fb_message1
								.indexOf(" giá ") >= 0)

						|| (fb_message1.indexOf("áo mưa") >= 0 || fb_message1
								.indexOf(" giá ") >= 0)
						|| (fb_message1.indexOf("call") >= 0 || fb_message1
								.indexOf(" giá ") >= 0)
						|| (fb_message1.indexOf("acc") >= 0 || fb_message1
								.indexOf(" giá ") >= 0) || (fb_message1
						.indexOf("cần đổi") >= 0 && fb_message1.length() < 150 && fb_message1
						.indexOf("cần đổi mới") < 0)))

		) {
			check = 1;
		}
		return check;
	}

	public static int rule_monitaz(String fb_message1, String fb_from_name1) {
		int check = 0;
		String fb_message = Normalizer.normalize(fb_message1,
				Normalizer.Form.NFC).toLowerCase();
		String fb_from_name = Normalizer.normalize(fb_from_name1,
				Normalizer.Form.NFC).toLowerCase();
		if (fb_message.indexOf("ngân hàng bảo lãnh") >= 0) {
			check = 1;
		}
		if (fb_message.indexOf("hệ thống các ngân hàng lớn") >= 0) {
			check = 2;
		}
		if (fb_message.indexOf("diện tích mb") >= 0) {
			check = 3;
		}
		if (fb_message.indexOf("bạn nào có thẻ") >= 0) {
			check = 4;
		}
		if (fb_message.indexOf("thẻ tín dụng") >= 0) {
			check = 5;
		}
		if (fb_message.indexOf("internet banking") >= 0) {
			check = 6;
		}
		if (fb_message.indexOf("ví việt") >= 0) {
			check = 7;
		}
		if (fb_message.indexOf("ngân hàng") >= 0
				&& fb_message.indexOf("hỗ trợ vay") >= 0) {
			check = 8;
		}
		if (fb_message.indexOf("hỗ trợ vay vốn ngân hàng") >= 0) {
			check = 9;
		}
		if (fb_message.indexOf("cần tuyển") >= 0
				&& fb_message.indexOf("vị trí") >= 0) {
			check = 10;
		}
		if (fb_message.indexOf("cần tuyển") >= 0
				&& fb_message.indexOf("yêu cầu") >= 0) {
			check = 11;
		}
		if (fb_message.indexOf("vay vốn ngân hàng") >= 0
				&& fb_message.indexOf("thủ tục") >= 0) {
			check = 12;
		}

		return check;
	}

	public static int rule2_spam(String fb_message1, String fb_from_name1) {
		int check = 0;
		String fb_message = Normalizer.normalize(fb_message1,
				Normalizer.Form.NFC).toLowerCase();
		String fb_from_name = Normalizer.normalize(fb_from_name1,
				Normalizer.Form.NFC).toLowerCase();

		if (fb_from_name.indexOf("cho vay") >= 0
				|| fb_from_name.indexOf("tuyển dụng") >= 0
				|| fb_from_name.indexOf("tổng hợp thông tin khuyến mãi") >= 0
				|| fb_from_name.indexOf("yêu bóng đá") >= 0
				|| fb_from_name.indexOf("bóng chuyền việt nam") >= 0
				|| fb_from_name.indexOf("nam mô cầu cứu khổ cứu nạn") >= 0
				|| fb_from_name.indexOf("vay vốn") >= 0
				|| fb_from_name.indexOf("chovay") >= 0
				|| fb_message.indexOf("tuyển dụng") >= 0
				|| fb_message.indexOf("tuyen dung vi tri") >= 0
				|| fb_message.indexOf("tuyển sinh chương trình") >= 0
				|| fb_message.indexOf("hỗ trợ vay vốn") >= 0
				|| fb_message.indexOf("hỗ trợ ls") >= 0
				|| fb_message.indexOf("hỗ trợ lãi suất") >= 0
				|| fb_message.indexOf("không chứng minh thu nhập") >= 0
				|| fb_message.indexOf("không cần chứng minh thu nhập") >= 0
				|| fb_message.indexOf("đăng ký vay vốn") >= 0
				|| fb_message.indexOf("chương trình khuyến mãi") >= 0
				|| fb_message.indexOf("dự định cá nhân") >= 0
				|| fb_message.indexOf("phần quà yêu thương") >= 0
				|| fb_message.indexOf("chung tay giúp đỡ") >= 0
				|| fb_message.indexOf("nếu bạn muốn vay tín chấp") >= 0
				|| fb_message.indexOf("like ủng hộ") >= 0
				|| fb_message.indexOf("ngân hàng bảo lãnh cho vay") >= 0
				|| fb_message.indexOf("ngân hàng đang triển khai ví điện tử") >= 0
				|| fb_message.indexOf("mọi sự giúp đỡ xin gửi") >= 0
				|| fb_message.indexOf("các bạn có nhu cầu vay vốn") >= 0
				|| fb_message.indexOf("dịch vụ giấy tờ bằng cấp") >= 0
				|| fb_message.indexOf("dịch vụ văn bằng") >= 0
				|| fb_message.indexOf("đừng bỏ lỡ cơ hội") >= 0
				|| fb_message.indexOf("trải nghiệm và cảm nhận tiện ích") >= 0
				|| fb_message.indexOf("tham khảo các tiện ích") >= 0
				|| fb_message.indexOf("hướng dẫn cách chuyển tiền") >= 0
				|| fb_message.indexOf("tuyển nhân viên") >= 0
				|| fb_message.indexOf("nhận chạy vay vốn") >= 0
				|| fb_message.indexOf("trả góp qua") >= 0
				|| fb_message.indexOf("khởi nghiệp không đồng") >= 0
				|| fb_message.indexOf("chương trình làm thẻ") >= 0
				|| fb_message.indexOf("bản tin sáng ngày") >= 0
				|| fb_message.indexOf("thị trường bds") >= 0
				|| fb_message.indexOf("thị trường bđs") >= 0
				|| (fb_message.indexOf("khai trương") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| ((fb_message.indexOf("căn hộ") >= 0 || fb_message
						.indexOf("căn nhà") >= 0) && fb_message
						.indexOf("chủ đầu tư") >= 0)
				|| (fb_message.indexOf("căn hộ") >= 0 && (fb_message
						.indexOf("tài trợ") >= 0 || fb_message
						.indexOf("hỗ trợ") >= 0))
				|| (fb_message.indexOf("ủng hộ") >= 0 && fb_message
						.indexOf("tấm lòng") >= 0)
				|| (fb_message.indexOf("hướng dẫn kiếm") >= 0 && fb_message
						.indexOf("free") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("qua thẻ") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("vay ưu đãi") >= 0)
				|| (fb_message.indexOf("thủ tục làm hồ sơ") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("chủ thẻ") >= 0)
				|| (fb_message.indexOf("đáp ứng nhu cầu") >= 0 && fb_message
						.indexOf("quý khách") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("holine") >= 0)
				|| (fb_message.indexOf("liên hệ") >= 0 && fb_message
						.indexOf("để được tư vấn") >= 0)
				|| (fb_message.indexOf("liên hệ") >= 0 && fb_message
						.indexOf("lương liền qua ck") >= 0)
				|| (fb_message.indexOf("hồ sơ yêu cầu") >= 0 && fb_message
						.indexOf("holine") >= 0)
				|| (fb_message.indexOf("vay mua nhà") >= 0 && fb_message
						.indexOf("lãi suất") >= 0)

				|| (fb_message.indexOf("gọi tới") >= 0 && fb_message
						.indexOf("để được hướng dẫn") >= 0)
				|| (fb_message.indexOf("thiện nguyện") >= 0 && fb_message
						.indexOf("ban tổ chức") >= 0)
				|| (fb_message.indexOf("hotline") >= 0 && fb_message
						.indexOf("chuyên viên") >= 0)
				|| (fb_message.indexOf("the bank") >= 0 && fb_message
						.indexOf("chuyên gia tài chính") >= 0)
				|| (fb_message.indexOf("dịch vụ chuyển tiền") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("dịch vụ chuyển tiền") >= 0 && fb_message
						.indexOf("lien he") >= 0)
				|| (fb_message.indexOf("vay tiêu dùng") >= 0 && fb_message
						.indexOf("mọi chi tiết") >= 0)
				|| (fb_message.indexOf("hỗ trợ ưu đãi") >= 0 && fb_message
						.indexOf("hotline") >= 0)
				|| (fb_message.indexOf("gọi ngay") >= 0 && fb_message
						.indexOf("chi tiết") >= 0)
				|| (fb_message.indexOf("bác nào chuyển tiền được") >= 0 && fb_message
						.indexOf("nhờ tý") >= 0)
				|| (fb_message.indexOf("vay ưu đãi") >= 0 && fb_message
						.indexOf("bạn có nhu cầu") >= 0)
				|| (fb_message.indexOf("hướng dẫn") >= 0
						&& fb_message.indexOf("điều kiện") >= 0 && fb_message
						.indexOf("internet banking") >= 0)
				|| fb_message.indexOf("vietinbank aviva") >= 0
				|| (fb_message.indexOf("vietinbank aviva") >= 0 && fb_message
						.indexOf("an toàn tài chính") >= 0)
				|| (fb_message.indexOf("vietinbank aviva") >= 0 && fb_message
						.indexOf("tư vấn") >= 0)
				|| (fb_message.indexOf("cam kết") >= 0 && fb_message
						.indexOf("hỗ trợ") >= 0)
				|| fb_message.indexOf("ai có nhu cầu") >= 0
				|| fb_message.indexOf("chỉ cần có internet banking") >= 0
				|| fb_message.indexOf("vui lòng inbox") >= 0
				|| fb_message.indexOf("chúng tôi thấu hiểu nhu cầu") >= 0
				|| fb_message.indexOf("hướng dẫn thanh toán") >= 0
				|| fb_message.indexOf("nhận tiền nhanh") >= 0
				|| fb_message.indexOf("ví momo") >= 0
				|| fb_message.indexOf("momo") >= 0
				|| fb_message.indexOf("không cần chứng minh thu nhập") >= 0
				|| fb_message.indexOf("tư vấn nhiệt tình") >= 0
				|| fb_message.indexOf("thủ tục vay đơn giản") >= 0
				|| fb_message.indexOf("trả góp linh hoạt") >= 0
				|| fb_message.indexOf("cho vay tín chấp lãi suất cực thấp") >= 0
				|| fb_message.indexOf("hỗ trợ vay ngân hàng") >= 0
				|| fb_message.indexOf("đổi trả hàng miễn phí") >= 0
				|| fb_message.indexOf("chương trình mở thẻ tín dụng") >= 0
				|| fb_message.indexOf("hỗ trợ vay không cần thế chấp") >= 0
				|| (fb_message.indexOf("hỗ trợ khách hàng") >= 0 && fb_message
						.indexOf("vui lòng liên hệ") >= 0)
				|| (fb_message.indexOf("thủ tục nhanh gọn") >= 0 && fb_message
						.indexOf("không cần thế chấp") >= 0)
				|| (fb_message.indexOf("tuyển") >= 0 && fb_message
						.indexOf("ưu tiên") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("quý khách hàng") >= 0)
				|| (fb_message.indexOf("cho vay") >= 0 && fb_message
						.indexOf("thủ tục đơn giản") >= 0)
				|| (fb_message.indexOf("cho vay") >= 0 && fb_message
						.indexOf("lãi xuất") >= 0)
				|| (fb_message.indexOf("vay tín chấp") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("trúng ngay") >= 0)
				|| fb_message.indexOf("nếu bạn muốn vay tín chấp") >= 0
				|| fb_message.indexOf("buôn bán uy tín") >= 0
				|| fb_message.indexOf("thu hộ tiền trả góp") >= 0
				|| fb_message.indexOf("bạn có nhu cầu") >= 0
				|| (fb_message.indexOf("ưu đãi") >= 0
						&& fb_message.indexOf("khuyến mại") >= 0
						&& fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("tài khoản") >= 0)
				|| (fb_message.indexOf("hỗ trợ cho vay") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("chủ thẻ") >= 0)
				|| (fb_message.indexOf("xin hỏi") >= 0 && fb_message
						.indexOf("xin cám ơn") >= 0)
				|| (fb_message.indexOf("xin hoi") >= 0 && fb_message
						.indexOf("xin cam on") >= 0)
				|| (fb_message.indexOf("chi tiết khuyến mại") >= 0 && fb_message
						.indexOf("nội dung khuyến mại") >= 0)

				|| (fb_message.indexOf("khuyến mại") >= 0 && fb_message
						.indexOf("thông tin chi tiết") >= 0)
				|| (fb_message.indexOf("sổ tiết kiệm") >= 0 && fb_message
						.indexOf("chi tiết liên hệ") >= 0)

				|| fb_message.indexOf("điều kiện ưu đãi") >= 0
				|| fb_message.indexOf("sản phẩm tài trợ") >= 0
				|| fb_message.indexOf("buôn án uy tín") >= 0
				|| (fb_message.indexOf("cơn sốt") >= 0 && fb_message
						.indexOf("đừng bỏ lỡ") >= 0)
				|| (fb_message.indexOf("thẻ tín dụng") >= 0 && fb_message
						.indexOf("hoàn tiền lên đến") >= 0)
				|| (fb_message.indexOf("vốn ưu đãi") >= 0 && fb_message
						.indexOf("lãi suất thấp") >= 0)
				|| (fb_message.indexOf("inbox") >= 0 && fb_message
						.indexOf("em sẵn sàng chia sẻ") >= 0)
				|| fb_message.indexOf("dịch vụ bảo vệ chuyên nghiệp") >= 0
				|| fb_message.indexOf("với lãi suất ưu đãi") >= 0
				|| fb_message.indexOf("kính chúc quý khách") >= 0
				|| fb_message.indexOf("kinh chuc quy khach") >= 0
				|| fb_message.indexOf("daily news") > 0
				|| fb_message.indexOf("ưu đãi trả góp") > 0
				|| fb_message.indexOf("được trả góp lãi suất") > 0
				|| fb_message.indexOf("bạn muốn mở thẻ") > 0
				|| fb_message.indexOf("chấp nhận thanh toán thẻ qua") > 0
				|| fb_message.indexOf("hỗ trợ vay lên đến") >= 0
				|| fb_message.indexOf("số lượng tuyển dụng") >= 0
				|| fb_message.indexOf("tuyển cộng tác viên") >= 0
				|| fb_message.indexOf("tư vấn mua căn hộ vay vốn") >= 0
				|| ((fb_message.indexOf("vay tiêu dùng") >= 0 || fb_message
						.indexOf("vay tín chấp") >= 0) && fb_message
						.indexOf("tư vấn") >= 0)
				|| fb_message.indexOf("các bạn có nhu cầu vay vốn") >= 0
				|| fb_message.indexOf("bạn gặp khó khăn khi vay tiền") >= 0
				|| fb_message.indexOf("vay tiền không cần thế chấp") >= 0
				|| fb_message.indexOf("giao lưu bóng đá") >= 0
				|| fb_message.indexOf("lazada mang đến ưu đãi") >= 0
				|| fb_message.indexOf("chương trình giảm giá ưu đãi") >= 0
				|| fb_message.indexOf("thể thao & văn hóa cuối tuần") >= 0
				|| fb_message.indexOf("chính sách có hiệu lực") >= 0
				|| (fb_message.indexOf("ủng hộ chương trình") >= 0 && fb_message
						.indexOf("phóng sự") >= 0)
				|| (fb_message.indexOf("thông báo") >= 0 && fb_message
						.indexOf("giới thiệu công ty") >= 0)
				|| (fb_message.indexOf("luận văn") >= 0 && fb_message
						.indexOf("nghiên cứu") >= 0)
				|| (fb_message.indexOf("giao hàng") >= 0 && fb_message
						.indexOf("ship") >= 0)
				|| (fb_message.indexOf("cần tuyển") >= 0 && fb_message
						.indexOf("ứng viên") >= 0)
				|| (fb_message.indexOf("hấp dẫn") >= 0 && fb_message
						.indexOf("thông tin chi tiết") >= 0)
				|| (fb_message.indexOf("hỗ trợ cho vay") >= 0 && fb_message
						.indexOf("thủ tục đơn giản") >= 0)
				|| (fb_message.indexOf("sưu tầm") >= 0 && fb_message
						.indexOf("giới thiệu") >= 0)
				|| (fb_message.indexOf("hỗ trợ vốn ưu đãi") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("guongmathdsaison") >= 0 && fb_message
						.indexOf("bình chọn") >= 0)

				|| (fb_message.indexOf("ủng hộ chương trình") >= 0 && fb_message
						.indexOf("phóng sự") >= 0)
				|| (fb_message.indexOf("thủ tục cho vay đơn giản") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("triển khai chương trình") >= 0 && fb_message
						.indexOf("hỗ trợ") >= 0)
				|| (fb_message.indexOf("sản phẩm") >= 0 && fb_message
						.indexOf("giá thành") >= 0)
				|| (fb_message.indexOf("shop") >= 0
						&& fb_message.indexOf("quà tặng") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("chiến lược") >= 0
						&& fb_message.indexOf("dịch vụ") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| (fb_message.indexOf("hướng dẫn") >= 0
						&& fb_message.indexOf("thủ tục") >= 0 && fb_message
						.indexOf("đăng ký") >= 0)
				|| (fb_message.indexOf("còn tiền ở") >= 0
						&& fb_message.indexOf("nhờ chút") >= 0 && fb_message
						.indexOf("gửi tiền mặt") >= 0)
				|| (fb_message.indexOf("còn tiền ") >= 0
						&& fb_message.indexOf("đổi giúp") >= 0 && fb_message
						.indexOf("mình gửi") >= 0)

				|| (fb_message.indexOf("tư vấn") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| (fb_message.indexOf("shop") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| (fb_message.indexOf("tuyển chọn") >= 0 && fb_message
						.indexOf("đào tạo") >= 0)
				|| (fb_message.indexOf("chuyến đi") >= 0 && fb_message
						.indexOf("ủng hộ") >= 0)
				|| (fb_message.indexOf("dự án") >= 0 && fb_message
						.indexOf("buôn bán") >= 0)
				|| (fb_message.indexOf("tài khoản") >= 0 && fb_message
						.indexOf("phương thức thanh toán") >= 0)
				|| (fb_message.indexOf("hấp dẫn") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("cho vay tiền") >= 0 && fb_message
						.indexOf("hình thức đơn giản") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0
						&& fb_message.indexOf("hỗ trợ") >= 0 && fb_message
						.indexOf("giá bán") >= 0)
				|| (fb_message.indexOf("đăng ký làm thẻ") >= 0
						&& fb_message.indexOf("nhanh chóng") >= 0 && fb_message
						.indexOf("an toàn") >= 0)
				|| fb_message.indexOf("gói vay ngân hàng lãi suất thấp") >= 0
				|| fb_message.indexOf("vui lòng liên hệ trực tiếp") >= 0
				|| fb_message.indexOf("tuyển thực tập sinh") >= 0
				|| fb_message.indexOf("tuyển gấp thực tập sinh") >= 0
				|| fb_message.indexOf("tư vấn mở thẻ liên hệ") >= 0
				|| fb_message.indexOf("tuyển sinh du học") >= 0
				|| fb_message.indexOf("hỗ trợ cho vay lên đến") >= 0
				|| fb_message.indexOf("bộ tài liệu luyện thi") >= 0
				|| fb_message.indexOf("thông tin nhà đất") >= 0
				|| fb_message.indexOf("mong muốn đem đến khách hàng") >= 0
				|| fb_message.indexOf("lợi nhuận cam kết") >= 0
				|| fb_message.indexOf("đền ơn đáp nghĩa") >= 0
				|| fb_message.indexOf("nhu cầu mua hàng") >= 0
				|| fb_message.indexOf("hấp dẫn dành riêng cho chủ thẻ") >= 0
				|| fb_message.indexOf("hấp dẫn dành cho chủ thẻ") >= 0
				|| fb_message.indexOf("chương trình trả góp") >= 0
				|| fb_message.indexOf("vay tín chấp dễ dàng") >= 0
				|| fb_message.indexOf("chương trình ưu đãi") >= 0
				|| fb_message.indexOf("chương trình quà tặng hấp dẫn") >= 0
				|| (fb_message.indexOf("hỗ trợ vay") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("hoạt động") >= 0)
				|| fb_message.indexOf("tinnhanhchungkhoan") >= 0
				|| fb_message.indexOf("chi tiết về quyền lợi") >= 0
				|| fb_message.indexOf("thị trường chứng khoán") >= 0
				|| fb_message.indexOf("sản phẩm vay tín chấp") >= 0
				|| fb_message.indexOf("tham gia chương trình") >= 0

				|| fb_message.indexOf("chương trình cho vay") >= 0
				|| fb_message.indexOf("thông tin liên hệ") >= 0
				|| (fb_message.indexOf("dự án") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("ủn hộ") >= 0 && fb_message
						.indexOf("gửi về tài khoản") >= 0)
				|| fb_message.indexOf("thông tin chi tiết") >= 0
				|| fb_message.indexOf("chương trình khuyến mãi") >= 0
				|| fb_message.indexOf("chương trình khuyến mại") >= 0
				|| fb_message.indexOf("nhu cầu inbox hoặc liên hệ") >= 0
				|| fb_message.indexOf("trả góp lãi suất") >= 0
				|| fb_message.indexOf("hot deal") >= 0
				|| fb_message.indexOf("danh sách các ngân hàng làm việc") >= 0
				|| (fb_message.indexOf("muốn hợp tác") >= 0 && fb_message
						.indexOf("giới thiệu") >= 0)
				|| (fb_message.indexOf("sở hữu căn hộ") >= 0 && fb_message
						.indexOf("lãi suất ưu đãi") >= 0)
				|| (fb_message.indexOf("vay tín chấp") >= 0 && fb_message
						.indexOf("hồ sơ đơn giản") >= 0)
				|| (fb_message.indexOf("cần tuyển") >= 0 && fb_message
						.indexOf("vị trí") >= 0)
				|| (fb_message.indexOf("chương trình ưu đãi") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| (fb_message.indexOf("vay vốn ngân hàng") >= 0 && fb_message
						.indexOf("thủ tục") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0 && fb_message
						.indexOf("hỗ trợ") >= 0)
				|| (fb_message.indexOf("vay tín chấp") >= 0 && fb_message
						.indexOf("không thủ tục rườm rà") >= 0)
				|| (fb_message.indexOf("vay tin chap") >= 0 && fb_message
						.indexOf("khong thu tuc ruom ra") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("ưu đãi đặc biệt") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("hướng dẫn") >= 0)
				|| (fb_message.indexOf("thực tập") >= 0 && fb_message
						.indexOf("ứng viên") >= 0)
				|| (fb_message.indexOf("hết hàng") >= 0 && fb_message
						.indexOf(" tk ") >= 0)
				|| (fb_message.indexOf("cách kiếm") >= 0 && fb_message
						.indexOf("hướng dẫn") >= 0)
				|| (fb_message.indexOf("để được hỗ trợ") >= 0 && fb_message
						.indexOf("đăng kí") >= 0)
				|| (fb_message.indexOf("mùa đồ diện") >= 0 && fb_message
						.indexOf("khách") >= 0)
				|| fb_message.indexOf("đem lại cho quý khách hàng") >= 0
				|| fb_message.indexOf("chỉ cần đăng ký dịch vụ") >= 0
				|| fb_message.indexOf("làm thẻ tín dụng miễn phí") >= 0
				|| fb_message.indexOf("thực tập viên tiềm năng") >= 0
				|| fb_message.indexOf("ai cần liên hệ") >= 0
				|| fb_message.indexOf("hứng thú cứ ib mình") >= 0
				|| fb_message.indexOf("hứng thú cứ inbox mình") >= 0
				|| fb_message.indexOf("bạn có cơ hội trúng") >= 0
				|| fb_message.indexOf("nhận chuyển qua thẻ") >= 0
				|| (fb_message.indexOf("chào đón") >= 0
						&& fb_message.indexOf("hỗ trợ") >= 0 && fb_message
						.indexOf("khách hàng") >= 0)
				|| (fb_message.indexOf("tuyển") >= 0
						&& fb_message.indexOf("nhân viên") >= 0 && fb_message
						.indexOf("yêu cầu") >= 0)
				|| (fb_message.indexOf("trả góp") >= 0
						&& fb_message.indexOf("thủ tục") >= 0 && fb_message
						.indexOf("tư vấn") >= 0)
				|| (fb_message.indexOf("vay tín chấp") >= 0
						&& fb_message.indexOf("hồ sơ") >= 0 && fb_message
						.indexOf("lãi suất") >= 0)
				|| (fb_message.indexOf("cần tuyển") >= 0
						&& fb_message.indexOf("phỏng vấn") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| fb_message.indexOf("thí sinh dự thi") >= 0
				|| fb_message.indexOf("cung cấp các gói vay tiêu dùng") >= 0
				|| fb_message.indexOf("tuyển gấp nhân viên") >= 0
				|| fb_message.indexOf("tải về ứng dựng") >= 0
				|| fb_message.indexOf("tuyển chuyên viên") >= 0
				|| fb_message.indexOf("hỗ trợ vay vốn ngân hàng") >= 0
				|| fb_message.indexOf("bán trả góp") >= 0
				|| fb_message.indexOf("quý khách vui lòng liên hệ") >= 0
				|| fb_message.indexOf("hãy liên lạc với chúng tôi") >= 0
				|| (fb_message.indexOf("ủng hộ chương trình") >= 0 && fb_message
						.indexOf("chi tiết") >= 0)
				|| (fb_message.indexOf("nhu cầu mở thẻ") >= 0 && fb_message
						.indexOf("inbox") >= 0)
				|| (fb_message.indexOf("vui lòng gọi đến") >= 0 && fb_message
						.indexOf("tư vấn") >= 0)
				|| (fb_message.indexOf("khuyến mãi") >= 0 && fb_message
						.indexOf("quý khách") >= 0)
				|| (fb_message.indexOf("khuyến mại") >= 0 && fb_message
						.indexOf("quý khách") >= 0)
				|| (fb_message.indexOf("bạn sẽ tận hưởng") >= 0 && fb_message
						.indexOf("ưu đãi") >= 0)
				|| (fb_message.indexOf("cơ hội làm việc tại ngân hàng") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("chương trình") >= 0 && fb_message
						.indexOf("chi tiết") >= 0)
				|| (fb_message.indexOf("hỗ trợ vay") >= 0 && fb_message
						.indexOf(" lh ") >= 0)
				| (fb_message.indexOf("ai cần") >= 0 && fb_message
						.indexOf("liên hệ") >= 0)
				|| (fb_message.indexOf("hỗ trợ") >= 0 && fb_message
						.indexOf("liên hệ qua") >= 0)

		) {

			check = 1;
		}
		return check;
	}

	public static int check_number(String s) {
		int check = 0;
		if (s != null) {
			double m = s.length();
			double n = Check_sentiment.printText(s, "0")
					+ Check_sentiment.printText(s, "1")
					+ Check_sentiment.printText(s, "2")
					+ Check_sentiment.printText(s, "3")
					+ Check_sentiment.printText(s, "4")
					+ Check_sentiment.printText(s, "5")
					+ Check_sentiment.printText(s, "6")
					+ Check_sentiment.printText(s, "7")
					+ Check_sentiment.printText(s, "8")
					+ Check_sentiment.printText(s, "9")
					// + (Check_sentiment.printText(s, "chi nhánh")*10)
					+ (Check_sentiment.printText(s, "stk") * 3)
					+ (Check_sentiment.printText(s, " tk ") * 2)
					+ (Check_sentiment.printText(s, "ctk") * 3);
			// System.out.println(m);
			System.out.println(n);
			double ch = n / m;
			System.out.println(ch);
			if (ch >= 0.3 || n >= 50 || (ch > 0.12 && n > 30)) {
				check = 1;
			}
		}
		if (s != null) {
			int stk = +(Check_sentiment.printText(s.toLowerCase(), "stk"))
					+ (Check_sentiment.printText(s.toLowerCase(), " tk "))
					+ (Check_sentiment.printText(s.toLowerCase(), "ctk"));
			System.out.println(s);
			System.out.println(stk);
			if (stk >= 3) {
				check = 1;
			}

		}
		return check;
		// System.out.println(check);
	}

	public static int spam_number(String s) {
		int check = 0;
		double n = 0;
		String fb_message = Normalizer.normalize(
				(" "
						+ s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ")
								.toLowerCase(Locale.getDefault()) + " "),
				Normalizer.Form.NFC).toLowerCase();
		/*
		 * if (s != null) { n = Check_sentiment.printText(s, "0") +
		 * Check_sentiment.printText(s, "1") + Check_sentiment.printText(s, "2")
		 * + Check_sentiment.printText(s, "3") + Check_sentiment.printText(s,
		 * "4") + Check_sentiment.printText(s, "5") +
		 * Check_sentiment.printText(s, "6") + Check_sentiment.printText(s, "7")
		 * + Check_sentiment.printText(s, "8") + Check_sentiment.printText(s,
		 * "9") // + (Check_sentiment.printText(s, "chi nhánh")*10) +
		 * (Check_sentiment.printText(s, "stk") * 3) +
		 * (Check_sentiment.printText(s, " tk ") * 2) +
		 * (Check_sentiment.printText(s, "ctk") * 3); // System.out.println(m);
		 * System.out.println(n);
		 * 
		 * }
		 */
		System.out.println(fb_message);
		int regex_number = regex_number(s);
		System.out.println(regex_number);
		if (regex_number >= 1) {
			check = 1;
			if (fb_message.toLowerCase().indexOf("stk") >= 0
					|| fb_message.toLowerCase().indexOf("số tk") >= 0
					|| fb_message.toLowerCase().indexOf(" tk ") >= 0
					|| fb_message.toLowerCase().indexOf("chuyển khoản") >= 0
					|| fb_message.toLowerCase().indexOf("shop") >= 0
					|| fb_message.toLowerCase().indexOf(" ck ") >= 0
					|| fb_message.toLowerCase().indexOf("sale") >= 0
					// || fb_message.toLowerCase().indexOf("ngân hàng")>=0
					|| fb_message.toLowerCase().indexOf("zalo") >= 0
					// || fb_message.toLowerCase().indexOf("chi nhánh")>=0
					|| fb_message.toLowerCase().indexOf("tài khoản") >= 0
					|| fb_message.toLowerCase().indexOf("chủ tk") >= 0
					|| fb_message.toLowerCase().indexOf("order") >= 0
					|| fb_message.toLowerCase().indexOf("thông tin") >= 0
					|| fb_message.toLowerCase().indexOf("oder") >= 0
					|| fb_message.toLowerCase().indexOf("bán hàng") >= 0
					|| fb_message.toLowerCase().indexOf("bán nhanh") >= 0
					|| fb_message.toLowerCase().indexOf("ship") >= 0
					|| fb_message.toLowerCase().indexOf(" sỉ ") >= 0
					|| (fb_message.toLowerCase().indexOf(" lẻ ") >= 0 && fb_message
							.toLowerCase().indexOf(" khách ") >= 0)
					|| fb_message.toLowerCase().indexOf("học phí") >= 0
					|| fb_message.toLowerCase().indexOf("ckhoan") >= 0
					|| fb_message.toLowerCase().indexOf("chuyen khoan") >= 0
					|| fb_message.toLowerCase().indexOf("tai khoan") >= 0
					|| regex_number >= 2 || s.length() < 60) {
				check = 1;
			}
		}
		if (s.toLowerCase().indexOf("cần gấp") >= 0
				&& s.toLowerCase().indexOf("bắn trả") >= 0) {
			check = 1;
		}
		if (fb_message.toLowerCase().indexOf("vay thế chấp") >= 0
				|| fb_message.toLowerCase().indexOf("vay mua oto") >= 0
				|| fb_message.toLowerCase().indexOf("vay lãi suất") >= 0
				|| fb_message.toLowerCase().indexOf("hỗ trợ vay vốn") >= 0
				|| fb_message.toLowerCase().indexOf("trả góp") >= 0
				|| fb_message.toLowerCase().indexOf("vay mua nhà đất") >= 0
				|| fb_message.toLowerCase().indexOf("vay bảng lương") >= 0
				|| fb_message.indexOf("ngân hàng bảo lãnh") >= 0
				|| fb_message.indexOf("ngân hàng cho vay") >= 0
				|| fb_message.indexOf("vay tín chấp") >= 0
				|| fb_message.indexOf("vay tiêu dùng") >= 0
				|| fb_message.indexOf("vay mua nhà") >= 0
				|| fb_message.indexOf("thép hòa phát") >= 0
				|| fb_message.indexOf("phát hành thẻ tín dụng") >= 0
				|| fb_message.indexOf("làm thẻ vay ngân hàng") >= 0
				|| fb_message.indexOf("hỗ trợ vay") >= 0
				|| fb_message.indexOf("vay tín chấp ngân hàng") >= 0
				|| fb_message.indexOf("hỗ trợ lãi suất") >= 0
				|| fb_message.indexOf("gói cho vay") >= 0
				|| fb_message.indexOf("ví việt") >= 0
				|| (fb_message.indexOf("lãi suất cố định") >= 0 && fb_message
						.indexOf("ngân hàng") >= 0)
				|| fb_message.indexOf("nhu cầu vay") >= 0
				|| fb_message.indexOf("đại án ngân hàng") >= 0
				|| fb_message.toLowerCase().indexOf("lãi suất") >= 0
				|| fb_message.indexOf("vay mua nhà") >= 0
				|| fb_message.indexOf("hỗ trợ tài chính") >= 0
				|| fb_message.indexOf("hỗ trợ cho vay") >= 0
				|| fb_message.indexOf("nhận chạy vay vốn ngân hàng") >= 0
				|| (fb_message.indexOf("tuyển dụng") >= 0 && fb_message
						.indexOf("chuyên viên ngân hàng") >= 0)

		) {
			check = 0;
		}

		return check;
		// System.out.println(check);
	}

	public static int regex_number(String str) {
		int check = 0;
		// str = str.replaceAll(".htm", "1111111111111111111111");
		// str = str.replaceAll(" htm", "1111111111111111111111");
		str = str.replaceAll("/.", " ");
		str = str.replaceAll("/-", " ");
		System.out.println(str);
		// str = str.replaceAll("[^0-9,-\\.]", ",");
		System.out.println("str" + str);
		str = str.replaceAll("[^0-9,]", ",");
		System.out.println("str" + str);
		/** cat thanh cac phan tu thong qua dau phay */
		String[] item = str.split(",");
		// duyet cac phan tu, neu la so thi in ra
		for (int i = 0; i < item.length; i++) {
			try {
				if ((item[i].length() >= 12 && item[i].indexOf("016") != 0
						&& item[i].indexOf("09") != 0
						&& item[i].indexOf("0123") != 0 && item[i].length() <= 20)
						|| (item[i].length() >= 13 && item[i].length() <= 16)) {
					check = check + 1;
				}

				// System.out.println(item[i].length());

				// Double.parseDouble(item[i]);
				// System.out.println(item[i]);
			} catch (NumberFormatException e) {
			}
		}
		System.out.println(check);
		return check;

	}

	public static int check_sdt(String str) {
		int check = 0;
		Pattern pattern = Pattern.compile("\\d[\\s\\d-.]{1,}\\d");
		Matcher matcher = pattern.matcher(str);
		double leng_message = str.length();
		double leng_phone = 0;
		if (matcher.find()) {
			do {
				String candidate = matcher.group();
				candidate = candidate.replace(".", "");
				candidate = candidate.replace("-", "");
				candidate = candidate.replace(" ", "");
				leng_phone = leng_phone + candidate.length();
				System.out.println(candidate.length());
			} while (matcher.find());
		}
		double check_count = leng_phone / leng_message;
		System.out.println(check_count);
		System.out.println(check_count);
		System.out.println("phone number: " + leng_phone);
		System.out.println("message: " + leng_message);
		if (str.toLowerCase().indexOf("vcb") >= 0
				|| str.toLowerCase().indexOf("vietcom") >= 0
				|| str.toLowerCase().indexOf("vp") >= 0
				) {
			if (leng_message > 100 && check_count > 0.17) {
				check = 1;
			}
			if (leng_message < 100 && check_count > 0.18) {
				check = 1;
			}
		}
		return check;

	}

	public static int get_stk(String input) {
		int check = 0;
		Pattern pattern = Pattern.compile("e");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			do {
				String candidate = matcher.group();
				candidate = candidate.replace(".", "");
				candidate = candidate.replace("-", "");
				candidate = candidate.replace(" ", "");
				if ((candidate.length() > 11 && candidate.length() < 17)
						|| (candidate.length() == 10 && candidate
								.indexOf("010") == 0)
						|| (candidate.length() == 10 && candidate
								.indexOf("011") == 0)) {
					check = 1;
					break;
				}
			} while (matcher.find());
		}
		return check;
	}

	public static int test(String fb_message1) {
		int check = 0;
		if ((fb_message1.indexOf("shop") >= 0 && fb_message1.indexOf(" stk ") >= 0)
				|| (fb_message1.indexOf("shop") >= 0 && fb_message1
						.indexOf(" tk ") >= 0)
				|| (fb_message1.indexOf("zalo") >= 0 && fb_message1
						.indexOf("shop") >= 0)
				|| (fb_message1.indexOf("số tk công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("stk công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("số tài khoản công ty") >= 0 && fb_message1
						.indexOf("tại ngân hàng") >= 0)
				|| (fb_message1.indexOf("gửi hàng") >= 0 && fb_message1
						.indexOf("chuyển khoản") >= 0)
				|| (fb_message1.indexOf("hàng có sẵn") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf(" acc ") >= 0 && fb_message1
						.indexOf(" giá ") >= 0)
				|| (fb_message1.indexOf("cần tuyển") >= 0 && fb_message1
						.indexOf("nhân viên phục vụ") >= 0)
				|| (fb_message1.indexOf("thẩm mỹ viện") >= 0 && fb_message1
						.indexOf("liên hệ") >= 0)
				|| (fb_message1.indexOf("mien trung") >= 0 && fb_message1
						.indexOf("ung ho") >= 0)
				|| (fb_message1.indexOf(" thầy ") >= 0 && fb_message1
						.indexOf(" công đức ") >= 0)
				|| (fb_message1.indexOf("store") >= 0 && fb_message1
						.indexOf("hotline") >= 0)
				|| (fb_message1.indexOf("đại lý") >= 0 && fb_message1
						.indexOf("ruby") >= 0)
				|| fb_message1.indexOf("nhận order") >= 0
				|| fb_message1.indexOf("chuyên hàng xách tay") >= 0
				|| fb_message1.indexOf("rơi ví") >= 0
				|| fb_message1.indexOf("lô đề online") >= 0
				|| fb_message1.indexOf("luckyshoes") >= 0
				|| fb_message1.indexOf("nhặt được thẻ") >= 0
				|| fb_message1.indexOf("mất cái ví") >= 0) {
			check = 8;
		}
		return check;
	}

	public static void main(String[] args) {

		String s = "VPBank vip cho 1982 8299999999 Call 0979977833";
		String fb_message1 = Normalizer
				.normalize(
						(" "
								+ s.replaceAll("\\p{P}", " ")
										.replaceAll("\\s+", " ")
										.toLowerCase(Locale.getDefault()) + " "),
						Normalizer.Form.NFC).toLowerCase();
	//			.replaceAll("\\d", "").trim().replaceAll(" +", " ");
		System.out.println(fb_message1);
		System.out.println(check_sdt(s));

	}

}
