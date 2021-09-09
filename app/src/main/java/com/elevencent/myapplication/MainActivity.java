package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    String[] listTitles;
    String[] list1;
    String[] list2;
    String[] list3;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTitles = new String[]{"Aldi", "Rossmann", "Aktiv"};
        list1 = new String[]{"Eier", "Tomaten"};
        list2 = new String[]{"Deo", "Spülung"};
        list3 = new String[]{"Milch", "Kuchen", "Eier", "Käse", "Shampoo"};

        recyclerView = findViewById(R.id.recycler_view_of_shopping_lists);

        MyAdapter myAdapter = new MyAdapter(this, listTitles);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
        });
    }
}