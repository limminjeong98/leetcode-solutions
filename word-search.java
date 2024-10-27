import java.util.*;

// https://leetcode.com/problems/word-search

class Solution {
    int M, N;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    boolean[][] visited;
    boolean valid;
    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            if (valid) break;
            for (int j = 0; j < N; j++) {
                if (valid) break;
                visited[i][j] = true;
                dfs(visited, board, word, new StringBuilder().append(board[i][j]), i, j);
                visited[i][j] = false;
            }
        }
        
        return valid;
    }

    public void dfs(boolean[][] visited, char[][] board, String word, StringBuilder sb, int x, int y) {
        if (valid || sb.toString().equals(word)) {
            valid = true;
            return;
        }
        if (word.length() <= sb.length()) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 > nx || nx >= M || 0 > ny || ny >= N) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(visited, board, word, new StringBuilder(sb).append(board[nx][ny]), nx, ny);
            visited[nx][ny] = false;
        }
    }
}
