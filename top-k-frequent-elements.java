import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int key : frequencies.keySet()) {
            int value = frequencies.get(key);
            List<Integer> bucket = buckets.getOrDefault(value, new ArrayList<>());
            bucket.add(key);
            buckets.put(value, bucket);
        }

        int n = nums.length;
        int[] result = new int[k];
        int index = 0;
        for (int i = n; i >= 0; i--) {
            if (index >= k) break;
            if (!buckets.containsKey(i)) continue;
            List<Integer> bucket = buckets.get(i);
            for (Integer value : bucket) {
                result[index] = value;
                index++;
                if (index >= k) break;
            }
        }
        return result;
    }
}
