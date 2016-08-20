package net.flutterflies.ticytacy.board;

import net.flutterflies.ticytacy.board.init.ITTInitializer;
import net.flutterflies.ticytacy.board.init.TTBlankInitializer;

/**
 * Created by ashrynn on 8/4/16.
 */
public class TTBoard {

    private TTCell[][] board;
    private int turnNumber;
    private int blueCells;
    private int purpleCells;

    public TTBoard() {
        this(new TTBlankInitializer());
    }

    public TTBoard(ITTInitializer initializer) {
        board = initializer.initBoard();
        turnNumber = 1;
        blueCells = 0;
        purpleCells = 0;
    }

    public void reset() {
        turnNumber = 1;
        blueCells = 0;
        purpleCells = 0;

        for(int i = 0; i < getSize(); i++) {
            for(int j = 0; j < getSize(); j++) {
                getCell(i, j).setOwner(TTCell.NO_PLAYER);
            }
        }
    }

    public void updateBoard(int cellX, int cellY, int newOwner) {
        blueCells = 0;
        purpleCells = 0;

        if(newOwner != TTCell.NO_PLAYER) {
            turnNumber++;
        }

        board[cellX][cellY].setOwner(newOwner);

        for(int i = 0; i < getSize(); i++) {
            for(int j = 0; j < getSize(); j++) {
                if(getCell(i, j).getOwner() == TTCell.BLUE_PLAYER) {
                    blueCells++;
                }
                else if(getCell(i, j).getOwner() == TTCell.PURPLE_PLAYER) {
                    purpleCells++;
                }
            }
        }
    }

    public boolean checkWinCondition(int playerToCheck) {
        boolean hasWon = false;

        //Top row
        if(getCell(0, 0).getOwner() == playerToCheck && getCell(0, 1).getOwner() == playerToCheck && getCell(0, 2).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Center Row
        else if(getCell(1, 0).getOwner() == playerToCheck && getCell(1, 1).getOwner() == playerToCheck && getCell(1, 2).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Bottom Row
        else if(getCell(2, 0).getOwner() == playerToCheck && getCell(2, 1).getOwner() == playerToCheck && getCell(2, 2).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Left Column
        else if(getCell(0, 0).getOwner() == playerToCheck && getCell(1, 0).getOwner() == playerToCheck && getCell(2, 0).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Center Column
        else if(getCell(0, 1).getOwner() == playerToCheck && getCell(1, 1).getOwner() == playerToCheck && getCell(2, 1).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Bottom Row
        else if(getCell(0, 2).getOwner() == playerToCheck && getCell(1, 2).getOwner() == playerToCheck && getCell(2, 2).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Top left -> Bottom right
        else if(getCell(0, 0).getOwner() == playerToCheck && getCell(1, 1).getOwner() == playerToCheck && getCell(2, 2).getOwner() == playerToCheck) {
            hasWon = true;
        }
        //Top right -> Bottom left
        else if(getCell(0, 2).getOwner() == playerToCheck && getCell(1, 1).getOwner() == playerToCheck && getCell(2, 0).getOwner() == playerToCheck) {
            hasWon = true;
        }

        return hasWon;
    }

    public int getSize() {
        return board.length;
    }

    public TTCell getCell(int x, int y) {
        return board[x][y];
    }

    public int getBlueCells() {
        return blueCells;
    }

    public int getPurpleCells() {
        return purpleCells;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
