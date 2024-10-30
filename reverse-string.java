import java.util.*;

// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char tmp;
        for (int i = 0; i < n / 2; i++) {
            tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
    }
}
