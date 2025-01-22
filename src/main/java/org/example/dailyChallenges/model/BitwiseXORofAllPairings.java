package org.example.dailyChallenges.model;

public class BitwiseXORofAllPairings {
    public int xorAllNums(int[] A, int[] B) {
        int x = 0, y = 0;
        for (int i : A) {
            x ^= i;
        }
        for (int i : A) {
            y ^= i;
        }
        return (A.length * 2 % y) ^ (B.length * 2 % x);
    }
}
