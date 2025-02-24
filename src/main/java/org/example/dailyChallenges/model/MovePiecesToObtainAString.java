package org.example.dailyChallenges.model;

/*You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:

The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.



Example 1:

Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.
Example 2:

Input: start = "R_L_", target = "__LR"
Output: false
Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
Example 3:

Input: start = "_R", target = "R_"
Output: false
Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.


Constraints:

n == start.length == target.length
1 <= n <= 105
start and target consist of the characters 'L', 'R', and '_'.*/
public class MovePiecesToObtainAString {
    public boolean canChange(String word, String targetWord) {

        //Check the length of the strings
        if (word.length() != targetWord.length()) {
            return false;
        }
        //Initialization of pointers and capturing the length of the strings
        int n = word.length(), m = targetWord.length(), start = 0, target = 0;
        while (start < n && target < m) {
            //Getting the character at the pointers
            char startChar = word.charAt(start);
            char targetChar = targetWord.charAt(target);

            //Check for the blank spaces and increase the pointers
            if (startChar == '_' && targetChar == '_') {
                start++;
                target++;
            }
            // increase the pointers if one has blank space and the other has character
            else if (startChar == '_') {
                start++;
            } else if (targetChar == '_') {
                target++;
            }
            //Check for the characters in either strings and check whether the 'L'(ONLY SHIFTS TO LEFT) and 'R'(ONLY SHIFTS TO RIGHT) are present and check for their shifts
            else if (startChar == targetChar && ((startChar == 'L' && start >= target) || (startChar == 'R' && start <= target))) {
                start++;
                target++;
            } else {
                return false;
            }
        }
        //Check for the starting char of the strings whether it's a blank space or not and increase the pointers
        while (start < n && word.charAt(start) == '_') {
            start++;
        }
        while (target < m && targetWord.charAt(target) == '_') {
            target++;
        }
        return start == n && target == m;
    }

    public boolean canWork(String start, String target) {
        //Strings to charArray
        char[] startChar = start.toCharArray();
        char[] targetChar = target.toCharArray();
        //Initialization of pointers and length of the Strings
        int startPointer = 0, targetPointer = 0, n = start.length(), m = target.length();

        //Execute when the pointers are within the length
        while (startPointer <= n && targetPointer <= m) {
            //Check for the blank space character '_'
            while (startPointer < n && startChar[startPointer] == '_') {
                startPointer++;
            }
            while (targetPointer < m && targetChar[targetPointer] == '_') {
                targetPointer++;
            }

            //if StartingPointer in the word and the TargetPointer in the target is equal to their lengths
            if (startPointer == n || targetPointer == m) {
                return startPointer == n && targetPointer == m;
            }
            //If the characters are not same in either arrays
            else if (startChar[startPointer] != targetChar[targetPointer]) {
                return false;
            }
            //if start char in the word is 'L' it can move ONLY TO THE LEFT!!
            else if (startChar[startPointer] == 'L' && startPointer < targetPointer) {
                return false;
            }
            //if start char in the word is 'R' it can move ONLY TO THE RIGHT!!
            else if (startChar[startPointer] == 'R' && startPointer > targetPointer) {
                return false;
            }
            //Increment the pointers and check for the remaining characters
            startPointer++;
            targetPointer++;
        }
        return true;
    }
}
