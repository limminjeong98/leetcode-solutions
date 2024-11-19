import java.util.*;

// https://leetcode.com/problems/range-sum-query-immutable

class NumArray {

    public int[] sumArray;

    public NumArray(int[] nums) {
        int n = nums.length;
        sumArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return sumArray[right + 1] - sumArray[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
