import java.util.*;

// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        char[] s = Integer.valueOf(x).toString().toCharArray();
        int n = s.length;
        
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        if (s[0] == '-') sb.append('-');

        for (int i = n - 1; i >= 0; i--) {
            if (isFirst && s[i] == '0') continue;
            if (i == 0 && s[i] == '-') {
                continue;
            }
            sb.append(s[i]);
            isFirst = false;
        }
        if (sb.isEmpty()) sb.append('0');

        Long result = Long.parseLong(sb.toString());
        if (result > (long)Integer.MAX_VALUE) return 0;
        if (result < (long)Integer.MIN_VALUE) return 0;

        return result.intValue();
    }
}
