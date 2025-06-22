package org.example.dailyChallenges.model;

import java.util.Arrays;

public class MinimumDeletionsToMakeStringKSpecial {
    public int minimumDeletions(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] updated = new int[26];
        int size = 0;
        for (int i : freq) {
            if (i > 0) {
                updated[size++] = i;
            }
        }
        Arrays.sort(updated, 0, size);

        int min = 100000, totalSum = s.length(), deletedLeftSum = 0, sum = 0, j = 0;
        for (int i = 0; i < size; i++) {
            int left = updated[i], right = left + k;
            while (j < size && updated[j] <= right) {
                sum += updated[j++];
            }

            int start = size - j;
            int startSum = totalSum - sum;
            int required = start * right;
            int deleted = startSum - required;

            min = Math.min(min, deleted + deletedLeftSum);
            totalSum -= updated[i];
            deletedLeftSum += updated[i];
            sum -= updated[i];
        }


        return min;
    }
}
