package org.example.dailyChallenges.model;

public class CircularSentence {
    public boolean solve(String s) {
        String[] split = s.split(" ");
        System.out.println(1 % split.length);
        for (int i = 0; i < split.length; i++) {
            if (split[i].charAt(split[i].length() - 1) != split[(i + 1) % split.length].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
