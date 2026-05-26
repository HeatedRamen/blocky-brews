package com.pluralsight.model;

enum Item{
    GOLDEN_CARROT(5),
    XP_BOTTLE(10);

    private final int price;

    Item(int price){
        this.price = price;
    }

    public int getPrice() { return price; }
}
public class TradableItems extends ShopItem{
    private Item name;

    TradableItems(Item name) { this.name = name; }

    @Override
    public long getPrice() { return name.getPrice(); }
}
