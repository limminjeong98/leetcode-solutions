import java.util.*;

// https://leetcode.com/problems/excel-sheet-column-title

class Solution {

    // Ascii A: 65, Z: 90

    public String convertToTitle(int columnNumber) {
        if (columnNumber < 27) {
            return Character.toString((char) columnNumber + 64);
        }
        
        StringBuilder answer = new StringBuilder();
        int quotient = columnNumber; // 몫
        int remainder; // 나머지

        while (quotient > 0) {
            remainder = quotient % 26;
            // Z
            if (remainder == 0) {
                answer.append('Z');
                quotient /= 26;
                quotient--;
            } else {
                answer.append((char) (remainder + 64));
                quotient /= 26;
            }
        }
        
        return answer.reverse().toString();
    }
}
