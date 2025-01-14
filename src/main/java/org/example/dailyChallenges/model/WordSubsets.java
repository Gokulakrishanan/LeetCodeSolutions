package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        //preprocessing Words2
        int[] hashOfChar = new int[26];
        //iterating each String in words2 and storing their hashValues;
        for (String string : words2) {

            //Storing hashValue of Characters in every String
            int[] hash = new int[26];
            for (char c : string.toCharArray()) {
                hash[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                hashOfChar[i] = Math.max(hashOfChar[i], hash[i]);
            }
        }

        //now checking whether words1[] string is universal or not
        //iterate through the Strings in words1[]
        for (String string : words1) {
            int[] hash = new int[26];
            for (char ch : string.toCharArray()) {
                hash[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (hash[i] >= hashOfChar[i]) {
                    result.add(string);
                }
            }
        }
        return result;
    }


    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            List<String> result = new ArrayList<>();
            int[] target = new int[26];

            for (String word : B) {
                int[] temp = new int[26];
                for (char ch : word.toCharArray()) {
                    temp[ch - 'a']++;
                    target[ch - 'a'] = Math.max(target[ch - 'a'], temp[ch - 'a']);
                }
            }

            for (String word : A) {
                int[] source = new int[26];
                for (char ch : word.toCharArray()) {
                    source[ch - 'a']++;
                }

                if (subset(source, target)) {
                    result.add(word);
                }
            }

            return result;
        }

        private boolean subset(int[] parent, int[] child) {
            for (int i = 0; i < 26; i++) {
                if (parent[i] < child[i]) return false;
            }
            return true;
        }
    }
}

