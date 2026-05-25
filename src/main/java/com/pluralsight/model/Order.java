package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShopItem> playerOrder;

    Order(){
        playerOrder = new ArrayList<>();
    }

    public void addItem(ShopItem item){
        playerOrder.add(item);
    }
}
