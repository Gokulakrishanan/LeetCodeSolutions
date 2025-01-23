package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumns {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, columns = mat[0].length;

        //hashing the values and their location in the matrix
        Map<Integer, int[]> map = new HashMap<>();
        //traversing the rows
        for (int i = 0; i < rows; i++) {
            //traversing the columns
            for (int j = 0; j < columns; j++) {
                //storing the key(mat[i][j]) and their values(new int[] {i,j}) in the map
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        //tracking the value of paintedRows and paintedColumns
        int[] paintedRows = new int[rows];
        int[] paintedColumns = new int[columns];

        //traversing the given arr and their elements and trying to find the first completed row or column
        for (int i = 0; i < arr.length; i++) {
            //identifying the location of the elements in the map
            int[] location = map.get(arr[i]);

            //incrementing the values of painted rows and columns
            paintedRows[location[0]]++;
            paintedColumns[location[1]]++;
            //condition check (either row or column in completely painted)
            if (paintedRows[location[0]] == rows || paintedColumns[location[1]] == columns) {
                //return the index of the element in the given arr
                return i;
            }
        }
        return -1;
    }
}
