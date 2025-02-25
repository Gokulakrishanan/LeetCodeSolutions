package org.example.dailyChallenges.model;

import java.util.HashMap;

/*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        //int nums[] = new int[]{1,2,3}, k =3;
        int count = 0, total = 0;
        //map<Integer,Count>
        HashMap<Integer, Integer> map = new HashMap<>();
        //since number is starting from 1 we put 0 with value of 1
        map.put(0, 1);
        for (int num : nums) {
            total += num;
            //total = 1

            //total-k = 1-3 = -2;
            //total-k = 3-3 = 0;
            //total-k = 6-3 = 3
            if (map.containsKey(total - k)) {
                count += map.get(total - k);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return count;
    }
}
