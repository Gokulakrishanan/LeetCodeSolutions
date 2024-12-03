package org.example.dailyChallenges.model;

public class TakeKofEachCharacterFromLeftAndRight {
    /*
    * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

    Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
    Example 1:

    Input: s = "aabaaaacaabc", k = 2
    Output: 8
    Explanation:
    Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
    Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
    A total of 3 + 5 = 8 minutes is needed.
    It can be proven that 8 is the minimum number of minutes needed.
    Example 2:

    Input: s = "a", k = 1
    Output: -1
    Explanation: It is not possible to take one 'b' or 'c' so return -1.

    Constraints:

    1 <= s.length <= 105
    s consists of only the letters 'a', 'b', and 'c'.
    0 <= k <= s.length*/
    int k;

    public int takeCharacters(String s, int k) {
        this.k = k;
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if (!validCount(count)) {
            return -1;
        }

        int left = 0, right = 0, max = -1;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            count[currentChar - 'a']--;

            if (!validCount(count) && left <= right) {
                count[s.charAt(left) - 'a']++;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return s.length() - max;
    }

    private boolean validCount(int[] count) {
        for (int i : count) {
            if (i < k) {
                return false;
            }
        }
        return true;
    }
}
