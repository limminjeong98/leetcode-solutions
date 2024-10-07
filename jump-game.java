import java.util.*;

// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            // 현재 인덱스까지 도달할 방법이 없다면 
            if (i > maxPosition) return false;
            // 현재까지 가장 멀리 갈 수 있는 위치
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (maxPosition >= length - 1) return true;
        }

        return maxPosition >= length - 1;
    }
}
