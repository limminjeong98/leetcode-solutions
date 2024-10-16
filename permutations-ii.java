import java.util.*;

// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums.length, nums, new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()), answer);
        return answer;
    }

    public void dfs(int n, int[] nums, List<Integer> prevElements, List<Integer> nextElements, List<List<Integer>> answer) {
        // 모든 숫자를 더 방문했다면 종료
        if (nextElements.isEmpty()) {
            answer.add(prevElements);
            return;
        }

        List<Integer> newPrev;
        List<Integer> newNext;

        int leftCount = nextElements.size();
        for (int i = 0; i < leftCount; i++) {
            Integer current = nextElements.get(i);
            // 같은 순번으로 같은 숫자를 방문하지 않기 위해서 같은 숫자들 중에서는 첫번째 위치에 있는 숫자만 방문한다.
            if (nextElements.indexOf(current) != i) continue;
            
            newPrev = new ArrayList<>(prevElements);
            newNext = new ArrayList<>(nextElements);
            
            newPrev.add(current);
            newNext.remove(current);

            dfs(n, nums, newPrev, newNext, answer);
        }

    }
}
