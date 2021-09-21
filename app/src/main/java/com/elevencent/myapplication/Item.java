package com.elevencent.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents a shopping-item. Can be put into an ItemList.
 *
 * @author Pieter Vogt
 * @see ItemList
 * @since 09.09.2021
 */
public class Item implements Parcelable {
    private final String name;
    private Boolean checked = false;
    
    /**
     * Constructor for Item.
     * <p>
     * Simple constructor, mostly used for instantiating Chips in ChipGroups that only need names of
     * Items.
     *
     * @param name Name of the Item.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public Item(String name) {
        this.name = name;
    }
    
    /**
     * Constructor for Item that uses a Parcel for parameters.
     *
     * @param in Parcel holding the information about the Item.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    protected Item(Parcel in) {
        name = in.readString();
    }
    
    /**
     * Creates a Creator for Item.
     *
     * @since 09.09.2021
     */
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            String name = in.readString();
            return new Item(name);
        }
        
        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    
    /**
     * Returns the Name of the Item.
     *
     * @return Name of the Item.
     *
     * @author Pieter Vogt
     * @since 21.09.2021
     */
    public String getName() {
        return name;
    }
    
    /**
     * No idea what this does. ¯\_(ツ)_/¯
     *
     * @return Absolutely no idea.
     *
     * @since 09.09.2021
     */
    @Override
    public int describeContents() {
        return 0;
    }
    
    /**
     * Creates a Parcel from the calling Item.
     *
     * @param parcel Parcel to write to.
     * @param i      Index of information.
     *
     * @since 09.09.2021
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //Order to read/write from/to parcel: itemName, itemCount
        parcel.writeString(name);
    }
    
    /**
     * Marks the Item as checked.
     *
     * @author Pieter Vogt
     * @since 21.09.2021
     */
    public void setChecked() {
        this.checked = true;
    }
    
    /**
     * Marks the Item as unchecked.
     *
     * @author Pieter Vogt
     * @since 21.09.2021
     */
    public void setUnchecked() {
        this.checked = false;
    }
    
    /**
     * Returns the value checked.
     *
     * @return Tells if the item is already in the shopping-cart.
     *
     * @author Pieter Vogt
     * @since 21.09.2021
     */
    public Boolean getChecked() {
        return checked;
    }
    
    /**
     * Returns the Creator of the Item.
     *
     * @return Creator of the Item.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public static Creator<Item> getCREATOR() {
        return CREATOR;
    }
}