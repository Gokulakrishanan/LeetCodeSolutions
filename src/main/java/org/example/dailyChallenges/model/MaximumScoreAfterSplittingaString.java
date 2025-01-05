package org.example.dailyChallenges.model;

public class MaximumScoreAfterSplittingaString {
    public int maxScore(String s){

        int totalOnes =0, zerosCount=0,onesCount=0,bestScore = -1, n = s.length()-1;
        for (char ch : s.toCharArray()) {
            if (ch=='1'){ totalOnes++;}
        }

        for (int i = 0; i <n ; i++) {
            if (s.charAt(i)=='0') {zerosCount++;}
            else{
                onesCount++;
            }
            int currentScore = zerosCount + (totalOnes - onesCount);
            bestScore = Math.max(bestScore,currentScore);
        }
        return bestScore;
    }
}
