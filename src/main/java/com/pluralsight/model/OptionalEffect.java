package com.pluralsight.model;

public class OptionalEffect {
    private String name, type;
    private boolean premium;

    public OptionalEffect(String name, String type, boolean premium){
        this.name = name;
        this.type = type;
        this.premium = premium;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isPremium() { return premium; }
    public void setPremium(boolean premium) { this.premium = premium; }

    @Override
    public String toString() {
        return type + ": " + name;
    }
}
