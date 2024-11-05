import java.util.*;

// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i].equals("")) continue;
            return arr[i].length();
        }
        return 0;
    }
}
