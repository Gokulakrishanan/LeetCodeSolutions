package org.example.dailyChallenges.model;

public class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length + 1];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            prefix[i + 1] = (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) ? 1 + prefix[i] : prefix[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            ans[i] = prefix[right + 1] - prefix[left];
        }
        return ans;
    }

    private boolean isVowel(char index) {
        return (index == 'a' || index == 'e' || index == 'i' || index == 'o' || index == 'u');
    }
}
