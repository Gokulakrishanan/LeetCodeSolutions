package org.example.dailyChallenges.model;

import java.util.Arrays;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] charArray = (n + "").toCharArray();
        int i = charArray.length - 2, k = charArray.length - 1;
        System.out.println(Arrays.toString(charArray));
        System.out.println(charArray.length - 2);
        while (i >= 0 && charArray[i] >= charArray[i + 1]) i--;

        if (i == -1) return -1;

        while (charArray[k] <= charArray[i]) {
            k--;
        }


        swap(charArray, i, k);
        reverse(charArray, i + 1);

        long result = Long.parseLong(new String(charArray));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void reverse(char[] charArray, int start) {
        int end = charArray.length - 1;
        while (start < end) {
            swap(charArray, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
