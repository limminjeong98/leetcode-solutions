import java.util.*;

// https://leetcode.com/problems/hamming-distance

class Solution {
    public int hammingDistance(int x, int y) {
        // String a = String.valueOf(Integer.parseInt(String.valueOf(x), 2));
        // String a = Integer.toBinaryString(x);
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
}
