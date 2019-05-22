package com.zero.rua.reporttracking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class NetworkUtil {

    private final OkHttpClient.Builder client;

    {
        client = new OkHttpClient.Builder();
        client.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                if (responseCount(response) >= 3) {
                    return null; // If we've failed 3 times, give up. - in real life, never give up!!
                }
                String credential = Credentials.basic("name", "password");
                return response.request().newBuilder().header("Authorization", credential).build();
            }
        });
        client.connectTimeout(10, TimeUnit.SECONDS);
        client.writeTimeout(10, TimeUnit.SECONDS);
        client.readTimeout(30, TimeUnit.SECONDS);
    }

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }

}