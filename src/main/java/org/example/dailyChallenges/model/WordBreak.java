package org.example.dailyChallenges.model;

import java.util.List;

/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int maxLengthWord = 0;
        for (String word : wordDict) {
            maxLengthWord = Math.max(maxLengthWord, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= (i - maxLengthWord - 1); j--) {
                if (visited[j] && wordDict.contains(s.substring(j, i))) {
                    visited[i] = true;
                    break;
                }
            }
        }
        return visited[n];
    }
}
