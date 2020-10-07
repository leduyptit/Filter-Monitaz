package filtered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Check_spam_service {
	public static int sendPost(String s, int id) throws Exception {
		int out;
		try {
			// Application http = new Application();
			String url = "http://192.168.1.233:10407/spam";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			String urlParameters = "{\"data\":\"" + s + "\"}";
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.write(urlParameters.getBytes("UTF-8"));
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject output = new JSONObject(response.toString());
			out = output.getInt("banking_spam");
			// print result
		} catch (Exception e) {
			out = 3;
		}
		FileWriter fw1 = null;
		if (out == 1) {
			try {
				fw1 = new FileWriter(
						"/root/Filter/tvplusfilter/all/sentiment_log/spam_service.txt",
						true);
				BufferedWriter bw1 = new BufferedWriter(fw1);

				try {
					bw1.write(s + " spam_check:" + id);
					bw1.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					bw1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (out == 0) {
			try {
				fw1 = new FileWriter(
						"/root/Filter/tvplusfilter/all/sentiment_log/nonspam_service.txt",
						true);
				BufferedWriter bw1 = new BufferedWriter(fw1);

				try {
					bw1.write(s + " spam_check:" + id);
					bw1.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					bw1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return out;
	}

}
