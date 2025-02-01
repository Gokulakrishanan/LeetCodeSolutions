package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private Map<Integer, Integer> islandSizes = new HashMap<>();
    private int length;

    public int largestIsland(int[][] grid) {

        this.length = grid.length;
        this.grid = grid;

        int regionId = 2, maxIsland = 0;
        boolean hasNoZeroes = false;

        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (grid[row][column] == 1) {
                    int size = dfs(row, column, regionId);
                    islandSizes.put(regionId, size);
                    maxIsland = Math.max(maxIsland, size);
                    regionId++;
                } else {
                    hasNoZeroes = true;
                }
            }
        }

        if (!hasNoZeroes) return maxIsland;

        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (grid[row][column] == 0) {
                    Set<Integer> visitedIslands = new HashSet<>();
                    int newSize = 1;

                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newColumn = column + direction[1];

                        if (isValid(newRow, newColumn) && grid[newRow][newColumn] > 1 && visitedIslands.add(grid[newRow][newColumn])) {
                            newSize += islandSizes.get(grid[newRow][newColumn]);
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }
        return maxIsland;
    }

    private boolean isValid(int row, int column) {
        return row >= 0 && column >= 0 && row < length && column < length;
    }

    private int dfs(int row, int column, int regionId) {
        if (!isValid(row, column) || grid[row][column] != 1) {
            return 0;
        }

        grid[row][column] = regionId;
        int count = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            count += dfs(newRow, newColumn, regionId);
        }
        return count;
    }

}
