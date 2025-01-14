package org.example.dailyChallenges.model;


/*
* You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
Each answer[i] is calculated considering the initial state of the boxes.

Example 1:
Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
*
Example 2:
Input: boxes = "001011"
Output: [11,8,5,4,3,4]
Constraints:
n == boxes.length
1 <= n <= 2000
boxes[i] is either '0' or '1'.
* */
public class MinNumberOfOpsToMoveBallsToEachBox {
    public int[] minOperations(String boxes) {

        /*int n = boxes.length(), leftCount = 0, leftSum = 0, rightSum = 0, rightCount = 0;
        int[] result = new int[n];
        //traversing the array from left to right
        for (int i = 0; i < n; i++) {
            result[i] = leftCount * i - leftSum;
            if (boxes.charAt(i) == '1') {
                leftCount++;
                leftSum += i;
            }
        }
        //traversing the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += rightSum - rightCount * i;
            if (boxes.charAt(i) == '1') {
                rightCount++;
                rightSum += i;
            }
        }
        return result;*/

        int n = boxes.length(), leftCount = 0, rightCount = 0, leftSum = 0, rightSum = 0;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = leftCount * i - leftSum;
            if (boxes.charAt(i) == '1') {
                leftCount++;
                leftSum += i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] += rightSum - rightCount * i;
            if (boxes.charAt(i) == '1') {
                rightCount++;
                rightSum += i;
            }
        }
        return result;

    }
}
