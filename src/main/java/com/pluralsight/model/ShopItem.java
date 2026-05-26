package com.pluralsight.model;

public abstract class ShopItem implements Priceable{
    private long price;

    public ShopItem(){
        this.price = 0;
    }


    public void setPrice( long price ){ this.price = price; }
    public abstract long getPrice();

}
