import java.util.*;

// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 문자 단위 빈도수 계산
        int[] freqs = new int[26];
        for (char c : tasks) {
            freqs[c - 'A']++;
        }
        // 우선순위 큐에 빈도가 0보다 큰 모든 아이템 추가
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freqs) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int result = 0;
        while (true) {
            int intervals = 0;
            List<Integer> list = new ArrayList<>();
            // 우선순위 큐에서 모두 추출할 때까지 반복
            while (!pq.isEmpty()) {
                int frequency = pq.poll();
                // n+1만큼 추출하면서 현재 간격의 진행 횟수를 늘리고, 결과도 증가
                if (intervals <= n) {
                    intervals++;
                    result++;
                    // 추출 아이템이 아직 1보다 크다면 1 감소시켜 다시 추가
                    if (frequency > 1) {
                        list.add(frequency - 1);
                    }
                } else {
                    // 나머지 값들은 그대로 보존
                    list.add(frequency);
                }
            }
            if (list.isEmpty()) break;
            // 우선순위 큐에 리스트를 다시 삽입
            pq.addAll(list);
            // 현재 간격의 진행횟수(intervals)기 n+1만큼 추출하지 못해서 idle이 필요한 상태라면 그만큼 결과 증가
            result += n + 1 - intervals;
        }
        return result;
    }
}
