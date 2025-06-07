package org.example.dailyChallenges.model;

import java.util.Stack;

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String printTheSmallestString(String s) {
        int[] freq = new int[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder robotString = new StringBuilder();

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;

            while (!stack.isEmpty() && stack.peek() <= smallestChar(freq)) {
                robotString.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            robotString.append(stack.pop());
        }

        return robotString.toString();
    }

    private char smallestChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
