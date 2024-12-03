package org.example.dailyChallenges.model;

public class RotateAString {
    public boolean solve(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (stringBuilder.toString().equals(goal)) {
                return true;
            }
            char result = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(result);
        }
        return false;

    }
}
