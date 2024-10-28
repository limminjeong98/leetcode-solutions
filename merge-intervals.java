import java.util.*;

// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }));

        int n = intervals.length;
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            int size = answer.size();
            if (i > 0 && answer.get(size - 1)[1] >= interval[0]) {
                answer.get(size - 1)[1] = Math.max(answer.get(size - 1)[1], interval[1]);
            } else {
                answer.add(interval);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
