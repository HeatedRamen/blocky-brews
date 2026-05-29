package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Potion extends ShopItem{
    private List<OptionalEffect> optionalEffects;
    private String mainEffect;
    private PotionSize size;
    private String potionType;

    public Potion(){
        super();
        mainEffect = "";
        potionType = "Consumable";
        this.optionalEffects = new ArrayList<>();
    }

    public Potion(PotionSize size, String mainEffect){
        super();
        this.size = size;
        this.mainEffect = mainEffect;
        potionType = "Consumable";
        this.optionalEffects = new ArrayList<>();
    }

    public List<OptionalEffect> getOptionalEffects() { return optionalEffects; }
    public void setOptionalEffects(List<OptionalEffect> optionalEffects) { this.optionalEffects = optionalEffects; }
    public void addOptionalEffect(OptionalEffect optionalEffect){ optionalEffects.add(optionalEffect); }

    public String getMainEffect() { return mainEffect; }
    public void setMainEffect(String mainEffect) { this.mainEffect = mainEffect; }

    public PotionSize getSize() { return size; }
    public void setSize(PotionSize size) { this.size = size; }

    public enum PotionSize{
        SMALL(10, 3, 2),
        MEDIUM(15, 6, 4),
        LARGE(20, 9, 6);

        private final long basePrice;
        private final long initialPremium;
        private final long additionalPremium;

        PotionSize(long basePrice, long initialPremium, long additionalPremium){
            this.basePrice = basePrice;
            this.initialPremium = initialPremium;
            this.additionalPremium = additionalPremium;
        }

        public long getBasePrice() { return basePrice; }
        public long getInitialPremium () {return initialPremium; }
        public long getAdditionalPremium () { return additionalPremium; }
    }

    public String listOptionalEffects(){
        return optionalEffects.stream()
                .map(OptionalEffect::toString)
                .collect(Collectors.joining("\n"));
    }
    // Helper methods to calculate total potion price
    // Get a count of the premium option, if 1 charge the initial premium,
    // if 2 charge the initial + additional premium, else (0) no charge added
    private long getAdditionalEffectCount(){
        return optionalEffects.stream()
                .filter(OptionalEffect::isPremium)
                .filter(effect -> effect.getType().equalsIgnoreCase("Additional Effect"))
                .count();
    }
    private long getAdditionalEffectCost(){
        if (getAdditionalEffectCount() == 1){
            return size.getInitialPremium();
        } else if (getAdditionalEffectCount() == 2) {
            return size.getInitialPremium() + size.getAdditionalPremium();
        } else return 0;
    }

    private long getEnhancementCount(){
        return optionalEffects.stream()
                .filter(OptionalEffect::isPremium)
                .filter(effect -> effect.getType().equalsIgnoreCase("Enhancement"))
                .count();
    }
    private long getEnhancementCost(){
        if (getEnhancementCount() == 1){
            return size.getInitialPremium();
        } else if (getEnhancementCount() == 2) {
            return size.getInitialPremium() + size.getAdditionalPremium();
        } else return 0;
    }

    @Override
    public long getPrice() {
        long totalCost = size.getBasePrice();
        totalCost += getAdditionalEffectCost();
        totalCost += getEnhancementCost();

        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("%10s Potion\n%s\n", mainEffect, listOptionalEffects());
    }
}
