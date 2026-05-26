package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

enum PotionSize{
    SMALL(10),
    MEDIUM(15),
    LARGE(20);

    private final int price;

    PotionSize(int price){ this.price = price; }

    public int getPrice() { return price; }
}

public class Potion extends ShopItem{
    private List<OptionalEffect> optionalEffects;
    private String mainEffect;
    private PotionSize size;

    public Potion(){
        super();
        mainEffect = "";
        optionalEffects = new ArrayList<>();
    }
    public Potion(long price, PotionSize size, String mainEffect, List<OptionalEffect> optionalEffects){
        super();
        this.size = size;
        this.mainEffect = mainEffect;
        this.optionalEffects = optionalEffects;
    }


    @Override
    public long getPrice() { return 0; }
}
