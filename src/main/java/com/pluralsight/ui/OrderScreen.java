package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.util.InputValidation;
import com.pluralsight.data.ReceiptWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OrderScreen {

    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        clearConsole();

        while(isRunning){

            // Show menu selection and take valid user input then process
            displayScreen();
            isRunning = processMenuSelection(InputValidation.getValidInput
                                            (InputValidation.options(4)));
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
                return checkOut();

            case "0":
                clearConsole();
                userOrder.clearOrder();
                VillagerExpression.angry();
                return false;

            default:
                return true;
        }
    }

    public void makePotion() {
        promptPotion();
    }

    public void promptPotion(){
        System.out.println(MenuStrings.MAIN_EFFECT_MENU());

        System.out.println(MenuStrings.POTION_SIZE());

        System.out.println(MenuStrings.POTION_FORM_MENU());

        System.out.println(MenuStrings.ADDITIONAL_EFFECT_MENU());

        System.out.println(MenuStrings.POTION_ENHANCEMENT());

        System.out.println(MenuStrings.VISUAL_EFFECT_MENU());


        System.out.println(MenuStrings.POTION_HELPER_MENU());
    }

    public void addBasePotion(){

        clearConsole();

        // Show menu selector for base potion "types"
        promptBasePotionName();
        String potionName = InputValidation.getValidInput
                            (InputValidation.options(3));

        // Check if user canceled
        if(potionName.equalsIgnoreCase("0")){
            clearConsole();
            VillagerExpression.angry();
            return;
        }

        // Show menu selector for base potion sizes
        clearConsole();
        promptBasePotionSize();
        String potionSize = InputValidation.getValidInput
                            (InputValidation.options(4));

        // Check if user canceled
        if(potionSize.equalsIgnoreCase("0")){
            clearConsole();
            VillagerExpression.angry();
            return;
        }

        processBasePotionSelection(potionName, potionSize);
        clearConsole();
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

        processTradeSelection(InputValidation.getValidInput
                             (InputValidation.options(2)));
    }

    public void processTradeSelection(String userChoice){

        switch (userChoice){

            // Add in Golden Carrot to the order
            case "1":
                clearConsole();
                userOrder.addItem(new TradableItem(TradableItem.Item.GOLDEN_CARROT));
                break;

            // Add in Xp Bottle to the order
            case "2":
                clearConsole();
                userOrder.addItem(new TradableItem(TradableItem.Item.XP_BOTTLE));
                break;

            // Clear console before showing the angry villager for wasting his time
            case "0":
                clearConsole();
                VillagerExpression.angry();
                break;
        }
    }

    public boolean checkOut() {
        clearConsole();

        if(userOrder.isEmpty()){
            VillagerExpression.angry();
            System.out.println("        Hrghh! Hrghhh!! (Add an item before checking out)");
            return true;
        }
        userOrder.displayOrder();

        confirmOrder();

        String userChoice = InputValidation.getValidInput
                            (InputValidation.options(1));

        switch(userChoice){

            // Write receipt, empty the order, then returns to home
            case "1":
                ReceiptWriter.writeReceipt(userOrder);
                userOrder.clearOrder();
                return false;

            // Shows angry villager for wasting his time then return back to order menu
            case "0":
                clearConsole();
                VillagerExpression.angry();
                return true;

            default:
                return true;
        }
    }


    // Helper clear console
    private static void clearConsole(){ System.out.print("\033[H\033[2J"); }

   // Menu output
    public static void displayScreen() { System.out.println(MenuStrings.ORDER_MENU()); }
    public static void promptBasePotionName() { System.out.println(MenuStrings.BASE_POTION_MENU()); }
    public static void promptBasePotionSize(){ System.out.println(MenuStrings.BASE_POTION_SIZE_MENU()); }
    public static void promptTrade(){ System.out.println(MenuStrings.TRADE_MENU()); }
    public static void confirmOrder(){ System.out.println(MenuStrings.CONFIRM_CHECKOUT_MENU()); }

}

