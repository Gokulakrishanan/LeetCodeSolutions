package org.example.dailyChallenges.model;

import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomI {
    public int minTimeToReach(int[][] moveTime) {
        /*int[][] dp = new int[rowLength][columnLength];
        for (int[] val : dp) {
            Arrays.fill(val, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        queue.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;


        while (!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            int currentTime = currentElement[0];
            int currentRow = currentElement[1];
            int currentColumn = currentElement[2];

            //if the currentTime is greater then continue because we need to have the min time
            if (currentTime >= dp[currentRow][currentColumn]) continue;
            if (currentRow == rowLength - 1 && currentColumn == columnLength - 1) return currentTime;

            dp[currentRow][currentColumn] = currentTime;

            for (int[] dir : directions) {
                int nextRow = currentRow + dir[0];
                int nextColumn = currentColumn + dir[1];
                if (nextRow >= 0 && nextColumn >= 0 && nextRow < rowLength && nextColumn < columnLength && dp[nextRow][nextColumn] == Integer.MAX_VALUE) {
                    int nextTime = Math.max(moveTime[nextRow][nextColumn], currentTime) + 1;
                    queue.add(new int[]{nextTime, nextRow, nextColumn});
                }
            }
        }*/

        int rowLength = moveTime.length, columnLength = moveTime[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] vis = new boolean[rowLength][columnLength];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        vis[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            int x = currentElement[0], y = currentElement[1], wt = currentElement[2];

            if (y == columnLength - 1 && x == rowLength - 1) return wt;
            for (int[] direction : directions) {
                int newRow = x + direction[0];
                int newCol = y + direction[1];

                if (newRow >= 0 && newCol >= 0
                        && newRow < rowLength && newCol < columnLength && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    int time = Math.max(wt, moveTime[newRow][newCol]);
                    queue.add(new int[]{newRow, newCol, time + 1});
                }
            }
        }

        return -1;
    }
}
