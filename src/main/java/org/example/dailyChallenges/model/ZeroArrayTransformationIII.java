package org.example.dailyChallenges.model;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            diff[i] += (i == 0) ? 0 : diff[i - 1];
            int value = nums[i] - diff[i];
            for (int j = 0; j < queries.length && queries[j][0] == i; j++) {
                queue.offer(queries[j][1]);
            }
            while (value > 0) {

                if (queue.isEmpty()) {
                    return -1;
                }
                int x = queue.poll();
                if (x >= i) {
                    value--;
                    diff[i]++;
                    diff[x + 1]--;
                }
            }
        }


        return queue.size();
    }
}
