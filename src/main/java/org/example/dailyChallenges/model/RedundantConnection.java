package org.example.dailyChallenges.model;

/*In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example 1:----------
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:----------
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.*/
public class RedundantConnection {

    //create a 1-D parentArray  to store all the node parent
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        //initializing the size of the parent array;
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            //populating the parent array;
            parent[i] = i;
        }
        //traversing through every edge in the given edges
        for (int[] edge : edges) {
            if (findParent(edge[0]) == findParent(edge[1])) {

                //edge to be deleted from the given set of edges;
                return edge;
            } else {
                unionSet(edge[0], edge[1]);
            }
        }
        return edges[0];
    }


    //finding the parent node
    private int findParent(int childNode) {
        /*lets say node is 1 and the starting node is also 1 then the parent node is 1
        and 2 is connected to 1 so parent node of 2 is 1 and 3 is connected to 2.
        So the parent node will be 1 and it makes it as a cycle;
         */
        if (childNode != parent[childNode]) {
            parent[childNode] = findParent(parent[childNode]);
        }
        return parent[childNode];
    }


    private void unionSet(int parentNode, int childNode) {
        parent[findParent(childNode)] = findParent(parentNode);
    }
}
