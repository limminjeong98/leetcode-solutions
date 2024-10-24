import java.util.*;

// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int subTotal = 0;
        
        for (int i = 0; i < k; i++) {
            subTotal += nums[i];
        }
        int answer = subTotal;

        for (int i = k; i < n; i++) {
            subTotal += nums[i] - nums[i - k];
            answer = Math.max(answer, subTotal);
        }
        return (double)answer / k;
    }
}
