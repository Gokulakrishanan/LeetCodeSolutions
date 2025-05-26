package org.example.dailyChallenges.model;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int[][] wordsCount = new int[26][26];
        int count = 0;
        for (String s : words) {
            int char1 = s.charAt(0) - 'a', char2 = s.charAt(1) - 'a';
            //reversePair
            if (wordsCount[char2][char1] > 0) {
                count += 4; //pair count should be twice ([x][y] & [y][x])
                wordsCount[char2][char1]--;
            } else {
                wordsCount[char1][char2]++;
            }

        }
        for (int i = 0; i < 26; i++) {
            if (wordsCount[i][i] > 0) {
                count += 2; //middle words
                break;
            }
        }
        return count;

    }
}
