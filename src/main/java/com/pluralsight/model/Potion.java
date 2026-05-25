package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Potion extends ShopItem{
    private List<Catalyst> catalysts;
    private List<Effect> effects;
    private String size, type;

    Potion(){
        super();
        this.type = "";
        effects = new ArrayList<>();
    }
    Potion(String name, long price, String type, List<Effect> effects){
        super(name, price);
        this.type = type;
        this.effects = effects;
    }


    @Override
    public long getPrice() {
        return 0;
    }
}
