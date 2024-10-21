import java.util.*;

// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 금액을 동전으로 바꾸는 것이 불가능하다면 amount + 1 개
        // 0원은 가능하므로 0으로 두기
        Arrays.fill(dp, 1, amount + 1, amount + 1);

        for (int coin : coins) {
            for (int money = coin; money <= amount; money++) {
                dp[money] = Math.min(dp[money], dp[money - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
