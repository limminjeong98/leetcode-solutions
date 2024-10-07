import java.util.*;

// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        // 부분 최적해의 합이 전체의 최적해가 되므로 Dynamic Programming 문제임
        int n = nums.length;
        int[] dp = IntStream.range(0, n).toArray();
        int position;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                position = i + j;
                position = Math.min(position, n - 1);
                dp[position] = Math.min(dp[position], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}
