import java.util.*;

// https://leetcode.com/problems/subsets

class Solution {

    public static List<List<Integer>> answer;
    public static int n;
    public static List<Integer> arr;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        n = nums.length;

        arr = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(new ArrayList<>(), 0);
        return answer;
    }

    public void dfs(List<Integer> subList, int index) {
        if (index > n) return;

        answer.add(new ArrayList<>(subList));

        for (int i = index; i < n; i++) {
            subList.add(arr.get(i));
            dfs(subList, i + 1);
            subList.removeLast();
        }
    }
}
