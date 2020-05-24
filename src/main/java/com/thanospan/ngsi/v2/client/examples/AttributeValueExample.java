package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.AttributeValueApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class AttributeValueExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        AttributeValueApi attributeValueApi = new AttributeValueApi(apiClient);

        getAttributeValue(attributeValueApi);
//        updateAttributeValue(attributeValueApi);
    }

    private static void getAttributeValue(AttributeValueApi attributeValueApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        String attrName = "location";
        HttpResponse<String> httpResponse = attributeValueApi.getAttributeValue(entityId, attrName, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateAttributeValue(AttributeValueApi attributeValueApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";

        // Content-Type: text/plain
        String attrName = "humidity";
        String contentType = "text/plain";
        String body = "30";

        // Content-Type: application/json
//        String attrName = "location";
//        String contentType = "application/json";
//        String body = "{\"address\":\"Ronda de la Comunicacion s/n\",\"zipCode\":28050,\"city\":\"Madrid\",\"country\":\"Spain\"}";

        HttpResponse<String> httpResponse = attributeValueApi.updateAttributeValue(entityId, attrName, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
