package com.elevencent.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elevencent.myapplication.ItemList;
import com.elevencent.myapplication.R;
import com.elevencent.myapplication.ShoppingListActivity;

import java.util.LinkedList;

public class ADAPTER_ShoppingLists extends RecyclerView.Adapter<ADAPTER_ShoppingLists.MyViewHolder> {
    
    LinkedList<ItemList> listOfLists;
    Context context;
    
    public ADAPTER_ShoppingLists(Context context, LinkedList<ItemList> listOfLists) {
        this.context = context;
        this.listOfLists = listOfLists;
    }
    
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_shoppinglist, parent, false);
        return new MyViewHolder(view);
    }
    
    /**
     * Initialises the ViewHolder and gives it a clickListener.
     *
     * @param holder The ViewHolder to populate.
     * @param index  The index of the ViewHolder.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int index) {
        holder.title.setText(listOfLists.get(holder.getAdapterPosition()).getName());
        
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ShoppingListActivity.class);
            intent.putExtra("ItemList", listOfLists.get(holder.getAdapterPosition()));
            context.startActivity(intent);
        });
    }
    
    @Override
    public int getItemCount() {
        return listOfLists.size();
    }
    
    
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
        }
    }
    
}
