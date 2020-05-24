package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.TypesApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class TypesExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        TypesApi typesApi = new TypesApi(apiClient);

        listEntityTypes(typesApi);
//        retrieveEntityTypes(typesApi);
    }

    private static void listEntityTypes(TypesApi typesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = typesApi.listEntityTypes(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntityTypes(TypesApi typesApi) {
        String entityType = "Room";
        HttpResponse<String> httpResponse = typesApi.retrieveEntityType(entityType).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
