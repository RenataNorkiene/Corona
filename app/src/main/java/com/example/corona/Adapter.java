package com.example.corona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> { //praplecia recycleview klase
    private Context context;
    private LayoutInflater inflater;
    List<Corona> data; //data perduodama adapteriui per konstruktoriu

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Corona> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//sukuria vaizdo container/kortele
        View view = inflater.inflate(R.layout.container_corona, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data(sukurus container i ji sudedame visa data kuria perduodame)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;

        Corona current = data.get(position); //elelemntu indexas sarase, kuria kortele ir ja numeruoja tais paciais index kurie yra sarase
        //uzpildysime kortele duomenimis is saraso:
        myHolder.textKeyId.setText(current.getKeyId());
        myHolder.textLastUpdate.setText("Last Update: " + current.getLastUpdate());
        myHolder.textConfirmed.setText("Confirmed: " + current.getConfirmed());
        myHolder.textDeaths.setText("Deaths: " + current.getDeaths());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    } //galima atspausdinti kiek is viso irasu yra


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //kad butu galima paspaudus uzkrauti kortele naujame lange
        TextView textKeyId;
        TextView textLastUpdate;
        TextView textConfirmed;
        TextView textDeaths;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textKeyId = (TextView) itemView.findViewById(R.id.textKeyId);
            textLastUpdate = (TextView) itemView.findViewById(R.id.textLastUpdate);
            textConfirmed = (TextView) itemView.findViewById(R.id.textConfirmed);
            textDeaths = (TextView) itemView.findViewById(R.id.textDeaths);
            itemView.setOnClickListener(this);
        }

        // Click event for all items(paspaudus ant bet kokios korteles bus tas pats pranesimas)
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        }
    }
}
