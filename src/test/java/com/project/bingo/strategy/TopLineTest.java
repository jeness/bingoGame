package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Player;
import com.project.bingo.pojo.Ticket;
import com.project.bingo.strategy.TopLine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TopLineTest {
    private Ticket ticket;
    private BingoCell[][] board;

    @Before
    public void setup() {
        Player player = new Player(1);
        ticket = new Ticket(player);
        board = ticket.getBoard();
    }

    @Test
    public void willWinTest_withValidTopLine() {
        BingoCell[] firstLine = board[0];
        for(int colIndex = 0; colIndex < board[0].length; colIndex++) {
            if(!firstLine[colIndex].isEmptyCell()) {
                firstLine[colIndex].setChecked(true);
            }
        }
        TopLine topLine = new TopLine();
        assertEquals("Top Line", topLine.getWingCombinationName());
        assertTrue(topLine.willWin(ticket));
    }

    @Test
    public void willWinTest_withInvalidTopLine() {
        int numPerRow = ticket.getNumbersPerRow();

        BingoCell[] firstLine = board[0];
        int counter = 0;
        for(int colIndex = 0; colIndex < board[0].length; colIndex++) {
            if(!firstLine[colIndex].isEmptyCell()) {
                firstLine[colIndex].setChecked(true);
                counter++;
            }
            if(counter == numPerRow - 1){
                break;
            }
        }
        TopLine topLine = new TopLine();
        assertEquals("Top Line", topLine.getWingCombinationName());
        assertFalse(topLine.willWin(ticket));
    }
}
