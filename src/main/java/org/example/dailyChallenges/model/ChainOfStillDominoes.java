package org.example.dailyChallenges.model;

public class ChainOfStillDominoes {
    public String pushDominoes(String dominoes) {
        //including left and right because one either side its gonna fall
        String s = "L" + dominoes + "R";
        //result String after the dominoes fell
        StringBuilder resultString = new StringBuilder();
        //starting element on the left pos
        int previous = 0;
        for (int current = 1; current < s.length(); ++current) {
            if (s.charAt(current) == '.') continue;
            //windowlength = right - left+1;
            int windowLength = current - previous - 1;
            if (previous > 0) {
                resultString.append(s.charAt(previous));
            }
            //checking the valid 'L' and 'R'
            if (s.charAt(previous) == s.charAt(current)) {
                for (int i = 0; i < windowLength; ++i) {
                    resultString.append(s.charAt(previous));
                }
                //if left and right are on either side just append '.'
            } else if (s.charAt(previous) == 'L' && s.charAt(current) == 'R') {
                for (int i = 0; i < windowLength; ++i) {
                    resultString.append('.');
                }
            } else {
                //adding 'R' to the right side element
                for (int i = 0; i < windowLength / 2; ++i) {
                    resultString.append('R');
                }
                //adding the mid element '.'
                if (windowLength % 2 == 1) {
                    resultString.append('.');
                }
                //adding 'L' to the left side element
                for (int i = 0; i < windowLength / 2; ++i) {
                    resultString.append('L');
                }
            }
            previous = current;
        }
        return resultString.toString();
    }


    public String pushDominoesOptimized(String dominoes) {

        char[] chars = dominoes.toCharArray();
        int left = 0, n = dominoes.length();

        while (left < n) {
            if (chars[left] != '.') {
                left++;
                continue;
            }

            int right = left;
            while (right < n && chars[right] == '.') {
                right++;
            }

            if (left - 1 >= 0 && right < n) {
                if (chars[left - 1] == chars[right]) {
                    int mid = left;
                    while (mid < right) {
                        chars[mid++] = chars[left - 1];
                    }
                } else {
                    if (chars[left - 1] == 'R') {
                        int prev = left, current = right - 1;
                        while (prev < current) {
                            chars[prev] = 'R';
                            chars[current] = 'L';
                            prev++;
                            current--;
                        }
                    }
                }
            } else if (left - 1 >= 0) {
                if (chars[left - 1] == 'R') {
                    int mid = left;
                    while (mid < right) {
                        chars[mid++] = 'R';
                    }
                }
            } else if (right < n) {
                if (chars[right] == 'L') {
                    int mid = left;
                    while (mid < right) {
                        chars[mid++] = 'L';
                    }
                }
            }
            left = right;
        }
        return String.valueOf(chars);
    }
}
