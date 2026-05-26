package com.pluralsight.ui;

import com.pluralsight.model.Potion;
import com.pluralsight.model.SideItem;

import java.util.Scanner;

public class OrderScreen {
    static Scanner input = HomeScreen.input;

    public void run(){
        boolean isRunning = true;

        clearConsole();
        displayOrderScreen();

        while(isRunning){
            isRunning = processSelection(promptSelection());

        }
    }
    public static void displayOrderScreen() {
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
        return input.nextLine();
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
    public Potion makePotion() { return null; }
    public SideItem addBasePotion(){ return null; }
    public SideItem addSideItem() { return null; }
    public void checkOut() {}
    public void cancelOrder() {}

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }


}

