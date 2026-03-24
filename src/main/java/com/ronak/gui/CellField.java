package com.ronak.gui;

import java.awt.TextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CellField extends TextField {

    private boolean fixed = false;

    public CellField() {
        super("");

        setFont(new Font("Arial", Font.BOLD, 20));

        //use for only input can be 1-9
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (fixed) {
                    e.consume();
                    return;
                }

                char ch = e.getKeyChar();

                if (ch == KeyEvent.VK_BACK_SPACE) return;

                if (ch < '1' || ch > '9') {
                    e.consume();
                }

                if (getText().length() >= 1) {
                    e.consume();
                }
            }
        });
    }

    // Set fixed puzzle number
    public void setFixedValue(int val) {
        setText(String.valueOf(val));
        fixed = true;
        setBackground(new Color(220,220,220));
        setEditable(false);
    }

    // Allow user input
    public void setEditableCell() {
        fixed = false;
        setText("");
        setBackground(Color.WHITE);
        setEditable(true);
    }

    public boolean isFixed() {
        return fixed;
    }
}