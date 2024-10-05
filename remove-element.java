import java.util.*;

// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int updateIndex = 0;
        int currentIndex = 0;

        int k = 0;
        while (currentIndex < size) {
            if (nums[currentIndex] != val) {
                nums[updateIndex] = nums[currentIndex];
                updateIndex++;
            } else {
                k++;
            }
            currentIndex++;
        }
        return size - k;
    }
}
