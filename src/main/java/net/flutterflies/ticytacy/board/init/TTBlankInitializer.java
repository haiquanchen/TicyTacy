/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;

/**
 * Class containing an implementation of {@link ITTInitializer}.
 * Initializes the board by setting all cells to have no owner.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public class TTBlankInitializer implements ITTInitializer {

    /**
     * Construct a new instance of the initializer.
     */
    public TTBlankInitializer() {
    }

    /**
     * Initialize the cells of the board. Set each cell on the board
     * to be equal to a new {@link TTCell} with an owner of no player.
     *
     * @return The 3x3 grid of initialized cells.
     */
    public TTCell[][] initBoard() {
        TTCell[][] board = new TTCell[3][3];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = new TTCell();
            }
        }

        return board;
    }
}
