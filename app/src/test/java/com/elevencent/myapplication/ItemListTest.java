package com.elevencent.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.UUID;

public class ItemListTest {
    @Test
    public void itemListSortTest() {
        ItemList itemList = new ItemList("list", UUID.randomUUID());
        Item p1 = new Item("Product1");
        Item p2 = new Item("Product2");
        Item p3 = new Item("Product3");
        Item p4 = new Item("Product4");
        Item p5 = new Item("Product5");
        Item p6 = new Item("Product6");
        itemList.getItemArrayList().add(p1);
        itemList.getItemArrayList().add(p2);
        itemList.getItemArrayList().add(p3);
        itemList.getItemArrayList().add(p4);
        itemList.getItemArrayList().add(p5);
        itemList.getItemArrayList().add(p6);
        
        itemList.getItemArrayList().get(2).setChecked(true);
        itemList.sortByChecked();
        assertEquals(itemList.getItemArrayList().get(5),p3);
    }
}
