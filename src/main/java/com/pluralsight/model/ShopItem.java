package com.pluralsight.model;

public abstract class ShopItem implements Priceable{
    private long price;

    public abstract long getPrice();
}
