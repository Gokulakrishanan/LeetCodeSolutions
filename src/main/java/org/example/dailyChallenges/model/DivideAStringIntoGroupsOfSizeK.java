package org.example.dailyChallenges.model;

public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        /*List<String> list = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n) {
                    stringBuilder.append(s.charAt(j));
                } else {
                    stringBuilder.append(fill);
                }
            }
            list.add(stringBuilder.toString());
        }
        return list.toArray(new String[0]);*/

        StringBuilder stringBuilder = new StringBuilder(s);
        while (stringBuilder.length() % k != 0) {
            stringBuilder.append(fill);
        }

        String[] result = new String[stringBuilder.length() / k];
        for (int i = 0; i < stringBuilder.length() / k; i++) {
            result[i] = stringBuilder.substring(i * k, (i + 1) * k);
        }
        return result;
    }
}
