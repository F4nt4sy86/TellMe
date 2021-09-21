package com.elevencent.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private final String name;
    private Boolean checked = false;
    
    public Item(String name) {
        this.name = name;
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
    
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    
    public Boolean getChecked() {
        return checked;
    }
    
    public static Creator<Item> getCREATOR() {
        return CREATOR;
    }
}