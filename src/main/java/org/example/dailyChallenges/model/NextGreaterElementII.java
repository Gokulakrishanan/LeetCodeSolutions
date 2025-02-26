package org.example.dailyChallenges.model;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        /*for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
        }*/
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }

            if (i > n) stack.push(index);
        }


        return result;
    }
}
