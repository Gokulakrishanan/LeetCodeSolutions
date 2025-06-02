package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeTheNumberIOfTargetNodesAfterConnectingTreesII {
    int evenA, evenB, oddA, oddB;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adjA = populateTheTree(edges1), adjB = populateTheTree(edges2);
        int n = adjA.size(), m = adjB.size();
        int[] colorA = new int[n], colorB = new int[m];
        Arrays.fill(colorA, -1);
        Arrays.fill(colorB, -1);
        evenA = evenB = oddA = oddB = 0;
        colorA[0] = 0;
        dfsColor(adjA, 0, -1, colorA, true);
        colorB[0] = 0;
        dfsColor(adjB, 0, -1, colorB, false);

        int maxB = Math.max(oddB, evenB);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (colorA[i] == 0 ? evenA : oddA) + maxB;
        }
        return result;
    }

    private List<List<Integer>> populateTheTree(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return list;
    }

    private void dfsColor(List<List<Integer>> adj, int u, int parent, int[] color, boolean isA) {
        if (color[u] == 0) {
            if (isA) {
                evenA++;
            } else {
                evenB++;
            }
        } else {
            if (isA) {
                oddA++;
            } else {
                oddB++;
            }
        }

        for (int vertex : adj.get(u)) {
            if (vertex != parent) {
                color[vertex] = color[u] ^ 1;
                dfsColor(adj, vertex, u, color, isA);
            }
        }
    }
}
