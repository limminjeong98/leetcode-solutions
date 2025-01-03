// https://leetcode.com/problems/minimum-path-cost-in-a-grid

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int row = 1; row < m; row++) {
            int[] newDp = new int[n];
            for (int j = 0; j < n; j++) {
                newDp[j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    int currentValue = dp[row - 1][k] + moveCost[grid[row - 1][k]][j] + grid[row][j];
                    newDp[j] = Math.min(newDp[j], currentValue);
                }
            }
            dp[row] = newDp;
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minCost = Math.min(minCost, dp[m - 1][j]);
        }
        return minCost;
    }
}
