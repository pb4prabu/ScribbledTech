package com.scribbledtech.router.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpService {

    private final OkHttpClient client;

    public OkHttpService() {
        this.client = new OkHttpClient();
    }

    public String callExternalService(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            // Ensure the response body is closed
            return response.body() != null ? response.body().string() : null;
        }
    }
}
