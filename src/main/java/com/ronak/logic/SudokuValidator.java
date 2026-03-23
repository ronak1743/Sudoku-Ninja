package com.ronak.logic;

import java.util.ArrayList;

public class SudokuValidator {

    // check if your sudoku is valid or not
    public boolean isValidBoard(int[][] board) {
        //check all value is in rang 1-9
        if(!checkNum(board)){
            return false;
        }
        //check all constrains
        return checkRows(board) && checkColumns(board) && checkBoxes(board);
    }

    //validate  input range
    private boolean checkNum(int [][] board){
        for(int[] x :board){
            for(int i:x){
                if(i<=0 || i>9){
                    return false;
                }
            }
        }
        return true;
    }

    //check repetition in each row
    private boolean checkRows(int[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] check = new int[10];
            for (int j = 0; j < 9; j++) {
                if (check[board[i][j]] != 0) {
                    return false;
                } else {
                    check[board[i][j]]++;
                }
            }
        }
        return true;
    }

    //check repetition in each column
    private boolean checkColumns(int[][] board) {
        for(int i=0;i<9;i++){
            int[] check =new int[10];
            for(int j=0;j<9;j++){
                if(check[board[j][i]]!=0){
                    return false;
                }
                else{
                    check[board[j][i]]++;
                }
            }
        }
        return true;
    }

    //check repetition in each 3x3 box
    private boolean checkBoxes(int[][] board) {
        ArrayList<int[]>start=new ArrayList<>();
        getBoxStartPoints(start);

        for(int[] point:start){
            int r=point[0];
            int c=point[1];
            int [] visited=new int[10];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(visited[board[r+i][c+j]]>0){
                        return false;
                    }
                    else{
                        visited[board[r+i][c+j]]++;
                    }
                }
            }
        }
        return true;

    }

    //getting start points of each box
    private void getBoxStartPoints(ArrayList<int[]>list){
        list.add(new int[]{0,0});
        list.add(new int[]{0,3});
        list.add(new int[]{0,6});
        list.add(new int[]{3,0});
        list.add(new int[]{3,3});
        list.add(new int[]{3,6});
        list.add(new int[]{6,0});
        list.add(new int[]{6,3});
        list.add(new int[]{6,6});

    }

    //check for is given move is valid during hint
    public boolean isMoveValid(int[][] board, int r, int c, int val) {
        if(val<1 || val>9){
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][c] == val) return false;
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sr+i][sc+j] == val) return false;
            }
        }
        return true;
    }

}
