/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy;

import net.flutterflies.ticytacy.board.TTBoard;
import net.flutterflies.ticytacy.board.init.TTBlankInitializer;
import net.flutterflies.ticytacy.board.init.TTRandomInitializer;
import net.flutterflies.ticytacy.display.TTDisplay;

import java.util.Arrays;
import java.util.List;

/**
 * Main class for Ticy Tacy. Contains the entry point for the program
 * as well as being the master class which connects the game logic
 * and the game display.
 *
 * @author Ashrynn Macke | Flutterflies
 * @version 0.1.0 (07.08.2016)
 */
public class TicyTacy {

    /**
     * Instance of the Game's board.
     */
    private final TTBoard board;

    /**
     * Instance of the game's display.
     */
    private final TTDisplay display;

    /**
     * Constructor for the TicyTacy class.
     */
    private TicyTacy(List<String> args) {
        if(args.contains("blank")) {
            board = new TTBoard(new TTBlankInitializer());
        }
        else if(args.contains("random")) {
            board = new TTBoard(new TTRandomInitializer());
        }
        else {
            board = new TTBoard();
        }

        display = new TTDisplay(this);
    }

    /**
     * Get the games instance of it's board
     *
     * @return The game board
     */
    public TTBoard getBoard() {
        return board;
    }

    /**
     * Get the instance of the game's display manager.
     *
     * @return The display manager
     */
    public TTDisplay getDisplay() {
        return display;
    }

    /**
     * Main method. Entry point for the program
     *
     * @param args the program arguments
     */
    public static void main(String[] args) {
        new TicyTacy(Arrays.asList(args));
    }
}
