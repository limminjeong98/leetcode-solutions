import java.util.*;

// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 연결이 하나밖에 없는 노드를 리프노드에 추가
            if (graph.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            // 이전 단계의 리프 노드 개수만큼 n에서 제거
            n -= leaves.size();
            // 단계별로 새로운 리프 노드 선언
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // 리프 노드의 이웃 노드 추출
                int neighbor = graph.get(leaf).get(0);
                // 이웃 노드에서 리프 노드까지 연결 삭제
                graph.get(neighbor).remove((Object) leaf);
                // 이웃 노드가 리프 노드인 경우 newLeaves에 추가
                if (graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            // 현재 단계에서 리프 노드를 모두 추가한 newLeaves -> leaves
            leaves = newLeaves;
        }
        return leaves;
    }
}
