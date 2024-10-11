import java.util.*;

// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            // char 비교
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
