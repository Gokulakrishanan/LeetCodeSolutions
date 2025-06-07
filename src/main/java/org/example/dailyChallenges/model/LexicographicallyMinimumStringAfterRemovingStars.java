package org.example.dailyChallenges.model;

import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> queue = new PriorityQueue<>();
        HashMap<Character, Deque<Integer>> map = new HashMap<>();
        boolean[] keepCh = new boolean[n];
        Arrays.fill(keepCh, true);


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                Character smallestChar = queue.poll();
                int removingIndex = map.get(smallestChar).removeLast();
                keepCh[i] = false;
                keepCh[removingIndex] = false;
            } else {
                queue.offer(ch);
                map.putIfAbsent(ch, new ArrayDeque<>());
                map.get(ch).add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (keepCh[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
