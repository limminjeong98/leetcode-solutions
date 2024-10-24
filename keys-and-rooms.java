import java.util.*;

// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    public void dfs(int index, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[index]) return;
        visited[index] = true;
        for (Integer next : rooms.get(index)) {
            if (visited[next]) continue;
            dfs(next, rooms, visited);
        }
    }
}
