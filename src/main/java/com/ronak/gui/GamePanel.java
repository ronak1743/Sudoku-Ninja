package com.ronak.gui;

import java.awt.GridLayout;
import java.awt.Panel;

public class GamePanel extends Panel {

    //all 81 cells
    private CellField[][] cells;

    public GamePanel() {
        setLayout(new GridLayout(9, 9));
        cells = new CellField[9][9];

        //initialize all cells
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new CellField();
                add(cells[i][j]);
            }
        }
    }

    //load board in this all cells
    public void loadPuzzle(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int val = board[i][j];

                if (val != 0) {
                    cells[i][j].setFixedValue(val);
                } else {
                    cells[i][j].setEditableCell();
                }
            }
        }
    }

    //get current values
    public int[][] getBoard() {

        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                String text = cells[i][j].getText();

                if (text.isEmpty()) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = Integer.parseInt(text);
                }
            }
        }

        return board;
    }

    //set new board with data
    public void setBoard(int[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (!cells[i][j].isFixed()) {
                    cells[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        }
    }

    //clear all board
    public void clearUserInput() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (!cells[i][j].isFixed()) {
                    cells[i][j].setText("");
                }
            }
        }
    }

    //get particular cell
    public CellField getCell(int r, int c) {
        return cells[r][c];
    }
}