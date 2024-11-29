import java.util.*;

// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String number = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        // compression
        char c = number.charAt(0);
        int count = 1;
        int i = 1;
        while (i < number.length()) {
            if (c == number.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                count = 1;
                c = number.charAt(i);
            }
            i++;
        }
        sb.append(count);
        sb.append(c);

        return sb.toString();
    }
}
