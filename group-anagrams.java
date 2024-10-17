import java.util.*;

// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        int n = strs.length;
        if (n == 0) return answer;

        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String target = strs[i];
            
            char[] sortedAscii = target.toCharArray();
            Arrays.sort(sortedAscii);
            
            String asciiString = new String(sortedAscii);
    
            if (anagramGroups.containsKey(asciiString)) {
                List<String> groupString = anagramGroups.get(asciiString);
                groupString.add(target);
            } else {
                anagramGroups.put(asciiString, new ArrayList(List.of(target)));
            }
        }

        for (List<String> group : anagramGroups.values()) {
            answer.add(group);
        }
        return answer;
    }
}
