package com.thanospan.ngsi.v2.client.examples;

import com.thanospan.ngsi.v2.client.ApiClient;
import com.thanospan.ngsi.v2.client.api.SubscriptionsApi;

import java.net.http.HttpResponse;
import java.util.HashMap;

public class SubscriptionsApiExample {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        SubscriptionsApi subscriptionsApi = new SubscriptionsApi(apiClient);

        listSubscriptions(subscriptionsApi);
//        createSubscription(subscriptionsApi);
//        retrieveSubscription(subscriptionsApi);
//        updateSubscription(subscriptionsApi);
//        deleteSubscription(subscriptionsApi);
    }

    private static void listSubscriptions(SubscriptionsApi subscriptionsApi) {
        HashMap<String, String> parameters = new HashMap<>();
//        parameters.put("limit", "10");
//        parameters.put("offset", "20");
//        parameters.put("options", "count");
        HttpResponse<String> httpResponse = subscriptionsApi.listSubscriptions(parameters).join();
        printHttpResponse(httpResponse);
    }

    private static void createSubscription(SubscriptionsApi subscriptionsApi) {
        String contentType = "application/json";
        String body = "{\"description\":\"One subscription to rule them all\",\"subject\":{\"entities\":[{\"idPattern\":\".*\",\"type\":\"Room\"}],\"condition\":{\"attrs\":[\"temperature\"],\"expression\":{\"q\":\"temperature>40\"}}},\"notification\":{\"http\":{\"url\":\"http://localhost:1234\"},\"attrs\":[\"temperature\",\"humidity\"]},\"expires\":\"2016-04-05T14:00:00.00Z\",\"throttling\":5}";
        HttpResponse<String> httpResponse = subscriptionsApi.createSubscription(contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void retrieveSubscription(SubscriptionsApi subscriptionsApi) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        HttpResponse<String> httpResponse = subscriptionsApi.retrieveSubscription(subscriptionId).join();
        printHttpResponse(httpResponse);
    }

    private static void updateSubscription(SubscriptionsApi subscriptionsApi) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        String contentType = "application/json";
        String body = "{\"expires\":\"2017-04-05T14:00:00.00Z\"}";
        HttpResponse<String> httpResponse = subscriptionsApi.updateSubscription(subscriptionId, contentType, body).join();
        printHttpResponse(httpResponse);
    }

    private static void deleteSubscription(SubscriptionsApi subscriptionsApi) {
        String subscriptionId = "5ec2f4a335882942c129804d";
        HttpResponse<String> httpResponse = subscriptionsApi.deleteSubscription(subscriptionId).join();
        printHttpResponse(httpResponse);
    }

    private static void printHttpResponse(HttpResponse<String> httpResponse) {
        System.out.println(httpResponse.request());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.headers().map());
        System.out.println(httpResponse.body());
    }
}
