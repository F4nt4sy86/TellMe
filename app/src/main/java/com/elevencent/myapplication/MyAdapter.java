package com.elevencent.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] titles;
    Context context;

    public MyAdapter(Context context, String[] titles) {
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_shoppinglist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int index) {
        holder.title.setText(titles[holder.getAdapterPosition()]);
        Intent intent = new Intent(context, ShoppingListActivity.class);
        holder.itemView.setOnClickListener(view -> context.startActivity(intent));
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
        }
    }

}
