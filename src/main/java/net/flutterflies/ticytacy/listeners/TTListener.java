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
import net.flutterflies.ticytacy.board.TTCell.Owners;

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
        Owners currentCellOwner = ticyTacy.getBoard().getCell(i, j).getOwner();
        Owners player;
        boolean hasWon = false;

        //If the current turn number is odd, then it is player 1's turn
        if(ticyTacy.getBoard().getTurnNumber() % 2 == 1) {
            player = Owners.PLAYER_1;
            onBlue(i, j, currentCellOwner);
            if(ticyTacy.getBoard().getBlueCells() == 3) {
                hasWon = ticyTacy.getBoard().checkWinCondition(Owners.PLAYER_1);
            }
        }
        else {
            player = Owners.PLAYER_2;
            onPurple(i, j, currentCellOwner);
            if(ticyTacy.getBoard().getPurpleCells() == 3) {
                hasWon = ticyTacy.getBoard().checkWinCondition(Owners.PLAYER_2);
            }
        }

        ticyTacy.getDisplay().updateBoardDisplay(ticyTacy.getBoard());
        if(hasWon) {
            displayWin(player);
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
    private void onBlue(int i, int j, Owners currentCellOwner) {
        if(currentCellOwner == Owners.PLAYER_2) {
            JOptionPane.showMessageDialog(
                    ticyTacy.getDisplay(),
                    "You cannot claim that cell, it is owned by the purple player.",
                    "Whoopsie",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        else if(currentCellOwner == Owners.PLAYER_1) {
            ticyTacy.getBoard().updateBoard(i, j, Owners.NO_PLAYER);
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
                ticyTacy.getBoard().updateBoard(i, j, Owners.PLAYER_1);
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
    private void onPurple(int i, int j, Owners currentCellOwner) {
        if(currentCellOwner == Owners.PLAYER_1) {
            JOptionPane.showMessageDialog(
                    ticyTacy.getDisplay(),
                    "You cannot claim that cell, it is owned by the blue player.",
                    "Whoopsie",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        else if(currentCellOwner == Owners.PLAYER_2) {
            ticyTacy.getBoard().updateBoard(i, j, Owners.NO_PLAYER);
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
                ticyTacy.getBoard().updateBoard(i, j, Owners.PLAYER_2);
            }
        }
    }

    /**
     * This method displays a notification message that there has been a winner.
     *
     * @param player that player that won.
     */
    private void displayWin(Owners player) {
        String winMessage = "The ${PLAYER} player has won the game!\nWould you like to play again?";

        winMessage = winMessage.replace("${PLAYER}", player.equals(Owners.PLAYER_1) ? "Blue" : "Purple");

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

