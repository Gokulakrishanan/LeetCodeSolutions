package org.example.dailyChallenges.model;

public class GridGame {
    public long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE, row1Sum = 0, row2Sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            row1Sum += grid[0][i];
        }
        for (int i = 0; i < grid[0].length; i++) {
            row1Sum -= grid[0][i];
            result = Math.min(result, Math.max(row1Sum, row2Sum));
            row2Sum += grid[1][i];
        }

        return result;
    }

}
