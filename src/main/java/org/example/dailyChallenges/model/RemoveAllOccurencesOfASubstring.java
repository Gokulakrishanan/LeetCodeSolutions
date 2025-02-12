package org.example.dailyChallenges.model;

public class RemoveAllOccurencesOfASubstring {
    public String removeOccurence(String s, String part) {
        char[] m = s.toCharArray();
        char[] n = part.toCharArray();
        int inputLength = m.length, targetLength = n.length, stackIndex = 0;
        char[] resultStack = new char[inputLength];
        char targetEndChar = n[targetLength - 1];
        for (char currentChar : m) {
            resultStack[stackIndex++] = currentChar;
            if (currentChar == targetEndChar && stackIndex >= targetLength) {
                int i = stackIndex - 1, j = targetLength - 1;
                while (j >= 0 && resultStack[i] == n[j]) {
                    i--;
                    j--;
                }
                if (j < 0) {
                    stackIndex = i + 1;
                }
            }

        }


        return new String(resultStack, 0, stackIndex);
    }
}
