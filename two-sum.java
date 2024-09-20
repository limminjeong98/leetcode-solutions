import java.util.*;

// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();

        int length = nums.length;
        for (int index = 0; index < length; index++) {
            if (numbers.containsKey(target - nums[index])) {
                return new int[] { numbers.get(target - nums[index]), index };
            } else {
                numbers.put(nums[index], index);
            }
        }

        return new int[] {0, 1};
    }
}
