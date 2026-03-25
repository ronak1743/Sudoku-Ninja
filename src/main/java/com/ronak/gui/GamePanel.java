package com.ronak.gui;

import com.ronak.logic.SudokuValidator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class GamePanel extends Panel {

    private CellField[][] cells;
    private SudokuValidator validator;

    public GamePanel() {

        setLayout(new GridLayout(3,3,4,4));
        setBackground(Color.BLACK);

        cells = new CellField[9][9];
        validator = new SudokuValidator();

        initBoard();
    }


    //Initialize board
    private void initBoard() {

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                Panel box = new Panel(new GridLayout(3,3));
                box.setBackground(Color.BLACK); // box border

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        int r = boxRow * 3 + i;
                        int c = boxCol * 3 + j;

                        cells[r][c] = new CellField();


                        cells[r][c].addTextListener(new TextListener() {
                            public void textValueChanged(TextEvent e) {
                                validateCell(r, c);
                            }
                        });

                        box.add(cells[r][c]);
                    }
                }

                add(box);
            }
        }
    }

    //validate each cell and if use input is invalid then show it in red color
    private void validateCell(int r, int c) {

        String text = cells[r][c].getText();

        if (text.isEmpty()) {
            cells[r][c].setForeground(Color.BLACK);
            return;
        }

        int val = Integer.parseInt(text);

        int[][] board = getBoard();

        board[r][c] = 0;

        if (validator.isMoveValid(board, r, c, val)) {
            cells[r][c].setForeground(Color.BLACK);
        } else {
            cells[r][c].setForeground(Color.RED);
        }
    }

    //load board
    public void loadPuzzle(int[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j] != 0){
                    cells[i][j].setFixedValue(board[i][j]);
                }else{
                    cells[i][j].setEditableCell();
                }
            }
        }
    }


    //get data from gui to array
    public int[][] getBoard(){

        int[][] board = new int[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                String text = cells[i][j].getText();

                if(text.isEmpty()){
                    board[i][j] = 0;
                }else{
                    board[i][j] = Integer.parseInt(text);
                }
            }
        }

        return board;
    }

    //set board
    public void setBoard(int[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(!cells[i][j].isFixed()){
                    cells[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        }
    }

    //clear user input form board
    public void clearUserInput(){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(!cells[i][j].isFixed()){
                    cells[i][j].setText("");
                    cells[i][j].setForeground(Color.BLACK);
                }
            }
        }
    }

    // get particular  Cell
    public CellField getCell(int r,int c){
        return cells[r][c];
    }
}