package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Ticket;

public class FirstFive implements WinningCombination{
    private static final int VALUE_FIVE = 5;
    private String name;

    public FirstFive() {
        this.name = "First Five";
    }

    @Override
    public String getWingCombinationName() {
        return this.name;
    }

    @Override
    public boolean willWin(Ticket ticket) {
        BingoCell[][] board = ticket.getBoard();
        int counter = 0;
        for(int i = 0; i < ticket.getRow(); i++) {
            for(int j = 0; j < ticket.getCol(); j++) {
                BingoCell cell = board[i][j];
                if(cell.isEmptyCell()) {
                    continue;
                }
                if(cell.isChecked()) {
                    counter++;
                }
                if(counter == VALUE_FIVE) {
                    return true;
                }
            }
        }
        return false;
    }
}
