package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.ApiEntryPointApi;

import java.net.http.HttpResponse;

public class ApiEntryPointApiExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        ApiEntryPointApi apiEntryPointApi = new ApiEntryPointApi(apiClient);

        retrieveApiResources(apiEntryPointApi);
    }

    private static void retrieveApiResources(ApiEntryPointApi apiEntryPointApi) {
        HttpResponse<String> httpResponse = apiEntryPointApi.retrieveApiResources().join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
