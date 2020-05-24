package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.BatchOperationsApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class BatchOperationsExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        BatchOperationsApi batchOperationsApi = new BatchOperationsApi(apiClient);

        update(batchOperationsApi);
//        query(batchOperationsApi);
//        notify(batchOperationsApi);
    }

    private static void update(BatchOperationsApi batchOperationsApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("options", "keyValues");
        String contentType = "application/json";
        String body = "{\"actionType\":\"append\",\"entities\":[{\"type\":\"Room\",\"id\":\"Bcn-Welt\",\"temperature\":{\"value\":21.7},\"humidity\":{\"value\":60}},{\"type\":\"Room\",\"id\":\"Mad_Aud\",\"temperature\":{\"value\":22.9},\"humidity\":{\"value\":85}}]}";
        HttpResponse<String> httpResponse = batchOperationsApi.update(contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void query(BatchOperationsApi batchOperationsApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("orderBy", "temperature,!speed");
//        parameters.put("options", "count");
        String contentType = "application/json";
        String body = "{\"entities\":[{\"idPattern\":\".*\",\"type\":\"Room\"},{\"id\":\"Car\",\"type\":\"P-9873-K\"}],\"attrs\":[\"temperature\",\"humidity\"],\"expression\":{\"q\":\"temperature>20\"},\"metadata\":[\"accuracy\",\"timestamp\"]}";
        HttpResponse<String> httpResponse = batchOperationsApi.query(contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void notify(BatchOperationsApi batchOperationsApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("options", "keyValues");
        String contentType = "application/json";
        String body = "{\"subscriptionId\":\"5aeb0ee97d4ef10a12a0262f\",\"data\":[{\"type\":\"Room\",\"id\":\"DC_S1-D41\",\"temperature\":{\"value\":35.6,\"type\":\"Number\"}},{\"type\":\"Room\",\"id\":\"Boe-Idearium\",\"temperature\":{\"value\":22.5,\"type\":\"Number\"}}]}";
        HttpResponse<String> httpResponse = batchOperationsApi.notify(contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
