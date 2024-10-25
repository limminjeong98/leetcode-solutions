import java.util.*;

// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 != l2) return false;
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (Character c : word1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        for (Character c : word2.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }
        List<Integer> v1 = m1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> v2 = m2.values().stream().sorted().collect(Collectors.toList());
        int s1 = v1.size();
        int s2 = v2.size();
        if (s1 != s2) return false;
        for (int i = 0; i < s1; i++) {
            if (!v1.get(i).equals(v2.get(i))) return false;
        }
        Set<Character> k1 = m1.keySet();
        Set<Character> k2 = m2.keySet();
        s1 = k1.size();
        s2 = k2.size();
        if (s1 != s2) return false;
        if (!k1.equals(k2)) return false;
        return true;
    }
}
