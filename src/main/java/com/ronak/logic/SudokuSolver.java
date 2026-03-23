package com.ronak.logic;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuSolver {

    //Function on Backtracking which is used to solve sudoku
    //return true if solve otherwise false if solution is not possible
    public boolean solveSudoku(int[][] board){

        //A list of possible all digits with random shuffle
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=1;i<10;i++){
            list.add(i);
        }
        Collections.shuffle(list);

        //main Logic travel on each cell
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                //if cell is 0 that means it is empty so solve that
                if(board[i][j]==0) {
                    for (int val : list) {

                        //if current value is safe for cell then put and call for next

                        if(isSafe(board,i,j,val)) {
                            board[i][j] = val;

                            //if it will give true then return true otherwise backtrack
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    //check for if current value is safe for current cell
    public boolean isSafe(int[][] board, int r, int c, int x){
        //check in current col
        for(int i=0;i<9;i++){
            if(i==c){
                continue;
            }
            if(board[r][i]==x){
                return false;
            }
        }

        //check in current row
        for(int i=0;i<9;i++){
            if(i==r){
                continue;
            }
            if(board[i][c]==x){
                return false;
            }

        }

        //check in current 3x3 square
        int sr=(r/3)*3;
        int sc=(c/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((sr+i)==r && (sc+j)==c){
                    continue;
                }
                if(board[sr+i][sc+j]==x){
                    return false;
                }
            }
        }
        return true;
    }
}
