import java.util.*;

// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> next = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(answer, new ArrayList<>(), next);
        return answer.stream().collect(Collectors.toList());
    }

    public void dfs(Set<List<Integer>> answer, List<Integer> current, List<Integer> next) {
        Collections.sort(current);
        if (answer.contains(current)) return; 
        answer.add(new ArrayList<>(current));
        if (next.isEmpty()) return;

        for (Integer i : next) {
            current.add(i);
            List<Integer> newNext = new ArrayList<>(next);
            newNext.remove(i);
            dfs(answer, current, newNext);
            current.remove(i);
        }
    }
}
