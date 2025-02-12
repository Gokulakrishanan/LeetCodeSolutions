package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public int longestSubString(String s) {

        /*for (int right = 0; right < s.length(); right++) {
            if (!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < leftIndex) {
                map.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - leftIndex + 1);
            } else {
                leftIndex = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right), right);
            }
        }*/
        int maxLength = 0, leftIndex = 0, rightIndex = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (rightIndex < n) {
            char key = s.charAt(rightIndex);
            if (map.containsKey(key)) {
                leftIndex = Math.max(leftIndex, map.get(key) + 1);
            }
            map.put(key, rightIndex);
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLength;
    }
}
