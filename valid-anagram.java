import java.util.*;

// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < 1 || tLength < 1 || sLength != tLength) return false;

        // char의 unicode 값
        Map<Integer, Integer> count = new HashMap<>();

        List<Integer> sChars = s.chars().boxed().collect(Collectors.toList());
        for (Integer ch : sChars) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        List<Integer> tChars = t.chars().boxed().collect(Collectors.toList());
        for (Integer ch : tChars) {
            Integer left = count.get(ch);
            if (left == null) return false;
            else if (left == 1) count.remove(ch);
            else count.put(ch, left - 1);
        }
        return true;
    }
}
