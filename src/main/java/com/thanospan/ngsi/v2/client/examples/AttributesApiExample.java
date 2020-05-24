package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.AttributesApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class AttributesApiExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        AttributesApi attributesApi = new AttributesApi(apiClient);

        getAttributeData(attributesApi);
//        updateAttributeData(attributesApi);
//        removeASingleAttribute(attributesApi);
    }

    private static void getAttributeData(AttributesApi attributesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("metadata", "accuracy");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        HttpResponse<String> httpResponse = attributesApi.getAttributeData(entityId, attrName, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateAttributeData(AttributesApi attributesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        String contentType = "application/json";
        String body = "{\"value\":25,\"metadata\":{\"unitCode\":{\"value\":\"CEL\"}}}";
        HttpResponse<String> httpResponse = attributesApi.updateAttributeData(entityId, attrName, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void removeASingleAttribute(AttributesApi attributesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        HttpResponse<String> httpResponse = attributesApi.removeASingleAttribute(entityId, attrName, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
