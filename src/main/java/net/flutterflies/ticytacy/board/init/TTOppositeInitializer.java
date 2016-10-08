/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.board.init;

import net.flutterflies.ticytacy.board.TTCell;
import net.flutterflies.ticytacy.board.TTCell.Owners;

/**
 * Class containing an implementation of {@link ITTInitializer}.
 * Initializes the board so that each player starts with one cell.
 * The cells are located in opposite corners of the board as follows:
 * <pre>
 *     [x] [ ] [ ]
 *     [ ] [ ] [ ]
 *     [ ] [ ] [o]
 * </pre>
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.2.0
 */
public class TTOppositeInitializer extends TTBlankInitializer {

    /**
     * Construct a new instance of the initializer.
     */
    public TTOppositeInitializer() {
    }

    /**
     * Initialize the cells of the board. Set each cell on the board
     * to be equal to a new {@link TTCell} follow this exact layout.
     * <pre>
     *     [x] [ ] [ ]
     *     [ ] [ ] [ ]
     *     [ ] [ ] [o]
     * </pre>
     *
     * @return The 3x3 grid of initialized cells.
     */
    @Override
    public TTCell[][] initBoard() {
        TTCell[][] board = super.initBoard();

        board[0][0] = new TTCell(Owners.PLAYER_1);
        board[2][2] = new TTCell(Owners.PLAYER_2);

        return board;
    }
}
