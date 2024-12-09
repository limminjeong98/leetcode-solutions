import java.util.*;

// https://leetcode.com/problems/integer-to-roman

class Solution {
    List<Integer> lowerValues = List.of(1, 2, 3);
    public String intToRoman(int num) {
        String number = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '0') continue;
            // 단위 파악
            int d = (int)Math.pow(10, number.length() - 1 - i);
            
            int n = Integer.parseInt(new StringBuilder().append(c).toString());
                    
            if (c == '4') {
                if (d == 100) {
                    // 400
                    sb.append("CD");
                } else if (d == 10) {
                    // 40
                    sb.append("XL");
                } else {
                    // 4
                    sb.append("IV");
                } 
            } else if (c == '9') {
                if (d == 100) {
                    // 900
                    sb.append("CM");
                } else if (d == 10) {
                    // 90
                    sb.append("XC");
                } else {
                    // 9
                    sb.append("IX");
                } 
            } else {
                if (d == 1000) {
                    while (n > 0) {
                        sb.append('M');
                        n--;
                    } 
                } else if (d == 100) {
                    // 500 이상
                    if (!lowerValues.contains(n)) {
                        sb.append('D');
                        n -= 5;
                    }
                    while (n > 0) {
                        sb.append('C');
                        n--;
                    } 
                } else if (d == 10) {
                    if (!lowerValues.contains(n)) {
                        sb.append('L');
                        n -= 5;
                    }
                    while (n > 0) {
                        sb.append('X');
                        n--;
                    } 
                } else {
                    if (!lowerValues.contains(n)) {
                        sb.append('V');
                        n -= 5;
                    }
                    while (n > 0) {
                        sb.append('I');
                        n--;
                    } 
                }
            }
        }
        return sb.toString();
    }
}
