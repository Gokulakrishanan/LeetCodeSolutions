package org.example.dailyChallenges.model;

public class StringCompressionIII {
    public String solve(String input) {
        StringBuilder comp = new StringBuilder();
        //int i = 0;
        for (int i = 0; i < input.length(); ) {
            char current = input.charAt(i);
            int count = 0;
            while (i < input.length() && input.charAt(i) == current && count < 9) {
                count++;
                i++;
            }
            comp.append(count).append(current);
        }
        return comp.toString();
    }
}
