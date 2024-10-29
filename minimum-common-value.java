import java.util.*;

// https://leetcode.com/problems/minimum-common-value

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] == nums2[i2]) return nums1[i1];
            else if (nums1[i1] > nums2[i2]) i2++;
            else i1++;
        }
        return -1;
    }
}
