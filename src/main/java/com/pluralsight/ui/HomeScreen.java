package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {

    static Scanner input = new Scanner(System.in);

    public void run(){
        boolean isRunning = true;

        while(isRunning){
            displayHome();
            processSelection(promptSelection());
        }
    }
    public static void displayHome(){
        System.out.println("""
                ===================================================================
                                               WELCOME TO BLOCKY BREWS
                ┏━━━━━━━━━━━━━━━━━━━┓
                ┃                   ┃
                ┃                   ┃
                ┃   ▄▄▄▄▄▄▄▄▄▄▄▄▄   ┃
                ┃     |_|    |_|    ┃
                ┃                   ┃
                ┃       │   │       ┃
                ┃    ═══│   │═══    ┃
                ┃       │   │       ┃
                ┗━━━━━━━│   │━━━━━━━┛
                        └───┘
                ===================================================================
                """);
    }

    public String promptSelection(){
        return input.nextLine();
    }
    public void processSelection(String userChoice){

    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}

