import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum

class Solution {
  
    public int[] maxSlidingWindow(int[] nums, int k) {
      
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // 슬라이딩 윈도우에 들어있는 인덱스를 저장
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 슬라이딩 윈도우 크기를 넘을 경우 먼저 저장된 인덱스부터 삭제
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // 슬라이딩 윈도우에 새로 들어갈 값이 더 큰 값이라면 이전에 저장했던 값들은 모두 제거
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 현재 인덱스 저장
            dq.add(i);

            // 슬라이딩 윈도우마다 최대값을 저장
            // 데크의 첫번째 값은 가장 큰 값임
            if (i >= k - 1) {
                result.add(nums[dq.peek()]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
