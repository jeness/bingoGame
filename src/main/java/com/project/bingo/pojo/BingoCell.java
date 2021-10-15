package com.project.bingo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BingoCell {
    private int number;
    private boolean isChecked;
    private boolean isEmptyCell;


    /**
     * A constructor of an empty cell in a ticket
     */
    public BingoCell() {
        this.isEmptyCell = true;
        this.isChecked = false;
    }

    /**
     * A constructor of a cell in a ticket with a random number
     * @param number random number in the cell
     */
    public BingoCell(int number) {
        this.number = number;
        this.isChecked = false;
        this.isEmptyCell = false;
    }

}
