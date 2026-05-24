package com.pluralsight.model;

public abstract class ShopItem implements Priceable{
    private String name;
    private long price;

    ShopItem(){
        this.name = "";
        this.price = 0;
    }
    ShopItem(String name, long price){
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setPrice( long price ){ this.price = price; }
    public abstract long getPrice();
}
