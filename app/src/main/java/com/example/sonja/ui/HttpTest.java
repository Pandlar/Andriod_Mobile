package com.example.sonja.ui;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpTest {

    private final String USER_AGENT = "Mozilla/5.0";

    public enum Table{
        TEST, USER, MATCH, REQUEST, RATINGS, CACHELOCATIONS
    }

    public HttpTest(){

    }

    // HTTP GET request
    public String sendGet(String table, String attr, String value, String compare) throws Exception {
        if(table==null){
            //TODO
            throw new Exception();
        }
        String url = "http://18.191.175.126:3000/"+table+"?"+attr+"="+compare+"."+value;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

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

        //print result
        String result = response.toString();

        return result;

    }

    // HTTP POST request
    public void sendPost() throws Exception {

        String url = "http://18.191.175.126:3000/Test";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String id = "35";
        String name = "Larifari";

        String urlParameters = "id=" + id + "&name=" + name;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
    //TODO uuid, km, userid
    public void postRequest(int earliest_minute, int earliest_hour,
                            int latest_minute, int latest_hour,
                            NeueFahrt1.RequestRole requestRole, String direction) throws Exception {

        String url = "http://18.191.175.126:3000/Test";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String id = "35";
        String name = "Larifari";

        String urlParameters = "id=" + id + "&name=" + name;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    public void sendPut() throws Exception {

        String id = "2";
        String name= "Ex Machina";

        String ip = "http://18.191.175.126:3000/Test";
        String urlString = ip + "?id=eq." + id;

        URL url = new URL(urlString);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        httpCon.setRequestProperty("User-Agent", USER_AGENT);
        httpCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        DataOutputStream wr = new DataOutputStream(httpCon.getOutputStream());


        wr.writeBytes("{\"id\":\""+id+"\",\"name\":\""+name+"\"}");
        //wr.writeBytes("test");
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpCon.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
    }
}
