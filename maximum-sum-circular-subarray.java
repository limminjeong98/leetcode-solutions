import java.util.*;

// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMax = 0;
        int curMin = 0;

        int totalSum = 0;

        for (int num : nums) {
            // 일반적인 카데인 알고리즘으로 최대 부분합 구함
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            // 카데인 알고리즘으로 최소 부분합 구함
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            totalSum += num;
        }
        // 만약 모든 원소가 -밖에 없어서 maxSum이 0보다 작다면 그대로 maxSum을 리턴
        return maxSum >= 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
