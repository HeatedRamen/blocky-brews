package com.pluralsight;

import com.pluralsight.ui.HomeScreen;

public class App {
    static void main() {
        HomeScreen.displayHome();

        try {
            Thread.sleep(10000);
            HomeScreen.clearConsole();
            HomeScreen.displayHome();
        }catch(Exception e){}
    }
}
