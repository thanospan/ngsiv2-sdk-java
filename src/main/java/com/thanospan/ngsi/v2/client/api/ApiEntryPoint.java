package com.thanospan.ngsi.v2.client.api;

import com.thanospan.ngsi.v2.client.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ApiEntryPoint {
    private final ApiClient apiClient;
    private final HttpClient httpClient;

    public ApiEntryPoint(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.httpClient = apiClient.getHttpClient();
    }

    public CompletableFuture<HttpResponse<String>> retrieveApiResources() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiClient.getBaseUrl()))
                .GET()
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
