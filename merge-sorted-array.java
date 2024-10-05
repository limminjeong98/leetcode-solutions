import java.util.*;

// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 깊은 복사
        int[] tmp1 = nums1.clone();
        int size = nums1.length;
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (count < size) {
            if (index1 == m) {
                nums1[count] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                nums1[count] = tmp1[index1];
                index1++;
            } else if (nums2[index2] <= tmp1[index1]) {
                nums1[count] = nums2[index2];
                index2++;
            } else {
                nums1[count] = tmp1[index1];
                index1++;
            }
            count++;
        }
    }
}
