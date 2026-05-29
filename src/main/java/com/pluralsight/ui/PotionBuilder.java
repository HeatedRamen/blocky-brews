package com.pluralsight.ui;

import com.pluralsight.model.*;
import com.pluralsight.util.InputValidation;

public class PotionBuilder {

    public void buildPotion(Order userOrder){

        Potion potion = new Potion();

        getPotionMainEffect(potion);
        getPotionSize(potion);
        getPotionForm(potion);
        getPotionEnhancement(potion);
        getPotionAdditionalEffect(potion);
        getPotionVisualEffect(potion);
        getPotionHelper(potion);

        confirmPotion(potion, userOrder);
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
    public void getPotionMainEffect(Potion potion){
        clearConsole();
        promptMainPotionEffect();
        potion.setMainEffect(processMainEffect(InputValidation.getValidInput
                (InputValidation.options(1, 6))));
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
    public void getPotionSize(Potion potion){
        clearConsole();
        promptPotionSize();
        potion.setSize(processPotionSize(InputValidation.getValidInput
                (InputValidation.options(1, 3))));
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
    public void getPotionForm(Potion potion){
        clearConsole();
        promptPotionForm();
        processPotionForm(InputValidation.getValidInput
                (InputValidation.options(2)), potion);
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
    public void getPotionEnhancement(Potion potion){
        clearConsole();
        promptEnhancement(potion.getSize());
        processEnhancement(InputValidation.getValidInput
                (InputValidation.options(3)), potion);
    }

    public void processAdditionalEffect(String userChoice, Potion potion){

        int count = 0;

        while (!userChoice.equals("0") && count < 2){

            switch (userChoice){

                case "1":
                    potion.addOptionalEffect(
                            new OptionalEffect("Water Breathing", "Additional Effect", true));
                    break;

                case "2":
                    potion.addOptionalEffect(
                            new OptionalEffect("Fire Resistance", "Additional Effect", true));
                    break;

                case "3":
                    potion.addOptionalEffect(
                            new OptionalEffect("Night Vision", "Additional Effect", true));
                    break;

                case "4":
                    potion.addOptionalEffect(
                            new OptionalEffect("Invisibility", "Additional Effect", true));
                    break;

                case "5":
                    potion.addOptionalEffect(
                            new OptionalEffect("Slow Falling", "Additional Effect", true));
                    break;
            }

            count++;

            if (count < 2) {
                userChoice = InputValidation.getValidInput(
                        InputValidation.options(5));
            }
        }
    }
    public void getPotionAdditionalEffect(Potion potion){
        clearConsole();
        promptAdditionalEffect(potion.getSize());
        processAdditionalEffect(InputValidation.getValidInput
                (InputValidation.options(5)), potion);
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
    public void getPotionVisualEffect(Potion potion){
        clearConsole();
        promptVisualEffect();
        processVisualEffect(InputValidation.getValidInput
                (InputValidation.options(5)), potion);
    }

    public void addPotionHelper(String userChoice, Potion potion){

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
    public void getPotionHelper(Potion potion){
        clearConsole();
        promptPotionHelper();
        addPotionHelper(InputValidation.getValidInput
                (InputValidation.options(2)), potion);
    }

    public void confirmPotion(Potion potion, Order userOrder){

        clearConsole();

        System.out.println(MenuStrings.CONFIRM_POTION_HEADER());
        System.out.println(potion);
        System.out.println(MenuStrings.CONFIRM_POTION());

        String userChoice = InputValidation.getValidInput(
                InputValidation.options(1));

        switch (userChoice){

            case "1":
                userOrder.addItem(potion);
                clearConsole();
                break;

            case "0":
                VillagerExpression.angry();
                System.out.println("                Hrghhh... (Potion discarded)");
                break;
        }
    }

    public void buildSignaturePotion(Order userOrder){

        clearConsole();
        displaySignatureOption();

        Potion signaturePotion = processSignaturePotion(InputValidation.getValidInput
                                (InputValidation.options(1,2)));

        promptRemoval(signaturePotion);
        addAdditionCustomization(signaturePotion);

        confirmPotion(signaturePotion, userOrder);
    }

    public Potion processSignaturePotion(String userChoice){

        switch (userChoice){
            case "1":
                return new BloxyCola();
            case "2":
                return new CrashOut();
        }
        return null;
    }

    public void promptRemoval(Potion potion){

        while (!potion.getOptionalEffects().isEmpty()){

        }
    }

    public void addAdditionCustomization(Potion potion){

        clearConsole();
        promptCustomization();

        String userChoice = InputValidation.getValidInput
                            (InputValidation.options(5));

        while (!userChoice.equals(0)){

            switch (userChoice) {
                case "1":
                    getPotionForm(potion);
                    break;

                case "2":
                    getPotionEnhancement(potion);
                    break;

                case "3":
                    getPotionAdditionalEffect(potion);
                    break;

                case "4":
                    getPotionVisualEffect(potion);
                    break;

                case "5":
                    getPotionHelper(potion);
                    break;
            }

            userChoice = InputValidation.getValidInput
                    (InputValidation.options(5));
        }
    }

    // Helper clear console
    private static void clearConsole(){ System.out.print("\033[H\033[2J"); }

    // Menu Output
    public static void promptMainPotionEffect()                           { System.out.println(MenuStrings.MAIN_EFFECT_MENU()); }
    public static void promptPotionSize()                                 { System.out.println(MenuStrings.POTION_SIZE()); }
    public static void promptPotionForm()                                 { System.out.println(MenuStrings.POTION_FORM_MENU());}
    public static void promptAdditionalEffect(Potion.PotionSize size)     { System.out.println(MenuStrings.ADDITIONAL_EFFECT_MENU(size)); }
    public static void promptEnhancement(Potion.PotionSize size)          { System.out.println(MenuStrings.POTION_ENHANCEMENT(size)); }
    public static void promptVisualEffect()                               { System.out.println(MenuStrings.VISUAL_EFFECT_MENU()); }
    public static void promptPotionHelper()                               { System.out.println(MenuStrings.POTION_HELPER_MENU()); }
    public static void displaySignatureOption()                           { System.out.println(MenuStrings.SIGNATURE_POTION_MENU());}
    public static void promptCustomization()                              { System.out.println(MenuStrings.ADD_EFFECT_TO_SIGNATURE());}
}
