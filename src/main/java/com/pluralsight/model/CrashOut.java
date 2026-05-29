package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrashOut extends Potion {

    public CrashOut() {
        super(PotionSize.LARGE, "Strength");
        List<OptionalEffect> optionalEffects = new ArrayList<>(Arrays.asList(
                new OptionalEffect("Consumable", "Form", false),
                new OptionalEffect("Invisibility", "Additional Effect", true),
                new OptionalEffect("Longer", "Enhancement", true),
                new OptionalEffect("Stronger", "Enhancement", true),
                new OptionalEffect("Glows", "Visual", false)
        ));
    }
}
