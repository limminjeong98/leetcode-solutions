import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 여행 경로 (출발지, (도착지, 비용))
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        // 출발지, 비용, 경로 수
        pq.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> current = pq.poll();
            int u = current.get(0);
            int price_u = current.get(1);
            int k_visited = current.get(2);

            if (u == dst) return price_u;

            if (visited.containsKey(u) && visited.get(u) <= k_visited) continue;
            visited.put(u, k_visited);

            // 진행한 경로가 k이하라면 계속 처리
            if (k_visited <= k) {
                k_visited += 1;
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            int alt = price_u + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }
        }
        // 경로가 존재하지 않음
        return -1;
    }
}
