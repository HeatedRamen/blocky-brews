package com.pluralsight.model;

enum Size{
    SMALL(2),
    MEDIUM(3),
    LARGE(4);

    private final int price;

    Size(int price){ this.price = price; }

    public int getPrice() { return price; }
}

public class PotionBase extends ShopItem{
    private String name;
    private Size size;


    PotionBase(String name, Size size){
        this.name = name;
        this.size = size;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Size getSize() { return size; }
    public void setSize(Size size) { this.size = size; }

    @Override
    public long getPrice() {
        return size.getPrice();
    }
}
