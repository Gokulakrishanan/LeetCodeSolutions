package org.example.dailyChallenges.model;

public class FindTheLexicographicallyLargestStringFromTheBoxI {
    public String answerString(String word, int numFriends) {
        //return the word if there is only one split
        if (numFriends == 1) return word;
        //initializing the result variable
        String result = "";
        int n = word.length() - numFriends + 1;

        for (int i = 0; i < word.length(); i++) {
            String temp;
            if (i + n <= word.length()) {
                temp = word.substring(i, i + n);
            } else {
                temp = word.substring(i);
            }
            //compare to result and update to the highest length of substring
            if (temp.compareTo(result) > 0) {
                result = temp;
            }
        }
        return result;
    }
}
