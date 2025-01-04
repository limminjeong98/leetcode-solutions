// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        // substring 길이
        for (int i = 1; i <= length / 2; i++) {
            if (length % i > 0) continue;
            String substr = s.substring(0, i);
            boolean flag = true;
            for (int j = i; j < length; j += i) {
                String target = s.substring(j, j + i);
                if (!target.equals(substr)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}
