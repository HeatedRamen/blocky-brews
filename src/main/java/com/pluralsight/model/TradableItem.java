package com.pluralsight.model;


public class TradableItem extends ShopItem{
    private Item name;

    public TradableItem(Item name) {
        this.name = name;
    }

    public enum Item{
        GOLDEN_CARROT(5),
        XP_BOTTLE(10);

        private final long price;

        Item(long price){
            this.price = price;
        }

        public long getPrice() { return price; }
    }

    public String getName(){
        if (this.name == Item.GOLDEN_CARROT)    { return "Golden Carrot"; }
            else if (name == Item.XP_BOTTLE)    { return "Xp Bottle"; }
            else return "";
    }

    @Override
    public long getPrice() { return name.getPrice(); }

    @Override
    public String toString() {
        return String.format("Item: %33s %16d Emerald(s)", getName(), getPrice());
    }
}
