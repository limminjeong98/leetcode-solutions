import java.util.*;

// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        // 피벗 찾기
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 분리되는 인덱스
        int pivot = left;

        left = 0;
        right = nums.length - 1;
        int midPivot;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) left = mid + 1;
            else if (nums[midPivot] > target) right = mid - 1;
            else return midPivot;
        }
        return -1;
    }
}
