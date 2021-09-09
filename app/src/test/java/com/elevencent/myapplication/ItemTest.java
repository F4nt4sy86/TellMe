package com.elevencent.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void itemIncrease() {
        Item item = new Item("item");
        assertEquals(1, item.getItemCount());

        try {
            item.increaseItemCount(1);
        } catch (InvalidNumberToAddException ignored) {
        }
        assertEquals(2, item.getItemCount());
    }

    @Test
    public void illegalItemIncrease() {
        Item item = new Item("item");
        assertThrows(InvalidNumberToAddException.class, () -> item.increaseItemCount(0));
        assertThrows(InvalidNumberToAddException.class, () -> item.increaseItemCount(-6));
    }

    @Test
    public void itemNameChange() {
        Item item = new Item("item");
        assertEquals("item", item.getItemName());

        try {
            item.changeItemName("item1");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item1", item.getItemName());

        try {
            item.changeItemName("   item2   ");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item2", item.getItemName());

        try {
            item.changeItemName("           item3                     ");
        } catch (InvalidNameForItemException ignored) {
        }
        assertEquals("item3", item.getItemName());

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
