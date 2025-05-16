package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n], parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && diffChar(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max) max = dp[i];
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                while (i != -1) {
                    list.add(words[i]);
                    i = parent[i];
                }
                break;
            }
        }
        return list.reversed();

    }

    private boolean diffChar(String word, String word1) {
        if (word.length() != word1.length()) return false;

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word.charAt(i) != word1.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public List<String> getMaxSubSequenceII(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n], parent = new int[n];

        dp[n - 1] = 1;
        parent[n - 1] = -1;

        int maxLen = 1, maxIndex = 0;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j = i + 1; j < n; j++) {

                if (dp[i] < dp[j] + 1 && diffChar(words[i], words[j]) && groups[i] != groups[j]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }

        }

        List<String> list = new ArrayList<>();
        while (maxIndex >= 0) {
            list.add(words[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        return list;
    }

    private boolean hummingDistance(String word1, String word2, int g1, int g2) {
        if (g1 == g2) return false;
        if (word1.length() != word2.length()) return false;
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        return count == 1;
    }

}
