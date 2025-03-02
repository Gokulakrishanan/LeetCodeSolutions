package org.example.dailyChallenges.model;

public class SmallestSubtreeWithAllTheDeepestNodes {

    int maxDepth = Integer.MIN_VALUE;
    TreeNode result = null;

    public TreeNode subtreeWithAllDeepest(TreeNode node) {
        postOrder(node, 0);
        return result;
    }

    public int postOrder(TreeNode node, int depth) {
        if (node == null) return depth;

        int leftNode = postOrder(node.left, depth + 1);
        int rightNode = postOrder(node.right, depth + 1);
        int currentDepth = Math.max(leftNode, rightNode);
        maxDepth = Math.max(currentDepth, maxDepth);

        if (leftNode == maxDepth && rightNode == maxDepth) {
            result = node;
        }
        return currentDepth;
    }
}
