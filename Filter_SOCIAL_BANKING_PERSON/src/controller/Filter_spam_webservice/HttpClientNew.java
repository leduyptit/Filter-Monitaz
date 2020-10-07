package Filter_spam_webservice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.omg.CORBA.portable.InputStream;

public class HttpClientNew {
	public static int filter_spam(String s){
		int check=0;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost request = new HttpPost("http://192.168.2.80:8888");
			StringEntity params = new StringEntity(
					"{\"message\":\""+s+"\"}");
			request.addHeader("Content-Type", "application/json");
			request.addHeader("Accept", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			String output;

			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if(output.compareTo("{\"label\": \"nonspam\"}")==0){
					check=1;
				}
			}
		} catch (Exception ex) {
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return check;
	}
/*	public static void main(String[] args) throws Exception {
//		System.out.println(filter_spam("có lẽ nào"));
		System.out.println(filter_spam("BIDV đang thi tuyển"));
		System.out.println(filter_spam("tuyệt vời"));
		System.out.println(filter_spam("có lẽ nào"));
	}
*/
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader in4 = new BufferedReader(new InputStreamReader(
				new FileInputStream("/root/Filter/tvplusfilter/all/test.txt")));
		String line2;

		DefaultHttpClient httpClient = new DefaultHttpClient();
//		String s=" BIDV thật tuyệt vời";
//		System.out.println(s);
//		StringEntity params = new StringEntity(
//				"{\"message\":\""+line2+"\"}");
//		System.out.println(line2);
		try {
			HttpPost request = new HttpPost("http://localhost:8888");
//			StringEntity params = new StringEntity(
//					"{\"message\":\"thật tuyệt vời\"}");
//			System.out.println(json.toString());
//		    StringEntity params = new StringEntity(json.toString());
			request.addHeader("Content-Type", "application/json");
			request.addHeader("Accept", "application/json");

			while ((line2 = in4.readLine()) != null ) {
				StringEntity params = new StringEntity(
						"{\"message\":\""+line2+"\"}");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println("output"+output);
			}}
			long end = System.currentTimeMillis();
//			System.out.println(end-start);
		} catch (Exception ex) {
		}
		
		finally {
			httpClient.getConnectionManager().shutdown();
		}
		
		
	}

}