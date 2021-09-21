package com.elevencent.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.elevencent.myapplication.Item;
import com.elevencent.myapplication.ItemList;
import com.elevencent.myapplication.R;
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
        itemList.sortByChecked();
        title = findViewById(R.id.concrete_title);
        title.setText(itemList.getName());
        chipGroup = findViewById(R.id.chip_group);
        for (Item item : itemList.getItemArrayList()) {
            Chip chip = new Chip(this);
            chip.setText(item.getName());
            chip.setOnClickListener(view -> {
                //TODO: Finish implementation.
                // # Chips need to be visually checked.
                // # ChipGroup needs to visually update corresponding to itemList.
                // # On long hold on chip it needs to be deleted.
                item.setChecked(!item.getChecked());
                itemList.sortByChecked();
            });
            chipGroup.addView(chip);
        }
    }
}