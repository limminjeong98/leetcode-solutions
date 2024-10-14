import java.util.*;

// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = nums.length;

        for (int i = 0 ; i < length; i++) {
            Integer index = Integer.valueOf(i);
            Integer num = nums[i];
            if (indexMap.containsKey(num)) {
                Integer prev = indexMap.get(num);
                if (i - prev <= k) return true;
                indexMap.put(num, index);
            } else {
                indexMap.put(num, index);
            }
        }

        return false;
    }
}
