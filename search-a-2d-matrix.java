import java.util.*;

// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m - 1;
        int row;

        while (start <= end) {
            row = (start + end) / 2;
            int result = binarySearch(matrix[row], n, target);
            if (result == 0) return true;
            else if (result == 1) {
                start = row + 1;
            } else {
                end = row - 1;
            }
        }
        return false;
    }

    public int binarySearch(int[] rowMatrix, int colSize, int target) {
        int left = 0;
        int right = colSize - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > rowMatrix[mid]) {
                left = mid + 1;
            } else if (target < rowMatrix[mid]) {
                right = mid - 1;
            } else {
                return 0;
            }
        }
        // target이 없고, target이 mid보다 작은 경우
        if (rowMatrix[mid] > target) return -1;
        else return 1;
    }
}
