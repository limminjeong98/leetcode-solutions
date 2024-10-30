import java.util.*;

// https://leetcode.com/problems/jewels-and-stones

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (Character c : stones.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        for (Character c : jewels.toCharArray()) {
            if (!frequencies.containsKey(c)) continue;
            answer += frequencies.get(c);
        }
        return answer;
    }
}
