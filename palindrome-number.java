import java.util.*;

// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] arr = String.valueOf(x).toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) return false;
        }
        return true;
    }
}
