package org.example.dailyChallenges.model;

public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        int maxVal = num, minVal = num;
        String numStr = String.valueOf(num);
        /*Set<Character> set = new HashSet<>();
        for (char o : numStr.toCharArray()) {
            set.add(o);
        }
        for (Character ch : set) {
            for (char newDigit = '0'; newDigit <= '9'; newDigit++) {
                if (numStr.charAt(0) == ch && newDigit == '0') continue;
                String replaced = numStr.replace(ch, newDigit);
                int newNum = Integer.parseInt(replaced);
                maxVal = Math.max(maxVal, newNum);
                minVal = Math.min(minVal, newNum);
            }
        }*/

        char firstChar = numStr.charAt(0);
        for (char c : numStr.toCharArray()) {
            String maxString = numStr.replace(c, '9');
            String minString = numStr.replace(c, '0');
            if (c == firstChar) {
                minString = numStr.replace(c, '1');
            }
            int replacedMax = Integer.parseInt(maxString);
            int replacedMin = Integer.parseInt(minString);
            maxVal = Math.max(replacedMax, maxVal);
            if (replacedMin != 0) {
                minVal = Math.min(minVal, replacedMin);
            }
        }

        return maxVal - minVal;
    }
}
