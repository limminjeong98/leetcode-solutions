import java.util.*;

 // https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: 각 숫자를 올바른 위치로 배치
        // 예: 숫자 3은 인덱스 2 (3 - 1)에 위치해야 함
        for (int i = 0; i < n; i++) {
            // 현재 숫자가 1 이상, n 이하인 경우
            // 그리고 현재 숫자가 이미 올바른 위치에 있지 않은 경우
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // nums[i]와 nums[nums[i] - 1]을 스왑 (올바른 위치로 이동)
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: 최소 누락된 양의 정수 확인
        for (int i = 0; i < n; i++) {
            // 인덱스 i에 숫자 i + 1이 있어야 함
            if (nums[i] != i + 1) {
                return i + 1; // 누락된 숫자 발견
            }
        }

        // Step 3: 모든 숫자가 올바른 위치에 있는 경우
        return n + 1; // 배열의 모든 숫자가 [1, n]에 포함되면 n + 1 반환
    }
}
