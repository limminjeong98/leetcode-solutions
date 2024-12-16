import java.util.*;

// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            if (countMap.containsKey(i)) {
                Integer value = countMap.get(i);
                if (value == 2) {
                    countMap.remove(i);
                } else {
                    countMap.put(i, value + 1);
                }
            } else {
                countMap.put(i, 1);
            }
        }
        return countMap.keySet().stream().collect(Collectors.toList()).get(0);
        // return 0;
    }
}
