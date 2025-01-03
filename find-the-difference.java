// https://leetcode.com/problems/find-the-difference

class Solution {
    public char findTheDifference(String s, String t) {
        int length = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (countMap.containsKey(s.charAt(i))) {
                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
            } else {
                countMap.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (!countMap.containsKey(t.charAt(i))) return t.charAt(i);
            int count = countMap.get(t.charAt(i));
            if (count == 1) {
                countMap.remove(t.charAt(i));
            } else {
                countMap.put(t.charAt(i), count - 1);
            }
        }
        return t.charAt(length);
    }
}
