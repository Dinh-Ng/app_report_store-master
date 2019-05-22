package com.zero.rua.reporttracking;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class test {

    OkHttpClient client = new OkHttpClient.Builder()
            .protocols(Arrays.asList(Protocol.HTTP_1_1))
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//                    Request.Builder requestBuilder = request.newBuilder();
//                    RequestBody formBody = new FormEncodingBuilder()
//                            .add("email", "Jurassic@Park.com")
//                            .add("tel", "90301171XX")
//                            .build();
//                    String postBodyString = Utils.bodyToString(request.body());
//                    postBodyString += ((postBodyString.length() > 0) ? "&" : "") + Utils.bodyToString(formBody);
//                    request = requestBuilder
//                            .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString))
//                            .build();
//                    return chain.proceed(request);
                    return null;
                }
            })
            .build();

    public static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
