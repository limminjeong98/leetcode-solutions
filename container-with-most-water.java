import java.util.*;

// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int answer = 0;
        int current = 0;

        while (left < right) {
            // 현재 위치에서 담을 수 있는 최대값
            current = Math.min(height[left], height[right]) * (right - left);
            if (current > answer) {
                answer = current;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
