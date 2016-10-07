package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

public class TTOppositeInitializer extends TTBlankInitializer {


    @Override
    public TTCell[][] initBoard() {
        TTCell[][] board = super.initBoard();

        board[0][0] = new TTCell(TTCell.BLUE_PLAYER);
        board[2][2] = new TTCell(TTCell.PURPLE_PLAYER);

        return board;
    }
}
