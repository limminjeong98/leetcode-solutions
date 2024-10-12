import java.util.*;

// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (count.containsKey(c) == false) return false;
            int current = count.get(c);
            if (current == 1) {
                count.remove(c);
            } else {
                count.put(c, current - 1);
            }
        }
        return true;
    }
}
