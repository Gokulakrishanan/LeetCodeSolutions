package org.example.dailyChallenges.model;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundThePivot(s, i, i);
            int even = expandAroundThePivot(s, i, i + 1);
            int length = Math.max(odd, even);

            if (length > right - left) {
                left = i - (length - 1) / 2;
                right = i + length / 2;
            }

        }

        return s.substring(left, right + 1);
    }

    private int expandAroundThePivot(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
