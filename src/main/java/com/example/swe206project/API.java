package com.example.swe206project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class API {
    public static void post(String username, String password, String type) {
        String endpoint = "https://us-central1-swe206-221.cloudfunctions.net/app/SignUp?teamKey=41885202";

        try {
            
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            params.put("type", type);

            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String, Object> param : params.entrySet()){
                if (postData.length() != 0 ) postData.append( '&') ;
                postData.append((URLEncoder.encode(param.getKey(), "UTF-8")));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postdatabytes = postData.toString().getBytes("UTF-8");
            
            URL url = new URL(endpoint);


            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postdatabytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postdatabytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            System.out.println(in);

            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }   

    public static String get(String username, String password){
         String url = "https://us-central1-swe206-221.cloudfunctions.net/app/SignIn?teamKey=41885202&username=" + username.replaceAll("\\#", "%23") + "&password=" + password;
         //String url = "https://us-central1-swe206-221.cloudfunctions.net/app/SignIn?teamKey=41885202&username=trainee%2317802&password=pxbtm5391";
         try{
         URL obj = new URL(url);
         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         // optional default is GET
         con.setRequestMethod("GET");
         //add request header
         //con.setRequestProperty("User-Agent", "Mozilla/5.0");
         int responseCode = con.getResponseCode();
         System.out.println("\nSending 'GET' request to URL : " + url);
         System.out.println("Response Code : " + responseCode);
         BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
             response.append(inputLine);
         }
         in.close();
         return response.toString();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "gg";
        }


    }

    public static void main(String[] args) {
        //post("admin", "admin", "GymManager");
        //get("admin", "admin");
        //get("trainer#17484", "cuuxe2672");
        //get("trainee#24382", "lydiv7492");
        //get();
    }



}