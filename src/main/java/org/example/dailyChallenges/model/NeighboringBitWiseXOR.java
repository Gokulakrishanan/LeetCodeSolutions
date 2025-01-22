package org.example.dailyChallenges.model;

public class NeighboringBitWiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        // return Arrays.stream(derived).sum() % 2 == 0;
        int xor = 0;
        for (int i : derived) {
            xor ^= i;
        }
        return xor == 0;
    }
}
