/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.board;

import net.flutterflies.ticytacy.board.init.ITTInitializer;
import net.flutterflies.ticytacy.board.init.TTBlankInitializer;
import net.flutterflies.ticytacy.board.TTCell.Owners;

/**
 * Class used to represent a Ticy Tacy game board.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public class TTBoard {

    /**
     * An array of {@link TTCell} that makes up the actual board.
     */
    private TTCell[][] board;

    /**
     * The initializer being used to create the board.
     */
    private ITTInitializer initializer;

    /**
     * The current turn number, an odd turn number represents
     * that it is player 1's turn, and even turn number
     * represents that it is player 2's turn.
     */
    private int turnNumber;

    /**
     * The current number of cells owned by player 1 on the board.
     */
    private int player1Cells;

    /**
     * The current number of cells owned by player 2 on the board.
     */
    private int player2Cells;

    /**
     * Construct a new instance of the Ticy Tacy Board with a
     * blank initializer.
     */
    public TTBoard() {
        this(new TTBlankInitializer());
    }

    /**
     * Construct a new instance of the Ticy Tacy Board with
     * a provided {@link ITTInitializer} to initialize the
     * board.
     *
     * @param initParam The Initializer to use when creating
     *                    the board.
     */
    public TTBoard(ITTInitializer initParam) {
        turnNumber = 1;
        player1Cells = 0;
        player2Cells = 0;

        initializer = initParam;
        board = initializer.initBoard();
        updateCellCount();
    }

    /**
     * Reset the current game board.
     */
    public void reset() {
        turnNumber = 1;
        player1Cells = 0;
        player2Cells = 0;

        board = initializer.initBoard();
        updateCellCount();
    }

    /**
     * Update the owner of a given cell on the board.
     *
     * @param cellI    the vertical placement of the cell to update.
     * @param cellJ    The horizontal placement of the cell to update.
     * @param newOwner The new owner of the cell.
     */
    public void updateBoard(int cellI, int cellJ, Owners newOwner) {
        player1Cells = 0;
        player2Cells = 0;

        if(!newOwner.equals(Owners.NO_PLAYER)) {
            turnNumber++;
        }

        board[cellI][cellJ].setOwner(newOwner);

        updateCellCount();
    }

    /**
     * Check the current state of the board to see if the given player
     * has won the game. Winning conditions are three cells in a row
     * either horizontally, vertically, or diagonally.
     *
     * @param playerToCheck The player to check the win condition for.
     * @return True if a player has won.
     */
    public boolean checkWinCondition(Owners playerToCheck) {
        boolean hasWon = false;

        //Top row
        if(getCell(0, 0).getOwner().equals(playerToCheck) && getCell(0, 1).getOwner().equals(playerToCheck) && getCell(0, 2).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Center Row
        else if(getCell(1, 0).getOwner().equals(playerToCheck) && getCell(1, 1).getOwner().equals(playerToCheck) && getCell(1, 2).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Bottom Row
        else if(getCell(2, 0).getOwner().equals(playerToCheck) && getCell(2, 1).getOwner().equals(playerToCheck) && getCell(2, 2).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Left Column
        else if(getCell(0, 0).getOwner().equals(playerToCheck) && getCell(1, 0).getOwner().equals(playerToCheck) && getCell(2, 0).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Center Column
        else if(getCell(0, 1).getOwner().equals(playerToCheck) && getCell(1, 1).getOwner().equals(playerToCheck) && getCell(2, 1).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Right Column
        else if(getCell(0, 2).getOwner().equals(playerToCheck) && getCell(1, 2).getOwner().equals(playerToCheck) && getCell(2, 2).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Top left -> Bottom right
        else if(getCell(0, 0).getOwner().equals(playerToCheck) && getCell(1, 1).getOwner().equals(playerToCheck) && getCell(2, 2).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }
        //Top right -> Bottom left
        else if(getCell(0, 2).getOwner().equals(playerToCheck) && getCell(1, 1).getOwner().equals(playerToCheck) && getCell(2, 0).getOwner().equals(playerToCheck)) {
            hasWon = true;
        }

        return hasWon;
    }

    /**
     * Updates the current count of how many cells each player owns
     */
    private void updateCellCount() {
        player1Cells = 0;
        player2Cells = 0;

        for(int i = 0; i < getSize(); i++) {
            for(int j = 0; j < getSize(); j++) {
                if(getCell(i, j).getOwner() == Owners.PLAYER_1) {
                    player1Cells++;
                }
                else if(getCell(i, j).getOwner() == Owners.PLAYER_2) {
                    player2Cells++;
                }
            }
        }
    }

    /**
     * Return the size of the game board. The game board will always
     * be square so the length and width will always be the same.
     *
     * @return The size of the game board.
     */
    public int getSize() {
        return board.length;
    }

    /**
     * Retrieve a cell from the game board at the given coordinates.
     *
     * @param i The Vertical position of the cell.
     * @param j The Horizontal position of the cell.
     * @return The cell at the given coordinates.
     */
    public TTCell getCell(int i, int j) {
        return board[i][j];
    }

    /**
     * Get the number of cells owned by player 1 present in the game board.
     *
     * @return The number of cells owned by player 1.
     */
    public int getPlayer1Cells() {
        return player1Cells;
    }

    /**
     * Get the number of cells owned by player 2 present in the game board.
     *
     * @return The number of cells owned by player 2.
     */
    public int getPlayer2Cells() {
        return player2Cells;
    }

    /**
     * Get the current turn number for the game.
     *
     * @return The current turn of the game.
     */
    public int getTurnNumber() {
        return turnNumber;
    }
}
