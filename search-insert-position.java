import java.util.*;

// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) return index;
            index++;
        }
        return index;
    }
}
