package com.ronak.logic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SudokuGenerator {

    //function for generate different sudoku board base on different levels
    public int[][] generateBoard(String level){
        SudokuSolver solver =new SudokuSolver();
        int[][] board =new int[9][9];

        //first generate on solved sudoku
        solver.solveSudoku(board);

        //then remove some of the cells from it
        removeCells(level,board);

        return board;
    }

    //return no of cells need to remove from solved sudoku base on level
    public  int getCellNo(String level){

        if(level.equals("easy")){
            return 35;
        }

        else if(level.equals("medium")){
            return 45;
        }

        else{
            return 55;
        }

    }

    //remove some of the cells from board for generate new puzzle
    public void  removeCells(String level, int[][] board){
        int no=getCellNo(level);

        //get all cells in list and shuffle
        ArrayList<int[]>list = new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                list.add(new int[]{i,j});
            }
        }
        Collections.shuffle(list);

        //this is count of no of cells remains in each row,col and 3x3 box
        int[] row =new int[9];
        int[] col =new int[9];
        int[] cell =new int[9];
        Arrays.fill(row,9);
        Arrays.fill(col,9);
        Arrays.fill(cell,9);

        //it is track no of removed cells
        int removed=0;
        for(int[] x :list){
            if(removed>=no){
                return;
            }

            int r=x[0];
            int c=x[1];
            int b=((x[0]/3)*3)+(x[1]/3);

            //remove cell in that way that at least 1 cell remain in each box,column,row
            if(row[r]>1 && col[c]>1 && cell[b]>1){
                row[r]--;
                col[c]--;
                cell[b]--;
                board[r][c]=0;
                removed++;
            }

        }

    }
}
