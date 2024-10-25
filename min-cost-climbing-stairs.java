import java.util.*;

// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // index 0에서 시작하는 경우
        int[] dp1 = new int[n];
        dp1[0] = cost[0];
        dp1[1] = cost[0] + cost[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.min(dp1[i - 2], dp1[i - 1]) + cost[i];
        }

        // index 1에서 시작하는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = cost[1];
        if (n > 2) {
            dp2[2] = cost[1] + cost[2];
        } else {
            dp2[0] = Integer.MAX_VALUE;
        }
        for (int i = 3; i < n; i++) {
            dp2[i] = Math.min(dp2[i - 2], dp2[i - 1]) + cost[i];
        }

        return Math.min(Math.min(dp1[n - 2], dp1[n - 1]), Math.min(dp2[n - 2], dp2[n - 1]));
    }
}
