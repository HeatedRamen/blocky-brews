package com.pluralsight.ui;

import com.pluralsight.model.*;

import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    static Scanner input = new Scanner(System.in);
    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        clearConsole();
        displayScreen();

        while(isRunning){
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
                1) """);
    }

    public void addBasePotion(){

    }

    public void addTrade() {
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
                VillagerExpression.angry();
                break;
            default:
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
        }
    }
    public void checkOut() {
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
                ===================================================================
                """);
    }
}

