// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // 마지막 집을 털지 않는 경우
        int sum1 = 0;
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        dp1[n - 1] = dp1[n - 2];

        // 마지막 집을 털 수 있는 경우 (첫번째 집을 반드시 안턴다)
        int sum2 = 0;
        int[] dp2 = new int[n];
        dp2[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
