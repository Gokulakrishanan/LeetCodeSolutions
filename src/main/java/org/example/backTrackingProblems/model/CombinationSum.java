package org.example.backTrackingProblems.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> solve(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backTrack(result, tempList, nums, target - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
