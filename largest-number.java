import java.util.*;

// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            String s1 = String.valueOf(a) + b;
            String s2 = String.valueOf(b) + a;
            return s2.compareTo(s1);
        });

        for (int i : nums) {
            pq.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 0) {
            int num = pq.poll();
            sb.append(String.valueOf(num));
        }
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
