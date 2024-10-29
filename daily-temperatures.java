import java.util.*;

// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 이전에 방문했던 인덱스들의 값을 업데이트할 수 있는 경우 (현재 온도가 이전보다 높은 경우 스택에서 pop)
                int index = stack.pop();
                answer[index] = i - index;
            }
            // 현재 인덱스 삽입
            stack.push(i);
        }

        return answer;
    }
}
