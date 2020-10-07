package dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Utils.sentiment;
public class Getlib_sentiment {
	public static ArrayList<sentiment> lib_sentiment(ResultSet rs)
			throws SQLException {
		ArrayList<sentiment> sentiment1 = new ArrayList<sentiment>();
		while (rs.next()) {
			sentiment a = new sentiment();
			a.id = rs.getInt(1);
			a.word = rs.getString(2);
			a.point = rs.getInt(3);
			a.status = rs.getInt(4);
			a.check = rs.getInt(5);
			a.pid = rs.getInt(6);
			sentiment1.add(a);

		}
		return sentiment1;
	}

	public static ArrayList<sentiment> lib(ArrayList<sentiment> a)
			throws SQLException {
		ArrayList<sentiment> sentiment = new ArrayList<sentiment>();
		for (int j = 0; j < a.size(); j++) {
			sentiment c = new sentiment();
			c.point = a.get(j).point;
			c.word = a.get(j).word;
			c.status = a.get(j).status;
			c.check = a.get(j).check;
			c.id = a.get(j).id;
			c.pid = a.get(j).pid;
			sentiment.add(c);
			String s;
			s = a.get(j).word;
			sentiment b = new sentiment();
			sentiment b1 = new sentiment();
			sentiment b2 = new sentiment();
			sentiment b3 = new sentiment();
			sentiment b4 = new sentiment();
			sentiment b5 = new sentiment();
			sentiment b6 = new sentiment();
			sentiment b7 = new sentiment();
			sentiment b8 = new sentiment();
			sentiment b9 = new sentiment();
			sentiment b10 = new sentiment();

			b.word = "không " + s;
			b1.word = "ko " + s;
			b2.word = "hok " + s;
			b3.word = "bất " + s;
			b4.word = "mất " + s;
			b5.word = "chẳng " + s;
			b6.word = "chẳng đáng " + s;
			b7.word = "đếch " + s;
			b8.word = "đéo " + s;
			b9.word = "kg " + s;
			b10.word = "k " + s;

			b.pid = a.get(j).id;
			b1.pid = a.get(j).id;
			b2.pid = a.get(j).id;
			b3.pid = a.get(j).id;
			b4.pid = a.get(j).id;
			b5.pid = a.get(j).id;
			b6.pid = a.get(j).id;
			b7.pid = a.get(j).id;
			b8.pid = a.get(j).id;
			b9.pid = a.get(j).id;
			b10.pid = a.get(j).id;
			if (a.get(j).check != 2) {

				if (a.get(j).check == 0) {
					if (a.get(j).point * 2 > 5) {
						b.point = a.get(j).point * 1 / 2;
						b1.point = a.get(j).point * 1 / 2;
						b2.point = a.get(j).point * 1 / 2;
						b3.point = a.get(j).point * 1 / 2;
						b4.point = a.get(j).point * 1 / 2;
						b5.point = a.get(j).point * 1 / 2;
						b6.point = a.get(j).point * 1 / 2;
						b7.point = a.get(j).point * 1 / 2;
						b8.point = a.get(j).point * 1 / 2;
						b9.point = a.get(j).point * 1 / 2;
						b10.point = a.get(j).point * 1 / 2;

					} else {
						b.point = 1;
						b1.point = 1;
						b2.point = 1;
						b3.point = 1;
						b4.point = 1;
						b5.point = 1;
						b6.point = 1;
						b7.point = 1;
						b8.point = 1;
						b9.point = 1;
						b10.point = 1;
					}
					// b.status = a.get(j).status;
					b.check = a.get(j).check;
					// b1.status = a.get(j).status;
					b1.check = a.get(j).check;
					// b2.status = a.get(j).status;
					b2.check = a.get(j).check;
					// b3.status = a.get(j).status;
					b3.check = a.get(j).check;
					// b4.status = a.get(j).status;
					b4.check = a.get(j).check;
					// b5.status = a.get(j).status;
					b5.check = a.get(j).check;
					// b6.status = a.get(j).status;
					b6.check = a.get(j).check;
					// b7.status = a.get(j).status;
					b7.check = a.get(j).check;
					// b8.status = a.get(j).status;
					b8.check = a.get(j).check;
					// b9.status = a.get(j).status;
					b9.check = a.get(j).check;
					b10.check = a.get(j).check;

					if (a.get(j).status == 1) {
						b.status = 2;
						b1.status = 2;
						b2.status = 2;
						b3.status = 2;
						b4.status = 2;
						b5.status = 2;
						b6.status = 2;
						b7.status = 2;
						b8.status = 2;
						b9.status = 2;
						b10.status = 2;
					} else {
						b.status = 1;
						b1.status = 1;
						b2.status = 1;
						b3.status = 1;
						b4.status = 1;
						b5.status = 1;
						b6.status = 1;
						b7.status = 1;
						b8.status = 1;
						b9.status = 1;
						b10.status = 1;
					}

				} else {
					b.point = a.get(j).point;
					b1.point = a.get(j).point;
					b2.point = a.get(j).point;
					b3.point = a.get(j).point;
					b4.point = a.get(j).point;
					b5.point = a.get(j).point;
					b6.point = a.get(j).point;
					b7.point = a.get(j).point;
					b8.point = a.get(j).point;
					b9.point = a.get(j).point;
					b10.point = a.get(j).point;

					if (a.get(j).status == 1) {
						b.status = 2;
						b1.status = 2;
						b2.status = 2;
						b3.status = 2;
						b4.status = 2;
						b5.status = 2;
						b6.status = 2;
						b7.status = 2;
						b8.status = 2;
						b9.status = 2;
						b10.status = 2;
					} else {
						b.status = 1;
						b1.status = 1;
						b2.status = 1;
						b3.status = 1;
						b4.status = 1;
						b5.status = 1;
						b6.status = 1;
						b7.status = 1;
						b8.status = 1;
						b9.status = 1;
						b10.status = 1;
					}
					b.check = a.get(j).check;
					b1.check = a.get(j).check;
					b2.check = a.get(j).check;
					b3.check = a.get(j).check;
					b4.check = a.get(j).check;
					b5.check = a.get(j).check;
					b6.check = a.get(j).check;
					b7.check = a.get(j).check;
					b8.check = a.get(j).check;
					b9.check = a.get(j).check;
					b10.check = a.get(j).check;

				}

				b.id = 9999;
				b1.id = 9999;
				b2.id = 9999;
				b3.id = 9999;
				b4.id = 9999;
				b5.id = 9999;
				b6.id = 9999;
				b7.id = 9999;
				b8.id = 9999;
				b9.id = 9999;
				b10.id = 9999;

				sentiment.add(b);
				sentiment.add(b1);
				sentiment.add(b2);
				sentiment.add(b3);
				sentiment.add(b4);
				sentiment.add(b5);
				sentiment.add(b6);
				sentiment.add(b7);
				sentiment.add(b8);
				sentiment.add(b9);
				sentiment.add(b10);

			}
		}
		return sentiment;
	}
}
