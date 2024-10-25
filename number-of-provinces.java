import java.util.*;

// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(isConnected, visited, n, i);
            answer++;
        }
        return answer;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int n, int x) {
        for (int y = 0; y < n; y++) {
            if (x == y || visited[y]) continue;
            if (isConnected[x][y] == 1) {
                // 방문 처리
                visited[y] = true;
                dfs(isConnected, visited, n, y);
            } 
        }
    }
}
