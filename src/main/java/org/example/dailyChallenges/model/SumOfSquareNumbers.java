package org.example.dailyChallenges.model;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        long left = 0;
        long right = (int) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
