package org.example.dailyChallenges.model;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = getDistances(edges, node1), dist2 = getDistances(edges, node2);
        int result = -1, minDistanceOfNodes = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDistanceOfNodes = Math.max(dist1[i], dist2[i]);
                if (maxDistanceOfNodes < minDistanceOfNodes) {
                    minDistanceOfNodes = maxDistanceOfNodes;
                    result = i;
                }
            }
        }
        return result;
    }

    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int d = 0;

        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }

        return dist;
    }

}
