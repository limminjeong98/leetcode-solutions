import java.util.*;

// https://leetcode.com/problems/power-of-three

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            int m = n % 3;
            if (m > 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
