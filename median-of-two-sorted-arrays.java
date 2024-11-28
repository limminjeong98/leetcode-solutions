import java.util.*;

// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int mergedLength = l1 + l2;
        int[] arr = new int[mergedLength];
        int index = 0;

        int i1 = 0;
        int i2 = 0;
        while (index < mergedLength) {
            if (i1 == l1 || (i2 < l2 && nums2[i2] < nums1[i1])) {
                arr[index++] = nums2[i2++];
            } else {
                arr[index++] = nums1[i1++];
            }
        }
        
        if (mergedLength % 2 == 1) return (double) arr[mergedLength / 2];
        return ((double) arr[mergedLength / 2 - 1] + arr[mergedLength / 2])/ 2;
    }
}
