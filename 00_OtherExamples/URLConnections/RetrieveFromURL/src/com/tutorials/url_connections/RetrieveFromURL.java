package com.tutorials.url_connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RetrieveFromURL {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.github.com/slavidlancer");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));
        String line;
        
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        
        in.close();
    }
}
