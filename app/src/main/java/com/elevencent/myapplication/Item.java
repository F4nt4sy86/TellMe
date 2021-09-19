package com.elevencent.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name;
    
    public Item(String name) {
        this.name=name;
    }
    
    protected Item(Parcel in) {
        name = in.readString();
    }
    
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            //Order to read/write from/to parcel: itemName, itemCount
            String name = in.readString();
            return new Item(name);
        }
        
        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    
    public void changeItemName(String newItemName) throws InvalidNameForItemException {
        if (newItemName == null || newItemName.trim().isEmpty()) {
            System.out.println("Cannot change item-name to empty string.");
            throw new InvalidNameForItemException();
        } else this.name = newItemName.trim();
    }
    
    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //Order to read/write from/to parcel: itemName, itemCount
        parcel.writeString(name);
    }
}