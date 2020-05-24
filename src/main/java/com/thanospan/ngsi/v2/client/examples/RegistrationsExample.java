package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.RegistrationsApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class RegistrationsExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        RegistrationsApi registrationsApi = new RegistrationsApi(apiClient);

        listRegistrations(registrationsApi);
//        createRegistration(registrationsApi);
//        retrieveRegistration(registrationsApi);
//        updateRegistration(registrationsApi);
//        deleteRegistration(registrationsApi);
    }

    private static void listRegistrations(RegistrationsApi registrationsApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = registrationsApi.listRegistrations(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createRegistration(RegistrationsApi registrationsApi) {
        String contentType = "application/json";
        String body = "{\"description\":\"Relative Humidity Context Source\",\"dataProvided\":{\"entities\":[{\"id\":\"room2\",\"type\":\"Room\"}],\"attrs\":[\"relativeHumidity\"]},\"provider\":{\"http\":{\"url\":\"http://localhost:1234\"}}}";
        HttpResponse<String> httpResponse = registrationsApi.createRegistration(contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveRegistration(RegistrationsApi registrationsApi) {
        String registrationId = "5ec2fe0b35882942c129804e";
        HttpResponse<String> httpResponse = registrationsApi.retrieveRegistration(registrationId).join();
        printHttpResponse(httpResponse);
    }

    private static void updateRegistration(RegistrationsApi registrationsApi) {
        String registrationId = "5ec2fe0b35882942c129804e";
        String contentType = "application/json";
        String body = "{\"expires\":\"2017-10-04T00:00:00\"}";
        HttpResponse<String> httpResponse = registrationsApi.updateRegistration(registrationId, contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void deleteRegistration(RegistrationsApi registrationsApi) {
        String registrationId = "5ec2fe0b35882942c129804e";
        HttpResponse<String> httpResponse = registrationsApi.deleteRegistration(registrationId).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
