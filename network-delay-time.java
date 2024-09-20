import java.util.*;

// https://leetcode.com/problems/network-delay-time/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // k번 노드에서 각 n - 1개의 노드까지 걸리는 시간
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        // 각 노드에서 다른 노드까지 이동하는 경로를 저장한 맵
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            
            map.putIfAbsent(u - 1, new HashMap<>());
            map.get(u - 1).putIfAbsent(v - 1, w);
        }

        // Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValues());
        // queue.offer(new AbstractMap.SimpleEntry<>(k - 1, 0));
        Queue<int[]> queue = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
        queue.offer(new int[] { 0, k - 1 });

        while (!queue.isEmpty()) {
            int[] network = queue.poll();
            int node = network[1];

            if (map.get(node) == null) continue;
            
            for (Map.Entry<Integer, Integer> nextNode : map.get(node).entrySet()) {
                int next_node = nextNode.getKey();
                // 아직 방문하지 않았다면
                int new_distance = network[0] + nextNode.getValue();
                if (dist[next_node] > new_distance) {
                    dist[next_node] = new_distance;
                    queue.offer(new int[] { new_distance, next_node });
                }
            }
        }

        int maxValue = Arrays.stream(dist).max().getAsInt();
        if (Integer.MAX_VALUE == maxValue) return -1;
        return maxValue;
    }
}
