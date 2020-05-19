package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class Types {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public Types(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> listEntityTypes(HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/types", parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> retrieveEntityType(String entityType) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/types/" + entityType, new HashMap<>())))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
