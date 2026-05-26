package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    static Scanner input = new Scanner(System.in);

    public void run(){
        boolean isRunning = true;


        clearConsole();
        while(isRunning){
            displayScreen();
            isRunning = processSelection(promptSelection());
        }
    }
    public static void displayScreen(){
        System.out.println("""
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
                ===================================================================
                """);
    }

    public String promptSelection(){
        System.out.println("Enter in your choice");
        return input.nextLine().trim();
    }
    public boolean processSelection(String userChoice){
        switch(userChoice){
            case "1":
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.run();
                return true;
            case "0":
                return false;
            default:
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
                return true;
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}

