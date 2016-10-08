/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

import java.util.Random;

/**
 * Class containing an implementation of {@link ITTInitializer}.
 * Initializes the board so that each player starts with three
 * randomly assigned cells.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.2.0
 */
public class TTRandomInitializer extends TTBlankInitializer {

    /**
     * Instance of the random class used to randomly
     * generate cell owners.
     */
    private final Random random;

    /**
     * Construct a new instance of the initializer.
     */
    public TTRandomInitializer() {
        random = new Random();
    }

    /**
     * Initialize the cells of the board. Set each cell on the board
     * to be equal to a new {@link TTCell} with now owner. Then goes
     * the board and randomly set 3 cells to player 1 and three cells
     * to player 2.
     *
     * @return The 3x3 grid of initialized cells.
     */
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
