import java.util.*;

// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> answer = new LinkedList<>();
        int sum = 0;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            answer.add(sum);
        }
        if (carry > 0) {
            answer.add(carry);
        }
        Collections.reverse(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
