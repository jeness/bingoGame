package com.project.bingo.pojo;

import com.project.bingo.pojo.BingoCell;
import com.project.bingo.pojo.Player;
import com.project.bingo.utils.RandomValueGenerator;
import lombok.Data;

import java.util.Arrays;

import static com.project.bingo.utils.Constants.DEFAULT_COL;
import static com.project.bingo.utils.Constants.DEFAULT_ROW;
import static com.project.bingo.utils.Constants.DEFAULT_NUMBERS_PER_ROW;


@Data
public class Ticket {

    private BingoCell[][] board;
    private int row;
    private int col;
    private Player player;
    private int numbersPerRow;
    private RandomValueGenerator cellValueGenerator;


    /**
     * default constructor to generate Tickets when row, col and numbersPerRow
     * not given by user
     * @param player
     */
    public Ticket (Player player) {
        this.row = DEFAULT_ROW;
        this.col = DEFAULT_COL;
        this.numbersPerRow = DEFAULT_NUMBERS_PER_ROW;
        this.player = player;
        this.cellValueGenerator = new RandomValueGenerator();
        this.board = initializeBoard();
    }

    /**
     * constructor to generate Tickets from user input params
     *
     * @param player the player assigned to the ticket
     * @param row number of rows in the board
     * @param col number of columns in the board
     * @param numbersPerRow number of cells contains a number in a row
     * @param limit range [1, limit] is the range of numbers in ticket
     */
    public Ticket(Player player, int row, int col, int numbersPerRow, int limit) {
        this.player = player;
        this.row = row;
        this.col = col;
        this.numbersPerRow = numbersPerRow;
        this.cellValueGenerator = new RandomValueGenerator(limit);
        this.board = initializeBoard();
    }

    /**
     * TODO: polish verb of this comment
     * This method is intended to initialize the ticket board with row, column,
     * populate numbersPerRow numbers with random values and remaining with empty BingoCells
     * in each row
     * @return the board populated random int values range [1, limit]
     */
    public BingoCell[][] initializeBoard() {
        //TODO: validate BingoCell() is called
        BingoCell[][] board = new BingoCell[row][col];
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            Arrays.fill(board[rowIndex], new BingoCell());
            RandomValueGenerator colIndexGenerator = new RandomValueGenerator(col);
            for (int count = 0; count < numbersPerRow; count++) {
                int colIndex = colIndexGenerator.generateValue() - 1;
                board[rowIndex][colIndex] = new BingoCell(cellValueGenerator.generateValue());
            }
        }
        return board;
    }

    public void markCell(int number) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                BingoCell cell = board[i][j];
                if (cell.isEmptyCell()) {
                    continue;
                }
                if (number == cell.getNumber()) {
                    cell.setChecked(true);
                }
            }
        }
    }
}
