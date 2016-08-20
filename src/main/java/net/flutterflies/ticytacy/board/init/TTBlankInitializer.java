package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

/**
 * Created by ashrynn on 8/4/16.
 */
public class TTBlankInitializer implements ITTInitializer {

    public TTBlankInitializer() {
    }

    public TTCell[][] initBoard() {
        TTCell[][] board = new TTCell[3][3];

        for(int i = 0; i <  board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = new TTCell();
            }
        }

        return board;
    }
}
