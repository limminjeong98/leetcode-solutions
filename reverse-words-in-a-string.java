import java.util.*;

// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        // 공백이 1글자 혹은 1글자 이상 연속되는 경우
        String[] arr = s.strip().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        // 마지막 공백은 제거
        return sb.toString().substring(0, sb.length() - 1);
    }
}
