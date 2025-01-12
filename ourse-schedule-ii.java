// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] required = new int[numCourses];
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            required[pre[0]]++;
            List<Integer> current = courseMap.getOrDefault(pre[1], new ArrayList<>());
            current.add(pre[0]);
            courseMap.put(pre[1], current);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (required[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            answer.add(course);
            if (!courseMap.containsKey(course)) continue;
            for (Integer next : courseMap.get(course)) {
                required[next] -= 1;
                if (required[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (answer.size() != numCourses) return new int[] {};
        return answer.stream().mapToInt(i -> i).toArray();
    }

}
