import java.util.*;

// https://leetcode.com/problems/combination-sum-ii

class Solution {

    Set<List<Integer>> answer;
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new HashSet<>();
        n = candidates.length;
        Arrays.sort(candidates);
    
        dfs(target, 0, 0, new ArrayList<>(), candidates);
        return answer.stream().collect(Collectors.toList());
    }

    public void dfs(int target, int total, int index, List<Integer> combination, int[] candidates) {
        if (target == total) {
            answer.add(new ArrayList<>(combination));
            return;
        }
        if (target < total) return;
        for (int i = index; i < n; i++) {
            if (total + candidates[i] > target) continue;
            // i > 0 && i > index
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> comb = new ArrayList<>(combination);
            comb.add(candidates[i]);
            dfs(target, total + candidates[i], i + 1, comb, candidates);
        }
    }
}
