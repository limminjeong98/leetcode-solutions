import java.util.*;

// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            answer[i] = answer[i / 2] + i % 2;
        }
        return answer;
    }
}
