package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class ShoppingListActivity extends AppCompatActivity {
    
    ItemList itemList;
    ChipGroup chipGroup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);
        
        Intent intent = getIntent();
        itemList = intent.getParcelableExtra("ItemList");
        
        TextView title = findViewById(R.id.concrete_title);
        title.setText(itemList.getName());
        
        
    }
}