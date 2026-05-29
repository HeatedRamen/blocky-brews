package com.pluralsight.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudCloud extends Potion{

    public LoudCloud(){
        super(PotionSize.LARGE, "Slowness");
        List<OptionalEffect> optionalEffects = new ArrayList<>(Arrays.asList(
                new OptionalEffect("Lingering", "Form", false),
                new OptionalEffect("Slow Falling", "Additional Effect", true),
                new OptionalEffect("Longer", "Enhancement", true),
                new OptionalEffect("Stronger", "Enhancement", true),
                new OptionalEffect("Swirls", "Visual", false),
                new OptionalEffect("Nether Warts", "Potion Helper", false),
                new OptionalEffect("Rotten Flesh", "Potion Helper", false),
                new OptionalEffect("Secret Ingredient", "Gilbert's Formula", false)
        ));
    }
}
