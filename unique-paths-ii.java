import java.util.*;

// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 첫번째 칸에 장애물이 있거나, 마지막 칸에 장애물이 있다면
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        obstacleGrid[0][0] = 1;

        // 장애물을 만나면 더 이상 해당 방향으로 진행할 수 없다
        boolean isPossible = true;
        for (int i = 1; i < n; i++) {
            if (isPossible == false || obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = -1;
                isPossible = false;
            } else if (isPossible) {
                obstacleGrid[0][i] = 1;
            }
        }

        isPossible = true;
        for (int i = 1; i < m; i++) {
            if (isPossible == false || obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = -1;
                isPossible = false;
            } else if (isPossible) {
                obstacleGrid[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 첫번째 행이나 첫번째 열이 아닌 내부에서 해당 칸에 장애물이 있다면
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if (obstacleGrid[i][j - 1] > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                } 
                if (obstacleGrid[i - 1][j] > 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
            }
        }
        
        return obstacleGrid[m - 1][n - 1];
    }
}
