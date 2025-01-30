package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numberOfCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        boolean[][] isPre = new boolean[numberOfCourses][numberOfCourses];

        for (int[] pre : prerequisites) {
            isPre[pre[0]][pre[1]] = true;
        }

        for (int k = 0; k < numberOfCourses; k++) { // Intermediate node
            for (int i = 0; i < numberOfCourses; i++) { // Start node
                for (int j = 0; j < numberOfCourses; j++) { // End node
                    // If i -> k and k -> j, then i -> j
                    isPre[i][j] = isPre[i][j] || (isPre[i][k] && isPre[k][j]);
                }
            }
        }

        for (int[] query : queries) {
            ans.add(isPre[query[0]][query[1]]);
        }
        return ans;
    }
}
