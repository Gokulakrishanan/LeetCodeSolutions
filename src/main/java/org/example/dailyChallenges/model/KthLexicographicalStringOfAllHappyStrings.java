package org.example.dailyChallenges.model;

/*A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

Constraints:

1 <= n <= 10
1 <= k <= 100
*/

public class KthLexicographicalStringOfAllHappyStrings {

    int lengthOfTheString;
    String ans;
    int n;
    int k;
    char[] chars;

    public String getHappyString(int n, int k) {
        this.lengthOfTheString = n;
        return sol(new StringBuilder(), n, k);
    }

    private String sol(StringBuilder prefix, int n, int k) {
        if (n == 0) {
            return prefix.toString();
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (prefix.length() > 0 && prefix.charAt(prefix.length() - 1) == ch) continue;

            int count = (int) Math.pow(2, lengthOfTheString - prefix.length() - 1);

            if (count >= k) {
                return sol(prefix.append(ch), n - 1, k);
            } else {
                k -= count;
            }
        }

        return "";
    }

    public String getLexicalString(int n, int k) {
        this.n = n;
        this.k = k;
        chars = new char[]{'a', 'b', 'b'};
        ans = "";
        solution(0, "");
        return ans;
    }

    private boolean solution(int index, String temp) {
        if (index == n) {
            if (k == 1) {
                ans = temp;
                return true;
            } else {
                k--;
                return false;
            }
        }

        for (char aChar : chars) {
            char previousCharacter = temp.length() == 0 ? 'x' : temp.charAt(temp.length() - 1);
            if (previousCharacter != aChar) {
                if (solution(index + 1, temp + aChar)) {
                    return true;
                }
            }
        }

        return false;
    }
}
