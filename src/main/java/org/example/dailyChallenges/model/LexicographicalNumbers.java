package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        //int currentNumber = 1;
        for (int i = 1; i <= n; i++) {
            /*list.add(currentNumber);
            if (currentNumber * 10 <= n) {
                currentNumber = currentNumber * 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber = currentNumber / 10;
                }
                currentNumber += 1;
            }*/
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int currentNumber, int givenNumber, List<Integer> result) {
        if (currentNumber > givenNumber) return;
        result.add(currentNumber);
        for (int i = 0; i <= 9; i++) {
            int nextNumber = currentNumber * 10 + i;
            if (nextNumber > givenNumber) return;
            dfs(nextNumber, givenNumber, result);
        }
    }
}
