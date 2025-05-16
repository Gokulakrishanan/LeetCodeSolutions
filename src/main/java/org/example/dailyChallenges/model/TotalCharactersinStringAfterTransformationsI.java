package org.example.dailyChallenges.model;

public class TotalCharactersinStringAfterTransformationsI {

    public final int mod = 1_000_000_007;

    public int findLenAfterTransform(String s, int t) {
        int ans = 0;
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

       
        return ans;
    }
}
