import java.util.*;

// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int i : nums) {
            if (visited.contains(i)) return true;
            visited.add(i);
        }
        return false;
    }
}
