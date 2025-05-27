package org.example.dailyChallenges.model;

public class DivisibleAndNonDivisibleSumsDifference {

    public int differenceOfSums(int m, int n) {
        // num1 sum of all integers starting from 1-n and not divisible by m
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            }
        }
        return num1 - num2;
    }

    public int diffOfSums(int n, int m) {

        //num1= sum of non-DivisibleNumbers, num2=sum of divisibleNumbers;
        //return num1-num2 --(1)
        //totalSum = num1+ num2 --> (2)
        //num1 = totalSum -num2 (substitute num1 in equation 1)
        //totalSum - 2*num2

        int totalSum = n * (n + 1) / 2; //formula
        int sumOfDivisibles = m * (n / m) * ((n / m) + 1);
        return totalSum - sumOfDivisibles;
    }

}
