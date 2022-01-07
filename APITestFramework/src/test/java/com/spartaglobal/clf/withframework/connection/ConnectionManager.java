package com.spartaglobal.clf.withframework.connection;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

public class ConnectionManager {
    private static final String BASEURL = "https://www.boredapi.com/api/activity";

    public static String getConnectionForGivenNumberOfParticipants(int participants) {
        return BASEURL + "?participants=" + participants;
    }

    public static String getConnection() {
        return BASEURL ;
    }

    public static String getConnection(int key) {
        return BASEURL + "?key=" + key;
    }


    // add more getConnection methods for different endpoint

    public static int getStatusCode(String connection) {
        HttpResponse<String> httpResponse = getStringHttpResponse(connection);
        return httpResponse.statusCode();
    }

    // add a method to return the headers
    /// or methods to return the values of a particular header key

    public static String getHeader(String connection, String key) {
        HttpResponse<String> httpResponse = getStringHttpResponse(connection);
        return httpResponse.headers().map().get(key).get(0);
    }

    private static HttpResponse<String> getStringHttpResponse(String connection) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(create(connection))
                .build();
        HttpResponse<String> httpResponse = null;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
}
