package org.example.dailyChallenges.model;

/*You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u')
at least once and exactly k consonants.

Example 1:

Input: word = "aeioqq", k = 1

Output: 0

Explanation:

There is no substring with every vowel.

Example 2:

Input: word = "aeiou", k = 0

Output: 1

Explanation:

The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:

Input: word = "ieaouqqieaouqq", k = 1

Output: 3

Explanation:

The substrings with every vowel and one consonant are:

word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".

Constraints:

5 <= word.length <= 2 * 105
word consists only of lowercase English letters.
0 <= k <= word.length - 5
*/
public class CountOFSubstringsContainingEveryVowelAndKConsonantsII {
    public long countOfSubstrings(String word, int k) {
        int[][] freq = new int[2][128];
        //initialising the vowels
        freq[0]['a'] = 1;
        freq[0]['e'] = 1;
        freq[0]['i'] = 1;
        freq[0]['o'] = 1;
        freq[0]['u'] = 1;


        long result = 0;
        int currentK = 0, extraLeft = 0, vowels = 0;
        for (int right = 0, left = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);
            if (freq[0][rightChar] == 1 && freq[1][rightChar]++ == 1) {
                vowels++;
            } else if (freq[0][rightChar] == 0) {
                currentK++;
            }
            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (freq[0][leftChar] == 1 && freq[1][leftChar]-- == 0) {
                    vowels--;
                } else if (freq[0][leftChar] == 0) {
                    currentK--;
                }
                left++;
                extraLeft = 0;
            }

            while (vowels == 5 && currentK == k && left < right && freq[0][word.charAt(left)] == 1 &&
                    freq[1][word.charAt(left)] > 1) {
                extraLeft++;
                freq[1][word.charAt(left)]--;
                left++;
            }
            if (currentK == k && vowels == 5) {
                result++;
                result += extraLeft;
            }
        }
        return result;
    }
}
