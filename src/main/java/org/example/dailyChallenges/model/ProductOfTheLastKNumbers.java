package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

    List<Integer> list;
    int previousNumber;

    public ProductOfTheLastKNumbers() {
        this.list = new ArrayList<>();
        list.add(1);
        previousNumber = 1;
    }

    public void add(int num) {
        if (num > 0) {
            previousNumber *= num;
            list.add(previousNumber);
        } else {
            list = new ArrayList<>();
            list.add(1);
            previousNumber = 1;
        }
    }

    public int getProduct(int k) {
        int n = list.size();

        return (k < n) ? previousNumber / list.get(n - 1 - k) : 0;
    }
}
