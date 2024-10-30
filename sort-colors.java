import java.util.*;

// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] < 1) {
                int tmp = nums[red];
                nums[red] = nums[white];
                nums[white] = tmp;
                red++;
                white++;
            } else if (nums[white] > 1) {
                int tmp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = tmp;
                blue--;
            } else {
                white++;
            }
        }
    }
}
