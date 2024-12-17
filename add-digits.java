import java.util.*;

// https://leetcode.com/problems/add-digits

class Solution {
    public int addDigits(int num) {
        String str = String.valueOf(num);
        int answer = 0;

        while (str.length() > 1) {
            answer = 0;
            for (char c : str.toCharArray()) {
                answer += Integer.valueOf(String.valueOf(c));
            }
            str = String.valueOf(answer);
        }
        
        return Integer.valueOf(str);
    }
}
