package com.elevencent.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    
    @Test
    public void itemNameChange() {
        Item item = new Item("item");
        assertEquals("item", item.getName());
        
        try {
            item.changeItemName("item1");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item1", item.getName());
        
        try {
            item.changeItemName("   item2   ");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item2", item.getName());
        
        try {
            item.changeItemName("           item3                     ");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item3", item.getName());
        
    }
    
    @Test
    public void illegalItemNameChange() {
        Item item = new Item("item");
        
        assertThrows(InvalidNameForItemException.class, () -> item.changeItemName(null));
        assertThrows(InvalidNameForItemException.class, () -> item.changeItemName(""));
        assertThrows(InvalidNameForItemException.class, () -> item.changeItemName("    "));
        assertThrows(InvalidNameForItemException.class, () -> item.changeItemName("             "));
        assertThrows(InvalidNameForItemException.class, () -> item.changeItemName("                  "));
    }
}
