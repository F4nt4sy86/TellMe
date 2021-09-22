package com.elevencent.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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
    EditText editText;
    Button addItemButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);
        
        //Connecting interface-logic to xml-elements.
        itemList = getIntent().getParcelableExtra("ItemList");
        title = findViewById(R.id.concrete_title);
        editText = findViewById(R.id.add_item_textfield);
        chipGroup = findViewById(R.id.chip_group);
        
        //Initializing ChipGroup with all items in it.
        addItemButton = findViewById(R.id.add_item_button);
        for (Item item : itemList.getItemArrayList()) {
            Chip chip = new Chip(this);
            chip.setCheckable(true);
            chip.setText(item.getName());
            chip.setOnCheckedChangeListener((compoundButton, b) -> {
                if (!compoundButton.isChecked()) {
                    item.setChecked();
                    chipGroup.removeView(chip);
                    chipGroup.addView(chip, 0);
                } else {
                    item.setUnchecked();
                    chipGroup.removeView(chip);
                    chipGroup.addView(chip);
                }
            });
            chipGroup.addView(chip);
        }
        
        //OnClickListener for add-item-button.
        addItemButton.setOnClickListener(view -> {
            String itemName = editText.getText().toString().trim();
            if (!itemName.equals("")) {
                boolean itemNameAlreadyTaken = false;
                for (Item item : itemList.getItemArrayList()) {
                    if (item.getName().equals(itemName)) {
                        itemNameAlreadyTaken = true;
                        break;
                    }
                }
                if (!itemNameAlreadyTaken) {
                    Item item = new Item(editText.getText().toString());
                    itemList.getItemArrayList().add(item);
                    Chip chip = new Chip(this);
                    chip.setText(item.getName());
                    chip.setCheckable(true);
                    chip.setOnCheckedChangeListener((compoundButton, b) -> {
                        if (!compoundButton.isChecked()) {
                            item.setChecked();
                            chipGroup.removeView(chip);
                            chipGroup.addView(chip, 0);
                        } else {
                            item.setUnchecked();
                            chipGroup.removeView(chip);
                            chipGroup.addView(chip);
                        }
                    });
                    chipGroup.addView(chip);
                    editText.setText("");
                }
            }
        });
        title.setText(itemList.getName());
    }
}