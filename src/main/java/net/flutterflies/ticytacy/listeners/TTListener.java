/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.listeners;

import net.flutterflies.ticytacy.TicyTacy;
import net.flutterflies.ticytacy.board.TTCell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@link ActionListener} that controls the program.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public class TTListener implements ActionListener {

    /**
     * Instance of the TicyTacy main class used to access
     * other parts of the program.
     */
    private final TicyTacy ticyTacy;

    /**
     * Construct a new instance of the TTListener.
     *
     * @param ticyTacy The instance of the main program class.
     */
    public TTListener(TicyTacy ticyTacy) {
        this.ticyTacy = ticyTacy;
    }

    /**
     * Listener method for when an action event happens.
     * This method checks the conditions of the event and
     * delegates further operation based on those conditions.
     *
     * @param event The event that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();
        String[] cords = clickedButton.getName().split(",");
        int i = Integer.parseInt(cords[0]);
        int j = Integer.parseInt(cords[1]);
        int currentCellOwner = ticyTacy.getBoard().getCell(i, j).getOwner();
        int turnPlayer = ticyTacy.getBoard().getTurnNumber() % 2;
        boolean hasWon = false;

        if(turnPlayer == 1) {
            onBlue(i, j, currentCellOwner);
            if(ticyTacy.getBoard().getBlueCells() == 3) {
                hasWon = ticyTacy.getBoard().checkWinCondition(TTCell.BLUE_PLAYER);
            }
        }
        else {
            onPurple(i, j, currentCellOwner);
            if(ticyTacy.getBoard().getPurpleCells() == 3) {
                hasWon = ticyTacy.getBoard().checkWinCondition(TTCell.PURPLE_PLAYER);
            }
        }

        ticyTacy.getDisplay().updateBoardDisplay(ticyTacy.getBoard());
        if(hasWon) {
            displayWin(turnPlayer);
        }
    }

    /**
     * If a button was pressed on the Blue player's turn then
     * this method is called. checks the button that was clicked
     * and updates the board accordingly for the next round.
     *
     * @param i                The vertical coordinate of the clicked cell.
     * @param j                The horizontal coordinate of the clicked cell.
     * @param currentCellOwner The current owner of the clicked cell.
     */
    private void onBlue(int i, int j, int currentCellOwner) {
        if(currentCellOwner == TTCell.PURPLE_PLAYER) {
            JOptionPane.showMessageDialog(
                    ticyTacy.getDisplay(),
                    "You cannot claim that cell, it is owned by the purple player.",
                    "Whoopsie",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        else if(currentCellOwner == TTCell.BLUE_PLAYER) {
            ticyTacy.getBoard().updateBoard(i, j, TTCell.NO_PLAYER);
        }
        else {
            if(ticyTacy.getBoard().getBlueCells() == 3) {
                JOptionPane.showMessageDialog(
                        ticyTacy.getDisplay(),
                        "You cannot claim more than three (3) cells at a time.",
                        "Whoopsie",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            else {
                ticyTacy.getBoard().updateBoard(i, j, TTCell.BLUE_PLAYER);
            }
        }
    }

    /**
     * If a button was pressed on the Purple player's turn then
     * this method is called. checks the button that was clicked
     * and updates the board accordingly for the next round.
     *
     * @param i                The vertical coordinate of the clicked cell.
     * @param j                The horizontal coordinate of the clicked cell.
     * @param currentCellOwner The current owner of the clicked cell.
     */
    private void onPurple(int i, int j, int currentCellOwner) {
        if(currentCellOwner == TTCell.BLUE_PLAYER) {
            JOptionPane.showMessageDialog(
                    ticyTacy.getDisplay(),
                    "You cannot claim that cell, it is owned by the blue player.",
                    "Whoopsie",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        else if(currentCellOwner == TTCell.PURPLE_PLAYER) {
            ticyTacy.getBoard().updateBoard(i, j, TTCell.NO_PLAYER);
        }
        else {
            if(ticyTacy.getBoard().getPurpleCells() == 3) {
                JOptionPane.showMessageDialog(
                        ticyTacy.getDisplay(),
                        "You cannot claim more than three (3) cells at a time.",
                        "Whoopsie",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            else {
                ticyTacy.getBoard().updateBoard(i, j, TTCell.PURPLE_PLAYER);
            }
        }
    }

    /**
     * This method displays a notification message that there has been a winner.
     *
     * @param player that player that won.
     */
    private void displayWin(int player) {
        String winMessage = "The ${PLAYER} player has won the game!\nWould you like to play again?";

        winMessage = winMessage.replace("${PLAYER}", player == TTCell.BLUE_PLAYER ? "Blue" : "Purple");

        int choice = JOptionPane.showConfirmDialog(
                ticyTacy.getDisplay(),
                winMessage,
                "Congratulations!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if(choice == 0) {
            ticyTacy.getBoard().reset();
            ticyTacy.getDisplay().updateBoardDisplay(ticyTacy.getBoard());
        }
        else {
            Runtime.getRuntime().exit(0);
        }
    }

}

