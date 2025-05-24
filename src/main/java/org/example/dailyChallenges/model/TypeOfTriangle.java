package org.example.dailyChallenges.model;

public class TypeOfTriangle {
    public String typeOfTriangle(int[] nums) {

        int a = nums[0], b = nums[1], c = nums[2];

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }

    }
}
