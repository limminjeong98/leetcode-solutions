import java.util.*;

// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int money = 1; money <= amount; money++) {
            for (int coin : coins) {
                if (money >= coin && dp[money - coin] != Integer.MAX_VALUE) {
                    dp[money] = Math.min(dp[money], dp[money - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
