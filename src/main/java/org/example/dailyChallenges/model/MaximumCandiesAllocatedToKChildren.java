package org.example.dailyChallenges.model;

public class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0, result = 0;
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long childrenCount = 0;
            for (int candy : candies) {
                childrenCount += candy / mid;
            }

            if (childrenCount >= 0) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
