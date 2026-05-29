package com.pluralsight.ui;

import com.pluralsight.model.BloxyCola;
import com.pluralsight.model.CrashOut;
import com.pluralsight.model.Potion;

public class MenuStrings {

    public static final String HOME_SCREEN() {
        return """
                ===================================================================
                                               WELCOME TO BLOCKY BREWS
                ┏━━━━━━━━━━━━━━━━━━━┓
                ┃                   ┃
                ┃                   ┃
                ┃   ▄▄▄▄▄▄▄▄▄▄▄▄▄   ┃
                ┃    |_|     |_|    ┃               1) New Order
                ┃                   ┃               0) Exit
                ┃       │   │       ┃
                ┃    ═══│   │═══    ┃
                ┃       │   │       ┃
                ┗━━━━━━━│   │━━━━━━━┛
                        └───┘
                ===================================================================""";
    }

    public static final String ORDER_MENU() {
        return """
                ===================================================================
                                            Order Menu
                ===================================================================
                   ┏━━━━━━━━━━━━━━━━━━━┓
                   ┃                   ┃
                   ┃                   ┃
                   ┃   ▄▄▄▄▄▄▄▄▄▄▄▄▄   ┃          1) Make Potion
                   ┃    |_|     |_|    ┃          2) Add Base Potion
                   ┃                   ┃          3) Tradable items
                   ┃       │   │       ┃          4) Check out
                   ┃    ═══│   │═══    ┃          0) Cancel Order
                   ┃       │   │       ┃
                   ┗━━━━━━━│   │━━━━━━━┛
                           └───┘
                ===================================================================
                """;

    }

    public static final String MAIN_EFFECT_MENU() {
        return """
                ===================================================================
                                        Main Potion Effect
                ===================================================================
                
                                            1) Strength
                                            2) Swiftness
                                            3) Healing
                                            4) Weakness
                                            5) Slowness
                                            6) Poison
                
                ===================================================================""";
    }

    public static final String POTION_SIZE() {
        return """
                ===================================================================
                                            Potion Size
                ===================================================================
                
                                      1) Small  (10 Emeralds)
                                      2) Medium (15 Emeralds)
                                      3) Large  (20 Emeralds)
                
                ===================================================================""";
    }

    public static final String POTION_FORM_MENU() {
        return """
                ===================================================================
                                         Change Potion Form
                ===================================================================
                
                                        (Default: Consumable)
                                        1) Throwable
                                        2) Lingering
                                        0) Continue
                
                ===================================================================""";
    }

    public static final String ADDITIONAL_EFFECT_MENU(Potion.PotionSize size) {

        return String.format("""
                        ===================================================================
                                           Additional Premium Attributes
                        ===================================================================
                                           First Effect  + %d Emeralds
                                           Second Effect + %d Emeralds
                                                1) Water Breathing
                                                2) Fire Resistance
                                                3) Night Vision
                                                4) Invisibility
                                                5) Slow Falling
                                                0) Continue
                        ===================================================================""",
                size.getInitialPremium(), size.getAdditionalPremium());
    }

    public static final String POTION_ENHANCEMENT(Potion.PotionSize size) {
        return String.format("""
                        ===================================================================
                                                Potion Enhancements
                        ===================================================================
                        
                                        1) Stronger effect ( + %d Emeralds)
                                        2) Longer effect   ( + %d Emeralds)
                                        3) Both            ( + %d Emeralds)
                                        0) Continue
                        
                        ===================================================================""",
                size.getInitialPremium(), size.getInitialPremium(), size.getInitialPremium() + size.getAdditionalPremium());
    }

    public static final String VISUAL_EFFECT_MENU() {
        return """
                ===================================================================
                                          Visuals Effects
                ===================================================================
                
                                           1) Glows
                                           2) Swirly
                                           3) Diamond Sparkle
                                           4) Gold Flakes
                                           5) Emerald color
                                           0) Continue
                
                ===================================================================""";
    }

    public static final String POTION_HELPER_MENU() {
        return """
                ===================================================================
                                        Potion Helpers
                ===================================================================
                
                                        1) Rotten Flesh
                                        2) Nether Warts
                                        0) Continue
                
                ===================================================================""";
    }

    public static final String CONFIRM_POTION_HEADER() {
        return """
                ===================================================================
                                         Confirm Potion
                ===================================================================""";
    }

    public static final String CONFIRM_POTION() {
        return """
                ===================================================================
                
                                         1) Add To Order
                                         0) Cancel Potion
                
                ===================================================================""";
    }

    public static final String BASE_POTION_MENU() {
        return """
                ===================================================================
                                            Base Potion
                ===================================================================
                
                                            1) Mundane
                                            2) Awkward
                                            3) Thick
                                            0) Cancel
                
                ===================================================================""";
    }

    public static final String BASE_POTION_SIZE_MENU() {
        return """
                ===================================================================
                                               Sizes
                ===================================================================
                
                                       1) Small        (2 Emeralds)
                                       2) Medium       (3 Emeralds)
                                       3) Large        (4 Emeralds)
                                       0) Cancel
                
                ===================================================================""";
    }

    public static final String TRADE_MENU() {
        return """
                ===================================================================
                                           Tradable Items
                ===================================================================
                
                                    1) Golden Carrot (5 Emeralds)
                                    2) XP bottle     (10 Emeralds)
                                    0) Go back
                
                ===================================================================""";
    }

    public static final String CONFIRM_CHECKOUT_MENU() {
        return """
                ===================================================================
                                           Confirm Order?
                ===================================================================
                
                                             1) Confirm
                                             0) Go back
                
                ===================================================================""";
    }

    public static final String POTION_TYPE_MENU() {
        return """
                ===================================================================
                
                                      1) Make Custom Potion
                                      2) Choose Signature Potion
                                      0) Cancel
                
                ===================================================================""";

    }

    public static final String SIGNATURE_POTION_MENU() {
        BloxyCola bloxyCola = new BloxyCola();
        CrashOut crashOut = new CrashOut();
        return String.format("""
                        ===================================================================
                                             Select a Signature Potion
                                                   1) Bloxy Cola
                        %s
                        
                                                    2) Crash Out
                        %s
                        ===================================================================""",
                bloxyCola, crashOut);

    }

    public static final String ADD_EFFECT_TO_SIGNATURE() {
        return """
                ===================================================================
                                     Add More Custom Effects?
                ===================================================================
                
                                     1) Add Enhancement
                                     2) Add Additional Effect
                                     3) Add Visual Effect
                                     4) Add Potion Helper
                                     0) Continue
                
                ===================================================================""";
    }

    public static final String REMOVE_EFFECT(Potion potion) {
        return String.format("""
                ===================================================================
                                       Remove Any Effects?
                ===================================================================
                
                %s
                0) Continue
                
                ===================================================================""",
                potion.getOptionalEffectsList());
    }
}
