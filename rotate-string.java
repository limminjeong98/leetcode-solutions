// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (goal.equals(s.substring(i, n) + s.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
