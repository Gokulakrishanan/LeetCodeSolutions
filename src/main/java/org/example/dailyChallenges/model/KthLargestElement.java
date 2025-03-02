package org.example.dailyChallenges.model;

/*Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/

import java.util.PriorityQueue;

public class KthLargestElement {

    private void swap(int[] nums, int i, int partitionIndex) {
        int temp = nums[i];
        nums[i] = nums[partitionIndex];
        nums[partitionIndex] = temp;
    }

    public int findKthLargestElement(int[] nums, int k) {

        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {

        if (left == right) return nums[left];

        int partitionIndex = partitionIndex(nums, left, right);

        if (k == partitionIndex) {
            return partitionIndex;
        }

        return (k > partitionIndex) ?
                quickSort(nums, left, partitionIndex - 1, k) : quickSort(nums, partitionIndex + 1, right, k);
    }

    private int partitionIndex(int[] nums, int left, int right) {
        int pivotElement = nums[right];
        int partitionIndex = left; //0/start

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivotElement) {
                swap(nums, i, partitionIndex);
                partitionIndex++;
            }

        }
        swap(nums, partitionIndex, right);
        return partitionIndex;
    }


    public int KthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            minHeap.offer(num);
        }

        while (k > 1) {
            minHeap.poll();
            k--;
        }
        return minHeap.poll();
    }

}
