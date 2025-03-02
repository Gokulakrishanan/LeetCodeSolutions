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
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder lcs = new StringBuilder();
        int i = n1;
        int j = n2;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                j--;
            } else {
                i--;
            }
        }

        return lcs.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        String lcs = findLCS(str1, str2);

        StringBuilder ans = new StringBuilder();

        int p1 = 0, p2 = 0;
        for (char ch : lcs.toCharArray()) {
            while (p1 < str1.length() && str1.charAt(p1) != ch) {
                ans.append(str1.charAt(p1++));
            }
            while (p2 < str2.length() && str2.charAt(p2) != ch) {
                ans.append(str2.charAt(p2++));
            }
            ans.append(ch);
            p1++;
            p2++;

        }
        ans.append(str1.substring(p1));
        ans.append(str2.substring(p2));

        return ans.toString();
    }

}
