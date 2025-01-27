package org.example.dailyChallenges.model;

import java.util.LinkedList;
import java.util.Queue;

/*You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

*/

public class MapOfTheHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        //initialising the length of givenRows and givenColumns
        int givenRows = isWater.length, givenColumns = isWater[0].length;
        //initialising the resultMatrix
        int[][] resultMatrix = new int[givenRows][givenColumns];

        //Possible directions in the matrix
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        ///initialising the queue
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < givenRows; row++) {
            for (int column = 0; column < givenColumns; column++) {
                //If isWater[i][j] == 1, cell (i, j) is a water cell.
                if (isWater[row][column] == 1) {
                    queue.offer(new int[]{row, column});
                } else {
                    //Mark the rest as unvisited
                    resultMatrix[row][column] = -1;
                }
            }
        }
        //traversing using the BFS
        while (!queue.isEmpty()) {
            int[] valueAtTop = queue.poll();
            int rowOfValue = valueAtTop[0];
            int columnOfValue = valueAtTop[1];
            //checking all the adjacent values.
            for (int[] dir : directions) {
                int newRow = rowOfValue + dir[0];
                int newColumn = columnOfValue + dir[1];

                //if the adjacent cell is within the boundart and unvisited
                if (newRow >= 0 && newRow < givenRows && newColumn >= 0 && newColumn < givenColumns && resultMatrix[newRow][newColumn] == -1) {
                    resultMatrix[newRow][newColumn] = resultMatrix[rowOfValue][columnOfValue] + 1;
                    //adding to queue for further exploration
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
        }
        return resultMatrix;
    }
}
