package org.example.dailyChallenges.model;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNandItsDoubleExist {

    public boolean checkIfExist(int[] nums) {
        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums) {
            if (resultSet.contains(2 * num) || (num % 2 == 0 && resultSet.contains(num / 2))) {
                return true;
            }
            resultSet.add(num);
        }
        return false;
    }
}
