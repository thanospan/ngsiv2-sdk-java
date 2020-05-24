package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class AttributeValueApi {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public AttributeValueApi(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> getAttributeValue(String entityId, String attrName, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs/" + attrName + "/value", parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> updateAttributeValue(String entityId, String attrName, String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs/" + attrName + "/value", parameters)))
                .header("Content-Type", contentType)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
