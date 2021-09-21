package com.elevencent.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * Class that holds all information about the shoppinglist and its contents.
 *
 * @author Pieter Vogt
 * @since 09.09.2021
 */
public class ItemList implements Parcelable {
    private final ArrayList<Item> itemArrayList;
    private final UUID listUuid;
    private final UUID creatorUuid;
    private final String name;
    private Boolean ticked;
    
    /**
     * Constructor for ItemList.
     *
     * @param creatorUuid The uuid that represents the User that created the ItemList.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public ItemList(String name, UUID creatorUuid) {
        this.name = name;
        this.itemArrayList = new ArrayList<>();
        this.listUuid = UUID.randomUUID();
        this.creatorUuid = creatorUuid;
    }
    
    /**
     * Creates a HashSet of items out of an Array of Parcelables.
     * <p>
     * This is used for unpacking the parcelable array to use it in another activity.
     *
     * @param parcelables Array of items to use in another activity.
     *
     * @return HashSet of items.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    private HashSet<Item> parcelableArrayToHashSet(Parcelable[] parcelables) {
        //Order to write or read into/out of parcel: set, listUuid, creatorUuid, name
        if (parcelables == null || parcelables.length == 0) {
            return new HashSet<>();
        } else {
            HashSet<Item> items = new HashSet<>();
            for (Parcelable parcelable : parcelables) {
                items.add((Item) parcelable);
            }
            return items;
        }
    }
    
    /**
     * Creates an array of parcelables out of an hashset of items.
     * <p>
     * This is used for packing the hashset for later use in another activity.
     *
     * @param items Hashset of items.
     *
     * @return Array of parcelables.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    private Parcelable[] hashSetToParcelableArray(HashSet<Item> items) {
        //Order to write or read into/out of parcel: set, listUuid, creatorUuid, name
        if (items == null || items.isEmpty()) {
            return new Parcelable[0];
        } else {
            Parcelable[] parcelables = new Parcelable[items.size()];
            int index = 0;
            for (Item item : items) {
                parcelables[index] = item;
                index++;
            }
            return parcelables;
        }
    }
    
    /**
     * Converts a HashSet to an ArrayList.
     *
     * @param itemHashSet HashSet of Items.
     *
     * @return ArrayList of Items.
     *
     * @author Pieter Vogt
     * @since 19.09.2021
     */
    private List<Item> hashSetToList(HashSet<Item> itemHashSet) {
        if (itemHashSet == null || itemHashSet.isEmpty()) {
            return new ArrayList<>();
        } else return new ArrayList<>(itemHashSet);
    }
    
    /**
     * Converts a List to a HashSet.
     *
     * @param items List of Items.
     *
     * @return HashSet of Items.
     *
     * @author Pieter Vogt
     * @since 19.09.2021
     */
    private HashSet<Item> listToHashSet(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return new HashSet<>();
        } else return new HashSet<>(items);
    }
    
    /**
     * Writing an ItemList to a given parcel.
     * <p>
     *
     * @param parcel A parcel.
     * @param i      Some integer.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.itemArrayList);
        //  parcel.writeTypedArray(hashSetToParcelableArray(this.set), i);
        parcel.writeString(listUuid.toString());
        parcel.writeString(creatorUuid.toString());
        parcel.writeString(name);
    }
    
    /**
     * Constructing an ItemList from a given parcel.
     *
     * @param in parcel from some intent.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    protected ItemList(Parcel in) {
        this.itemArrayList = in.readArrayList(ItemList.class.getClassLoader());
        this.listUuid = UUID.fromString(in.readString());
        this.creatorUuid = UUID.fromString(in.readString());
        this.name = in.readString();
    }
    
    /**
     * The Creator for ItemList.java .
     *
     * @since 09.09.2021
     */
    public static final Creator<ItemList> CREATOR = new Creator<ItemList>() {
        @Override
        public ItemList createFromParcel(Parcel in) {
            return new ItemList(in);
        }
        
        @Override
        public ItemList[] newArray(int size) {
            return new ItemList[size];
        }
    };
    
    /**
     * Getter for HashSet.
     *
     * @return HashSet that contains all the Items.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }
    
    /**
     * Getter for UUID of List.
     *
     * @return UUID of the ItemList.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public UUID getListUuid() {
        return listUuid;
    }
    
    /**
     * Getter for UUID of creator.
     *
     * @return UUID of the creator of the ItemList.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public UUID getCreatorUuid() {
        return creatorUuid;
    }
    
    /**
     * Getter for String name.
     *
     * @return String name of the ItemList.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    public String getName() {
        return name;
    }
    
    /**
     * I have no idea what this does.
     *
     * @return 0.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    @Override
    public int describeContents() {
        return 0;
    }
    
    public void sortByChecked() {
        Collections.sort(itemArrayList, (i1, i2) -> {
            if (!i1.getChecked() && i2.getChecked()) return -1;
            else if (i1.getChecked() && !i2.getChecked()) return 1;
            else return 0;
        });
    }
}
