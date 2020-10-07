package mongodb;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class Update {
	private static DBCollection _conn = null;
	public static boolean update_fb_post(int object, int page_name_object,
			String id) {
		try {
			BasicDBObject updateDocument = new BasicDBObject();
			Date date = new Date();
			int time = (int) (date.getTime() / 1000);
			updateDocument.append("filtered_time", time);

			updateDocument.append("is_filtered", 2);
			updateDocument.append("object", object + "");
			updateDocument.append("page_name_object", page_name_object + "");
			// }
			BasicDBObject searchQuery = new BasicDBObject().append("_id",
					new ObjectId(id));
			_conn.update(searchQuery,
					new BasicDBObject().append("$set", updateDocument));
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public static boolean update_fb_post_multil(int object,
			int page_name_object, String id) {
		try {
			BasicDBObject updateDocument = new BasicDBObject();
			// Map json = (JSONObject) new JSONParser().parse(data);
			// Iterator iter = json.entrySet().iterator();
			// while (iter.hasNext()) {
			// Map.Entry entry = (Map.Entry) iter.next();
			// Date date = new Date();
			// int time = (int) (date.getTime() / 1000);
			// updateDocument.append("filtered_time", time);

			updateDocument.append("is_filtered", 3);
			// updateDocument.append("object", object + "");
			// updateDocument.append("page_name_object", page_name_object + "");
			// }
			BasicDBObject searchQuery = new BasicDBObject().append("_id",
					new ObjectId(id));
			_conn.update(searchQuery,
					new BasicDBObject().append("$set", updateDocument));
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	// up date bang comment,rep
	public static boolean update_fb(String id) {
		try {
			BasicDBObject updateDocument = new BasicDBObject();
			Date date = new Date();
			int time = (int) (date.getTime() / 1000);

			updateDocument.append("filtered_time", time);

			updateDocument.append("is_filtered", 2);
			BasicDBObject searchQuery = new BasicDBObject().append("_id",
					new ObjectId(id));
			_conn.update(searchQuery,
					new BasicDBObject().append("$set", updateDocument));
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public static boolean update_false(String id) {
		try {
			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("is_filtered", 1);
			BasicDBObject searchQuery = new BasicDBObject().append("_id",
					new ObjectId(id));
			_conn.update(searchQuery,
					new BasicDBObject().append("$set", updateDocument));
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public static boolean update_fb_multi(String id) {
		try {
			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("is_filtered", 3);
			BasicDBObject searchQuery = new BasicDBObject().append("_id",
					new ObjectId(id));
			_conn.update(searchQuery,
					new BasicDBObject().append("$set", updateDocument));
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

}
