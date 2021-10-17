package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Player;
import com.project.bingo.pojo.Ticket;
import com.project.bingo.strategy.FirstFive;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FirstFiveTest {
    private static final int VALUE_FIVE = 5;
    private Ticket ticket;
    private BingoCell[][] board;

    @Before
    public void setup() {
        Player player = new Player(1);
        ticket = new Ticket(player);
        board = ticket.getBoard();
    }

    @Test
    public void willWinTest_withValidFirstFive() {
        int counter = 0;
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for(int colIndex = 0; colIndex < board[0].length; colIndex++){
                BingoCell cell = board[rowIndex][colIndex];
                if(!cell.isEmptyCell()) {
                    cell.setChecked(true);
                    counter++;
                }
                if(counter == VALUE_FIVE) {
                    break;
                }
            }
            if(counter == VALUE_FIVE) {
                break;
            }
        }

        FirstFive firstFive = new FirstFive();
        assertEquals("First Five", firstFive.getWingCombinationName());
        assertTrue(firstFive.willWin(ticket));
    }

    @Test
    public void willWinTest_withInvalidFirstFive() {
        int counter = 0;
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for(int colIndex = 0; colIndex < board[0].length; colIndex++){
                BingoCell cell = board[rowIndex][colIndex];
                if(!cell.isEmptyCell()) {
                    cell.setChecked(true);
                    counter++;
                }
                if(counter == VALUE_FIVE - 1) {
                    break;
                }
            }
            if(counter == VALUE_FIVE - 1) {
                break;
            }
        }

        FirstFive firstFive = new FirstFive();
        assertEquals("First Five", firstFive.getWingCombinationName());
        assertFalse(firstFive.willWin(ticket));
    }
}
