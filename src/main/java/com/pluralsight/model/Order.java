package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private List<ShopItem> playerOrder;

    public Order(){
        playerOrder = new ArrayList<>();
    }

    public void addItem(ShopItem item){
        playerOrder.add(item);
    }
    public void displayOrder(){

        // Reverse the order to show newest items on top
        reverseOrder();
        playerOrder.forEach(System.out::println);

        // Reverse order back to normal in case they add more
        reverseOrder();

        System.out.println("Order total: \t\t" + getTotal() + " Emeralds");
    }

    public long getTotal(){
        return playerOrder.stream()
                .mapToLong(ShopItem::getPrice)
                .sum();
    }

    public List<ShopItem> getOrder() { return playerOrder; }
    public void reverseOrder(){ Collections.reverse(playerOrder); }
    // Clear order for when they cancel
    public void clearOrder(){ playerOrder.clear(); }

}
