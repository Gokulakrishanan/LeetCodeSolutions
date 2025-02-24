package org.example.dailyChallenges.model;

import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        while (k-- > 0) {
            int a = heap.poll();
            heap.offer((int) Math.sqrt(a));
        }
        long ans = 0;
        while (!heap.isEmpty()) {
            ans += heap.poll();
        }
        return ans;
    }
}
