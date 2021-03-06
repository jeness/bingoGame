package com.project.bingo.utils;


public class Validator {

    public static boolean isValidInput(int limit, int row,
                                       int col, int numbersPerRow) {
        if (numbersPerRow > col) {
            System.out.println("[numbers per row] should be larger than [the total number of cells in a row]");
            System.out.println("Will use default value: [numbers per row] = 5, " +
                    "[numbers per col] = 10, " +
                    "[numbers per row] = 3, " +
                    "[number range] = 90.");
            return false;
        }
        if(row * numbersPerRow < 5) {
            System.out.println("[The number of cells in the board] should be larger than 5 for early five.");
            System.out.println("Will use default value: [numbers per row] = 5, " +
                    "[numbers per col] = 10, " +
                    "[numbers per row] = 3, " +
                    "[number range] = 90.");
            return false;
        }
        if( row * numbersPerRow > limit) {
            System.out.println("The generated numbers should be sufficient to fill in cells");
            System.out.println("Will use default value: [numbers per row] = 5, " +
                    "[numbers per col] = 10, " +
                    "[numbers per row] = 3, " +
                    "[number range] = 90.");
            return false;
        }
        return true;
    }

    public static boolean validateInputIsPositiveNumber(String input, String inputType) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Input [" + input +"] for [" + inputType + "] is not a int value");
            return false;
        }
        return Integer.signum(number) > 0;
    }

}
