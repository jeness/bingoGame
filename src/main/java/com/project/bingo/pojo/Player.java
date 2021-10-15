package com.project.bingo.pojo;

import com.project.bingo.strategy.WinningCombination;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private int playerId;
    private List<WinningCombination> wined;

    public Player(int id){
        this.playerId = id;
        this.wined = new ArrayList<>();
    }

//    Summary:
//    Player#1 : Early Five
//    Player#2 : Full House and Top Line
//    Player#3 : Nothing

    /**
     * Print winning combinations for a player to console
     */
    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player#").append(playerId).append(" : ");
        if(wined.isEmpty()) {
            sb.append("Nothing");
        }
        for (int i = 0; i < wined.size(); i++) {
            String name = wined.get(i).getWingCombinationName();
            sb.append(name);
            if(i != wined.size() - 1) {
                sb.append(" and ");
            }
        }
        System.out.println(sb);
    }
}
