package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.Entities;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class EntitiesExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Entities entities = new Entities(apiClient);

        listEntities(entities);
//        createEntity(entities);
//        retrieveEntity(entities);
//        retrieveEntityAttributes(entities);
//        updateOrAppendEntityAttributes(entities);
//        updateExistingEntityAttributes(entities);
//        replaceAllEntityAttributes(entities);
//        removeEntity(entities);
    }

    private static void listEntities(Entities entities) {
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
        HttpResponse<String> httpResponse = entities.listEntities(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createEntity(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("options", "keyValues");
        String contentType = "application/json";
        String body = "{\"type\":\"Room\",\"id\":\"Bcn-Welt\",\"temperature\":{\"value\":21.7},\"humidity\":{\"value\":60},\"location\":{\"value\":\"41.3763726, 2.1864475\",\"type\":\"geo:point\",\"metadata\":{\"crs\":{\"value\":\"WGS84\"}}}}";
        HttpResponse<String> httpResponse = entities.createEntity(contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntity(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("attrs", "temperature,humidity");
//        parameters.put("metadata", "accuracy");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entities.retrieveEntity(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveEntityAttributes(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("attrs", "temperature,humidity");
//        parameters.put("metadata", "accuracy");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entities.retrieveEntityAttributes(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateOrAppendEntityAttributes(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "append");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"ambientNoise\":{\"value\":31.5}}";
        HttpResponse<String> httpResponse = entities.updateOrAppendEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void updateExistingEntityAttributes(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"temperature\":{\"value\":25.5}}";
        HttpResponse<String> httpResponse = entities.updateExistingEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void replaceAllEntityAttributes(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
//        parameters.put("options", "keyValues");
        String entityId = "Bcn-Welt";
        String contentType = "application/json";
        String body = "{\"temperature\":{\"value\":25.5},\"seatNumber\":{\"value\":6}}";
        HttpResponse<String> httpResponse = entities.replaceAllEntityAttributes(entityId, contentType, body, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void removeEntity(Entities entities) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("type", "Room");
        String entityId = "Bcn-Welt";
        HttpResponse<String> httpResponse = entities.removeEntity(entityId, parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
