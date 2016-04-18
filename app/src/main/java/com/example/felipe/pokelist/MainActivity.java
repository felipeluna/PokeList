package com.example.felipe.pokelist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.felipe.pokelist.communication.GetREST;
import com.example.felipe.pokelist.communication.Pokemon;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // list where the items will be loaded
        new AsyncTask<Void, Void,List<Pokemon>>(){
            OkHttpClient client = new OkHttpClient();
            @Override
            protected List<Pokemon> doInBackground(Void... params) {
                GetREST get = new GetREST("http://shuffle-server.herokuapp.com/api/pokemons");
                List<Pokemon> lista = get.getPoke();
                return lista;
            }
            protected void onPostExecute(List<Pokemon> lista){
                pokemonAdapter = new PokemonAdapter(getApplicationContext(), lista);
            }

        };
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
