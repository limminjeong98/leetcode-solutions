import java.util.*;

// https://leetcode.com/problems/factorial-trailing-zeroes

class Solution {
    public int trailingZeroes(int n) {
        // 2, 5의 개수만 세면 됨
        int[] counts = dfs(n);
        return Math.min(counts[0], counts[1]);
    }

    public int[] dfs(int n) {
        int N = n;
        if (n <= 1) return new int[] { 0, 0 };
        // 2의 개수
        int n2 = 0;
        while (n >= 2 && n % 2 == 0) {
            n /= 2;
            n2++;
        }
        // 5의 개수
        int n5 = 0;
        while (n >= 5 && n % 5 == 0) {
            n /= 5;
            n5++;
        }

        int[] counts = dfs(N - 1);
        counts[0] += n2;
        counts[1] += n5;
        return counts;
    }

}
