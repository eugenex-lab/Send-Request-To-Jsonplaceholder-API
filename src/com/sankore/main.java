package com.sankore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {


    private static HttpURLConnection connection;

    public static void main(String[] args) {
        BufferedReader br;
        String line;
        StringBuilder responseContent = new StringBuilder();
        // System.out.println("Hello World");

        // Method x : java.net.HttpURLConnection

        try
            {
                  URL  url = new URL("https://jsonplaceholder.typicode.com/users");
                connection = (HttpURLConnection) url.openConnection();

                //Request Setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);

                int status = connection.getResponseCode();
//                System.out.println(status);

                if (status > 299){
                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while((line = br.readLine()) != null){
                        responseContent.append(line);
                    }
                    br.close();
                }else{
                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while((line = br.readLine()) != null){
                        responseContent.append(line);
                    }
                    br.close();
                }
                System.out.println(responseContent.toString());
        }catch (MalformedURLException e) {
                    e.printStackTrace();
                }catch(IOException e){
            e.printStackTrace();

        }
        finally {
            connection.disconnect();
        }
    }
}
