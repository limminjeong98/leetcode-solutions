import java.util.*;

// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int i : arr) {
            Integer key = Integer.valueOf(i);
            occurences.put(key, occurences.getOrDefault(key, 0) + 1);
        }

        Set<Integer> occurencesSet = new HashSet<>(occurences.values());
        return occurencesSet.size() == occurences.size();

        // List<Integer> sorted = occurences.values().stream().sorted().collect(Collectors.toList());
        // int n = sorted.size();
        // for (int i = 1; i < n; i++) {
        //     if (sorted.get(i - 1).equals(sorted.get(i))) return false;
        // }
        // return true;
    }
}
