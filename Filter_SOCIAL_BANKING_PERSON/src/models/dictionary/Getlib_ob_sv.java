package dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Utils.Object;
import util.Utils.Service;
import util.Utils.logs;

public class Getlib_ob_sv {
	public static ArrayList<Object> lib_object(ResultSet rs)
			throws SQLException {
		ArrayList<Object> object = new ArrayList<Object>();
		while (rs.next()) {
			Object a = new Object();
			a.id = rs.getInt(1);
			a.cid = rs.getInt(2);
			a.sid = rs.getInt(3);
			a.pid = rs.getInt(4);
			a.name = rs.getString(5);
			a.status = rs.getInt(6);
			object.add(a);
		}
		return object;
	}
	public static ArrayList<Service> lib_service(ResultSet rs)
			throws SQLException {
		ArrayList<Service> service = new ArrayList<Service>();
		while (rs.next()) {
			Service a = new Service();
			a.id = rs.getInt(1);
			a.pid = rs.getInt(2);
			a.gid = rs.getInt(3);
			a.cid = rs.getInt(4);
			a.name = rs.getString(5);
			a.status = rs.getInt(6);
			service.add(a);
		}
		return service;
	}
	public static ArrayList<logs> lib_logs(ResultSet rs)
			throws SQLException {
		ArrayList<logs> log = new ArrayList<logs>();
		while (rs.next()) {
			logs a= new logs();
			a.id = rs.getInt(1);
			a.log = rs.getString(2);
			a.fb_id = rs.getString(3);
	
			log.add(a);
		}
		return log;
	}
	

}
