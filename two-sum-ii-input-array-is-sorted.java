import java.util.*;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        // 정렬되어 있는 배열이므로 이진 탐색 사용할 수 있음
        // 정렬되어 있지 않으면 해시맵 사용하면 됨
        for (int i = 0; i < n; i++) {
            int rightIndex = binarySearch(numbers, target - numbers[i]);
            if (rightIndex == -1) continue;
            return new int[] { i + 1, rightIndex + 1 };
        }
        
        return new int[] {};
    }

    public int binarySearch(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int mid;
        int answer = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (numbers[mid] < target) {
                start = mid + 1;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                answer = mid;
                // 오름차순 정렬이므로, 같은 값이 두개 있다면
                // 이진 탐색에서 찾는 값은 최대한 인덱스가 더 큰(더 뒤에 있는 값)을 반환해야 함
                start = mid + 1;
            }
        }
        return answer;
    }
}
