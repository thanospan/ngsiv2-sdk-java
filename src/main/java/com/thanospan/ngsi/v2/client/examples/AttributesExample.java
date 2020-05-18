package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.Attributes;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class AttributesExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Attributes attributes = new Attributes(apiClient);

        getAttributeData(attributes);
//        updateAttributeData(attributes);
//        removeASingleAttribute(attributes);
    }

    private static void getAttributeData(Attributes attributes) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("metadata", "accuracy");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        HttpResponse<String> httpResponse = attributes.getAttributeData(entityId, attrName, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateAttributeData(Attributes attributes) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        String contentType = "application/json";
        String body = "{\"value\":25,\"metadata\":{\"unitCode\":{\"value\":\"CEL\"}}}";
        HttpResponse<String> httpResponse = attributes.updateAttributeData(entityId, attrName, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void removeASingleAttribute(Attributes attributes) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        String attrName = "temperature";
        HttpResponse<String> httpResponse = attributes.removeASingleAttribute(entityId, attrName, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
