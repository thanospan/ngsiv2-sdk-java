package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.Types;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class TypesExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Types types = new Types(apiClient);

        listEntityTypes(types);
//        retrieveEntityTypes(types);
    }

    private static void listEntityTypes(Types types) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = types.listEntityTypes(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntityTypes(Types types) {
        String entityType = "Room";
        HttpResponse<String> httpResponse = types.retrieveEntityType(entityType).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
