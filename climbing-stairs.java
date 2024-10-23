import java.util.*;

// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1; else if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2; // 1 + 1, 2
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
