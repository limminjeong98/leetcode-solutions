import java.util.*;

// https://leetcode.com/problems/merge-strings-alternately

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();

        int i1 = 0;
        int i2 = 0;
        while (i1 < l1 || i2 < l2) {
            if (i1 < l1 && i2 < l2) {
                sb.append(String.valueOf(word1.charAt(i1)));
                sb.append(String.valueOf(word2.charAt(i2)));
                i1++;
                i2++;
            } else if (i1 < l1) {
                sb.append(String.valueOf(word1.charAt(i1)));
                i1++;
            } else {
                sb.append(String.valueOf(word2.charAt(i2)));
                i2++;
            }
        }
        return sb.toString();
    }
}
