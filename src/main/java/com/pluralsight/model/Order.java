package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private List<ShopItem> userOrder;

    public Order(){
        userOrder = new ArrayList<>();
    }

    public void addItem(ShopItem item){
        userOrder.add(item);
    }
    public void displayOrder(){

        // Reverse the order to show newest items on top
        reverseOrder();
        userOrder.forEach(System.out::println);

        // Reverse order back to normal in case they add more
        reverseOrder();

        System.out.printf("\nOrder Total %44d Emerald(s)\n", getTotal());
    }

    public long getTotal(){
        return userOrder.stream()
                .mapToLong(ShopItem::getPrice)
                .sum();
    }

    public List<ShopItem> getOrder() { return userOrder; }
    public void reverseOrder(){ Collections.reverse(userOrder); }
    // Clear order for when they cancel
    public void clearOrder(){ userOrder.clear(); }

}
