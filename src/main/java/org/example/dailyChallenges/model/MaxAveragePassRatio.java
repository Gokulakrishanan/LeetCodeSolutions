package org.example.dailyChallenges.model;

import java.util.PriorityQueue;

public class MaxAveragePassRatio {

    private static int compareClassesRatio(int[] c1, int[] c2){

        double pr1 =  c1[0] *1.0 /c1[1];
        double pr2 = c2[0]*1.0/c2[1];

        double npr1 = (c1[0]+1.0)/(c1[1]+1.0);
        double npr2 = (c2[0]+1.0)/(c2[1]+1.0);

        double d1 = npr1-pr1;
        double d2 = npr2-pr2;
        return Double.compare(d2,d1);
    }

    private double passRatio(int[] c){
        return c[0]*1.0/c[1];
    }
    public double maxAverageRatio(int[][] classes, int extraStudents){
        int n = classes.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(MaxAveragePassRatio :: compareClassesRatio);
        double totalPassRatio =0.0;

        for (int i = 0; i < n; i++) {
            int[] curr = classes[i];
            pq.offer(new int[]{curr[0], curr[1]});
            totalPassRatio+= passRatio(curr);
        }

        while (extraStudents>0){
            int[] bestClass = pq.poll();
            totalPassRatio-= passRatio(bestClass);
            bestClass[0]++;
            bestClass[1]++;
            totalPassRatio+= passRatio(bestClass);

            pq.offer(bestClass);
            extraStudents--;
        }
        return totalPassRatio/n;
    }
}
