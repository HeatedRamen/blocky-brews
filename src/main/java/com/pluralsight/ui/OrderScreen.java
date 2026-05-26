package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.model.Potion;

import java.util.Scanner;

public class OrderScreen {
    static Scanner input = new Scanner(System.in);
    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        Order userOrder = new Order();
        clearConsole();

        while(isRunning){
            displayScreen();
            isRunning = processSelection(promptSelection());

        }
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
                ┃                   ┃             3) Add Items
                ┃       │   │       ┃             4) Check out
                ┃    ═══│   │═══    ┃             0) Exit
                ┃       │   │       ┃
                ┗━━━━━━━│   │━━━━━━━┛
                        └───┘
                ===================================================================
                """);
    }

    public String promptSelection() {
        System.out.println("Enter in your choice");
        return input.nextLine().trim();
    }

    public boolean processSelection(String userChoice){
        switch(userChoice){
            case "1":
                makePotion();
                return true;
            case "2":
                addBasePotion();
                return true;
            case "3":
                addSideItem();
                return true;
            case "4":
                checkOut();
                return true;
            case "0":
                return false;
            default:
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
                return true;
        }
    }
    public void makePotion() {
        Potion userPotion = promptPotion();
        userOrder.addItem(userPotion);
    }
    public Potion promptPotion(){
        System.out.println("""
                ===================================================================
                
                                     Select which type of potion
                                             1) Consumable
                                             2) Throwable
                                             3) Lingering
                
                ===================================================================""");
        String potionType = promptSelection();

        System.out.println("""
                ===================================================================
                
                                     Select which size of potion
                                             1) Small
                                             2) Medium
                                             3) Large
                
                ===================================================================""");
        String potionSize = promptSelection();

        System.out.println("""
                ===================================================================
                
                                     Select which effect you like
                                             1) Strength
                                             2) Swiftness
                                             3) Healing
                                             4) Weakness
                                             5) Poison
                                             6) Harming
                
                ===================================================================""");
        String potionEffect = promptSelection();

        System.out.println("""
                ===================================================================
                
                                               Catalyst
                                             1) Consumable
                                             2) Stronger potion
                
                ===================================================================""");
        String potionCatalyst = promptSelection();

        return null;
    }
    public void addBasePotion(){ }
    public void addSideItem() { }
    public void checkOut() {}
    public void cancelOrder() {}

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }


}

