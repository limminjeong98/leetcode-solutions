import java.util.*;

// https://leetcode.com/problems/rotate-image

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            // 배열 참조 조심!!
            rotated[i] = matrix[i].clone();
        }

        // rotated된 배열 -> 원본 matrix
        // [i, j] -> [n - 1 - j, i]
        // [1] [0, 2] -> [0, 0]
        // [2] [1, 2] -> [0, 1]
        // [6] [2, 1] -> [1, 2]
        // [8] [1, 0] -> [2, 1]
        // [9] [2, 0] -> [2, 2]
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[n - 1 - j][i];
            }
        }
    }
}
