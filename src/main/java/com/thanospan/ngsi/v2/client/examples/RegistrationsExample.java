package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.Registrations;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class RegistrationsExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Registrations registrations = new Registrations(apiClient);

        listRegistrations(registrations);
//        createRegistration(registrations);
//        retrieveRegistration(registrations);
//        updateRegistration(registrations);
//        deleteRegistration(registrations);
    }

    private static void listRegistrations(Registrations registrations) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = registrations.listRegistrations(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createRegistration(Registrations registrations) {
        String contentType = "application/json";
        String body = "{\"description\":\"Relative Humidity Context Source\",\"dataProvided\":{\"entities\":[{\"id\":\"room2\",\"type\":\"Room\"}],\"attrs\":[\"relativeHumidity\"]},\"provider\":{\"http\":{\"url\":\"http://localhost:1234\"}}}";
        HttpResponse<String> httpResponse = registrations.createRegistration(contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveRegistration(Registrations registrations) {
        String registrationId = "5ec2fe0b35882942c129804e";
        HttpResponse<String> httpResponse = registrations.retrieveRegistration(registrationId).join();
        printHttpResponse(httpResponse);
    }

    private static void updateRegistration(Registrations registrations) {
        String registrationId = "5ec2fe0b35882942c129804e";
        String contentType = "application/json";
        String body = "{\"expires\":\"2017-10-04T00:00:00\"}";
        HttpResponse<String> httpResponse = registrations.updateRegistration(registrationId, contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void deleteRegistration(Registrations registrations) {
        String registrationId = "5ec2fe0b35882942c129804e";
        HttpResponse<String> httpResponse = registrations.deleteRegistration(registrationId).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
