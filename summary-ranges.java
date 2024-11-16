import java.util.*;

// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums.length;
        if (n == 0) return answer;
        answer.add(String.valueOf(nums[0]));
        stack.push(nums[0]);
        
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if ((long)current - stack.getLast() <= 1L) {
                // answer 마지막을 업데이트
                String start = answer.get(answer.size() - 1).split("->")[0];
                answer.set(answer.size() - 1, start + "->" + String.valueOf(current));
                stack.pop();
                stack.push(current);
            } else {
                // 전에 저장된 값과 1 이상 차이난다면
                stack.pop();
                stack.push(current);
                answer.add(String.valueOf(current));
            }
        }

        return answer;
    }
}
