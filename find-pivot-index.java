import java.util.*;

// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        for (int i = 0; i < length; i++) {
            if (sum[i] == sum[length] - sum[i + 1]) return i;
        }
        return -1;
    }
}
