package com.thanospan.ngsi.v2.client;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private HttpClient httpClient;
    private String baseUrl;

    public ApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.baseUrl = "http://localhost:1026/v2";
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String buildUri(String endpointPath, HashMap<String, String> parameters) {
        StringBuilder uri = new StringBuilder();
        uri.append(this.baseUrl).append(endpointPath).append("?");

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            uri.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        return uri.toString();
    }
}
