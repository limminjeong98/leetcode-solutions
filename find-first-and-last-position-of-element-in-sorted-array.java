import java.util.*;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = -1;
        int lastPosition = -1;

        firstPosition = findFirstPositionByBinarySearch(nums, target);
        if (firstPosition == -1) return new int[] { firstPosition, lastPosition };
        lastPosition = findLastPositionByBinarySearch(nums, target);

        return new int[] { firstPosition, lastPosition };
    }

    public int findFirstPositionByBinarySearch(int[] nums, int target) {
        int position = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                position = mid;
                right = mid - 1;
            }
        }

        return position;
    }

    public int findLastPositionByBinarySearch(int[] nums, int target) {
        int position = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                position = mid;
                left = mid + 1;
            }
        }

        return position;
    }
}
