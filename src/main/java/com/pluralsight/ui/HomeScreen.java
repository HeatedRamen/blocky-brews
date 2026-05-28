package com.pluralsight.ui;

import com.pluralsight.util.InputValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeScreen {

    public void run(){

        boolean isRunning = true;

        // Cleans console and display home screen
        clearConsole();
        displayScreen();


        while(isRunning){
            // List of valid input for input valid input
            List<String> validInput = new ArrayList<>(Arrays.asList("0", "1"));


            isRunning = processSelection(InputValidation.getValidInput(validInput));
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
                ===================================================================""");
    }

    public boolean processSelection(String userChoice){

        // Switch case based off user input
        switch(userChoice){

            case "1":
                // Run the order menu
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.run();

                // Clears and displays home again when return from order screen
                displayScreen();
                return true;

                // Returns false to end program / while loop
            case "0":
                return false;

            default:
                return true;
        }
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}

