import java.util.*;

// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;

        int rightMostPeak = 0;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                rightMostPeak = i;
                break;
            }
        }
        // get left index of the rightmost peak
        int pivot = rightMostPeak - 1;

        if (pivot != -1) {
            int rightMostSuccessor = rightMostPeak;
            for (int i = length - 1; i >= 0; i--) {
                if (nums[i] > nums[pivot]) {
                    rightMostSuccessor = i;
                    break;
                }
            }
            swap(pivot, rightMostSuccessor, nums);
        } 
        
        int start = rightMostPeak;
        int end = length - 1;
        while (start < end) {
            swap(start++, end--, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
