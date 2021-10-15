package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Ticket;

public class FullHouse implements WinningCombination {
    private String name;

    public FullHouse() {
        this.name = "Full House";
    }
    @Override
    public String getWingCombinationName() {
        return this.name;
    }

    @Override
    public boolean willWin(Ticket ticket) {
        BingoCell[][] board = ticket.getBoard();
        for(int i = 0; i < ticket.getRow(); i++) {
            for(int j = 0; j < ticket.getCol(); j++) {
                BingoCell cell = board[i][j];
                if(cell.isEmptyCell()) {
                    continue;
                }
                if(!cell.isChecked()) {
                    return false;
                }
            }
        }
        return true;
    }
}
