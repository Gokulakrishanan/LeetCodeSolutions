package org.example.dailyChallenges.model;

import java.util.*;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        int res = 0;

        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return res;
    }


    public int countPalindrome(String word) {
        /*int length = word.length();
        Map<Character, int[]> firstlast = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (!firstlast.containsKey(c)) {
                firstlast.put(c, new int[]{i, i});
            } else {
                firstlast.get(c)[1] = i;
            }
        }

        int count = 0;
        for (Map.Entry<Character, int[]> entry : firstlast.entrySet()) {
            int[] value = entry.getValue();
            if (value[0] == value[1]) continue;

            Set<Character> uniqueChars = new HashSet<>();
            for (int i = value[0] + 1; i < value[1]; i++) {
                uniqueChars.add(word.charAt(i));
            }
            count += uniqueChars.size();
        }

        return count;*/

        int length = word.length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), new int[]{i, i});
            } else {
                map.get(word.charAt(i))[1] = i;
            }
        }

        int count = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            System.out.println(entry.getKey() + " " + value[0]);
            System.out.println(entry.getKey() + " " + value[1]);
            if (value[0] == value[1]) continue;

            Set<Character> set = new HashSet<>();
            for (int i = value[0] + 1; i < value[1]; i++) {
                set.add(word.charAt(i));
            }
            count += set.size();
        }

        return count;

    }
}
