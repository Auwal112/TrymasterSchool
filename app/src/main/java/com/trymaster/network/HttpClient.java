package com.trymaster.network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {

    public String sendRequest(String urlStr, String method, String jsonInputString) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");

        if (jsonInputString != null) {
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }

        int responseCode = conn.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            throw new Exception("Request failed with code " + responseCode);
        }
    }

    public String get(String urlStr) throws Exception {
        return sendRequest(urlStr, "GET", null);
    }

    public String post(String urlStr, String jsonInputString) throws Exception {
        return sendRequest(urlStr, "POST", jsonInputString);
    }

    public String put(String urlStr, String jsonInputString) throws Exception {
        return sendRequest(urlStr, "PUT", jsonInputString);
    }

    public String delete(String urlStr) throws Exception {
        return sendRequest(urlStr, "DELETE", null);
    }
}
