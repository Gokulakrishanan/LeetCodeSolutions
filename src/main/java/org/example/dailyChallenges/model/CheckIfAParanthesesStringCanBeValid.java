package org.example.dailyChallenges.model;

public class CheckIfAParanthesesStringCanBeValid {
    public boolean canBeValid(String string, String locked) {
        if (string.length() % 2 != 0) {
            return false;
        }
        /*int wildCards = 0, openingBrackets = 0, closingBrackets = 0;

        //left to right Iterations
        for (int i = 0; i < string.length(); i++) {
            if (locked.charAt(i) == '0') {
                wildCards++;
            } else if (string.charAt(i) == '(') {
                openingBrackets++;
            } else {
                closingBrackets++;
            }
            if (wildCards < (closingBrackets - openingBrackets)) {
                return false;
            }
        }

        wildCards = openingBrackets = closingBrackets = 0;
        //right to left Iterations
        for (int i = string.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                wildCards++;
            } else if (string.charAt(i) == '(') {
                openingBrackets++;
            } else {
                closingBrackets++;
            }
            if (wildCards < (openingBrackets - closingBrackets)) {
                return false;
            }
        }*/

        //Alternative Solution
        int wildCards1 = 0, openingBrackets = 0, closingBrackets = 0, wildCards2 = 0;

        for (int i = 0; i < string.length(); i++) {

            //left to right iteration
            if (locked.charAt(i) == '0') wildCards1++;
            else if (string.charAt(i) == '(') openingBrackets++;
            else if (string.charAt(i) == ')') openingBrackets--;
            if (openingBrackets + wildCards1 < 0) return false;

            //right to left
            int j = string.length() - 1 - i;
            if (locked.charAt(j) == '0') wildCards2++;
            else if (string.charAt(j) == ')') {
                closingBrackets++;
            } else if (string.charAt(j) == '(') closingBrackets--;
            if (closingBrackets + wildCards2 < 0) return false;
        }


        return true;
    }
}
