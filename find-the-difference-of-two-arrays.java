import java.util.*;

// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet(Arrays.stream(nums1).boxed().toList());
        Set<Integer> set2 = new HashSet(Arrays.stream(nums2).boxed().toList());

        return List.of(
            set1.stream().filter(i -> !set2.contains(i)).collect(Collectors.toList()), 
            set2.stream().filter(i -> !set1.contains(i)).collect(Collectors.toList()) 
        );
    }
}
