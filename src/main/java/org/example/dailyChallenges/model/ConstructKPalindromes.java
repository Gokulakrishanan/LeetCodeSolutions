package org.example.dailyChallenges.model;

public class ConstructKPalindromes {
    public boolean canConstruct(String string, int k) {
       /* if (string.isEmpty() || string.length() < k) return false;

        Map<Character, Integer> map = new HashMap<>();
        int oddOccurence = 0;
        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                oddOccurence++;
            }
        }

        return oddOccurence <= k & k <= string.length();*/
        if (string.length() < k) return false;
        if (string.length() == k) return true;

        int oddOccurence = 0;
        int[] count = new int[26];
        for (char c : string.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i : count) {
            if (i % 2 == 1) {
                oddOccurence++;
            }
        }
        return oddOccurence <= k;
    }
}
