import java.util.*;

// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(k, n, 0, 0, 1, answer, new ArrayList<>());
        return answer;
    }

    public void dfs(int k, int n, int subTotal, int count, int idx, List<List<Integer>> answer, List<Integer> subArray) {
        if (count == k) {
            if (subTotal == n) {
                answer.add(subArray);
            }
            return;
        }
        if (subTotal >= n) return;
        
        for (int i = idx; i <= 9; i++) {
            if (subArray.contains(i)) continue;
            List<Integer> newArray = new ArrayList(subArray);
            newArray.add(i);
            dfs(k, n, subTotal + i, count + 1, i + 1, answer, newArray);
        }
    }
}
