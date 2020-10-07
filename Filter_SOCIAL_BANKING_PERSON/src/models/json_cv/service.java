package json_cv;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;

import testservice.doituong;

public class service implements JSONAware {
	private int id_service;
	private int cid_service;
	private int gid_service;
	private int pid_service;
	private int status_service;

	public service(final int id_service, final int pid_service,
			final int gid_service, final int cid_service, final int status_service) {
		this.id_service = id_service;
		this.gid_service = gid_service;
		this.cid_service = cid_service;
		this.pid_service = pid_service;
		this.status_service = status_service;
	}

	public int getid_service() {
		return id_service;
	}

	public int getpid_service() {
		return pid_service;
	}

	public int getgid_service() {
		return gid_service;
	}

	public int getcid_service() {
		return cid_service;
	}

	public int getstatus_service() {
		return status_service;
	}

	public String toJSONString() {

		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"id\":\"" + getid_service() + "\"");
		sb.append(",");
		sb.append("\"pid\":\"" + getpid_service() + "\"");
		sb.append(",");
		sb.append("\"gid\":\"" + getgid_service() + "\"");
		sb.append(",");
		sb.append("\"cid\":\"" + getcid_service() + "\"");
		sb.append(",");
		sb.append("\"status\":\"" + getstatus_service() + "\"");
		sb.append("}");
		return sb.toString();

	}

	public static void main(String[] args) {
		List<doituong> list = new ArrayList<doituong>();
		list.add(new doituong(1, 1, 1, 1, 12));
		list.add(new doituong(1, 1, 1, 1, 12));
		list.add(new doituong(1, 1, 1, 1, 12));
		String JSONResult = JSONArray.toJSONString(list);

		System.out.println(JSONResult);

	}

}