package org.example.dailyChallenges.model;

public class MaximumNumberOfFishInAGrid {

    //Grid length of rows and hrid length of columns respectively
    int rowLength, columnLength;

    //temp grid to traverse through the grid
    int[][] grid;

    //variable to store the results
    int temp;

    //adjacency list (directions in which we can move)
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int findMaxFish(int[][] gird) {

        //initialization of values
        this.grid = grid;
        rowLength = grid.length;
        columnLength = grid[0].length;
        int ans = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (grid[row][column] != 0) {
                    temp = 0;
                    dfs(row, column);

                    if (temp > ans) {
                        ans = temp;
                    }
                }
            }
        }

        return ans;
    }

    private void dfs(int row, int column) {
        if (row < 0 || row >= rowLength || column < 0 || column >= columnLength || grid[row][column] == 0) {
            return;
        }

        temp += grid[row][column];
        grid[row][column] = 0;

        for (int[] dir : direction) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            dfs(newRow, newColumn);
        }
    }

    /*// Variables to store the maximum number of fish collected and temporary fish count for a region
    int max;
    int temp;

    // Dimensions of the grid
    int m, n;

    // Directions for moving up, down, left, and right
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    // Grid to represent the fishing area
    int[][] grid;

    // Method to find the maximum fish that can be collected
    public int findMaxFish(int[][] grid) {
        this.grid = grid; // Initialize the grid
        max = 0; // Initialize the maximum fish count to 0

        m = grid.length; // Number of rows
        n = grid[0].length; // Number of columns

        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell has fish, start a DFS from there
                if (grid[i][j] != 0) {
                    temp = 0; // Reset the temporary fish count for the current region
                    dfs(i, j); // Perform a DFS to collect all fish in the connected region

                    // Update the maximum fish count if the current region has more fish
                    if (temp > max)
                        max = temp;
                }
            }
        }
        return max; // Return the maximum fish count
    }

    // Depth-First Search (DFS) to collect fish in a connected region
    private void dfs(int i, int j) {
        // Base case: If out of bounds or the cell is empty, return
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return;

        temp += grid[i][j]; // Add the fish in the current cell to the temporary count
        grid[i][j] = 0; // Mark the cell as visited by setting it to 0

        // Explore all 4 possible directions
        for (int[] d : dir) {
            int ii = i + d[0]; // Calculate the new row index
            int jj = j + d[1]; // Calculate the new column index
            dfs(ii, jj); // Recursively perform DFS in the new direction
        }
    }
*/


}
