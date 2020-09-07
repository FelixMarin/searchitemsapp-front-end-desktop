package com.sia.desktop.model.apiconnect;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetConnection {
	
	private OkHttpClient client;
	
   public GetConnection() {
	   client  = new OkHttpClient();
   }

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } 
    }
}
