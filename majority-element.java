import java.util.*;

// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int n;
        if (nums.length % 2 == 0) {
            n = nums.length / 2;
        } else {
            n = nums.length / 2 + 1;
        }

        for (int num : nums) {
            Integer i = Integer.valueOf(num);
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (count.get(i) >= n) return i.intValue();
        }
        return -1;
    }
}
