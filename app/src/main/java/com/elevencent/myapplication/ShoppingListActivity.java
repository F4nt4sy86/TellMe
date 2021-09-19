package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ShoppingListActivity extends AppCompatActivity {
    
    ItemList itemList;
    ChipGroup chipGroup;
    TextView title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);
        
        itemList = getIntent().getParcelableExtra("ItemList");
        
        title = findViewById(R.id.concrete_title);
        title.setText(itemList.getName());
        chipGroup = findViewById(R.id.chip_group);
        for (Item item : itemList.getItemArrayList()) {
            Chip chip = new Chip(this);
            chip.setText(item.getName());
            chip.setCheckable(true);
            chipGroup.addView(chip);
        }
    }
}