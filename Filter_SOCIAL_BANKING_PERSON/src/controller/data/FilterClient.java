package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import data.*;
import filtered.Filtered;

public class FilterClient {
	private void invoke() {
		TTransport transport;
		try {
			transport = new TSocket("192.168.1.10", 9910);
			TProtocol protocol = new TBinaryProtocol(transport);
			FilterMonitazService.Client client = new FilterMonitazService.Client(
					protocol);
			transport.open();
			Map jsonobj = new HashMap();
			jsonobj.put("id", 196);
			jsonobj.put("cid", 108);
			jsonobj.put("sid", 1);
			jsonobj.put("pid", 0);
			jsonobj.put("status", 1);

			Map jsonobj1 = new HashMap();
			jsonobj1.put("id", 196);
			jsonobj1.put("cid", 108);
			jsonobj1.put("sid", 1);
			jsonobj1.put("pid", 0);
			jsonobj1.put("status", 1);

			List list_obj = new ArrayList();
			list_obj.add(jsonobj);
			list_obj.add(jsonobj1);

			try {
				String jsonText = JSONValue.toJSONString(list_obj);
				boolean result = client.update(jsonText, "abc", (short) 1,
						(short) 0, (short) 7, (short) 5,
						"560cbb56a21a6fe1d716fd84", (short) 0, (short) 1,
						(short) 1, 77, (short) 7);

				System.out.println(result);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public static int update_service_hung(String JSONResult_object,
			String JSONResult_service, short point_negative,
			short point_positive, String id_str, short type, short mention,
			short tag, int own, short involove,int tag_sentiment) {
		tag_sentiment =1;
		if (JSONResult_service != null) {
			if (JSONResult_service.compareTo("[]") == 0) {
				JSONResult_service = null;
			}
		}
		if (JSONResult_object != null) {
			if (JSONResult_object.compareTo("[]") == 0) {
				JSONResult_object = null;
			}
		}
		TTransport transport;
		int check = 0;
		System.out.println("Start service hung");
		try {
			transport = new TSocket("192.168.1.10", 9910);
			TProtocol protocol = new TBinaryProtocol(transport);
			FilterMonitazService.Client client = new FilterMonitazService.Client(
					protocol);
			transport.open();
			short point = 3;
			short point_neutral =0;
			if (point_positive != 0 || point_negative != 0) {
				if (point_positive > point_negative) {
					point = 5;
				} else {
					point = 1;
				}
				if(tag_sentiment==0){
					point_neutral =666;
					point_positive = 0;
					point_negative = 0;
					point =3;
				}
			}
			try {
				if(JSONResult_object!=null){
            		mention=1;
            	}
            	else{
            		mention=0;
            	}

				boolean result = client.update(JSONResult_object,
						JSONResult_service, point, point_negative,
						point_positive, point_neutral, id_str, type, mention, tag,
						own, involove);
				if (result == false) {
					check = check + 1;
					FileWriter fw = new FileWriter(
							"/root/Filter/tvplusfilter/log/log1.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Banking : False - Id_mongo : ");
					bw.write(id_str);
					bw.write("\n");
					bw.close();
					fw.close();
				}
				if(JSONResult_object!=null){
					FileWriter fw = new FileWriter(
							"/root/Filter/tvplusfilter/log/log_object_update.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Banking id:");
					bw.write(id_str+" "+JSONResult_object);
					bw.write("\n");
					bw.close();
					fw.close();
            	}
				System.out.println("Service return"+result);
				if (result == false) {
					check = check + 1;
					System.out.println("Service return erro");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
		return check;
	}

	public static void main(String[] args) {
		FilterClient c = new FilterClient();
		c.invoke();
	}
}
