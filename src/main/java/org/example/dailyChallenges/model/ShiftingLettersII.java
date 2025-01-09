package org.example.dailyChallenges.model;

public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray = s.toCharArray();
        int[] count = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }
        int sum = 0;
        for (int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int newChar = ((charArray[i] - 'a') + sum) % 26;
            if (newChar < 0) newChar += 26;
            charArray[i] = (char) (newChar + 'a');
        }
        return String.valueOf(charArray);
    }
}
