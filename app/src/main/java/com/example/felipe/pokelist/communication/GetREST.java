package com.example.felipe.pokelist.communication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by felipe on 18/04/16.
 */

public class GetREST {

    public String url;
    OkHttpClient client = new OkHttpClient();

    public GetREST(String url) {
        this.url = url;
    }


    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public List<Pokemon> getPoke() {
        String jsonArray = null;
        try {
            jsonArray = run(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject js = null;
        Gson gs = new Gson();
        Type listType = new TypeToken<ArrayList<Pokemon>>() {}.getType();
        List<Pokemon> lista = new Gson().fromJson(jsonArray, listType);
        return lista;
    }
}