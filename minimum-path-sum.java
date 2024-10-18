import java.util.*;

// https://leetcode.com/problems/minimum-path-sum

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // i == 0 & j == 0, 맨 위 왼쪽 칸은 업데이트할 필요 없음

        // i == 0, 첫번째 행이면 왼쪽에서 오는 값만 비교
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // j == 0, 첫번째 열이면 위에서 오는 값만 비교
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[n - 1][m - 1];
    }
}
