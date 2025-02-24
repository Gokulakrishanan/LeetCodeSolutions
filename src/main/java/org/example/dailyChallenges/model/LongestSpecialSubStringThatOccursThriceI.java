package org.example.dailyChallenges.model;

import java.util.HashMap;

public class LongestSpecialSubStringThatOccursThriceI {
    public int maximumLength(String input) {
        HashMap<String, Integer> map = new HashMap<>();

        int n = input.length();
        for (int i = 0; i < n; i++) {
            int j = i;
            do {
                String substring = input.substring(i, j + 1);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                if (j < n - 1 && input.charAt(j) == input.charAt(j + 1)) {
                    j++;
                } else {
                    break;
                }
            } while (j < n);
        }
        String subStringMax = "";

        for (String s : map.keySet()) {
            if (map.get(s) >= 3 && s.length() > subStringMax.length()) {
                subStringMax = s;
            }
        }
        return subStringMax == "" ? -1 : subStringMax.length();
    }
}
