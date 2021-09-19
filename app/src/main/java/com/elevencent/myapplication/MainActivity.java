package com.elevencent.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.elevencent.myapplication.adapters.ADAPTER_ShoppingLists;

import java.util.LinkedList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    
    LinkedList<ItemList> listOfLists;
    ItemList itemList1;
    ItemList itemList2;
    ItemList itemList3;
    UUID user;
    Button button;
    RecyclerView recyclerView;
    EditText editText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        recyclerView = findViewById(R.id.recycler_view_of_shopping_lists);
        //Beginning temporary, hardcoded lists.
        listOfLists = new LinkedList<>();
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
        //End
        editText = findViewById(R.id.add_item_textfield);
        user = UUID.randomUUID();
        button = findViewById(R.id.Add_ItemList);
        button.setOnClickListener(view -> listOfLists.add(new ItemList(editText.getText().toString(), UUID.randomUUID())));
        
        
        
        ADAPTER_ShoppingLists adapter = new ADAPTER_ShoppingLists(this, listOfLists);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
        });
    }
    
}