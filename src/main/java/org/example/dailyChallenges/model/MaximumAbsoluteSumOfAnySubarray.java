package org.example.dailyChallenges.model;

/*You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.

Example 1:

Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
Example 2:

Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
*/

public class MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        /*int n = nums.length;
        int minSum = nums[0], maxSum = nums[0];
        int currentMaxSum = nums[0], currentMinSum = nums[0];
        for (int i = 0; i < n; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);

            maxSum = Math.max(maxSum, currentMaxSum);
            minSum = Math.min(minSum, currentMinSum);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));*/

        //initializing
        int minSum = 0, maxSum = 0, currentSum = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            //iterating for maxSum by storing the maxSum (+ve sum)
            if (currentSum < 0)
                currentSum = 0;
            currentSum += nums[i];
            //catching the maximum sum value in the maxSum using Math.max
            maxSum = Math.max(maxSum, currentSum);
        }

        //setting the currentSum to zero for the minSum (-ve Sum)
        currentSum = 0;
        for (int i = 0; i < n; i++) {
            if (currentSum < 0)
                currentSum = 0;

            currentSum += nums[i];
            //catching the minimum sum value in the minSum using the Math.min
            minSum = Math.min(minSum, currentSum);
        }

        //setting the value of minSum to abs to get the maxSum between both the maxSum and minSum
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
