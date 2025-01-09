package org.example.dailyChallenges.model;

public class CountPrefixAndSuffixPairsI {

    public int countPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isValidSuffixAndPrefix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValidSuffixAndPrefix(String word, String word2) {
        return word2.startsWith(word) && word2.endsWith(word);
    }
}
