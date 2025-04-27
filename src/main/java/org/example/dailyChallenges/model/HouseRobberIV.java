package org.example.dailyChallenges.model;

public class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int leftHouse = nums[0], rightHouse = nums[0], result = 0;

        for (int num : nums) {
            leftHouse = Math.min(leftHouse, num);
            rightHouse = Math.max(rightHouse, num);
        }
        while (leftHouse <= rightHouse) {
            int mid = leftHouse + (rightHouse - leftHouse) / 2;
            int numberOfHouses = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    numberOfHouses++;
                    i++;
                }
            }
            if (numberOfHouses >= k) {
                result = mid;
                rightHouse = mid - 1;
            } else {
                leftHouse = mid + 1;
            }
        }
        return result;
    }
}
