import java.util.*;

// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        int[] tmp = nums.clone();
        int length = nums.length;
        if (length == 1) return;
        k %= length;
        if (k == 0) return;

        int index = 0;
        for (int i = length - k; i < length; i++) {
            nums[index] = tmp[i];
            index++;
        }
        for (int i = 0; i < length - k; i++) {
            nums[index] = tmp[i];
            index++;
        }
    }
}
