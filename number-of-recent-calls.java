import java.util.*;

// https://leetcode.com/problems/number-of-recent-calls

class RecentCounter {
    public static Queue<Integer> queue;
    
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty()) {
            Integer request = queue.peek();
            if (request < t - 3000) {
                queue.poll();
            } else {
                break;
            }
        }
        queue.add(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
