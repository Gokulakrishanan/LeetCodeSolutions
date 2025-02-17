package org.example.dailyChallenges.model;

public class LetterTilePossibilties {

    public int numTilePossibilities(String tiles) {
        char[] charArray = tiles.toCharArray();
        int[] freqArray = new int[26];
        for (char c : charArray) {
            freqArray[c - 'A']++;
        }
        return getFreq(freqArray);
    }

    private int getFreq(int[] freqArray) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freqArray[i] != 0) {
                count++;
                freqArray[i]--;
                count += getFreq(freqArray);
                freqArray[i]++;
            }
        }

        return count;
    }

    public int possibilities(String tiles) {
        char[] charArray = tiles.toCharArray();
        return permuteString(charArray, 0);
    }

    private int permuteString(char[] ch, int index) {
        if (index == ch.length) return 0;
        int ans = 0;
        for (int i = index; i < ch.length; i++) {
            if (!isPermutated(index, i - 1, ch[i], ch)) {
                swap(ch, index, i);
                ans += 1 + permuteString(ch, index + 1);
                swap(ch, index, i);

            }
        }
        return ans;
    }

    private boolean isPermutated(int start, int previousIndex, char character, char[] characterArray) {
        while (start <= previousIndex) {
            if (characterArray[start++] == character) return true;
        }
        return false;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
