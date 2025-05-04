package org.example.dailyChallenges.model;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumNumberOfTasksYouCanAssign {
    public int maxTasksAssign(int[] tasks, int[] workers, int pills, int strength) {
        int left = 0, right = Math.min(workers.length, tasks.length);
        //sorting the arrays to give the higher strength tasks from higher strength workers
        Arrays.sort(workers);
        Arrays.sort(tasks);
        //Apply Binary search to find the max strength workers and assign it to higher strength tasks
        boolean isPossible = false;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //track the usage of magic pills
            int usedPills = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = workers.length - mid; i < workers.length; i++) {
                map.put(workers[i], map.getOrDefault(workers[i], 1));
            }
            //checking whether it's possible for the worker to do the task
            isPossible = true;

            for (int i = mid - 1; i >= 0; i--) {
                int task = tasks[i];
                //returns the highest worker from the map
                int worker = map.lastKey();
                if (worker >= task) {
                    //successfully assigned
                    decrementingWorkers(map, worker);
                } else {
                    Integer key = map.ceilingKey(task - strength);
                    if (key == null || ++usedPills > pills) {
                        isPossible = false;
                        break;
                    }
                    decrementingWorkers(map, key);
                }

            }
            if (isPossible) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }


        return left;
    }

    public void decrementingWorkers(TreeMap<Integer, Integer> map, int key) {
        int value = map.get(key);
        if (value == 1) {
            map.remove(key);
        } else {
            map.put(key, value - 1);
        }
    }
}
