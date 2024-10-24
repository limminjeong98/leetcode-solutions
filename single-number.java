import java.util.*;

// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int number : nums) {
            Integer num = Integer.valueOf(number);
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }
        return numSet.stream().findFirst().get().intValue();
    }
}
