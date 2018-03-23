package kpc.iot.smb.fcm;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.gson.Gson;

import kpc.iot.smb.fcm.FCMData;
import kpc.iot.smb.fcm.Data;

import java.security.cert.X509Certificate;

public class FCMServer {

	public FCMServer() {
		// TODO Auto-generated constructor stub
		String url = "https://fcm.googleapis.com/fcm/send"; 
		FCMDataTo fcmDataTo = new FCMDataTo();
		Data data = new Data();
		data.setContent_1("빠르게 대피해주세요!");
		data.setTitle("[I Save You]긴급상황 발생");
		fcmDataTo.setData(data);
		fcmDataTo.setTo("dpLbZuQqfWI:APA91bGk_AXJK3q6Kx4_k9sil7hJQ1CzfqFvTPzonsQpl3OwOpCYVeHrcJdcBpvgY6XaazHcQLkSfHtho2cVdv6G9hkMZUELAPruewDjlffQ5sNCPyIQL71PNtQPVfPlPHOusLBnN6pJ");
		// DB에 전체 SELECT
	
		Gson gson = new Gson();
		String params = gson.toJson(fcmDataTo);
		System.out.println(params);
		try {
			String returnData = sendPost(url, params);
			System.out.println(returnData);
		}catch(Exception e) {
			System.out.println("e : " + e);
		}		
	}
	
	public String sendPost(String url, String parameters) throws Exception { 
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
   
       URL obj = new URL(url);
       HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
   
       //reuqest header
       con.setRequestMethod("POST");
       con.setRequestProperty("Content-Type", "application/json");
       con.setRequestProperty("Authorization", "key=AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ");
       String urlParameters = parameters;
   
       //post request
       con.setDoOutput(true);
       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
       wr.write(urlParameters.getBytes("UTF-8"));
       wr.flush();
       wr.close();

       int responseCode = con.getResponseCode();     
       System.out.println("Post parameters : " + urlParameters);
       System.out.println("Response Code : " + responseCode);
   
       StringBuffer response = new StringBuffer();
   
       if(responseCode == 200){   
              BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
              String inputLine;
              while ((inputLine = in.readLine()) != null) {
                     response.append(inputLine);
              }
              in.close();   
       }
       //result
       System.out.println(response.toString());
       return response.toString();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FCMServer();
	}

}
