package org.example.dailyChallenges.model;

import java.util.Arrays;

public class TwoBestNonOverLappingEvents {
    public int maxTwoEvents(int[][] events){
        // Step 1: Sort the events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        // Step 2: Create the suffixMax array where suffixMax[i] holds the max value from i to the end
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];  // last event's value is the base case

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int maxSum = 0;

        // Step 3: For each event, find the maximum sum of choosing one or two non-overlapping events
        for (int i = 0; i < n; i++) {
            // Current event value
            int currentValue = events[i][2];

            // Step 4: Perform binary search to find the first event whose start time > current event's end time
            int validIndex = binarySearch(events, events[i][1] + 1);

            // If such a valid event exists, add its maximum value from suffixMax array
            if (validIndex != -1) {
                currentValue += suffixMax[validIndex];
            }

            // Update the maximum sum
            maxSum = Math.max(maxSum, currentValue);
        }

        return maxSum;
    }

    // Binary search to find the first event whose start time is greater than the given target time
    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (events[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // If we find a valid event, return its index; otherwise, return -1
        return (left < events.length) ? left : -1;
    }
}
