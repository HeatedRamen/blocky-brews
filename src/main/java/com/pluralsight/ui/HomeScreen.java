package com.pluralsight.ui;

import com.pluralsight.util.InputValidation;

public class HomeScreen {

    public void run(){

        boolean isRunning = true;

        // Cleans console and display home screen
        clearConsole();
        displayScreen();


        while(isRunning){

            isRunning = processSelection(InputValidation.getValidInput
                                        (InputValidation.options(1)));
        }
    }

    public static void displayScreen(){

        // Menu with our villager trader
        System.out.println(MenuStrings.HOME_SCREEN());
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

