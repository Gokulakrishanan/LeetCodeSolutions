package org.example.dailyChallenges.model;

import java.util.HashMap;

/*Given an array of integers arr, return the number of subarrays with an odd sum.
Since the answer can be very large, return it modulo 10^9 + 7.
Example 1:
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
Example 2:
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.
Example 3:
Input: arr = [1,2,3,4,5,6,7]
Output: 16
Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 100
*/
public class NumberOfSubArraysWithOddSum {


    public int numOfSubarrays(int[] nums) {
       /* int mod = 1000000007, count = 0, even = 1, odd = 0, total = 0;
        for (int num : nums) {
            total += num;

            if (total % 2 == 1) {
                count = (count + even) % mod;
                odd++;
            } else {
                count = (count + odd) % mod;
                even++;
            }
        }*/

        int mod = 10 ^ 9 + 7;
        int count = 0, total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            total += num;

            if (total % 2 == 1) {
                count = (count + map.getOrDefault(0, 0)) % mod;
            } else {
                count = (count + map.getOrDefault(1, 0)) % mod;
            }

            map.put(total % 2, map.getOrDefault(total % 2, 0) + 1);
        }
        return count;

    }

}
