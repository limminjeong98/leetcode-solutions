import java.util.*;

// https://leetcode.com/problems/queue-reconstruction-by-height

class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        // 키가 클수록, 키가 같다면 앞에 줄 서 있는 사람이 작을수록
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                else return a[1] - b[1];
            }
        );

        for (int[] person : people) {
            pq.add(person);
        }

        List<int[]> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}
