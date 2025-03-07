package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].



Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.


Constraints:

1 <= left <= right <= 106


*/
public class ClosestPrimeNumbersInRange {

    public int[] closestPrimeNumbers(int left, int right) {
        int[] result = new int[2];
        boolean[] seive = new boolean[right + 1];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (seive[i]) {
                for (int j = i * i; j <= right; j += i) {
                    seive[j] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (seive[i]) {
                primeNumbers.add(i);
            }
        }
        if (primeNumbers.size() < 2) {
            return new int[]{-1, -1};
        }
        int minGap = Integer.MAX_VALUE;

        for (int i = 1; i < primeNumbers.size(); i++) {
            int currentGap = primeNumbers.get(i) - primeNumbers.get(i - 1);
            if (currentGap < minGap) {
                minGap = currentGap;
                result[0] = primeNumbers.get(i);
                result[1] = primeNumbers.get(i - 1);
            }
        }

        return result;

    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();

        for (int number = left; number <= right; number++) {
            if (number % 2 == 0 && number > 2) {
                continue;
            }
            if (isPrime(number)) {
                if (!primes.isEmpty() && number <= primes.getLast() + 2) {
                    return new int[]{primes.getLast(), number};
                }
                primes.add(number);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int currGap = primes.get(i) - primes.get(i - 1);
            if (currGap < minGap) {
                minGap = currGap;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
