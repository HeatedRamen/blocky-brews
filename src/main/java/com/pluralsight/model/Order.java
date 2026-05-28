package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private List<ShopItem> items;
    private static final int WIDTH = 67;
    private static final String DIV = "=".repeat(WIDTH);

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(ShopItem item){
        items.add(item);
    }
    public void displayOrder(){

        // Reverse the order to show newest items on top
        reverseOrder();

        System.out.println(DIV);
        items.forEach(System.out::println);
        System.out.println(DIV);

        // Reverse order back to normal in case they add more
        reverseOrder();

        System.out.printf("Order Total: %43d Emerald(s)\n", getTotal());
    }

    public long getTotal(){
        return items.stream()
                .mapToLong(ShopItem::getPrice)
                .sum();
    }

    public boolean isEmpty(){ return items.isEmpty(); }
    public List<ShopItem> getItems() { return items; }
    public void reverseOrder(){ Collections.reverse(items); }
    // Clear order for when they cancel
    public void clearOrder(){ items.clear(); }


}
