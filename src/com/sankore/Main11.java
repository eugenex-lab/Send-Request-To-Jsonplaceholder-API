package com.sankore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main11 {


    public static void main(String[] args) {

        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/users")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(Main11::parser)
                .join();
    }

    public static String parser(String response) {
        JSONArray albums = new JSONArray(response);
        System.out.println("####$$$$$$$Hello SOji from inside the API####$$$$");
        System.out.println("   ");
        System.out.println("    ");

        for (int i = 0; i < albums.length(); i++ ){
            JSONObject album = albums.getJSONObject(i);
            String name = album.getString("name");
            String username = album.getString("username");
//            String address = album.getString("address");
//            String lat = album.getString("lat");
//            String lng = album.getString("lng");
//            int  phoneNUmber = Integer.parseInt(album.getString("phone"));
//            String website = album.getString("website");



            System.out.println( i + ".  User with named " + name + " has a user name of " + username  +  " \n lives in "
//                    + address + " please note the lng ang lat for war with is at " + lat + " with longitude of " + lng +  " \n please try conatc on phone number " + phoneNUmber
//            + " website address also at " + website + " \n our catch phrase is " + catchPhrase
            );
        }
        return "I no see nothing ";
    }

}