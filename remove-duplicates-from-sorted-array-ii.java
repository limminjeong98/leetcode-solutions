import java.util.*;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;

        int k = 2;

        int first;
        int second;

        for (int i = 2; i < length; i++) {
            first = nums[k - 2];
            second = nums[k - 1];
            if (first != second) {
                nums[k] = nums[i];
                k++;
            } else if (second != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
