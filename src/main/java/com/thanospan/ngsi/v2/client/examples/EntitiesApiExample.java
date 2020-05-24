package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.EntitiesApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class EntitiesApiExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        EntitiesApi entitiesApi = new EntitiesApi(apiClient);

        listEntities(entitiesApi);
//        createEntity(entitiesApi);
//        retrieveEntity(entitiesApi);
//        retrieveEntityAttributes(entitiesApi);
//        updateOrAppendEntityAttributes(entitiesApi);
//        updateExistingEntityAttributes(entitiesApi);
//        replaceAllEntityAttributes(entitiesApi);
//        removeEntity(entitiesApi);
    }

    private static void listEntities(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("id", "Boe_Idearium");
//        parameters.put("type", "Room");
//        parameters.put("idPattern", "Bode_.*");
//        parameters.put("typePattern", "Room_.*");
//        parameters.put("q", "temperature%3E40");
//        parameters.put("mq", "temperature.accuracy%3C0.9");
//        parameters.put("georel", "near");
//        parameters.put("geometry", "point");
//        parameters.put("coords", "41.390205%2C2.154007%3B48.8566%2C2.3522");
//        parameters.put("limit", "20");
//        parameters.put("offset", "20");
//        parameters.put("attrs", "seatNumber");
//        parameters.put("metadata", "accuracy");
//        parameters.put("orderBy", "temperature@2C!speed");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = entitiesApi.listEntities(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createEntity(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("options", "keyValues");
        String contentType = "application/json";
        String body = "{\"type\":\"Room\",\"id\":\"Bcn-Welt\",\"temperature\":{\"value\":21.7},\"humidity\":{\"value\":60},\"location\":{\"value\":\"41.3763726, 2.1864475\",\"type\":\"geo:point\",\"metadata\":{\"crs\":{\"value\":\"WGS84\"}}}}";
        HttpResponse<String> httpResponse = entitiesApi.createEntity(contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntity(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("attrs", "temperature,humidity");
//        parameters.put("metadata", "accuracy");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entitiesApi.retrieveEntity(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntityAttributes(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("attrs", "temperature,humidity");
//        parameters.put("metadata", "accuracy");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entitiesApi.retrieveEntityAttributes(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateOrAppendEntityAttributes(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "append");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"ambientNoise\":{\"value\":31.5}}";
        HttpResponse<String> httpResponse = entitiesApi.updateOrAppendEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateExistingEntityAttributes(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"temperature\":{\"value\":25.5}}";
        HttpResponse<String> httpResponse = entitiesApi.updateExistingEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void replaceAllEntityAttributes(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"temperature\":{\"value\":25.5},\"seatNumber\":{\"value\":6}}";
        HttpResponse<String> httpResponse = entitiesApi.replaceAllEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void removeEntity(EntitiesApi entitiesApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entitiesApi.removeEntity(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
