package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.util.InputValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OrderScreen {

    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        clearConsole();

        while(isRunning){

            List<String> validInput = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4"));

            // Show menu selection and take valid user input then process
            displayScreen();
            isRunning = processMenuSelection(InputValidation.getValidInput(validInput));
        }
    }

    public boolean processMenuSelection(String userChoice){
        switch(userChoice){
            case "1":
                makePotion();
                return true;

            case "2":
                addBasePotion();
                return true;

            case "3":
                addTrade();
                return true;

            case "4":
                checkOut();
                return true;

            case "0":
                userOrder.clearOrder();
                return false;

            default:
                return true;
        }
    }

    public void makePotion() {
        promptPotion();
    }

    public void promptPotion(){
        System.out.println("""
                ===================================================================
                                       Main Potion effect
                ===================================================================
                
                                    1) Strength
                                    2) Swiftness
                                    3) Healing
                                    4) Weakness
                                    5) Slowness
                                    6) Poison
                
                ===================================================================""");

        System.out.println("""
                ===================================================================
                                           Potion Size
                ===================================================================
                
                                    1) Small
                                    2) Medium
                                    3) Large
                
                ===================================================================""");

        System.out.println("""
                ===================================================================
                                    Additional Premium Attributes
                ===================================================================
                
                                    1) Water Breathing
                                    2) Fire Breathing
                                    3) Night Vision
                                    4) Invisibility
                                    5) Slow Falling
                
                ===================================================================""");


        System.out.println("""
                ===================================================================
                                       Potion Enhancements 
                ===================================================================
                
                                    1) Stronger effect
                                    2) Longer effect
                                   
                
                ===================================================================""");

        System.out.println("""
                ===================================================================
                                           Visuals Effects
                ===================================================================
                
                                    1) Glows
                                    2) Swirly
                                    3) Diamond sparkle
                                    4) 
                
                ===================================================================""");

        System.out.println("""
                ===================================================================
                                           Change Potion Form
                ===================================================================
                
                                    (Default: Consumable)
                                    1) Throwable
                                    2) Lingering
                
                ===================================================================""");

        System.out.println("""
                ===================================================================
                                                Potion Helpers
                ===================================================================
                
                                    1) Rotten Flesh
                                    2) Nether warts
                
                ===================================================================""");
    }

    public void addBasePotion(){

        clearConsole();

        // List of valid input
        List<String> validInput = new ArrayList<>(Arrays.asList("0", "1", "2", "3"));

        // Show menu selector for base potion "types"
        promptBasePotionName();
        String potionName = InputValidation.getValidInput(validInput);

        // Check if user canceled
        if(potionName.equalsIgnoreCase("0")){
            VillagerExpression.angry();
            return;
        }

        // Show menu selector for base potion sizes
        promptBasePotionSize();
        String potionSize = InputValidation.getValidInput(validInput);

        // Check if user canceled
        if(potionSize.equalsIgnoreCase("0")){
            VillagerExpression.angry();
            return;
        }

        processBasePotionSelection(potionName, potionSize);

    }

    public void promptBasePotionName() {

        System.out.println("""
                ===================================================================
                                            Base Potion
                ===================================================================

                                            1) Mundane
                                            2) Awkward
                                            3) Thick
                                            0) Cancel

                ===================================================================""");
    }

    public void promptBasePotionSize(){
        System.out.println("""
                ===================================================================
                                               Sizes
                ===================================================================
                
                                       1) Small        (2 Emeralds)
                                       2) Medium       (3 Emeralds)
                                       3) Large        (4 Emeralds)
                                       0) Cancel
                
                ===================================================================""");
    }

    public void processBasePotionSelection(String potionName, String potionSize){

        switch (potionName){
            case "1" -> potionName = "Mundane";
            case "2" -> potionName = "Awkward";
            case "3" -> potionName = "Thick";
        }

        switch (potionSize){
            case "1" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.SMALL));
            case "2" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.MEDIUM));
            case "3" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.LARGE));
        }
    }

    public void addTrade() {

        // Clear console then show menu selection
        clearConsole();
        promptTrade();

        // Get list of valid input
        List<String> validInput = new ArrayList<>(Arrays.asList("0", "1", "2"));

        processTradeSelection(InputValidation.getValidInput(validInput));
    }

    public void promptTrade(){
        System.out.println("""
                ===================================================================
                                           Tradable Items
                ===================================================================
                
                                    1) Golden Carrot (5 Emeralds)
                                    2) XP bottle     (10 Emeralds)
                                    0) Go back
                
                ===================================================================""");
    }

    public void processTradeSelection(String userChoice){

        switch (userChoice){

            // Add in Golden Carrot to the order
            case "1":
                userOrder.addItem(new TradableItems(TradableItems.Item.GOLDEN_CARROT));
                break;

            // Add in Xp Bottle to the order
            case "2":
                userOrder.addItem(new TradableItems(TradableItems.Item.XP_BOTTLE));
                break;

            // Clear console before showing the angry villager for wasting his time
            case "0":
                clearConsole();
                VillagerExpression.angry();
                break;
        }
    }

    public void checkOut() {
        clearConsole();
        userOrder.displayOrder();
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    public static void displayScreen() {

        // Order menu with all the option
        System.out.println("""
                ===================================================================
                                                    Order Menu
                ┏━━━━━━━━━━━━━━━━━━━┓
                ┃                   ┃
                ┃                   ┃
                ┃   ▄▄▄▄▄▄▄▄▄▄▄▄▄   ┃             1) Make Potion
                ┃    |_|     |_|    ┃             2) Add Base Potion
                ┃                   ┃             3) Tradable items
                ┃       │   │       ┃             4) Check out
                ┃    ═══│   │═══    ┃             0) Cancel Order
                ┃       │   │       ┃
                ┗━━━━━━━│   │━━━━━━━┛
                        └───┘
                ===================================================================""");
    }
}

