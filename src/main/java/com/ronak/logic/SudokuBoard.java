package com.ronak.logic;

//class which use to store data of sudoku board
public class SudokuBoard {
    int [][] board;

    public SudokuBoard(){
        board=new int[9][9];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setValue(int r,int c,int val){
        board[r][c]=val;
    }

    public int getValue(int r,int c){
        return board[r][c];
    }

    public void clearBoard(){
        board=new int[9][9];
    }
}
