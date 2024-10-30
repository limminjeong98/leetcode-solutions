import java.util.*;

// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                answer += leftMax - height[left];
                left++;
            } else {
                answer += rightMax - height[right];
                right--;
            }
        }
        return answer;
    }
}
