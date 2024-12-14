package org.example.dailyChallenges.model;

import java.util.Arrays;

public class MaxBeautyArrayAfterApplyingOperation {
    public int longestSequence(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        int maxBeauty=0;
        for (int i = 0; i < n; i++) {
            int maxIndex = findIndex(nums,nums[i]+2*k);
            maxBeauty = Math.max(maxBeauty, maxIndex-i+1);
        }
        return maxBeauty;
    }
    private int findIndex(int[] nums, int value){
        int result =0,left=0,right=nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]<=value){
                result=mid;
                left= mid+1;
            }else {
                right = mid-1;
            }
        }
        return result;
    }
}
