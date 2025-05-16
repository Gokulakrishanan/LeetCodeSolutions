package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> longestUnequalSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        pickTheWord(0, words, groups, -1, list);
        return list;
    }

    private void pickTheWord(int index, String[] words, int[] groups, int lastIndex, List<String> result) {
        if (index == words.length) return;

        if (index == 0 || lastIndex != groups[index]) {
            result.add(words[index]);
            lastIndex = groups[index];
        }
        pickTheWord(index + 1, words, groups, lastIndex, result);
    }
}
