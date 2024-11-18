import java.util.*;

// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> wordMapping = new HashMap<>();

        int n = pattern.length();
        String[] arr = s.split(" ");
        
        if (n != arr.length) return false;

        for (int i = 0; i < n; i++) {
            String current = arr[i];
            Character key = pattern.charAt(i);
            if (wordMapping.containsKey(key)) {
                String value = wordMapping.get(key);
                if (!value.equals(current)) return false;
            } else {
                if (wordMapping.containsValue(current)) return false;
                wordMapping.put(key, current);
            }
        }

        return true;
    }
}
