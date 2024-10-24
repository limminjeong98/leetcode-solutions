import java.util.*;

// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            System.out.println(left);
            while (left < right && nums[left] != 0) {
                left++;
            }
            // left로 0인 인덱스를 찾았음
            int target = left;
            while (target < right) {
                nums[target] = nums[++target];
            }

            // 한 칸씩 땡긴 이후에 num[right]는 0으로 채운다
            if (left < right) {
                nums[right--] = 0;
            }
            
        }
    }
}
