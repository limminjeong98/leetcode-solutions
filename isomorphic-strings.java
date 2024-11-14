import java.util.*;

// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);

            if (charMap.containsKey(from)) {
                char replaced = charMap.get(from);
                if (replaced != to) return false;
            } else if (charMap.containsValue(to)) {
                return false;
            } else {
                charMap.put(from, to);
            }
        }
        return true;
    }
}
