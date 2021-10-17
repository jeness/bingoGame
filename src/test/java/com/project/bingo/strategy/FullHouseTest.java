package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Player;
import com.project.bingo.pojo.Ticket;
import com.project.bingo.strategy.FullHouse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class FullHouseTest {
    private Ticket ticket;
    private BingoCell[][] board;

    @Before
    public void setup() {
        Player player = new Player(1);
        ticket = new Ticket(player);
        board = ticket.getBoard();
    }

    @Test
    public void willWinTest_withValidFullHouse() {
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for(int colIndex = 0; colIndex < board[0].length; colIndex++){
                BingoCell cell = board[rowIndex][colIndex];
                if(!cell.isEmptyCell()) {
                    cell.setChecked(true);
                }
            }
        }

        FullHouse fullHouse = new FullHouse();
        assertEquals("Full House", fullHouse.getWingCombinationName());
        assertTrue(fullHouse.willWin(ticket));
    }

    @Test
    public void willWinTest_withInvalidFullHouse() {
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            if(rowIndex == board.length - 1) {
                continue;
            }
            for(int colIndex = 0; colIndex < board[0].length; colIndex++){
                BingoCell cell = board[rowIndex][colIndex];
                if(!cell.isEmptyCell()) {
                    cell.setChecked(true);
                }
            }
        }

        FullHouse fullHouse = new FullHouse();
        assertEquals("Full House", fullHouse.getWingCombinationName());
        assertFalse(fullHouse.willWin(ticket));
    }
}
