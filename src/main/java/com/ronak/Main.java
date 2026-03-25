package com.ronak;

import com.ronak.gui.ControlPanel;
import com.ronak.gui.GamePanel;
import com.ronak.gui.StatusPanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {

    Main(){
        setTitle("Sudoku Game");
        setSize(700,800);
        setLayout(new BorderLayout());

        StatusPanel statusPanel = new StatusPanel();
        GamePanel gamePanel = new GamePanel();
        ControlPanel controlPanel = new ControlPanel(gamePanel, statusPanel);
        add(statusPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(1);
            }
        });

        setVisible(true);
    }

    static void main() {
        new Main();
    }
}