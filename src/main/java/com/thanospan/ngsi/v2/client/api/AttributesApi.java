package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class AttributesApi {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public AttributesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> getAttributeData(String entityId, String attrName, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs/" + attrName, parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> updateAttributeData(String entityId, String attrName, String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs/" + attrName, parameters)))
                .header("Content-Type", contentType)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> removeASingleAttribute(String entityId, String attrName, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs/" + attrName, parameters)))
                .DELETE()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
