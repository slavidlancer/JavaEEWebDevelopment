package com.tutorials.url_connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Search {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.searchalta.com/");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
        String query = URLEncoder.encode("Java EE", "UTF-8");
        out.println("q=" + query);
        
        out.close();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String line;
        
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        
        in.close();
    }
}
