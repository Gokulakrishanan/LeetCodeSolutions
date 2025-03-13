package org.example.dailyChallenges.model;

import java.util.Arrays;

/*Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
*/
public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int[] abc = new int[3];
        Arrays.fill(abc, -1);
        int count = 0, right = 0;
        while (right < charArray.length) {
            abc[charArray[right] - 'a'] = right;
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                minIndex = Math.min(minIndex, abc[i]);
            }
            count += minIndex + 1;
            right++;
        }
        return count;
    }
}
