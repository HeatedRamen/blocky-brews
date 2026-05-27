package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    static Scanner input = new Scanner(System.in);

    public void run(){

        boolean isRunning = true;

        // Cleans console and display home screen
        clearConsole();
        displayScreen();


        while(isRunning){
            isRunning = processSelection(promptSelection());
        }
    }

    public static void displayScreen(){

        // Menu with our villager trader
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

        // Prompt the user for their choice and returns the trimmed input
        System.out.println("Enter in your choice");
        return input.nextLine().trim();
    }

    public boolean processSelection(String userChoice){

        // Switch case based off user input
        switch(userChoice){

            case "1":
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.run();

                // Clears and displays home again when return from order screen
                clearConsole();
                displayScreen();
                return true;

                // Returns false to end program / while loop
            case "0":
                return false;

            default:
                // *Angry villager noise*
                System.out.println("HRGHHHHHH! (Enter a valid choice)");
                return true;
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}

