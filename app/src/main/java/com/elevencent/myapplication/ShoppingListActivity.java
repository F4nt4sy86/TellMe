package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class ShoppingListActivity extends AppCompatActivity {
    
    ItemList itemList;
    ChipGroup chipGroup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);
        
        //itemList = getIntent().getParcelableExtra("ItemList");
        
        itemList = getIntent().getParcelableExtra("ItemList");
        
        TextView title = findViewById(R.id.concrete_title);
        title.setText(itemList.getName());
        
        
    }
}