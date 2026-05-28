package com.pluralsight.model;

public class PotionBase extends ShopItem{
    private String name;
    private Size size;

    public PotionBase(String name, Size size){
        this.name = name;
        this.size = size;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() {
        if(size == Size.LARGE)          { return "Large"; }
        else if (size == Size.MEDIUM)   { return "Medium"; }
        else if (size == Size.SMALL)    { return  "Small"; }
        else return "";
    }
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

    @Override
    public String toString() {
        return String.format("Potion Base: %19s Potion %16d Emerald(s)", getSize() + " " + getName(), getPrice());
    }
}
