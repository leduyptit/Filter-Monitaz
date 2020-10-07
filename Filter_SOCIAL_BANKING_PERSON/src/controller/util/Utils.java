package util;

public class Utils {
	public static class Object {
//		public  Object message;
		public String name;
		public int id;
		public int cid;
		public int sid;
		public int pid;
		public int status;

	}
	public static class point {
		public int negative;
		public int positive;
		public int indexof_negative;
		public int indexof_positive;
	}
	public static class sentiment {
		public String word;
		public int point;
		public int status;
		public int check;
		public int pid;
		public int id;

	}
	public static class Service {
		public String name;
		public int id;
		public int pid;
		public int gid;
		public int cid;
		public int status;
	}
	public static class logs {
		public int id;
		public String log;
		public String fb_id;
	}
	public static class Record {
		public String page_name;
		public String id;
		public String message;
		public String post_message;
		public String fb_from_name;
		public int post_type;
	}

	public static class Record_tag {
		public static String post_mesage;
		public String message;
		public String id;
		public String p_name;
		public int tag;
		public point st;
		public String post_message;
		public String fb_from_name;
		public int post_type;

	}

	public static class Record_tag_involove {
		public String message;
		public String id;
		public String p_name;
		public int tag;
		public int involove;
		public point st;
		public String post_message;
		public String fb_from_name;
		public int check_spam;
		public int post_type;
	}

}
