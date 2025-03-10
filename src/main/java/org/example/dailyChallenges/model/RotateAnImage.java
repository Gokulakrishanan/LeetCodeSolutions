package org.example.dailyChallenges.model;

/*
Leetcode 48
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/
public class RotateAnImage {
    public void rotateMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = row; column < matrix[0].length; column++) {
                transposeSwap(matrix, row, column);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length / 2; column++) {
                flipSwap(matrix, row, column);
            }
        }
    }

    private void flipSwap(int[][] matrix, int row, int column) {
        int temp = matrix[row][column];
        matrix[row][column] = matrix[row][matrix.length - 1 - column];
        matrix[row][matrix.length - 1 - column] = temp;
    }

    private void transposeSwap(int[][] matrix, int row, int column) {
        int temp = matrix[row][column];
        matrix[row][column] = matrix[column][row];
        matrix[column][row] = temp;
    }


}
