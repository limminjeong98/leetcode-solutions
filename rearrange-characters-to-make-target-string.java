// https://leetcode.com/problems/rearrange-characters-to-make-target-string

class Solution {
    public int rearrangeCharacters(String s, String target) {

        int answer = 0;
        Map<Character, Integer> count = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        while (true) {
            boolean flag = true;
            for (char c : target.toCharArray()) {
                if (count.containsKey(c)) {
                    if (count.get(c) > 1) count.put(c, count.get(c) - 1);
                    else count.remove(c);
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            answer++;
        }

        return answer;
    }
}
