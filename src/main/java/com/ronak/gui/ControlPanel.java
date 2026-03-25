package com.ronak.gui;

import com.ronak.logic.ScoreCalculator;
import com.ronak.logic.SudokuSolver;
import com.ronak.logic.SudokuGenerator;
import com.ronak.logic.SudokuValidator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlPanel extends Panel {

    //main game
    private GamePanel gamePanel;
    //status panel for show status
    private StatusPanel statusPanel;

    //sudoku logic
    private SudokuSolver solver;
    private SudokuGenerator generator;
    private SudokuValidator validator;
    private  int hintCount=0;

    public ControlPanel(GamePanel gamePanel, StatusPanel statusPanel) {


        solver = new SudokuSolver();
        generator = new SudokuGenerator();
        validator = new SudokuValidator();

        setLayout(new FlowLayout());

        Label difficultyLabel = new Label("Difficulty:");

        Choice difficultyChoice = new Choice();
        difficultyChoice.add("easy");
        difficultyChoice.add("medium");
        difficultyChoice.add("hard");

        Button newGame = new Button("New Game");
        Button solve = new Button("Solve");
        Button hint = new Button("Hint");
        Button reset = new Button("Reset");
        Button submit = new Button("Submit");

        add(difficultyLabel);
        add(difficultyChoice);
        add(newGame);
        add(solve);
        add(hint);
        add(reset);
        add(submit);

        solve.setVisible(false);
        hint.setVisible(false);
        reset.setVisible(false);
        submit.setVisible(false);
        newGame.addActionListener(e -> {

            String difficulty = difficultyChoice.getSelectedItem();

            int[][] puzzle = generator.generateBoard(difficulty);

            gamePanel.loadPuzzle(puzzle);

            statusPanel.startTimer();

            hintCount=0;
            solve.setVisible(true);
            hint.setVisible(true);
            reset.setVisible(true);
            submit.setVisible(true);

            ControlPanel.this.validate();
            ControlPanel.this.repaint();

        });

        //solve
        solve.addActionListener(e -> {

            int[][] board = gamePanel.getBoard();

            if (solver.solveSudoku(board)) {
                gamePanel.setBoard(board);
            }

        });


        //get hint
        hint.addActionListener(e -> {

            int[][] board = gamePanel.getBoard();

            //make copy and solve that board
            int[][] copy = new int[9][9];

            for (int i = 0; i < 9; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, 9);
            }

            //now if there is ok then show hint from first empty block with solution
            if (solver.solveSudoku(copy)) {

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {

                        if (board[i][j] == 0) {

                            gamePanel.getCell(i, j)
                                    .setText(String.valueOf(copy[i][j]));

                            hintCount++;
                            return;
                        }
                    }
                }
            }
            else{
                Dialog dialog = new Dialog((Frame) null,"Warning",true);
                dialog.setLayout(new FlowLayout());
                dialog.add(new Label("You have do something wrong move so solution does not exist with this state...")) ;
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        dispatchEvent(e);
                    }
                });
            }
        });



        //reset
        reset.addActionListener(e -> gamePanel.clearUserInput());

        // When submitting
        submit.addActionListener(e -> {

            int[][] board = gamePanel.getBoard();

            boolean valid = validator.isValidBoard(board);

            Dialog dialog = new Dialog((Frame) null, "Result", true);
            dialog.setLayout(new FlowLayout());

            if(valid) {

                // Calculate score using the new class
                ScoreCalculator.Difficulty diff = ScoreCalculator.Difficulty.MEDIUM; // get from Choice
                ScoreCalculator calculator = new ScoreCalculator(diff, hintCount, statusPanel.getSeconds());
                int finalScore = calculator.calculateScore();

                dialog.add(new Label("Sudoku Solved!"));
                dialog.add(new Label("Score: " + finalScore));
                dialog.add(new Label("Time: " + statusPanel.getTime()));
                dialog.add(new Label("Hints Used: " + hintCount));

            } else {
                dialog.add(new Label("Sudoku Incorrect!"));
            }

            Button ok = new Button("OK");
            ok.addActionListener(ev -> dialog.setVisible(false));

            dialog.add(ok);
            dialog.setSize(250,150);
            dialog.setVisible(true);

        });
    }
}