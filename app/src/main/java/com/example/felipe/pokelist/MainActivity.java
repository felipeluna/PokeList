package com.example.felipe.pokelist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.felipe.pokelist.communication.Pokemon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokeTask mPokemonTask = new PokeTask();
    private PokemonAdapter pokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // list where the items will be loaded
        mPokemonTask.execute();

    }

    private class PokeTask extends AsyncTask<Void,Void , List<Pokemon>> {

        @Override
        protected List<Pokemon> doInBackground(Void... params) {
            OkHttpClient client = new OkHttpClient();
            String url = "http://shuffle-server.herokuapp.com/api/pokemons/";
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = null;
            String json = null;
            try {
                response = client.newCall(request).execute();
                json = response.body().string();
                Log.d("MainActivity", "Json results " + json);
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("Request", "response erro");
            }

            if (response != null) {
                Log.d("pokemon", "Response: " + response.body().toString());
            }
            Type listType = new TypeToken<ArrayList<Pokemon>>() {
            }.getType();
            return new Gson().fromJson(json, listType);
        }

        protected void onPostExecute(List<Pokemon> lista){
            Log.d("PostExecute", lista.toString());
            pokemonAdapter = new PokemonAdapter(getApplicationContext(), lista);
            pokemonAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(pokemonAdapter);
        }
    }

}
