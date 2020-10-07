package filtered;

import java.io.IOException;
import java.util.ArrayList;

import object_service.Check_object;
import object_service.Check_service;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import rule.Rule_spam;
import util.Utils.Object;
import util.Utils.Service;
import util.Utils.point;
import data.FilterClient;
import data.FilterMonitazService;
import NaiveBayes_data.NaiveBayesKnowledgeBase;
import NaiveBayes_data_order.NaiveBayesModel;

class task1 implements Runnable {
	private String fb_message;
	private String fb_page_name;
	private String id_conten;
	private ArrayList<Object> object;
	private ArrayList<Service> service;
	private int tag;
	private int type;
	private String post_message;
	private int involove;
	private String fb_from_name;
	private int check_spam;
	private NaiveBayesKnowledgeBase model_tag;
	private ArrayList<String> a;
	private NaiveBayesModel order;

	public task1(String fb_message, String fb_page_name, String id_conten,
			ArrayList<Object> object, ArrayList<Service> service, int tag,
			int type, String post_message, int involove, String fb_from_name,
			ArrayList<String> b, int check_spam,
			NaiveBayesKnowledgeBase model_tag,NaiveBayesModel order) {
		this.fb_message = fb_message;
		this.fb_page_name = fb_page_name;
		this.id_conten = id_conten;
		this.object = object;
		this.service = service;
		this.tag = tag;
		this.type = type;
		this.post_message = post_message;
		this.involove = involove;
		this.fb_from_name = fb_from_name;
		this.a = b;
		this.check_spam = check_spam;
		this.model_tag = model_tag;
		this.order = order;
	}

	public void run() {
		System.out.println(id_conten);
		long start = System.currentTimeMillis();
		System.out.println("Thoi gian bat dau" + start);
		int own = 0;
		String JSONResult_object_from_name = null;
		String JSONResult_object_page_name = null;
		String JSONResult_object = null;
		String JSONResult_service = null;
		String JSONservice = null;
		String JSONservice_post = null;
		String JSONobject_post = null;
		int point_negative;
		int point_positive;
		point st = null;
		int check_service = 0;
		if (fb_message != null && fb_message.length() > 0) {

			JSONResult_object_from_name = Check_object.return_object(object,
					fb_from_name);
			try {
				tag = Logic_tag.Filter_tag(fb_message, fb_from_name,
						JSONResult_object_from_name, a, object, service, model_tag,order);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// nếu là comment thì quét đối tượng, dịch vụ của post cha
			if (type == 1 || type == 2) {

				JSONservice_post = Check_service.return_service(service,
						post_message);
				JSONobject_post = Check_object.return_object(object,
						post_message);
				if (Rule_spam.rule1_spam(post_message) == 1) {
					JSONobject_post = null;
				}
			}

			// Tra ve full row object cua fb_post_message
			JSONResult_object = Check_object.return_object(object, fb_message);
			JSONResult_object_page_name = Check_object.return_object(object,
					fb_page_name);
			JSONservice = Check_service.return_service(service, fb_page_name);
			JSONResult_service = Check_service.return_service(service,
					fb_message);

			// Trả về object id của page_name
			for (int i = 0; i < object.size(); i++) {
				if (Check_object.check_object(fb_page_name.toLowerCase(),
						object.get(i).name.toLowerCase(), 1) == 1
						&& Check_object.check_object_confusion(
								fb_page_name.toLowerCase(),
								object.get(i).name.toLowerCase()) == 0

				) {
					if (object.get(i).status == 1) {
						own = object.get(i).cid;
					}
					if (object.get(i).status == 0) {
						own = object.get(i).id;
					}
					break;
				}
			}
			
			//Xử lí trường hợp đối tượng message k phải đối tượng page
		JSONResult_object = Check_object.return_message_object(object,fb_message,own,JSONResult_object_page_name);

			// chỉnh sửa lại điểm involove
	
		
				if (check_spam == 0 && JSONResult_object != null) {
					st = Filtered.rt_sentiment(fb_message);

			// Nếu là comment thì truyền dữ liệu post vào.

			}
				System.out.println("negative cũ  :" + st.negative);
				System.out.println("positive cũ :" + st.positive);
		int index;
			index = Check_object.return_indexof_firts_object(object,fb_message,own,JSONResult_object_page_name);
		if(st.indexof_negative!=-1 || st.indexof_positive!=-1){
			point sentiment = new point();
			sentiment = object_service.Check_sentiment.setpoints_compare_objects(index,st.indexof_negative,st.indexof_positive,st.negative,st.positive);
			System.out.println("object : "+JSONResult_object);
			System.out.println("object page name : "+JSONResult_object_from_name);
			System.out.println("index object : "+index);
			System.out.println("negative :" + sentiment.negative);
			System.out.println("positive :" + sentiment.positive);}

		long end = System.currentTimeMillis();
		System.out.println("Thoi gian ket thuc" + end);

	}
	}
}
