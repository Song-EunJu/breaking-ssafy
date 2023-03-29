package com.ssafy.trip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiExplorer {

	public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api"); /*관광지정보  URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "= ************** Service Key ************** "); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*관광지 정보 type : xml, json*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*거래 년월 검색*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*거래 년월 검색*/

//		String strUrl = "http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api";
//		strUrl += "?serviceKey=UTF-8로 인코딩된 인증키";
//		strUrl += "&type=xml";
//		strUrl += "&s_page=0";
//		strUrl += "&s_list=1";
//		strUrl += "&instt_nm=UTF-8로 인코딩된 value";
		URL url = new URL(urlBuilder.toString());
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection connection = null;
		if (urlConnection instanceof HttpURLConnection) {
			connection = (HttpURLConnection) urlConnection;
		} else {
			System.out.println("error");
			return;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String urlString = "";
		String current;
		while ((current = in.readLine()) != null) {
			urlString += current + "\n";
		}
		System.out.println(urlString);
	}

}
