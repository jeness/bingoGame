package com.project.bingo;

import com.project.bingo.pojo.Player;
import com.project.bingo.pojo.Ticket;
import com.project.bingo.strategy.FirstFive;
import com.project.bingo.strategy.FullHouse;
import com.project.bingo.strategy.TopLine;
import com.project.bingo.strategy.WinningCombination;
import com.project.bingo.utils.Constants;
import com.project.bingo.utils.GameInput;
import com.project.bingo.utils.RandomValueGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @Author Haoran Yu
 *
 */
public class BingoGame {
    public static void main(String[] args) {

        System.out.println("**** Lets Play Housie ***** \n\n");
        System.out.println("Note: - Press 'Q' to quit any time.");
        Scanner scanner = new Scanner(System.in);

        // get Input from user
        GameInput input = new GameInput(scanner);
//        System.out.println("My input will be ====== " + input);

        // init players, tickets and winning combination based on the input/default value
        List<Player> listOfPlayers = loadPlayers(input.getNumbersOfPlayers());
        List<Ticket> listOfTickets = loadTickets(listOfPlayers, input.getTicketRows(),
                input.getTicketColumns(), input.getNumbersPerRow(), input.getRangeHighest());
        Set<WinningCombination> winCombSet = loadWinningCombination();

        System.out.println("***Ticket Created Successfully ****");
        System.out.println(">> Press 'N' to generate next number.");

        RandomValueGenerator caller = new RandomValueGenerator(input.getRangeHighest());
        String option = scanner.nextLine();
        while (Constants.NEXT.equalsIgnoreCase(option)) {
            oneRound(caller, listOfTickets, winCombSet);
            if(gameFinished(winCombSet)) {
                break;
            } else {
                System.out.println(">> Press 'N' to generate next number.");
                option = scanner.nextLine();
            }
        }

        printSummary(listOfPlayers);
        scanner.close();
    }


    /**
     * this method is intended to do the business logic of one round of Bingo Game
     * 1. caller called a number
     * 2. mark the called number if each of the ticket
     * 3. check if any ticket could claim a winner
     *      if ticket claim one kind of winning combination, remove this type from winCombSet
     *
     *               ****** Assumption: ********
     *              if more than one tickets have first five,
     *              claim them all as first five at the same round
     * @param caller        to generate a random number of this round
     * @param tickets       list of tickets generated in this game
     * @param winCombSet    winning combinations of this game
     */
   private static void oneRound(RandomValueGenerator caller, List<Ticket> tickets,
                                  Set<WinningCombination> winCombSet) {
       int newNumber = caller.generateValue();
       System.out.println("Next Number is: " + newNumber);
       for (Ticket ticket : tickets) {
           ticket.markCell(newNumber);
       }

       Iterator<WinningCombination> iterator = winCombSet.iterator();
       while (iterator.hasNext()) {
           WinningCombination winComb = iterator.next();
           boolean willRemove = false; //flag for checking if the winComb need to be removed
           for (Ticket ticket : tickets) {
               if(winComb.willWin(ticket)) {
                   Player player = ticket.getPlayer();
                   player.getWined().add(winComb);
                   willRemove = true; //the winComb happened, will be removed
                   System.out.println("We have a winner: Player#" + player.getPlayerId()
                           +" has won '" + winComb.getWingCombinationName() + "' winning combination.");
               }
           }
           if (willRemove) {
               iterator.remove();
           }
       }

   }

    /**
     * this method is intended to check if game could be finished
     * game considered to be finished when all winning combinations have been claimed
     * @param winCombSet    set of winning combinations defined by the rule
     * @return              true if game is finished, false if not finished
     */
   private static boolean gameFinished(Set<WinningCombination> winCombSet) {
       return winCombSet.isEmpty();
   }

    // ***** Game Over *****
    //
    // ======================
    //              Summary:
    // Player#1 : Early Five
    // Player#2 : Full House and Top Line
    // Player#3 : Nothing
    // =======================

    private static void printSummary(List<Player> listOfPlayers) {
        System.out.println("***** Game Over *****");
        System.out.println();
        System.out.println("             Summary:");
        for (Player player : listOfPlayers) {
            player.printResult();
        }
    }
    private static List<Player> loadPlayers(int numOfPlayers) {
        List<Player> listOfPlayers = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            Player player = new Player(i);
            listOfPlayers.add(player);
        }
        return listOfPlayers;
    }

    private static List<Ticket> loadTickets(List<Player> listOfPlayers, int row, int col, int numbersPerRow, int limit) {
        List<Ticket> listOfTickets = new ArrayList<>();

        for(Player player : listOfPlayers) {
            Ticket ticket = new Ticket(player, row, col, numbersPerRow, limit);
            listOfTickets.add(ticket);
        }
        return listOfTickets;
    }

    private static Set<WinningCombination> loadWinningCombination() {
        Set<WinningCombination> winCombSet = new HashSet<>();
        WinningCombination firstFive = new FirstFive();
        WinningCombination fullHouse = new FullHouse();
        WinningCombination topLine = new TopLine();
        winCombSet.add(firstFive);
        winCombSet.add(fullHouse);
        winCombSet.add(topLine);
        return winCombSet;
    }

}
