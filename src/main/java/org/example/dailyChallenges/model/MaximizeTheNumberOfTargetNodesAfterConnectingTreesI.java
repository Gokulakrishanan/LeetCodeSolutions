package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = populateAdjList(edges1);
        List<List<Integer>> adj2 = populateAdjList(edges2);

        int n = adj1.size(), m = adj2.size(), maxB = 0;

        for (int i = 0; i < m; i++) {
            maxB = Math.max(maxB, dfs(adj2, i, -1, k - 1));
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(adj1, i, -1, k) + maxB;
        }
        return res;
    }

    public List<List<Integer>> populateAdjList(int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;

    }

    public int dfs(List<List<Integer>> adj, int u, int p, int k) {
        if (k < 0) {
            return 0;
        }

        int count = 1;

        for (int v : adj.get(u)) {
            if (v != p) {
                count += dfs(adj, v, u, k - 1);
            }
        }
        return count;
    }


}
