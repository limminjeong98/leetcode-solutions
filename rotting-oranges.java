import java.util.*;

// https://leetcode.com/problems/rotting-oranges

class Solution {
    int[] dx = new int[] { 0, 0, 1, -1 };
    int[] dy = new int[] { 1, -1, 0, 0 };
    public int orangesRotting(int[][] grid) {
        // 최소 시간 같은 경우는 항상 BFS 탐색으로 우선순위큐를 써야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new int[] { 0, i, j } );
                    grid[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    // 각 위치마다 소요된 시간을 저장하기 위해 값을 바꿔서 저장
                    grid[i][j] = -1;
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] position = pq.poll();
            int x = position[1];
            int y = position[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] == -1) {
                    pq.offer(new int[] { grid[x][y] + 1, nx, ny });
                    grid[nx][ny] = grid[x][y] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) return -1;
                answer = Math.max(answer, grid[i][j]);
            }
        }
        return answer;
    }
}
