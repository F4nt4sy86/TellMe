package com.elevencent.myapplication;

public class Item {
    private String itemName;
    private int itemCount;

    public Item(String itemName) {
        try {
            changeItemName(itemName);
        } catch (InvalidNameForItemException e) {
            e.getCause();
            e.printStackTrace();
        }
        this.itemCount = 1;
    }

    public void increaseItemCount(int numberToAdd) throws InvalidNumberToAddException {
        if (numberToAdd < 1) {
            System.out.println("Cannot add a number smaller than 1.");
            throw new InvalidNumberToAddException();
        } else this.itemCount += numberToAdd;
    }

    public void decreaseItemCount(int numberToSubtract) throws InvalidNumberToAddException {
        if (numberToSubtract < 1) {
            System.out.println("Cannot subtract a number smaller than 1.");
            throw new InvalidNumberToAddException();
        } else this.itemCount -= numberToSubtract;
    }

    public void changeItemName(String newItemName) throws InvalidNameForItemException {
        if (newItemName == null || newItemName.trim().isEmpty()) {
            System.out.println("Cannot change item-name to empty string.");
            throw new InvalidNameForItemException();
        } else this.itemName = newItemName.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCount() {
        return itemCount;
    }
}