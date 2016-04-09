package com.facebook.login.action;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

public class MySMS {
	public static void main(String[] args) {
		
		// rajesh ==   9535184724
		Random random = new Random();
		int max= 99999;
		int min=10000;
		try {
			String receiver ="9741790910";
			String message ="Your OTP is " + random.nextInt((max-min)+min)+ " - BIDMOV" ;
			String username = "demotr";
			String password = "123tr";
			String senderid ="INFODR";
String requestUrl="http://119.81.202.40/trans/api/http_sms_api.php?"+
		 "username=" + URLEncoder.encode(username, "UTF-8")+
		 "&password=" +URLEncoder.encode(password,"UTF-8")+
		 "&to=" +URLEncoder.encode(receiver,"UTF-8")+
		 "&message=" + URLEncoder.encode(message,"UTF-8")+
		 "&sender_id=" + URLEncoder.encode(senderid, "UTF-8");
		URL url = new URL(requestUrl);
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		System.out.println(uc.getResponseMessage());
		System.out.println(message);
		uc.disconnect();
		} catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
	}
}

