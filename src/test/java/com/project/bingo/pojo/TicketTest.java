package com.project.bingo.pojo;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicketTest {
    @Test
    public void initializeBoardTest_defaultValue() {
        Player player = new Player(1);
        Ticket ticket = new Ticket(player);
        BingoCell[][] board = ticket.getBoard();
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            int numCounter = 0;
            int checkedCounter = 0;
            for(int colIndex = 0; colIndex < board[0].length; colIndex++) {
                BingoCell curCell = board[rowIndex][colIndex];
                if(!curCell.isEmptyCell()) {
                    numCounter++;
                }
                if(curCell.isChecked()){
                    checkedCounter++;
                }
            }
            assertEquals("numbers per row should equal to default value 5", 5, numCounter);
            assertEquals("After initialization, there should not be checked cells", 0, checkedCounter);
        }
    }

    @Test
    public void initializeBoardTest_setValue() {
        Player player = new Player(2);
        Ticket ticket = new Ticket(player, 4, 10, 6, 30);
        BingoCell[][] board = ticket.getBoard();
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            int numCounter = 0;
            int checkedCounter = 0;
            for(int colIndex = 0; colIndex < board[0].length; colIndex++) {
                BingoCell curCell = board[rowIndex][colIndex];
                if(!curCell.isEmptyCell()) {
                    numCounter++;
                }
                if(curCell.isChecked()){
                    checkedCounter++;
                }
            }
            assertEquals("numbers per row should equal to 6, same as input", 6, numCounter);
            assertEquals("After initialization, there should not be checked cells", 0, checkedCounter);
        }
    }

    @Test
    public void markCellTest_defaultValue() {
        Player player = new Player(1);
        Ticket ticket = new Ticket(player);
        BingoCell[][] board = ticket.getBoard();
        Random rand = new Random();
        int rowIndex = rand.nextInt(board.length);
        int colIndex = rand.nextInt(board[0].length);
        BingoCell cell = board[rowIndex][colIndex];
        while(cell.isEmptyCell()) {
            rowIndex = rand.nextInt(board.length);
            colIndex = rand.nextInt(board[0].length);
            cell = board[rowIndex][colIndex];
        }
        int number = cell.getNumber();
        ticket.markCell(number);

        assertTrue("Cell should be checked after marked.", cell.isChecked());
        assertFalse("Cell should not be Empty.", cell.isEmptyCell());
        assertEquals("The number in cell should be accurate.", cell.getNumber(), number);
    }

    @Test
    public void markCellTest_setValue() {
        Player player = new Player(1);
        Ticket ticket = new Ticket(player, 4, 10, 3, 20);
        BingoCell[][] board = ticket.getBoard();
        Random rand = new Random();
        int rowIndex = rand.nextInt(board.length);
        int colIndex = rand.nextInt(board[0].length);
        BingoCell cell = board[rowIndex][colIndex];
        while(cell.isEmptyCell()) {
            rowIndex = rand.nextInt(board.length);
            colIndex = rand.nextInt(board[0].length);
            cell = board[rowIndex][colIndex];
        }
        int number = cell.getNumber();
        ticket.markCell(number);

        assertTrue("Cell should be checked after marked.", cell.isChecked());
        assertFalse("Cell should not be Empty.", cell.isEmptyCell());
        assertEquals("The number in cell should be accurate.", cell.getNumber(), number);
    }
}