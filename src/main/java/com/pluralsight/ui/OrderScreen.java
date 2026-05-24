package com.pluralsight.ui;

import com.pluralsight.model.Potion;
import com.pluralsight.model.SideItem;

public class OrderScreen {

    public static void displayOrderScreen() {
        System.out.println("""
                ===================================================================
                                      Order Menu
                _____________________
                |                   |
                |                   |
                |   =============   |
                |     |_|    |_|    |
                |                   |
                |       |   |       |
                |     ==|   |==     |
                |       |   |       |
                ‾‾‾‾‾‾‾‾|   |‾‾‾‾‾‾‾
                        ‾‾‾‾‾
                ===================================================================
                """);
    }

    public void promptSelection() {}
    public void processSelection(String userChoice) {}
    public Potion makePotion() { return null; }
    public SideItem addSideItem() { return null; }
    public void checkOut() {}
    public void cancelOrder() {}


}

