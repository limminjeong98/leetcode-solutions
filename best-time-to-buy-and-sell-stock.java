import java.util.*;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            }
            if (price - buyPrice > maxProfit) {
                maxProfit = price - buyPrice;
            }
        }
        return maxProfit;
    }
}
