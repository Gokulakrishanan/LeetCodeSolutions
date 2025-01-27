package org.example.dailyChallenges.model;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] blocks = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            blocks[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char valueAtIndex = board[row][column];

                if (valueAtIndex != '.') {
                    int blockIndex = (row / 3) * 3 + (column / 3);
                    if (!rows[row].add(valueAtIndex) || (!columns[column].add(valueAtIndex)) || (!blocks[blockIndex].add(valueAtIndex))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
