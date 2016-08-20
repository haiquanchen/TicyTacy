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
 * The interface all classes must implement to be usable as an Initializer.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public interface ITTInitializer {

    /**
     * Initialize the cells of the board.
     *
     * @return The 3x3 grid of initialized cells.
     */
    TTCell[][] initBoard();
}
