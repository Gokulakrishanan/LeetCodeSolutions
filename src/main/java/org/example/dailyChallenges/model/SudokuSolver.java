package org.example.dailyChallenges.model;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);

    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidSudoku(board, row, column, ch)) {
                            board[row][column] = ch;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][column] = '.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int row, int column, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][column] == num || board[(row / 3) * 3 + (i / 3)][(column / 3) * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
