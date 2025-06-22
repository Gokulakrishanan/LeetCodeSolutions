package org.example.dailyChallenges.model;

public class MaximumManhattanDistanceAfterKChanges {
    public int maxDistance(String s, int k) {

        int north = 0, south = 0, west = 0, east = 0, answer = 0;
        for (char c : s.toCharArray()) {
            if (c == 'N') {
                north++;
            } else if (c == 'S') {
                south++;
            } else if (c == 'W') {
                west++;
            }
            if (c == 'E') {
                east++;
            }

            int x = Math.min(k, Math.min(north, south));
            int y = Math.min(k - x, Math.min(east, west));
            answer = Math.max(answer, Math.abs(north - south) + Math.abs(east - west) + 2 * (x + y));
        }
        return answer;
    }
}
