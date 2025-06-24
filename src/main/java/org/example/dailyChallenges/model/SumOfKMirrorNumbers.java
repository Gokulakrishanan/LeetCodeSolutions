package org.example.dailyChallenges.model;

public class SumOfKMirrorNumbers {
    public long kMirror(int k, int n) {
        long sum = 0;
        for (long len = 1; n > 0; len *= 10) {
            for (long i = len; n > 0 && i < len * 10; i++) {
                long p = createPalindrome(i, true);
                if (isPalindrome(p, k)) {
                    sum += p;
                    n--;
                }
            }
            for (long i = len; n > 0 && i < len * 10; i++) {
                long p = createPalindrome(i, false);
                if (isPalindrome(p, k)) {
                    sum += p;
                    n--;
                }
            }
        }
        return sum;
    }

    private long createPalindrome(long num, boolean odd) {
        long x = num;
        if (odd) {
            x /= 10;
        }
        while (x > 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num;
    }

    private boolean isPalindrome(long num, int base) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append((char) num % base + '0');
            num /= base;
        }
        String s = stringBuilder.toString();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
