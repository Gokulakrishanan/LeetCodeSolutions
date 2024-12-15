package org.example.dailyChallenges.model;

import java.util.TreeMap;

public class ContinuousSubarrays {
    public long continuousSubArrays(int[] nums){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long ans =0;
        int i =0, j=0,n= nums.length;
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while (map.lastEntry().getKey()-map.firstEntry().getKey() >2){
                map.put(nums[i], map.get(nums[i])-1);
                if (map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}
