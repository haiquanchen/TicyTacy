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
 * Initializes the board so that each player starts with three cells.
 * The cells are arranged as follows:
 * <pre>
 *     [x] [ ] [o]
 *     [o] [ ] [x]
 *     [x] [ ] [o]
 * </pre>
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.2.0
 */
public class TTCrossInitializer implements ITTInitializer {

    /**
     * Construct a new instance of the initializer.
     */
    public TTCrossInitializer() {
    }

    /**
     * Initialize the cells of the board. Set each cell on the board
     * to be equal to a new {@link TTCell} follow this exact layout.
     * <pre>
     *     [x] [ ] [o]
     *     [o] [ ] [x]
     *     [x] [ ] [o]
     * </pre>
     *
     * @return The 3x3 grid of initialized cells.
     */
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
