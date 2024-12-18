import java.util.*;

// https://leetcode.com/problems/power-of-four

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            int m = n % 4;
            if (m > 0) return false;
            n /= 4;
        }
        return n == 1;
    }
}
