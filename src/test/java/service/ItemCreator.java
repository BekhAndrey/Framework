package service;

import model.Item;

public class ItemCreator {

    public static final String NAME = "testdata.item.name";
    public static final String COLOR = "testdata.item.color";
    public static final String SIZE = "testdata.item.size";
    public static final String PRICE = "testdata.item.price";
    public static final String AMOUNT = "testdata.item.amount";

    public static Item withCredentialsFromPropertyForWishlist(){
        return new Item(NAME, null, null, PRICE, AMOUNT);
    }

    public static Item withCredentialsFromPropertyForBag(){
        return new Item(NAME, COLOR, SIZE, PRICE, AMOUNT);
    }

}
