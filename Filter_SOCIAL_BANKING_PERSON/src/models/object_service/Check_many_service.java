package object_service;

import java.util.ArrayList;
import java.util.List;
import json_cv.service;
import util.Utils.Service;

public class Check_many_service {
	public static int check_service(String h, String character) {
		String s;
		character = character.trim();
		s = " " + h + " ";
		s = s.replaceAll("\\p{P}", " ").replaceAll("\\s+", " ");
		int check = 0;
		if (s.indexOf(" " + character + " ") >= 0) {
			check = check + 1;
		}
		return check;
	}

	public static int num(int k, ArrayList<Integer> pid) {
		int num = 0;
		for (int i = 0; i < pid.size(); i++) {
			if (pid.get(i) == k) {
				num++;
			}
		}
		return num;
	}

	public static int num_max(ArrayList<Integer> num) {
		int num_m = num.get(0);
		int index = 0;
		for (int i = 1; i < num.size(); i++) {
			if (num.get(i) > num_m) {
				num_m = num.get(i);
			}
		}
		for (int i = 0; i < num.size(); i++) {
			if (num.get(i) == num_m) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static String return_service(ArrayList<Service> service,
			String post_message) {
		String JSONservice_post = null;
		List<service> list4 = new ArrayList<service>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<Integer> pid = new ArrayList<Integer>();
		for (int j = 0; j < service.size(); j++) {
			if (Check_many_service.check_service(post_message.toLowerCase(),
					service.get(j).name.toLowerCase()) == 1) {
				System.out.print(" "+service.get(j).name+" ");

				list4.add(new service(service.get(j).id, service.get(j).pid,
						service.get(j).gid, service.get(j).cid,
						service.get(j).status));
				pid.add(service.get(j).pid);

			}

		}
		if(list4.size()!=0){

		for (int i = 0; i < pid.size(); i++) {
			num.add(num(pid.get(i), pid));
		}

//		for (int i = 0; i < pid.size(); i++) {
//			System.out.print(" pid :" + pid.get(i) + "   Size:" + num.get(i)+" ");
//		}
//		System.out.print(" Index to nhất là: "+num_max(num)+" "+pid.get(num_max(num)));
		JSONservice_post = list4.get(num_max(num)).toJSONString();
//				JSONArray.toJSONString(list4);
		}
		return JSONservice_post;
	}
}