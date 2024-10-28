import java.util.*;

// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        int n = nums.length;
        int left = 0;
        int right = 1;

        int[] subSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            subSum[i + 1] = subSum[i] + nums[i];
        }

        while (left < n && right < n + 1) {
            int current = subSum[right] - subSum[left];
            if (current >= target) {
                if (answer > right - left) {
                    answer = right - left;
                }
                left++;
            } else {
                right++;
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
