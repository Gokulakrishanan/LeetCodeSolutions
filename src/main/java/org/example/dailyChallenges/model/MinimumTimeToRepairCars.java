package org.example.dailyChallenges.model;

public class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
      /*  long left = 1, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;

            if (isTimeSuff(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;*/


        int[] freq = new int[100];
        int minF = 100;
        for (int i : ranks) {
            freq[i]++;
        }

        for (int i = 1; i <= 100; i++) {
            if (freq[i] > 0) {
                minF = i;
                break;
            }
        }

        long left = 0, right = (long) minF * cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isTimeSuff(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean isTimeSuff(int[] ranks, long cars, long value) {
        for (int i = 1; 0 < cars && i <= 100; i++) {
            if (ranks[i] == 0) {
                continue;
            }
            long time = (long) Math.sqrt((double) value / i);
            cars -= time * ranks[i];
        }
        return cars <= 0;
    }
}
