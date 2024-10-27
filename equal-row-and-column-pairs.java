import java.util.*;

// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int answer = 0;
        int[][] column = new int[n][n];
        // 3 1 2 / 2 7 7 / 1 6 7
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                column[i][j] = grid[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                // column과 일치하는 것이 있다면
                int[] col = column[j];
                if (Arrays.equals(row, col)) answer++;
            }
        }
        return answer;
    }
}
