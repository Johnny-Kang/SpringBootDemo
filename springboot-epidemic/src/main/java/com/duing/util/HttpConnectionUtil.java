package com.duing.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionUtil {
    public static String getData(String urlStr){
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(60000);
            conn.setRequestProperty("Accept","application/json");
            conn.connect();

            if (200 == conn.getResponseCode()){
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String str = br.readLine();
                while(str != null){
                    builder.append(str);
                    str = br.readLine();
                }
            }else {
                System.out.println("error"+conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null){
                    br.close();
                }
                if (is != null){
                    is.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn.disconnect();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String url = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        String result = getData(url);
        System.out.println(result);
    }
}
