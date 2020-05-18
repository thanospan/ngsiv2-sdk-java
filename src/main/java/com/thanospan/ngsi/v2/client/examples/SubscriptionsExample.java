package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.Subscriptions;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class SubscriptionsExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Subscriptions subscriptions = new Subscriptions(apiClient);

        listSubscriptions(subscriptions);
//        createSubscription(subscriptions);
//        retrieveSubscription(subscriptions);
//        updateSubscription(subscriptions);
//        deleteSubscription(subscriptions);
    }

    private static void listSubscriptions(Subscriptions subscriptions) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = subscriptions.listSubscriptions(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createSubscription(Subscriptions subscriptions) {
        String contentType = "application/json";
        String body = "{\"description\":\"One subscription to rule them all\",\"subject\":{\"entities\":[{\"idPattern\":\".*\",\"type\":\"Room\"}],\"condition\":{\"attrs\":[\"temperature\"],\"expression\":{\"q\":\"temperature>40\"}}},\"notification\":{\"http\":{\"url\":\"http://localhost:1234\"},\"attrs\":[\"temperature\",\"humidity\"]},\"expires\":\"2016-04-05T14:00:00.00Z\",\"throttling\":5}";
        HttpResponse<String> httpResponse = subscriptions.createSubscription(contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveSubscription(Subscriptions subscriptions) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        HttpResponse<String> httpResponse = subscriptions.retrieveSubscription(subscriptionId).join();
        printHttpResponse(httpResponse);
    }

    private static void updateSubscription(Subscriptions subscriptions) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        String contentType = "application/json";
        String body = "{\"expires\":\"2017-04-05T14:00:00.00Z\"}";
        HttpResponse<String> httpResponse = subscriptions.updateSubscription(subscriptionId, contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void deleteSubscription(Subscriptions subscriptions) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        HttpResponse<String> httpResponse = subscriptions.deleteSubscription(subscriptionId).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
