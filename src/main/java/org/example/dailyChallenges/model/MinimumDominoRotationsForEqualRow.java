package org.example.dailyChallenges.model;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotation(int[] tops, int[] bottoms) {
        int n = tops.length, m = bottoms.length, result = Integer.MAX_VALUE;
        int[] face = new int[7];
        //storing the max values of tile/domino
        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i]) face[bottoms[i]]++;
        }
        for (int x = 1; x <= 6; x++) {
            if (face[x] < n) {
                continue;
            }
            int keepTop = 0, keepBottom = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (tops[i] != x && bottoms[i] != x) {
                    possible = false;
                    break;
                }
                if (tops[i] != x) keepTop++;
                if (bottoms[i] != x) keepBottom++;
            }
            if (possible) {
                result = Math.min(result, Math.min(keepTop, keepBottom));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int minDominoRotationOpt(int[] tops, int[] bottoms) {
        int ans = -1;
        for (int i = 1; i < 7; i++) {
            int current = helper(tops, bottoms, i);
            if (current != -1 && (ans == -1 || ans > current)) {
                ans = current;
            }
        }
        return ans;
    }

    public int helper(int[] tops, int[] bottoms, int val) {
        int keepTop = 0, keepBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                keepTop++;
            } else if (bottoms[i] != val) {
                keepBottom++;
            }
        }
        return Math.min(keepTop, keepBottom);
    }
}
