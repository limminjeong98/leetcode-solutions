import java.util.*;

// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new LinkedList<>(), nums, 0, nums.length);
        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> current, int[] nums, int position, int n) {
        answer.add(new ArrayList<>(current));

        for (int i = position; i < n; i++) {
            Integer num = nums[i];
            // 같은 위치에서 같은 값을 방문하지 않음
            if (i > position && nums[i - 1] == nums[i]) continue;
            current.add(num);
            dfs(answer, current, nums, i + 1, n);
            current.removeLast();
        }
    }
}
