package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.util.InputValidation;
import com.pluralsight.data.ReceiptWriter;

public class OrderScreen {

    private Order userOrder = new Order();

    public void run(){
        boolean isRunning = true;

        clearConsole();

        while(isRunning){

            // Show menu selection and take valid user input then process
            displayScreen();
            isRunning = processMenuSelection(InputValidation.getValidInput
                                            (InputValidation.options(4)));
        }
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
                return checkOut();

            case "0":
                clearConsole();
                userOrder.clearOrder();
                VillagerExpression.angry();
                return false;

            default:
                return true;
        }
    }

    public void makePotion(){

        Potion potion = new Potion();

        clearConsole();
        promptMainPotionEffect();
        potion.setMainEffect(processMainEffect(InputValidation.getValidInput
                                            (InputValidation.options(1, 6))));

        clearConsole();
        promptPotionSize();
        potion.setSize(processPotionSize(InputValidation.getValidInput
                                   (InputValidation.options(1, 3))));

        clearConsole();
        promptPotionForm();
        processPotionForm(InputValidation.getValidInput
                        (InputValidation.options(2)), potion);

        clearConsole();
        promptEnhancement();
        processEnhancement(InputValidation.getValidInput
                    (InputValidation.options(3)), potion);

        clearConsole();
        promptAdditionalEffect();
        processAdditionalEffect(InputValidation.getValidInput
                    (InputValidation.options(5)), potion);

        clearConsole();
        promptVisualEffect();
        processVisualEffect(InputValidation.getValidInput
                (InputValidation.options(5)), potion);

        clearConsole();
        promptPotionHelper();
        processPotionHelper(InputValidation.getValidInput
                    (InputValidation.options(2)), potion);

        userOrder.addItem(potion);
    }

    public String processMainEffect(String userChoice){
        switch (userChoice){

            case "1":
                return "Strength";

            case "2":
                return "Swiftness";

            case "3":
                return "Healing";

            case "4":
                return "Weakness";

            case "5":
                return "Slowness";

            case "6":
                return "Poison";

            default:
                return "";
        }
    }

    public Potion.PotionSize processPotionSize(String userChoice){
        switch (userChoice){
            case "1":
                return Potion.PotionSize.SMALL;
            case "2":
                return Potion.PotionSize.MEDIUM;
            case "3":
                return Potion.PotionSize.LARGE;
            default:
                return null;
        }
    }

    public void processPotionForm(String userChoice , Potion potion){
        switch (userChoice){

            case "1":
                potion.addOptionalEffect( new OptionalEffect("Throwable", "Form", false));
                break;

            case "2":
                potion.addOptionalEffect( new OptionalEffect("Lingering", "Form", false));
                break;

            case "0":
                potion.addOptionalEffect( new OptionalEffect("Consumable", "Form", false));
                break;
        }
    }

    public void processEnhancement(String userChoice, Potion potion) {
        switch (userChoice) {
            case "1":
                potion.addOptionalEffect( new OptionalEffect("Stronger", "Enhancement", true));
                break;

            case "2":
                potion.addOptionalEffect( new OptionalEffect("Longer", "Enhancement", true));
                break;

            case "3":
                potion.addOptionalEffect( new OptionalEffect("Longer", "Enhancement", true));
                potion.addOptionalEffect( new OptionalEffect("Stronger", "Enhancement", true));
                break;

            case "0":
                return;
        }
    }

    public void processAdditionalEffect(String userChoice, Potion potion){

        int count = 0;
        while (!userChoice.equals("0") && count < 2){

            switch (userChoice){

                case "1":
                    potion.addOptionalEffect( new OptionalEffect("Water Breathing", "Additional Effect", true));
                    count++;
                    break;

                case "2":
                    potion.addOptionalEffect( new OptionalEffect("Fire Resistance", "Additional Effect", true));
                    count++;
                    break;

                case "3":
                    potion.addOptionalEffect( new OptionalEffect("Night Vision", "Additional Effect", true));
                    count++;
                    break;

                case "4":
                    potion.addOptionalEffect( new OptionalEffect("Invisibility", "Additional Effect", true));
                    count++;
                    break;

                case "5":
                    potion.addOptionalEffect( new OptionalEffect("Slow Falling", "Additional Effect", true));
                    count++;
                    break;
            }

            userChoice = InputValidation.getValidInput
                    (InputValidation.options(5));
        }
    }

    public void processVisualEffect(String userChoice, Potion potion){

        while (!userChoice.equals("0")){

            switch (userChoice){

                case "1":
                    potion.addOptionalEffect( new OptionalEffect("Glows", "Visual", false));
                    break;

                case "2":
                    potion.addOptionalEffect( new OptionalEffect("Swirly", "Visual", false));
                    break;

                case "3":
                    potion.addOptionalEffect( new OptionalEffect("Diamond Sparkle", "Visual", false));
                    break;

                case "4":
                    potion.addOptionalEffect( new OptionalEffect("Gold Flakes", "Visual", false));
                    break;

                case "5":
                    potion.addOptionalEffect( new OptionalEffect("Emerald Color", "Visual", false));
                    break;
            }

            userChoice = InputValidation.getValidInput
                        (InputValidation.options(5));
        }
    }

    public void processPotionHelper(String userChoice, Potion potion){

        while (!userChoice.equals("0")){

            switch (userChoice){

                case "1":
                    potion.addOptionalEffect( new OptionalEffect("Rotten Flesh", "Potion Helper", false));
                    break;

                    case "2":
                    potion.addOptionalEffect( new OptionalEffect("Nether Warts", "Potion Helper", false));
                    break;
            }

            userChoice = InputValidation.getValidInput
                    (InputValidation.options(2));
        }
    }

    public void addBasePotion(){

        clearConsole();

        // Show menu selector for base potion "types"
        promptBasePotionName();
        String potionName = InputValidation.getValidInput
                            (InputValidation.options(3));

        // Check if user canceled
        if(potionName.equalsIgnoreCase("0")){
            clearConsole();
            VillagerExpression.angry();
            return;
        }

        // Show menu selector for base potion sizes
        clearConsole();
        promptBasePotionSize();
        String potionSize = InputValidation.getValidInput
                            (InputValidation.options(4));

        // Check if user canceled
        if(potionSize.equalsIgnoreCase("0")){
            clearConsole();
            VillagerExpression.angry();
            return;
        }

        processBasePotionSelection(potionName, potionSize);
        clearConsole();
    }

    public void processBasePotionSelection(String potionName, String potionSize){

        switch (potionName){
            case "1" -> potionName = "Mundane";
            case "2" -> potionName = "Awkward";
            case "3" -> potionName = "Thick";
        }

        switch (potionSize){
            case "1" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.SMALL));
            case "2" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.MEDIUM));
            case "3" -> userOrder.addItem(new PotionBase(potionName, PotionBase.Size.LARGE));
        }
    }

    public void addTrade() {

        // Clear console then show menu selection
        clearConsole();
        promptTrade();

        processTradeSelection(InputValidation.getValidInput
                             (InputValidation.options(2)));
    }

    public void processTradeSelection(String userChoice){

        switch (userChoice){

            // Add in Golden Carrot to the order
            case "1":
                clearConsole();
                userOrder.addItem(new TradableItem(TradableItem.Item.GOLDEN_CARROT));
                break;

            // Add in Xp Bottle to the order
            case "2":
                clearConsole();
                userOrder.addItem(new TradableItem(TradableItem.Item.XP_BOTTLE));
                break;

            // Clear console before showing the angry villager for wasting his time
            case "0":
                clearConsole();
                VillagerExpression.angry();
                break;
        }
    }

    public boolean checkOut() {
        clearConsole();

        if(userOrder.isEmpty()){
            VillagerExpression.angry();
            System.out.println("        Hrghh! Hrghhh!! (Add an item before checking out)");
            return true;
        }
        userOrder.displayOrder();

        confirmOrder();

        String userChoice = InputValidation.getValidInput
                            (InputValidation.options(1));

        switch(userChoice){

            // Write receipt, empty the order, then returns to home
            case "1":
                ReceiptWriter.writeReceipt(userOrder);
                userOrder.clearOrder();
                return false;

            // Shows angry villager for wasting his time then return back to order menu
            case "0":
                clearConsole();
                VillagerExpression.angry();
                return true;

            default:
                return true;
        }
    }


    // Helper clear console
    private static void clearConsole(){ System.out.print("\033[H\033[2J"); }

   // Menu output
    public static void displayScreen() { System.out.println(MenuStrings.ORDER_MENU()); }
    public static void promptMainPotionEffect() { System.out.println(MenuStrings.MAIN_EFFECT_MENU()); }
    public static void promptPotionSize() { System.out.println(MenuStrings.POTION_SIZE()); }
    public static void promptPotionForm() { System.out.println(MenuStrings.POTION_FORM_MENU());}
    public static void promptAdditionalEffect(){ System.out.println(MenuStrings.ADDITIONAL_EFFECT_MENU()); }
    public static void promptEnhancement(){ System.out.println(MenuStrings.POTION_ENHANCEMENT()); }
    public static void promptVisualEffect(){ System.out.println(MenuStrings.VISUAL_EFFECT_MENU()); }
    public static void promptPotionHelper(){ System.out.println(MenuStrings.POTION_HELPER_MENU()); }
    public static void promptBasePotionName() { System.out.println(MenuStrings.BASE_POTION_MENU()); }
    public static void promptBasePotionSize(){ System.out.println(MenuStrings.BASE_POTION_SIZE_MENU()); }
    public static void promptTrade(){ System.out.println(MenuStrings.TRADE_MENU()); }
    public static void confirmOrder(){ System.out.println(MenuStrings.CONFIRM_CHECKOUT_MENU()); }

}

