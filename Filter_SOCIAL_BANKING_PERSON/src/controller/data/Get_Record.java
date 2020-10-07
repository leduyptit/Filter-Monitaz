package data;

import java.util.ArrayList;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import util.Utils.Record;

public class Get_Record {

	public static ArrayList<Record> getListFull(int limit, String s) {
		limit = 2000;
		ArrayList<util.Utils.Record> res = new ArrayList<util.Utils.Record>();
		TTransport transport1;
		try {
			transport1 = new TSocket("192.168.1.230", 2714);
			TProtocol protocol1 = new TBinaryProtocol(transport1);
			FilterMonitazService.Client client1 = new FilterMonitazService.Client(
					protocol1);
			transport1.open();
			System.out.println("open conection");
			String query = "{\n"
					+ "  \"sort\": [\n"
					+ "   { \"crawled_time\": { \"order\": \"desc\" }}\n"
					+ "  ],\n"
					+ "  \"_source\": [\"fb_page_name\", \"fb_message\", \"post_type\", \"fb_from_name\", \"fb_parent_id\", \"fb_grand_parent_id\"],\n"
					+ "    \"query\": {\n"
					+ "        \"filtered\" : {\n"
					+ "            \"query\" : {\n"
//					+ "                \"match\": { \"branch\": \"LEISURE\" }\n"
					+ "                \"match\": { \"branch\": \"PERSONAL\" }\n"
//					 +
//					 "                \"match\": { \"branch\": \"BANKING\" }\n"
					+ "            },\n"
					+ "    \"filter\" : {\n"
					+ "     \"bool\" : {\n"
					+ "      \"must\" : [\n"
//					+ "       {\"term\" : { \"is_filtered_banking\" : 1}"
//					+ "}\n"
//					+","
//					580871805_10155416931976806
				 +
					 "       {\"term\" : { \"fb_post_id\" : \""+s+"\" }}\n"



					+ "      ]\n" + "     }\n" + "    }\n" + "        }\n"
					+ "    },\n" + "  \"size\":" + limit + "\n" + "}";
			System.out.println(query);
			java.util.List<MessageInfo> result = client1.getPosts(10, query);
			for (MessageInfo e : result) {
				util.Utils.Record info = new util.Utils.Record();
				info.id = e.getId();
				info.page_name = e.getFb_page_name();
				info.message = e.getFb_message();
				info.post_type = e.getPost_type();
				info.fb_from_name = e.getFb_from_name();
				info.post_message = e.getPost_message();
				res.add(info);
				System.out.println("id " + info.id);
			}
			transport1.close();
		} catch (Exception e) {
			System.out.println("Error while tagging");
			System.out.println(e.getMessage());
		}
		return res;
	}
}
