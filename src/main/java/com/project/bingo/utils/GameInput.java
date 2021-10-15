package com.project.bingo.utils;

import lombok.Data;

import java.util.Scanner;

@Data
public class GameInput {

    private int numbersPerRow;
    private int ticketRows;
    private int ticketColumns;
    private int rangeHighest;
    private int numbersOfPlayers;

    public GameInput(Scanner scanner) {

        int numbersPerRow = Constants.DEFAULT_NUMBERS_PER_ROW;
        int ticketColumns = Constants.DEFAULT_COL;
        int ticketRows = Constants.DEFAULT_ROW;
        int rangeHighest = Constants.DEFAULT_LIMIT_NUMBER;
        int numbersOfPlayers = Constants.DEFAULT_NUM_OF_PLAYER;

        System.out.println("Enter the number range(1-n) : ");
        String inputStr = readLine(scanner);
        if(Validator.validateInputIsPositiveNumber(inputStr, "[number range]")) {
            rangeHighest = Integer.parseInt(inputStr);
        } else {
            System.out.println("[number range] is not a valid integer, will use default value 90.");
        }

        System.out.println("Enter Number of players playing the game: ");
        inputStr = readLine(scanner);
        if(Validator.validateInputIsPositiveNumber(inputStr, "[number of players]")) {
            numbersOfPlayers = Integer.parseInt(inputStr);
        } else {
            System.out.println("[number of players] is not a valid integer, will use default value 5. ");
        }


        System.out.println("Enter Ticket Size in the format of row (Default to 3X10): ");
        inputStr = readLine(scanner);
        String[] ticketSize = inputStr.split("X");
        if(Validator.validateInputIsPositiveNumber(ticketSize[0], "[row]")) {
            ticketRows = Integer.parseInt(ticketSize[0]);
        } else {
            System.out.println("[row] is not a valid integer, will use default value 3. ");
        }
        if(Validator.validateInputIsPositiveNumber(ticketSize[1], "[col]")) {
            ticketColumns = Integer.parseInt(ticketSize[1]);
        } else {
            System.out.println("[col] is not a valid integer, will use default value 10. ");
        }

        System.out.println("Enter numbers per row (Default to 5): ");
        inputStr = readLine(scanner);
        if(Validator.validateInputIsPositiveNumber(inputStr, "[numbers per row]")) {
            numbersPerRow = Integer.parseInt(inputStr);
        } else {
            System.out.println("Input [numbers per row] is not a valid integer, will use default value 5. ");
        }

        if(Validator.isValidInput(rangeHighest, ticketRows, ticketColumns, numbersPerRow)) {
            this.numbersPerRow = numbersPerRow;
            this.ticketRows = ticketRows;
            this.ticketColumns = ticketColumns;
            this.rangeHighest = rangeHighest;
        } else {
            this.numbersPerRow = Constants.DEFAULT_NUMBERS_PER_ROW;
            this.ticketColumns = Constants.DEFAULT_COL;
            this.ticketRows = Constants.DEFAULT_ROW;
            this.rangeHighest = Constants.DEFAULT_LIMIT_NUMBER;
        }

        this.numbersOfPlayers = numbersOfPlayers;
    }

    private String readLine(Scanner scanner) {
        String input = scanner.nextLine();
        if(Constants.QUIT.equals(input)) {
            System.out.println("Thanks for playing with us, Good Bye!");
            System.exit(1);
        }
        return input;
    }

}
