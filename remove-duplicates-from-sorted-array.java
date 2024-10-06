import java.util.*;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array


class Solution {
    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        int k = 0;

        int previousValue;
        int currentValue;

        for (int i = 1; i < length; i++) {
            previousValue = nums[k];
            currentValue = nums[i];
            if (previousValue != currentValue) {
                k++;
                nums[k] = nums[i];
            }
        }
        return ++k;
    }
}
