import java.util.*;

// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int answer = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int closestDiff = Integer.MAX_VALUE;
        
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                diff = Math.abs(sum - target);
                
                if (diff < closestDiff) {
                    closestDiff = diff;
                    answer = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return answer;
    }
}
