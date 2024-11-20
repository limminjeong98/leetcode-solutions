import java.util.*;

// https://leetcode.com/problems/set-mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        Set<Integer> visited = new HashSet<>();
        Set<Integer> numbers = IntStream.range(1, n + 1).boxed().collect(Collectors.toSet());

        int duplicatedValue = -1;
        int lostValue = -1;

        for (int i = 0; i < n; i++) {
            if (visited.contains(nums[i])) {
                duplicatedValue = nums[i];
                numbers.remove(nums[i]);
            } else {
                visited.add(nums[i]);
                numbers.remove(nums[i]);
            }
        }
        
        lostValue = numbers.stream().toList().get(0);
        return new int[] { duplicatedValue, lostValue };
    }
}
