package com.elevencent.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashSet;
import java.util.UUID;

/**
 * Class that holds all information about the shoppinglist and its contents.
 *
 * @author Pieter Vogt
 * @since 09.09.2021
 */
public class ItemList implements Parcelable {
    private final HashSet<Item> set;
    private final UUID listUuid;
    private final UUID creatorUuid;
    private final String name;
    
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
        this.set = new HashSet<>();
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
        if (parcelables != null && parcelables.length != 0) {
            HashSet<Item> items = new HashSet<>();
            for (Parcelable parcelable : parcelables) {
                items.add((Item) parcelable);
            }
            return items;
        } else return new HashSet<>();
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
        if (items != null && !items.isEmpty()) {
            Parcelable[] parcelables = new Parcelable[items.size()];
            int index = 0;
            for (Item item : items) {
                parcelables[index] = item;
                index++;
            }
            return parcelables;
        } else return new Parcelable[0];
    }
    
    /**
     * Constructor to take parcels.
     *
     * @param in parcel from some intent.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    protected ItemList(Parcel in) {
        this.set = parcelableArrayToHashSet(in.readParcelableArray(Item.class.getClassLoader()));
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
    public HashSet<Item> getSet() {
        return set;
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
    
    /**
     * Construcor of a parcel containing an ItemList.java .
     *
     * @param parcel Parcel containing an ItemList.
     * @param i Some integer.
     *
     * @author Pieter Vogt
     * @since 09.09.2021
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(hashSetToParcelableArray(set), i);
        parcel.writeString(listUuid.toString());
        parcel.writeString(creatorUuid.toString());
        parcel.writeString(name);
    }
}
