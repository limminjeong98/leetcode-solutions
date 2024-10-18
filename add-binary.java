import java.util.*;

// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        int carry = 0;

        int numA = 0;
        int numB = 0;

        int result = 0;

        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                numA = Integer.valueOf(String.valueOf(a.charAt(indexA))).intValue();
                indexA--;
            } else {
                numA = 0;
            }
            if (indexB >= 0) {
                numB = Integer.valueOf(String.valueOf(b.charAt(indexB))).intValue();
                indexB--;
            } else {
                numB = 0;
            }

            result = numA + numB + carry;
            if (result > 1) {
                carry = 1;
                result -= 2;
            } else {
                carry = 0;
            }
            
            sb.append(String.valueOf(result));
        }

        if (carry > 0) {
            sb.append(String.valueOf(carry));
        }

        return sb.reverse().toString();
    }
}
