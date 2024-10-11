import java.util.*;

// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        if (sLength == 0) return true;
        int tLength = t.length();
        int index = 0;

        // s의 문자들을 순서대로 포함하기만 하면 된다
        for (int i = 0; i < tLength; i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
                if (index == sLength) return true;
            }
        }
        return false;
    }
}
