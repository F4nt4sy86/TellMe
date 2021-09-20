package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.elevencent.myapplication.adapters.ADAPTER_ShoppingLists;
import com.google.android.material.chip.Chip;

import java.util.LinkedList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    
    LinkedList<ItemList> listOfLists;
    ItemList itemList1;
    ItemList itemList2;
    ItemList itemList3;
    UUID user;
    Button addNewShoppingList;
    RecyclerView recyclerView;
    EditText editText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting up relevant items and data.
        user = UUID.randomUUID();
        recyclerView = findViewById(R.id.recycler_view_of_shopping_lists);
        listOfLists = new LinkedList<>();
        
        //Hardcoded shopping-lists for temporary testing.
        ADAPTER_ShoppingLists adapter = new ADAPTER_ShoppingLists(this, listOfLists);
        itemList1 = new ItemList("Aktiv", user);
        itemList2 = new ItemList("Rossmann", user);
        itemList3 = new ItemList("Ikea", user);
        listOfLists.add(itemList1);
        listOfLists.add(itemList2);
        listOfLists.add(itemList3);
        
        itemList1.getItemArrayList().add(new Item("Brot"));
        itemList1.getItemArrayList().add(new Item("Milch"));
        itemList1.getItemArrayList().add(new Item("Eier"));
        itemList1.getItemArrayList().add(new Item("Nutella"));
        
        itemList2.getItemArrayList().add(new Item("Shampoo"));
        itemList2.getItemArrayList().add(new Item("Handseife"));
        itemList2.getItemArrayList().add(new Item("Wattestäbchen"));
        itemList2.getItemArrayList().add(new Item("Essigreiniger"));
        
        itemList3.getItemArrayList().add(new Item("Teller"));
        itemList3.getItemArrayList().add(new Item("Gläser"));
        itemList3.getItemArrayList().add(new Item("Schokolade"));
        itemList3.getItemArrayList().add(new Item("Hotdog"));
        
        //EditText for giving new Shopping-lists their names.
        editText = findViewById(R.id.new_shopping_list_name);
        editText.setEnabled(true);
        
        //Button for adding new shopping-lists.
        addNewShoppingList = findViewById(R.id.Add_ItemList);
        addNewShoppingList.setOnClickListener(view -> {
            if (editText.getText().toString().isEmpty()) {
                return;
            }
            String listName = editText.getText().toString();
            boolean nameAlreadyExists = false;
            for (ItemList itemList : listOfLists) {
                if (itemList.getName().equals(listName)) {
                    nameAlreadyExists = true;
                    break;
                }
            }
            if (!nameAlreadyExists) {
                listOfLists.add(new ItemList(listName, UUID.randomUUID()));
                adapter.notifyItemInserted(listOfLists.size());
                editText.setText("");
            }
        });
        
        //Adapter of recyclerview.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
        });
    }
    
}