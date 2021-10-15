package com.project.bingo.strategy;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Ticket;

public class TopLine implements WinningCombination{
    private String name;

    public TopLine() {
        this.name = "Top Line";
    }

    @Override
    public String getWingCombinationName() {
        return this.name;
    }

    @Override
    public boolean willWin(Ticket ticket) {
        BingoCell[][] board = ticket.getBoard();
        for(int j = 0; j < ticket.getCol(); j++) {
            BingoCell cell = board[0][j];
            if(cell.isEmptyCell()) {
                continue;
            }
            if(!cell.isChecked()) {
                return false;
            }
        }
        return true;
    }
}
