package org.example.dailyChallenges.model;

public class CountTheNumberOfArraysWithKMatchingAdjacentElements {
    private static final int MOD = (int) 1e9 + 7;
    private final int[] fact = new int[100001]; // given length of n is 10^5
    private final long[] inverseFact = new long[100001];

    public int countGoodArrays(int n, int m, int k) {
        if (fact[0] == 0) {
            fact[0] = 1;
        }
        long result = m * pow(m - 1, n - k - 1) % MOD * CValue(n - 1, n - k - 1) % MOD;
        return (int) result;
    }

    private long pow(int m, int k) {
        long result = 1;
        long base = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            k /= 2;
        }
        return result;
    }

    private long CValue(int n, int k) {
        return factorial(n) * reverseFact(factorial(n - k)) % MOD * reverseFact(factorial(k)) % MOD;
    }

    private long reverseFact(long n) {
        if (n == 1) {
            return n;
        }
        return MOD - MOD / n * reverseFact(MOD % n) % MOD;
    }

    private long factorial(int n) {
        if (fact[n] != 0) {
            return fact[n];
        }
        return fact[n] = (int) (factorial(n - 1) * n % MOD);
    }

}
