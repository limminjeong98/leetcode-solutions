import java.util.*;

// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        int n = s.length();
        int i = 0;
        char[] characters = s.toCharArray();
        
        char target;
        while (i < n) {
            target = characters[i];
            if (target == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(target);
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
