package org.example.dailyChallenges.model;

import java.util.Arrays;

public class MinimisedMaximumOfProductsDistributed {
    public int minimizedMaximum(int n, int[] quantities) {
        int result = 0;
        int left = 1;

        int right = Arrays.stream(quantities).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int stores = 0;
            for (int quantity : quantities) {
                stores += Math.ceil((double) quantity / mid);
            }
            if (stores <= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
