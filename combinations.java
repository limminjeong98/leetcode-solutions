import java.util.*;

// https://leetcode.com/problems/combinations

class Solution {

    public static List<List<Integer>> answer;
    public static int N, K;

    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        N = n;
        K = k;

        dfs(new ArrayList<Integer>(), 1, 0);
        return answer;
    }

    public void dfs(List<Integer> arr, int index, int count) {
        if (count == K) {
            answer.add(new ArrayList<>(arr));
            return;
        }

        for (int i = index; i <= N; i++) {
            List<Integer> newArr = new ArrayList<>(arr);
            newArr.add(i);
            dfs(newArr, i + 1, count + 1);
            newArr.removeLast();
        }
    }
}
