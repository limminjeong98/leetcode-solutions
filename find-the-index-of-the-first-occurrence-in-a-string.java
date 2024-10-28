import java.util.*;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        int length = haystack.length();
        int n = needle.length();
        
        for (int i = 0; i < length - n + 1; i++) {
            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) return i;
        }
        return -1;
    }
}
