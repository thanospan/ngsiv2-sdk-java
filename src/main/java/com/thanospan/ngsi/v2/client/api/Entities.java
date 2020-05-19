package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class Entities {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public Entities(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> listEntities(HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities", parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> createEntity(String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities", parameters)))
                .header("Content-Type", contentType)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> retrieveEntity(String entityId, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId, parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> retrieveEntityAttributes(String entityId, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs", parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> updateOrAppendEntityAttributes(String entityId, String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs", parameters)))
                .header("Content-Type", contentType)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> updateExistingEntityAttributes(String entityId, String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs", parameters)))
                .header("Content-Type", contentType)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> replaceAllEntityAttributes(String entityId, String contentType, String body, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId + "/attrs", parameters)))
                .header("Content-Type", contentType)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> removeEntity(String entityId, HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/entities/" + entityId, parameters)))
                .DELETE()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
