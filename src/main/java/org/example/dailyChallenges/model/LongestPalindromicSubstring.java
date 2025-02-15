package org.example.dailyChallenges.model;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundTheCenter(s, i, i);
            int even = expandAroundTheCenter(s, i, i + 1);
            int maxLength = Math.max(odd, even);

            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundTheCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
