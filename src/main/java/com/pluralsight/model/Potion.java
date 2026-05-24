package com.pluralsight.model;

public class Potion extends ShopItem{
    private String type, effect, size;

    Potion(){
        super();
        this.type = "";
        this.effect = "";
    }
    Potion(String name, long price, String type, String effect){
        super(name, price);
        this.type = type;
        this.effect = effect;
    }

    @Override
    public long getPrice() {
        return 0;
    }
}
