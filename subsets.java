import java.util.*;

// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new LinkedList<>(), nums, 0, nums.length);
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> subset, int[] nums, int idx, int n) {
        answer.add(new ArrayList<>(subset));
        for (int i = idx; i < n; i++) {
            subset.add(nums[i]);
            dfs(answer, subset, nums, i + 1, n);
            subset.removeLast();
        }
    }
}
