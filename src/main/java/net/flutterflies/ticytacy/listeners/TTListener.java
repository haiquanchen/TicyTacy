package net.flutterflies.ticytacy.listeners;

import net.flutterflies.ticytacy.TicyTacy;
import net.flutterflies.ticytacy.board.TTCell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ashrynn on 8/5/16.
 */
public class TTListener implements ActionListener {

    private TicyTacy ticyTacy;

    public TTListener(TicyTacy ticyTacy) {
        this.ticyTacy = ticyTacy;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();
        String[] cords = clickedButton.getName().split(",");
        int i = Integer.parseInt(cords[0]);
        int j = Integer.parseInt(cords[1]);
        int currentCellOwner = ticyTacy.getBoard().getCell(i, j).getOwner();
        int turnPlayer = ticyTacy.getBoard().getTurnNumber() % 2;

        if(turnPlayer == 1) {
            onBlue(i, j, currentCellOwner);
        }
        else {
            onPurple(i, j, currentCellOwner);
        }

        ticyTacy.getDisplay().updateBoardDisplay(ticyTacy.getBoard());
        checkWin(ticyTacy.getBoard().checkWinCondition(turnPlayer), turnPlayer);
    }

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

    private void checkWin(boolean hasWon, int player) {
        if(hasWon) {
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
                ticyTacy.endGame();
            }
        }
    }
}

