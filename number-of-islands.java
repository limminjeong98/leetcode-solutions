import java.util.*;

// https://leetcode.com/problems/number-of-islands

class Solution {
    public static int m, n;
    public static char[][] map;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        map = grid;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || map[i][j] == '0') return;
        map[i][j] = '0';
        dfs(i, j + 1);
        dfs(i, j - 1);
        dfs(i - 1, j);
        dfs(i + 1, j);
    }
}
