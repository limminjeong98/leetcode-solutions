import java.util.*;

// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] answer = new int[len1 + len2];

        for (int idx1 = len1 - 1; idx1 >= 0; idx1--) {
            int number1 = num1.charAt(idx1) - '0';
            for (int idx2 = len2 - 1; idx2 >= 0; idx2--) {
                int number2 = num2.charAt(idx2) - '0';
                answer[idx1 + idx2 + 1] += number1 * number2;
            }
        }

        // 캐리 정리
        for (int i = len1 + len2 - 1; i > 0; i--) {
            answer[i - 1] += answer[i] / 10;
            answer[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        if (answer[0] == 0) start = 1;
        for (int i = start; i < len1 + len2; i++) {
            sb.append(answer[i]);
        }

        return sb.toString();
    }
}
