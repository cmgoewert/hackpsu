package com.example.cmgoe.hackpsu;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cmgoe on 11/4/2017.
 */

public final class WatsonInteraction {
    private static ArrayList<String> concepts;

    public static ArrayList<String> send(String description) {
        String username = "04874903-5681-4148-9fdf-b4e4efc0fc13";
        String password = "j2baggRLJat5";
        String userPassword = username + ":" + password;
        String descToSend = "Big Luke is a company that will 3D print personalized water bottles for a cheap price to developing countries in order to provide them cheaper water.  We need branding in order to have a succesful launch and we need effecient manufacturing.  I have some photoshop ability but also need a graphic designer.  We are not entirely sure how to go about advertising once we are ready to launch so we need assitance with that as well.";
        String encoding = Base64.encodeToString(userPassword.getBytes(), Base64.DEFAULT);

        try{
            URL urlConnection = new URL("https://gateway.watsonplatform.net/natural-language-understanding/api/v1/analyze?version=2017-02-27");
            HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();
            con.setRequestProperty("Authorization", "Basic " + encoding);

            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write("{\n"
                    + "  \"text\": \""+descToSend +"\",\n"
                    + "  \"features\": {\n"
                    + "    \"concepts\": {\n"
                    + "      \"emotion\": true,\n"
                    + "      \"sentiment\": true,\n"
                    + "      \"limit\": 20\n"
                    + "    }\n"
                    + "  }\n"
                    + "}");
            osw.flush();
            String response = "";

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            System.out.println("in while");

            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                response += line;

            }
            System.out.println(response);

            concepts = responseHandler(response);

            System.out.print("HTTP code : "
                    + con.getResponseCode());
            System.out.println(con.getResponseMessage());
        } catch (Exception e){

        }

        return concepts;
    }


    public static ArrayList<String> responseHandler(String response){
        ArrayList<String> concepts = new ArrayList<>();
        while(response.contains("\"text\"")){
            int point = response.indexOf("\"text\"");
            String newConc = response.substring(point);
            newConc = newConc.substring(9);
            response = newConc;
            point = newConc.indexOf("\"");
            newConc = newConc.substring(0, point);
            concepts.add(newConc);
        }
        System.out.println(concepts.toString());
        return concepts;
    }
}
