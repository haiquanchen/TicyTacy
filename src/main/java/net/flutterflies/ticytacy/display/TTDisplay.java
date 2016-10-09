/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.display;

import net.flutterflies.ticytacy.TicyTacy;
import net.flutterflies.ticytacy.board.TTBoard;
import net.flutterflies.ticytacy.board.TTCell;
import net.flutterflies.ticytacy.listeners.TTListener;
import net.flutterflies.ticytacy.board.TTCell.Owners;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Display manager class for TicyTacy.
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public class TTDisplay extends JFrame {

    /**
     * A JPanel used to display meta information about the game board.
     */
    private final JPanel metaPanel;

    /**
     * A JPanel used to display the main grid of the game board.
     */
    private final JPanel boardGrid;

    /**
     * The listener responsible for handling the game controls.
     */
    private final TTListener listener;

    /**
     * Construct a new instance of the TicyTacy display manager.
     *
     * @param ticyTacy Instance of the main Game class.
     */
    public TTDisplay(TicyTacy ticyTacy) {
        super("Ticy Tacy");
        listener = new TTListener(ticyTacy);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(320, 400));

        metaPanel = new JPanel();
        boardGrid = new JPanel();

        updateBoardDisplay(ticyTacy.getBoard());

        add(metaPanel, BorderLayout.NORTH);
        add(boardGrid, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    /**
     * Update the display of the board to match the board's current state.
     *
     * @param board the current instance of the Game board.
     */
    public void updateBoardDisplay(TTBoard board) {
        makeBoardMeta(board);
        makeBoardGrid(board);

        revalidate();
        repaint();
    }

    /**
     * Make the meta panel for the board. this panel contains information like
     * the turn number, the number of cells each player has, and which players turn it is.
     *
     * @param board the current instance of the Game board.
     */
    private void makeBoardMeta(TTBoard board) {
        JLabel turnNumber = new JLabel();
        JLabel player1Cells = new JLabel();
        JLabel player2Cells = new JLabel();

        metaPanel.removeAll();
        metaPanel.setLayout(new BoxLayout(metaPanel, BoxLayout.Y_AXIS));
        metaPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        turnNumber.setText("Current turn: Player " + (board.getTurnNumber() % 2 == 1 ? "1" : "2"));
        turnNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        player1Cells.setText("Player 1's Cells: " + board.getPlayer1Cells());
        player1Cells.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2Cells.setText("Player 2's Cells: " + board.getPlayer2Cells());
        player2Cells.setAlignmentX(Component.CENTER_ALIGNMENT);

        metaPanel.add(turnNumber);
        metaPanel.add(player1Cells);
        metaPanel.add(player2Cells);
    }

    /**
     * Create the visual representation of the board grid.
     *
     * @param board The board to base the gird off.
     */
    private void makeBoardGrid(TTBoard board) {
        boardGrid.removeAll();
        boardGrid.setLayout(new GridLayout(board.getSize(), board.getSize()));


        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(90, 90));
                button.setBackground(getButtonColor(board.getCell(i, j)));
                button.addActionListener(listener);
                button.setName(i + "," + j);
                boardGrid.add(button);
            }
        }
    }

    /**
     * Return a color based on the given cells owner.
     *
     * @param boardCell The cell to color.
     * @return The color for the cell.
     */
    private Color getButtonColor(TTCell boardCell) {
        Color color;
        if(boardCell.getOwner() == Owners.PLAYER_1) {
            color = new Color(0x66CCFF);
        }
        else if(boardCell.getOwner() == Owners.PLAYER_2) {
            color = new Color(0xBD9CF8);
        }
        else {
            color = new Color(0x151515);
        }

        return color;
    }
}
