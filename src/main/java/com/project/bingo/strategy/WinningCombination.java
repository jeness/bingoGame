package com.project.bingo.strategy;

import com.project.bingo.pojo.Ticket;

public interface WinningCombination {
    String getWingCombinationName();
    boolean willWin(Ticket ticket);
}
