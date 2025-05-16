package org.example.dailyChallenges.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumTimeToReachLastRoomII {
    public int minTimeToReach(int[][] movetime) {
        int rowLength = movetime.length, columnLength = movetime[0].length;
        int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0, 1});
        movetime[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            int row = currentElement[0], column = currentElement[1], time = currentElement[2], altTime = currentElement[3];

            for (int[] direction : directions) {
                int newRow = row + direction[0], newCol = direction[1] + column;


                if (newRow >= 0 && newRow < rowLength && newCol >= 0 && newCol < columnLength && movetime[newRow][newCol] >= 0) {
                    int newTime = Math.max(time, movetime[newRow][newCol]) + altTime;
                    if (newRow == rowLength - 1 && newCol == columnLength - 1) return newTime;
                    queue.add(new int[]{newRow, newCol, newTime, 3 - altTime});
                    movetime[newRow][newCol] = -1;
                }
            }
        }


        return -1;
    }
}
