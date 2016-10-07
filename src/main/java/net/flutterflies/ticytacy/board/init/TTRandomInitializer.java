package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

import java.util.Random;

public class TTRandomInitializer extends TTBlankInitializer {
    private final Random random;

    public TTRandomInitializer() {
        random = new Random();
    }

    @Override
    public TTCell[][] initBoard() {
        TTCell[][] board = super.initBoard();
        int player1Cells = 0;
        int player2Cells = 0;

        //Pesudo-randomly create three cells for player 1
        while(player1Cells < 3) {
            int i = random.nextInt(3);
            int j = random.nextInt(3);

            if(board[i][j].getOwner() == TTCell.NO_PLAYER) {
                board[i][j] = new TTCell(TTCell.PURPLE_PLAYER);
                player1Cells++;
            }

        }

        //Pesudo-randomly create three cells for player 2
        while(player2Cells < 3) {
            int i = random.nextInt(3);
            int j = random.nextInt(3);

            if(board[i][j].getOwner() == TTCell.NO_PLAYER) {
                board[i][j] = new TTCell(TTCell.BLUE_PLAYER);
                player2Cells++;
            }
        }

        return board;
    }
}
