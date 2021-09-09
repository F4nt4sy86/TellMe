package com.elevencent.myapplication;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

/**
 * Class that holds all information about the shoppinglist and its contents.
 *
 * @author Pieter Vogt
 * @since 09.09.2021
 */
public class ItemList implements Serializable {
    private HashSet<Item> set;
    private UUID listUuid;
    private UUID creatorUuid;
    private String name;
    
    /**
     * Constructor for ItemList.
     *
     * @param creatorUuid The uuid that represents the User that created the ItemList.
     *
     * @since 09.09.2021
     */
    public ItemList(String name, UUID creatorUuid) {
        this.name = name;
        this.set = new HashSet<>();
        this.listUuid = UUID.randomUUID();
        this.creatorUuid = creatorUuid;
    }
    
    /**
     * Constructor for serialization only. DO NOT USE
     *
     * @since 09.09.2021
     */
    public ItemList() {
    }
    
    /**
     * Getter for HashSet.
     *
     * @return HashSet that contains all the Items.
     *
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
     * @since 09.09.2021
     */
    public UUID getCreatorUuid() {
        return creatorUuid;
    }
    
    public String getName() {
        return name;
    }
}
