package com.example.felipe.pokelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.felipe.pokelist.communication.Pokemon;
import com.squareup.picasso.Picasso;

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
//        MyViewHolder holder = new MyViewHolder(view);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // load the url in the Pokemon class into a Picasso object
        Picasso.with(context)
                .load(lista.get(position).getImg())
                .resize(300,300)
                .into(holder.pImage);
        holder.pName.setText(lista.get(position).getName());
        holder.pType.setText(lista.get(position).getType());
        holder.pAbility.setText(lista.get(position).getAbility());
        holder.pNumber.setText(lista.get(position).getNumber());
    }
    //TODO
    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pNumber;
        TextView pName;
        ImageView pImage;
        TextView pType;
        TextView pAbility;
        public MyViewHolder(View itemView) {
            super(itemView);
            pImage = (ImageView) itemView.findViewById(R.id.poke_image);
            pType = (TextView) itemView.findViewById(R.id.poke_type);
            pName = (TextView) itemView.findViewById(R.id.poke_name);
            pNumber = (TextView) itemView.findViewById(R.id.poke_number);
            pAbility = (TextView) itemView.findViewById(R.id.poke_ability);
        }
    }
}
