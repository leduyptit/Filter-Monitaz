package object_service;

import java.util.ArrayList;
import json_cv.service;
import util.Utils.Service;

public class Check_service {
	public static int check_service(String h, String character) {
		String s;
		character = character.trim();
		s = " " + h + " ";
		s = s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");
		int check = 0;
		if (s.indexOf(" " + character + " ") >= 0|| (" " + h + " ").indexOf(" " + character + " ") >= 0) {
			check = check + 1;
		}
		return check;
	}
	public static String return_service(ArrayList<Service> service,
			String post_message) {
		String JSONservice_post = null;
		for (int j = 0; j < service.size(); j++) {
			if (Check_service.check_service(post_message.toLowerCase(),
					service.get(j).name.toLowerCase()) == 1) {
				service dv1 = new service(service.get(j).id,
						service.get(j).pid, service.get(j).gid,
						service.get(j).cid, service.get(j).status);
				JSONservice_post = dv1.toJSONString();
				break;
			}
		}
		return JSONservice_post;
	}
}