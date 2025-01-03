// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                indexMap.put(c, -1);
            } else {
                indexMap.put(c, i);
            }
        }

        int answer = length;

        for (Map.Entry<Character, Integer> entry : indexMap.entrySet()) {
            if (entry.getValue() == -1) continue;
            answer = Math.min(answer, entry.getValue());
        }
        return answer == length ? -1 : answer;
    }
}
