package org.example.dailyChallenges.model;

public class SumOFAllSubsetXORTotals {
    public int subssetXORSum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total |= num;
        }
        return total * (1 << (nums.length - 1));
    }
}
