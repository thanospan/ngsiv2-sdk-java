package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class Registrations {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public Registrations(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> listRegistrations(HashMap<String, String> parameters) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/registrations", parameters)))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> createRegistration(String contentType, String body) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/registrations", new HashMap<>())))
                .header("Content-Type", contentType)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> retrieveRegistration(String registrationId) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/registrations/" + registrationId, new HashMap<>())))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> updateRegistration(String registrationId, String contentType, String body) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/registrations/" + registrationId, new HashMap<>())))
                .header("Content-Type", contentType)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> deleteRegistration(String registrationId) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.buildUri("/registrations/" + registrationId, new HashMap<>())))
                .DELETE()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
