package com.pluralsight.ui;

import com.pluralsight.model.*;

import java.util.Scanner;

public class OrderScreen {
    static Scanner input = new Scanner(System.in);
    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        clearConsole();

        while(isRunning){
            displayScreen();
            isRunning = processMenuSelection(promptSelection());
        }
    }

    public String promptSelection() {
        System.out.println("Enter in your choice");
        return input.nextLine().trim();
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
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
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
        promptBasePotionName();
        String potionName = promptSelection();

        // Check if they canceled
        if(potionName.equalsIgnoreCase("0")){
            VillagerExpression.angry();
            return;
        }

        promptBasePotionSize();
        processBasePotionSelection(potionName, promptSelection());

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
            default -> {
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
                return;
            }
        }

        switch (potionSize){
            case "1" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.SMALL));
            case "2" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.MEDIUM));
            case "3" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.LARGE));
            case "0" -> VillagerExpression.angry();
            default -> System.out.println("HRGHHHHHH! (Enter a valid choice)");
        }
    }

    public void addTrade() {
        clearConsole();
        promptTrade();
        processTradeSelection(promptSelection());
    }

    public void promptTrade(){
        System.out.println("""
                ===================================================================
                                           Tradable Items
                ===================================================================
                
                                    1) Golden Carrot (5 Emeralds)
                                    2) XP bottle     (10 Emeralds)
                                    3) Go back
                
                ===================================================================""");
    }

    public void processTradeSelection(String userChoice){

        switch (userChoice){
            case "1":
                userOrder.addItem(new TradableItems(TradableItems.Item.GOLDEN_CARROT));
                break;
            case "2":
                userOrder.addItem(new TradableItems(TradableItems.Item.XP_BOTTLE));
                break;
            case "3":
                clearConsole();
                VillagerExpression.angry();
                break;
            default:
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
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

