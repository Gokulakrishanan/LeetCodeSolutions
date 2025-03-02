package org.example.dailyChallenges.model;
/*You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.

Example 1:

Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.
Example 2:

Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.

Constraints:

1 <= nums1.length, nums2.length <= 200
nums1[i].length == nums2[j].length == 2
1 <= idi, vali <= 1000
Both arrays contain unique ids.
Both arrays are in strictly ascending order by id.
*/


import java.util.ArrayList;
import java.util.List;

public class MergeTwo2dArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        /*//Using HashMap or Treemap
        TreeMap<Integer, Integer> result = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length, n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            result.put(nums1[i][0], nums1[i][1]);
            //map.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < n2; i++) {
            result.put(nums2[i][0], result.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
          //  map.put(nums2[i][0], result.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        int[][] finalResult = new int[result.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> value : result.entrySet()) {
            finalResult[index][0] = value.getKey();
            finalResult[index++][1] = value.getValue();
        }

        *//*for (Map.Entry<Integer, Integer> value : map.entrySet()) {
            finalResult[index][0] = value.getKey();
            finalResult[index++][1] = value.getValue();
        }
        Arrays.sort(finalResult, (a, b) -> Integer.compare(a[0], b[0]));*//*

        return finalResult;*/

        //Using mergeSort{}

        int n1 = nums1.length, n2 = nums2.length;

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i][0] == nums2[j][0]) {
                result.add(new int[]{nums1[i][0], nums1[i++][1] + nums2[j++][1]});
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i++]);
            } else {
                result.add(nums2[j++]);
            }
        }
        while (i < n1) {
            result.add(nums1[i++]);
        }
        while (j < n2) {
            result.add(nums2[j++]);
        }
        return result.toArray(new int[result.size()][2]);

    }

}
