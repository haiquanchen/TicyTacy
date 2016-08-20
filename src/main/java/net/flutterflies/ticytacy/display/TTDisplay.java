package net.flutterflies.ticytacy.display;

import net.flutterflies.ticytacy.TicyTacy;
import net.flutterflies.ticytacy.board.TTBoard;
import net.flutterflies.ticytacy.board.TTCell;
import net.flutterflies.ticytacy.listeners.TTListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by ashrynn on 8/4/16.
 */
public class TTDisplay extends JFrame {

    private JPanel metaPanel;
    private JPanel boardGrid;
    private TTListener listener;

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

    public void updateBoardDisplay(TTBoard board) {
        makeBoardMeta(board);
        makeBoardGrid(board);

        revalidate();
        repaint();
    }

    private void makeBoardMeta(TTBoard board) {
        JLabel turnNumber = new JLabel();
        JLabel blueCells = new JLabel();
        JLabel purpleCells = new JLabel();

        metaPanel.removeAll();
        metaPanel.setLayout(new BoxLayout(metaPanel, BoxLayout.Y_AXIS));
        metaPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        if((board.getTurnNumber() % 2) == 1)
            turnNumber.setText("Current Turn: Blue");
        else
            turnNumber.setText("Current Turn: Purple");
        turnNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
        blueCells.setText("Blue Cells: " + board.getBlueCells());
        blueCells.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpleCells.setText("Purple Cells: " + board.getPurpleCells());
        purpleCells.setAlignmentX(Component.CENTER_ALIGNMENT);

        metaPanel.add(turnNumber);
        metaPanel.add(blueCells);
        metaPanel.add(purpleCells);
    }

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

    private Color getButtonColor(TTCell boardCell) {
        Color color;
        if(boardCell.getOwner() == TTCell.BLUE_PLAYER) {
            color = new Color(0x66CCFF);
        }
        else if(boardCell.getOwner() == TTCell.PURPLE_PLAYER) {
            color = new Color(0xBD9CF8);
        }
        else {
            color = new Color(0x151515);
        }

        return color;
    }
}
