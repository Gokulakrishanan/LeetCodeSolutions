package org.example.dailyChallenges.model;

public class MinCostToMakeAtLeastOneValidPathInAGrid {

    public int minCost(int[][] grid) {
        /*int rows = grid.length, columns = grid[0].length;
        int targetRow = grid.length - 1, targetColumn = grid[0].length - 1;
        PriorityQueue<Grid> queue = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        boolean[][] traversed = new boolean[rows][columns];

        queue.add(new Grid(0, 0, 0));
        while (!queue.isEmpty()) {
            Grid top = queue.poll();
            int row = top.row, col = top.col;
            if (traversed[row][col]) continue;
            traversed[row][col] = true;
 
            if (row == targetRow && col == targetColumn) {
                return top.cost;
            }

            if (col + 1 != columns && !traversed[row][col + 1]) {
                queue.add(new Grid(row, col + 1, (grid[row][col] == 1 ? 0 : 1) + top.cost));
            }

            if (col - 1 != -1 && !traversed[row][col - 1]) {
                queue.add(new Grid(row, col - 1, (grid[row][col] == 2 ? 0 : 1) + top.cost));
            }

            if (row + 1 != rows && !traversed[row + 1][col]) {
                queue.add(new Grid(row + 1, col, (grid[row][col] == 3 ? 0 : 1) + top.cost));
            }

            if (row - 1 != -1 && !traversed[row - 1][col]) {
                queue.add(new Grid(row - 1, col, (grid[row][col] == 4 ? 0 : 1) + top.cost));
            }
        }

        return 0;
    }

    class Grid {
        int row, col, cost;

        public Grid(int r, int c, int co) {
            row = r;
            col = c;
            cost = co;
        }*/

        //initialize
        int rowLength = grid.length, columnLength = grid[0].length, targetedRow = grid.length - 1, targetedColumn = grid[0].length - 1;


        return -1;
    }

    class GridPair {
        int gRow, gColumn, gCost;

        public GridPair(int row, int column, int cost) {
            gRow = row;
            gColumn = column;
            gCost = cost;
        }
    }
}
