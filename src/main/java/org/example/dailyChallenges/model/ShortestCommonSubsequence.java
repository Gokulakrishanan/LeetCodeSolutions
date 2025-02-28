package org.example.dailyChallenges.model;

/*Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
*/
public class ShortestCommonSubsequence {
    private String findLCS(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        int s1Len = str1.length(), s2Len = str2.length();
        int[][] dp = new int[s1Len + 1][s2Len + 2];

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j < +s2Len; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = s1Len, j = s2Len;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return ans.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        String lcs = findLCS(str1, str2);
        int p1 = 0, p2 = 0;
        for (char ch : lcs.toCharArray()) {
            while (p1 < str1.length() && str1.charAt(p1) != ch) {
                answer.append(str1.charAt(p1++));
            }

            while (p1 < str2.length() && str2.charAt(p2) != ch) {
                answer.append(str2.charAt(p2++));
            }

            answer.append(ch);
            p1++;
            p2++;
        }

        answer.append(str1.substring(p1));
        answer.append(str2.substring(p2));
        return answer.toString();


    }
}
