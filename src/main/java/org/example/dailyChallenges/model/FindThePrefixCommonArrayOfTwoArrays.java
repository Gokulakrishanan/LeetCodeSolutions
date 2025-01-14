package org.example.dailyChallenges.model;

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, counter = 0;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) counter++;
            if (++freq[B[i]] == 2) counter++;
            ans[i] = counter;
        }

        return ans;
    }
}
