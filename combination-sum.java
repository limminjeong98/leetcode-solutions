import java.util.*;

// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Arrays.sort(candidates);
        dfs(result, 0, candidates.length, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    public void dfs(List<List<Integer>> result, int index, int size, int[] candidates, List<Integer> combination, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(combination));
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < size; i++) {
            combination.add(candidates[i]);
            dfs(result, i, size, candidates, combination, sum + candidates[i], target);
            combination.removeLast();
        }
    }
}
