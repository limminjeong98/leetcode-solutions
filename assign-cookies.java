import java.util.*;

// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j == s.length) break;
            result++;
            j++;
        }
        return result;
    }
}
