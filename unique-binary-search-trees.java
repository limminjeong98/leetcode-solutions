import java.util.*;

// https://leetcode.com/problems/unique-binary-search-trees
// https://www.youtube.com/watch?v=OIc0mHgHUww

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
