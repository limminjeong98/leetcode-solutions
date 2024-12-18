import java.util.*;

// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) continue;
                queue.add(new int[] {i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            int row = x;
            int column = y;
            // 행
            row--;
            while (row >= 0) {
                matrix[row][column] = 0;
                row--;
            }
            row = x;
            row++;
            while (row < m) {
                matrix[row][column] = 0;
                row++;
            }

            // 열
            row = x;
            column--;
            while (column >= 0) {
                matrix[row][column] = 0;
                column--;
            }
            column = y;
            column++;
            while (column < n) {
                matrix[row][column] = 0;
                column++;
            }
        }

        
    }
}
