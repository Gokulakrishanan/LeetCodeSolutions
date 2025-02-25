package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
Constraints:
1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
*/
public class SubStringWithConcatenationOfAllWords {
    public List<Integer> findSubstringCount(String s, String[] words) {

        //initialization starts
        List<Integer> resultList = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return resultList;
        int sLem = s.length();
        int wordLen = words[0].length();
        int numOfWords = words.length;

        //populating the map with the words from the word map;
        //map<word,wordCount> wordsMap
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        //itertating for word length
        for (int i = 0; i < wordLen; i++) {
            //visitiedMap
            Map<String, Integer> visitedWordMap = new HashMap<>();
            //starting indices of the word
            int beginIndex = i;
            //count of the words
            int count = 0;

            //iterating from i to i+wordlength. For instance start from 0 and for the next iteration go from the next index of the wordLength
            for (int j = i; j + wordLen < s.length(); j += wordLen) {
                //take the substring in the given string with the given index (beginningIndex to wordlength)
                String substring = s.substring(j, j + wordLen);
                //check if the wordMap has the same word/substring
                if (wordMap.containsKey(substring)) {
                    //mark the substring
                    visitedWordMap.put(substring, visitedWordMap.getOrDefault(substring, 0) + 1);
                    //increase the count of the word
                    count++;

                    while (visitedWordMap.get(substring) > wordMap.get(substring)) {
                        //remove the visited string
                        String removeString = s.substring(beginIndex, beginIndex + wordLen);
                        visitedWordMap.put(removeString, visitedWordMap.get(removeString) - 1);
                        if (visitedWordMap.get(removeString) == 0) {
                            visitedWordMap.remove(removeString);
                        }
                        //decrease the count (similar to backTracking)
                        count--;
                        //skip that word and start from the next word. That is "foobar" to "bar"
                        beginIndex += wordLen;
                    }
                    //check for the words and the count value
                    if (count == numOfWords) {
                        //add to the resultset
                        resultList.add(beginIndex);
                    }
                } else {
                    visitedWordMap.clear();
                    count = 0;
                    beginIndex = j + wordLen;
                }
            }
        }
        return resultList;
    }
}
