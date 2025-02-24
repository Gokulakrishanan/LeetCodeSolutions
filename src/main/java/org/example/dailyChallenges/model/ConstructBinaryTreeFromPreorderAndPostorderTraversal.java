package org.example.dailyChallenges.model;
/*Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree,
reconstruct and return the binary tree.
If there exist multiple answers, you can return any of them.
Example 1:
Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:
Input: preorder = [1], postorder = [1]
Output: [1]
Constraints:
1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.*/

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructBinaryTree(int[] preorder, int[] postorder) {
        int[] index = new int[]{0};
        return construct(preorder, postorder, index, 0, preorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int[] index, int level, int height) {
        if (index[0] > preorder.length || level > height) return null;

        TreeNode root = new TreeNode(index[0]++);

        if (level == height) {
            return root;
        }

        int i;
        for (i = level; i <= height; i++) {
            if (postorder[i] == preorder[index[0]])
                break;
        }
        if (level <= height) {
            root.left = construct(preorder, postorder, index, level, i);
            root.left = construct(preorder, postorder, index, i + 1, height + 1);
        }

        return root;
    }
}


