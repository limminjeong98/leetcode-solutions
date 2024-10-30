import java.util.*;

// https://leetcode.com/problems/array-partition

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            answer += nums[2 * i];
        }
        return answer;
    }
}
