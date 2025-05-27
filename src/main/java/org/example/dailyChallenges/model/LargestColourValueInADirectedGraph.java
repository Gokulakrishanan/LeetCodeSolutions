package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class LargestColourValueInADirectedGraph {
    private static final int INF = Integer.MAX_VALUE;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        //create the adj list
        List<List<Integer>> adj = new ArrayList<>();
        //populating the adj list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[][] count = new int[n][26];
        int[] vis = new int[n];
        int ans = 0;

        for (int node = 0; node < n && ans != INF; node++) {
            ans = Math.max(ans, dfs(node, colors, adj, count, vis));
        }

        return ans == INF ? -1 : ans;
    }

    private int dfs(int node, String colors, List<List<Integer>> adj, int[][] count, int[] vis) {
        if (vis[node] == 1) {
            return INF;
        }
        if (vis[node] == 2) {
            return count[node][colors.charAt(node) - 'a'];
        }


        vis[node] = 1;

        for (int nextNode : adj.get(node)) {
            int result = dfs(nextNode, colors, adj, count, vis);
            if (result == INF) {
                return INF;
            }
            for (int ch = 0; ch < 26; ch++) {
                count[node][ch] = Math.max(count[node][ch], count[nextNode][ch]);
            }
        }

        int character = colors.charAt(node) - 'a';
        count[node][character]++;
        vis[node] = 2;
        return count[node][character];
    }
}
