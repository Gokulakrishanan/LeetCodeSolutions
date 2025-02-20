package org.example.dailyChallenges.model;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        int length = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= length + 1; i++) {
            stack.push(i);
            if (i == length + 1 || pattern.charAt(i - 1) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }

    public String smallNumber(String pattern) {
        int length = pattern.length();
        char[] charArray = new char[length + 1];
        for (int i = 0; i <= length; i++) {
            charArray[i] = ((i + 1) + "").charAt(0);
        }


        for (int i = 0; i < length; i++) {
            int j = i;
            while (j >= 0 && pattern.charAt(j) == 'D') {
                swap(charArray, j, j + 1);
                j--;
            }
        }

        return String.valueOf(charArray);
    }

    private void swap(char[] charArray, int currentIndex, int nextIndex) {
        char temp = charArray[currentIndex];
        charArray[currentIndex] = charArray[nextIndex];
        charArray[nextIndex] = temp;
    }
}
