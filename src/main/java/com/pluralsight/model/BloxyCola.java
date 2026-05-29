package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BloxyCola extends Potion{

    public BloxyCola(){
        super(PotionSize.MEDIUM, "Swiftness");
        List<OptionalEffect> optionalEffects = new ArrayList<>(Arrays.asList(
                new OptionalEffect("Consumable", "Form", false),
                new OptionalEffect("Longer", "Enhancement", true),
                new OptionalEffect("Swirls", "Visual", false),
                new OptionalEffect("Nether Warts", "Potion Helper", false)
        ));
        setOptionalEffects(optionalEffects);
    }
}
