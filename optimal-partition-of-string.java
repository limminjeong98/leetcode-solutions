import java.util.*;

// https://leetcode.com/problems/optimal-partition-of-string

class Solution {
    public int partitionString(String s) {
        Set<Character> visited = new HashSet<>();
        int answer = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (visited.contains(c)) {
                visited.clear();
                answer++;
            }
            visited.add(c);
        }

        return answer;
    }
}
