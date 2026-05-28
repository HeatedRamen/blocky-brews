package com.pluralsight.util;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputValidation {
    private static Scanner input = new Scanner(System.in);

    public static String getValidInput(List<String> validInput){

       // Keep looping until valid input
        while (true){

            // Prompt for user input / choice and store
            System.out.println("Enter in your choice");
            String userInput = input.nextLine().trim();

            // Look for a match and if matched return the string (exits loop as well)
            for(String option : validInput){
                if (userInput.equalsIgnoreCase(option)){
                    return userInput;
                }
            }

            // If no matches print default statement / error statement and loop again
            System.out.println("HRGHHHHHH! (Enter a valid choice)");
        }
    }

    public static List<String> options(int max) {
        return IntStream.rangeClosed(0, max)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

}
