package org.example.dailyChallenges.model;


/* Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumOfDistinctSubArraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        int currentSum = 0, left = 0, right = 0, n = nums.length;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        while (right < n) {
            int current = nums[right];
            Integer last = lastSeen.getOrDefault(current, -1);

            while (last >= left || right - left + 1 > k) {
                currentSum -= nums[left++];
                //left++;
            }
            currentSum += nums[right];
            lastSeen.put(current, right);
            if (right - left + 1 == k) {
                result = Math.max(result, currentSum);
            }
            right++;
        }
        return result;
    }

    public long maxSumSubArray(int[] nums, int k) {
        long result = 0, currentSum = 0;
        int left = 0, right = 0, n = nums.length;
        if (k > n) {
            return 0;
        }
        Set<Integer> resultSet = new HashSet<>();
        while (right < n) {
            currentSum += nums[right];

            while (resultSet.contains(nums[right])) {
                currentSum -= nums[left];
                resultSet.remove(nums[left]);
                left++;
            }
            resultSet.add(nums[right]);

            if (right - left + 1 == k) {
                result = Math.max(currentSum, result);
                currentSum -= nums[left];
                resultSet.remove(nums[left]);
                left++;
            }
            right++;
        }
        return result;
    }
}





