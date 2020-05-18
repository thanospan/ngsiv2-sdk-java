package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.ApiEntryPoint;

import java.net.http.HttpResponse;

public class ApiEntryPointExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        ApiEntryPoint apiEntryPoint = new ApiEntryPoint(apiClient);

        retrieveApiResources(apiEntryPoint);
    }

    private static void retrieveApiResources(ApiEntryPoint apiEntryPoint) {
        HttpResponse<String> httpResponse = apiEntryPoint.retrieveApiResources().join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
