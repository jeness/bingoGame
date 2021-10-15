package com.project.bingo.utils;


public class Validator {

    public static boolean isValidInput(int limit, int row,
                                       int col, int numbersPerRow) {
        if (numbersPerRow > col) {
            System.out.println("Numbers per row should be larger than the total number of cells in a row");
            System.out.println("Will use default value");
            return false;
        }
        if(row * numbersPerRow < 5) {
            System.out.println("The number of cells in the board should be larger than 5 for early five.");
            System.out.println("Will use default value");
            return false;
        }
        if( row * numbersPerRow > limit) {
            System.out.println("The generated numbers should be sufficient to fill in cells");
            System.out.println("Will use default value");
            return false;
        }
        return true;
    }

    public static boolean validateInputIsPositiveNumber(String input, String inputType) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("input " + input +" for " + inputType + " is not a int value");
            return false;
        }
        return Integer.signum(number) > 0;
    }

}
