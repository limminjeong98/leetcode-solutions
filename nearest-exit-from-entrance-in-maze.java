import java.util.*;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

class Solution {
    // 동, 서, 남, 북
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        // 현재까지 움직인 거리, x좌표, y좌효
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        queue.offer(new int[] { 0, entrance[0], entrance[1] });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // 동, 서, 남, 북 중 한 방향이라도 출구로 뚫려 있다면 리턴
            if (current[1] == 0 || current[1] == m - 1 || current[2] == 0 || current[2] == n - 1) {
                // 출발한 장소가 아니라면
                if (!(current[1] == entrance[0] && current[2] == entrance[1])) {
                    return current[0];
                }
            }
            // 방문한 장소라면 패스
            if (maze[current[1]][current[2]] == '+') continue;
            // 방문 처리
            maze[current[1]][current[2]] = '+';
            for (int i = 0; i < 4; i++) {
                int nx = current[1] + dx[i];
                int ny = current[2] + dy[i];
                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                // 벽이거나, 이미 방문한 곳이라면 더 이상 않는다.
                if (maze[nx][ny] == '+') continue;
                queue.offer(new int[] { current[0] + 1, nx, ny });
            }
        }
        return -1;
    }
}
