package org.example.sudokuCLass.Model;

import java.util.HashSet;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        suodkuCompletionChallenge(board);
    }

    private boolean suodkuCompletionChallenge(char[][] board) {
        for (int rows = 0; rows < 9; rows++) {
            for (int columns = 0; columns < 9; columns++) {
                if (board[rows][columns] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidSudoku(board, rows, columns, num)) {
                            board[rows][columns] = num;
                            if (suodkuCompletionChallenge(board)) {
                                return true;
                            }
                            board[rows][columns] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int rows, int columns, char num) {
        for (int i = 0; i < 9; i++) {
            int subGridRow = (rows / 3) * 3 + (i / 3);
            int subGridColumn = (columns / 3) * 3 + (i % 3);
            if (board[i][columns] == num || board[rows][i] == num || board[subGridRow][subGridColumn] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (result.contains(num)) {
                return false;
            }
            result.add(num);
        }
        return true;
    }
}
