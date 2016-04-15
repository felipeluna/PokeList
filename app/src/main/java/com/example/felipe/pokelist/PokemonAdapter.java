package com.example.felipe.pokelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by felipe on 4/14/16.
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {


    private Context context;
    private List<Pokemon> lista;
    private LayoutInflater inflater;

    public PokemonAdapter(Context context, List<Pokemon> lista) {
        this.context = context;
        this.lista = lista;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.pokemon_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.pName.setText(lista.get(position).name);
        holder.pNumber.setText(lista.get(position).number+ " ");
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pNumber;
        TextView pName;

        public MyViewHolder(View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.poke_name);
            pNumber = (TextView) itemView.findViewById(R.id.poke_number);
        }
    }
}
