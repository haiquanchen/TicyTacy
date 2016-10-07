package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

public class TTCrossInitializer implements ITTInitializer {

    public TTCrossInitializer() {

    }

    @Override
    public TTCell[][] initBoard() {
        TTCell[][] board = new TTCell[3][3];

        board[0][0] = new TTCell(TTCell.BLUE_PLAYER);
        board[0][1] = new TTCell(TTCell.NO_PLAYER);
        board[0][2] = new TTCell(TTCell.PURPLE_PLAYER);
        board[1][0] = new TTCell(TTCell.PURPLE_PLAYER);
        board[1][1] = new TTCell(TTCell.NO_PLAYER);
        board[1][2] = new TTCell(TTCell.BLUE_PLAYER);
        board[2][0] = new TTCell(TTCell.BLUE_PLAYER);
        board[2][1] = new TTCell(TTCell.NO_PLAYER);
        board[2][2] = new TTCell(TTCell.PURPLE_PLAYER);

        return board;
    }
}
