package com.example.felipe.pokelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Pokemon a = new Pokemon(1, R.drawable.poke_001, "Bulbasaur", "Grass");
        Pokemon b = new Pokemon(2, R.drawable.poke_002, "Ivysaur", "Grass");
        Pokemon c = new Pokemon(3, R.drawable.poke_003, "Venosaur", "Grass");

        List<Pokemon>  lista = new ArrayList<>();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        pokemonAdapter = new PokemonAdapter(this, lista);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
