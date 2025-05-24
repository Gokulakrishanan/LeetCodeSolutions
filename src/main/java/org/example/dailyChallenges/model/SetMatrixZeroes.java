package org.example.dailyChallenges.model;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //concept if matrix[row][column] ==0 then make their previous element and after element both horizontally and vertically zero
        int rowLength = matrix.length, columnLength = matrix[0].length;
        boolean zeroColFirst = false;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                zeroColFirst = true;
            }
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = rowLength - 1; i >= 0; i--) {
            for (int j = columnLength - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (zeroColFirst) {
                matrix[i][0] = 0;
            }
        }


    }
}
