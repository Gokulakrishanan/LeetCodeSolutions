package org.example.dailyChallenges.model;

public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        //Initialising the count
        int count = 0;
        //Initialising the rows and columns that have servers
        int[] rows = new int[grid.length], columns = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //storing the values and incrementing the values in the new rows and columns
                rows[i] += grid[i][j];
                columns[j] += grid[i][j];
            }
        }
        //counting the number of servers that can communicate either rows or columns
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
