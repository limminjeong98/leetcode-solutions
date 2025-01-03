import java.util.*;

// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(answer, new LinkedList<>(), nums, visited, nums.length, 0);
        return answer;
    }

    // 다음에 방문할 숫자를 List<Integer>로 관리하는 것보다, boolean[] 으로 방문처리하는거 더 빠름
    public void dfs(List<List<Integer>> answer, List<Integer> current, int[] nums, boolean[] visited, int n, int count) {
        if (count == n) {
            answer.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            dfs(answer, current, nums, visited, n, count + 1);
            current.removeLast();
            visited[i] = false;
        }
    }
}
