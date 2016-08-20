package net.flutterflies.ticytacy;

import net.flutterflies.ticytacy.board.TTBoard;
import net.flutterflies.ticytacy.display.TTDisplay;

/**
 * Created by ashrynn on 8/4/16.
 */
public class TicyTacy {

    private TTBoard board;
    private TTDisplay display;

    private TicyTacy() {
        board = new TTBoard();
        display = new TTDisplay(this);
    }

    public TTBoard getBoard() {
        return board;
    }

    public TTDisplay getDisplay() {
        return display;
    }

    public void endGame() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new TicyTacy();
    }
}
