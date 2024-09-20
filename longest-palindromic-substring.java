import java.util.*;

// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public static int n;
    public static int left;
    public static int maxLength;
  
    public String longestPalindrome(String s) {
    
        n = s.length();
        left = -1;
        maxLength = 0;

        if (n < 2) return s;

        for (int i = 0; i < n - 1; i++) {
            extendPalindrome(s, i, i + 1); // 두칸짜리 투포인터
            extendPalindrome(s, i, i + 2); // 세칸짜리 투포인터
        }

        return s.substring(left, left + maxLength);
    }

    public void extendPalindrome(String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < n && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }

        if (maxLength < rightIndex - leftIndex - 1) {
            maxLength = rightIndex - leftIndex - 1;
            left = leftIndex + 1;
            // while 문 빠져나갈때 leftIndex--한 상태라 1 더해줘야 함
        }
    }
}
