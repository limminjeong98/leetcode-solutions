import java.util.*;

// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> answer = new ArrayList<>();

        boolean processed = false;

        for (int[] interval : intervals) {
            if (processed) {
                if (answer.get(answer.size() - 1).get(1) >= interval[0]) {
                    List<Integer> current = new ArrayList(answer.get(answer.size() - 1));
                    current.set(1, Math.max(interval[1], answer.get(answer.size() - 1).get(1)));
                    answer.set(answer.size() - 1, current);
                } else {
                    answer.add(Arrays.stream(interval).boxed().collect(Collectors.toList()));
                }
            } else {
                if (interval[0] <= newInterval[0] && newInterval[0] <= interval[1]) {
                    answer.add(List.of(interval[0], Math.max(newInterval[1], interval[1])));
                    processed = true;
                } else if (newInterval[0] <= interval[0] && interval[0] <= newInterval[1]) {
                    answer.add(List.of(newInterval[0], Math.max(newInterval[1], interval[1])));
                    processed = true;
                } else if (newInterval[1] < interval[0]) {
                    answer.add(Arrays.stream(newInterval).boxed().collect(Collectors.toList()));
                    answer.add(Arrays.stream(interval).boxed().collect(Collectors.toList()));
                    processed = true;
                } else {
                    answer.add(Arrays.stream(interval).boxed().collect(Collectors.toList()));
                }
            }
        }

        if (processed == false) {
            answer.add(Arrays.stream(newInterval).boxed().collect(Collectors.toList()));
        }

        return answer.stream().map(arr -> arr.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
