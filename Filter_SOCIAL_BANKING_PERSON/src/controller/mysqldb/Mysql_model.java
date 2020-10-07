package mysqldb;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

public class Mysql_model {
	private  String className;
	private  String url;
	private  String user;
	private  String pass;
	
	private String table = "service_brand";
	private static  Connection connection;

	public static String p;
	public static long c_time;
	public static long filter_time;

	// connect to database
	public Mysql_model(String className, String url, String user,
			String pass, Connection connection
			) {
		this.className = className;
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.connection = connection;
	}
	public void connect() throws IOException {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect success!");

		} catch (ClassNotFoundException e) {

			System.out.println("Class not found!");
		} catch (SQLException e) {

			System.out.println("Error connection!");
		}
	}


	public void close() {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("dong ket noi");
			}
		} catch (Exception e) {

		}
	}

	// lấy dữ liệu đối tượng
	public ResultSet getselect_object() {
		ResultSet rs = null;
		String sqlCommand = "select * from " + table
				+ " where (cid=1 or sid=1 or pid=1 or cid =14331 or sid =14331 or pid =14331 or cid =20088 or sid =20088 or pid =20088) and id !=14331";

		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.println("select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy dữ liệu dịch vụ
	// k quét person và fanpage
	public ResultSet getselect_service() {
		ResultSet rs = null;
		String sqlCommand = "select * from service_categories where type = 0 and id not like'1' and id not like '34'";
		Statement st;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.println("select error \n" + e.toString());
		}
		return rs;
	}

	// Lấy dữ liệu sentiment
	public ResultSet getselectsentiment() {
		ResultSet rs = null;
		String sqlCommand = "select id, word, point_bank , status,sentiment.check, pid  from sentiment";
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.println("select error \n" + e.toString());
		}
		return rs;
	}
	
	public ResultSet getselect_log() {
		ResultSet rs = null;
		String sqlCommand = "select * from logs where logs.check=0 and id <420109 and is_has_object =0  order by id asc limit 5000";
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sqlCommand);
		} catch (SQLException e) {
			System.out.println("select error \n" + e.toString());
		}
		return rs;
	}
	
	public static  void update_log(int id) {
		String sqlCommand = "update logs set logs.check=1 where id ="
				+ id;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sqlCommand);
			if (pst.executeUpdate() > 0) {
				System.out.println("update success");
			} else {
				System.out.println("update error \n");
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
	}

	// Bat dau chay chuong trinh
	public  void startjob(int service_id, String pid) throws SQLException {

		Date date = new Date();
		int time = (int) (date.getTime() / 1000);
		String sqlCommand = "insert into crawl_manager_service_job(service_id,status,start_time,process_id) values("
				+ service_id + ",0," + time + ",'" + pid + "')";
		PreparedStatement pst = null;
		System.out.println(sqlCommand);
		try {
			pst = connection.prepareStatement(sqlCommand);
			if (pst.executeUpdate() > 0) {
				System.out.println("update success");
			} else {
				System.out.println("update error \n");
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}

	}

	// Ket thuc chay chuong trinh
	public  void finishjob(int service_id, String pid, String resson) {
		long time;
		Date date = new Date();
		time = date.getTime() / 1000;
		String sqlCommand = "update crawl_manager_service_job set status=1,finish_time="
				+ time
				+ ",finish_reason='"
				+ resson
				+ "' where service_id="
				+ service_id + " and process_id='" + pid + "'";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sqlCommand);
			if (pst.executeUpdate() > 0) {
				System.out.println("update success");
			} else {
				System.out.println("update error \n");
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
	}

}