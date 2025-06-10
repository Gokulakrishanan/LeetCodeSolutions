package org.example.dailyChallenges.model;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public int maxDifference(String s) {
        //int result = 0;
        //HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        int max = 0, min = s.length();
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                max = Math.max(max, freq[i]);
            }
            if (freq[i] % 2 == 0 && freq[i] > 0) {
                min = Math.min(min, freq[i]);
            }
        }

        return max - min;
    }
}
