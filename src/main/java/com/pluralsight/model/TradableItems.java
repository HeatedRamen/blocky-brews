package com.pluralsight.model;


public class TradableItems extends ShopItem{
    private Item name;

    TradableItems(Item name) { this.name = name; }

    public enum Item{
        GOLDEN_CARROT(5),
        XP_BOTTLE(10);

        private final long price;

        Item(long price){
            this.price = price;
        }

        public long getPrice() { return price; }
    }

    @Override
    public long getPrice() { return name.getPrice(); }
}
