package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

enum PotionSize{
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

public class Potion extends ShopItem{
    private List<OptionalEffect> optionalEffects;
    private String mainEffect;
    private PotionSize size;

    public Potion(){
        super();
        mainEffect = "";
        optionalEffects = new ArrayList<>();
    }
    public Potion(PotionSize size, String mainEffect, List<OptionalEffect> optionalEffects){
        super();
        this.size = size;
        this.mainEffect = mainEffect;
        this.optionalEffects = optionalEffects;
    }

    public List<OptionalEffect> getOptionalEffects() { return optionalEffects; }
    public void setOptionalEffects(List<OptionalEffect> optionalEffects) { this.optionalEffects = optionalEffects; }
    public void addOptionalEffect(OptionalEffect optionalEffect){ optionalEffects.add(optionalEffect); }

    public String getMainEffect() { return mainEffect; }
    public void setMainEffect(String mainEffect) { this.mainEffect = mainEffect; }

    public PotionSize getSize() { return size; }
    public void setSize(PotionSize size) { this.size = size; }

    // Helper methods to calculate total potion price
    // Get a count of the premium option, if 1 charge the initial premium,
    // if 2 charge the initial + additional premium, else (0) no charge added

    private long getAdditionalEffectCount(){
        return optionalEffects.stream()
                .filter(OptionalEffect::isPremium)
                .filter(effect -> effect.getType().equalsIgnoreCase("Enhancement"))
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

}
