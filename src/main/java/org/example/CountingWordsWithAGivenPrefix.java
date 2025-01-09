package org.example;

import java.util.Arrays;

public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) count++;
        }
        return count;
    }

    public int prefCount(String[] words, String prefix) {
        return (int) Arrays.stream(words).filter(s -> s.startsWith(prefix)).count();
    }

    public int countingprefix(String[] words, String prefix) {
        int count = 0;
        for (String word : words) {
            boolean value = true;
            for (int i = 0; i < prefix.length(); i++) {
                if (i >= word.length() || word.charAt(i) != prefix.charAt(i)) {
                    value = false;
                    break;
                }
            }
            if (value) {
                count++;
            }
        }
        return count;
    }
}
