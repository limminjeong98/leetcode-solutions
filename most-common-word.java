import java.util.*;

// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        List<String> bannedWords = Arrays.stream(banned).toList();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (bannedWords.contains(word)) continue;
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        int maxCount = 0;
        String answer = "";
        for (String key : count.keySet()) {
            int value = count.get(key);
            if (value > maxCount) {
                maxCount = value;
                answer = key;
            }
        }
        
        return answer;
    }
}
