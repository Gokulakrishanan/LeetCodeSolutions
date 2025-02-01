package org.example.dailyChallenges.model;

/*
 * Leetcode 2493
 * Desc:
 *You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.
Divide the nodes of the graph into m groups (1-indexed) such that:
Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.
Example 1:
Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
Output: 4
Explanation: As shown in the image we:
- Add node 5 to the first group.
- Add node 1 to the second group.
- Add nodes 2 and 4 to the third group.
- Add nodes 3 and 6 to the fourth group.
We can see that every edge is satisfied.
It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
Example 2:
Input: n = 3, edges = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
It can be shown that no grouping is possible.
Constraints:
1 <= n <= 500
1 <= edges.length <= 104
edges[i].length == 2
1 <= ai, bi <= n
ai != bi
There is at most one edge between any pair of vertices.

 * Personal Notes:
 Number of nodes = n
Starting node = 1
ending node = n
edges[][] are "bidirectional" meaning it can traverse front and back or side to side
"it may be disconnected" meaning connected components may be found

each node belongs to ONLY ONE GROUP
1 -> {2,4,5}
2 -> {1,3,6}
3 -> {2}
4 -> {1,6}
5 -> {1}
6 -> {2,4}
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideNodesIntoTheMaximumNumberOfGroups {
    public int magnificentSets(int n, int[][] edges) {
        // Populate the adjacency list
        n++;
        List<List<Integer>> adjacentNodes = populateAdjacentNodes(n, edges);
        if (!isBipartite(adjacentNodes, n)) return -1;

        int[] degreeBFS = new int[n];
        for (int i = 1; i < n; i++) { // Fix indexing (start from 1)
            degreeBFS[i] = bfsDegree(adjacentNodes, i);
        }

        int[] visitedNode = new int[n];
        int groupId = 0;
        for (int i = 1; i < n; i++) { // Fix indexing (start from 1)
            if (visitedNode[i] == 0) {
                groupId += dfs(adjacentNodes, visitedNode, degreeBFS, i);
            }
        }

        return groupId;
    }

    private int bfsDegree(List<List<Integer>> adjacentNodes, int node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, 1});
        int[] visitedNode = new int[adjacentNodes.size()];
        visitedNode[node] = 1;
        int[] currentElement = new int[2];
        while (!queue.isEmpty()) {
            currentElement = queue.poll();
            for (int adj : adjacentNodes.get(currentElement[0])) {
                if (visitedNode[adj] == 0) {
                    visitedNode[adj] = 1;
                    queue.offer(new int[]{adj, currentElement[1] + 1});
                }
            }
        }
        return currentElement[1];
    }

    private boolean isBipartite(List<List<Integer>> adjacentNodes, int nodes) {
        int[] regionId = new int[nodes];
        for (int i = 1; i < nodes; i++) { // Fix indexing (start from 1)
            if (regionId[i] == 0 && !bfsBipartite(adjacentNodes, regionId, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfsBipartite(List<List<Integer>> adjacentNodes, int[] regionId, int vertex) {
        regionId[vertex] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int regionValue = regionId[current] == 1 ? 2 : 1;
            for (Integer neighbor : adjacentNodes.get(current)) {
                if (regionId[neighbor] == 0) {
                    regionId[neighbor] = regionValue;
                    queue.offer(neighbor);
                } else if (regionId[neighbor] != regionValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<List<Integer>> populateAdjacentNodes(int n, int[][] edges) {
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

    public int dfs(List<List<Integer>> adjacentNodes, int[] vis, int[] deg, int vertex) {
        vis[vertex] = 1;
        int componentMax = deg[vertex];
        for (Integer neighbor : adjacentNodes.get(vertex)) {
            if (vis[neighbor] == 0) {
                componentMax = Math.max(componentMax, dfs(adjacentNodes, vis, deg, neighbor));
            }
        }
        return componentMax;
    }
}
