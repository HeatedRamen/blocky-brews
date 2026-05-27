package com.pluralsight.model;

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

    public enum Size{
        SMALL(2),
        MEDIUM(3),
        LARGE(4);

        private final long price;

        Size(long price){ this.price = price; }

        public long getPrice() { return price; }
    }

    @Override
    public long getPrice() {
        return size.getPrice();
    }
}
