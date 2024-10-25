import java.util.*;

// https://leetcode.com/problems/smallest-number-in-infinite-set

class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private int cursor;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        cursor = 1;
    }
    
    public int popSmallest() {
        if (pq.size() > 0) {
            return pq.poll();
        }
        return cursor++;
    }
    
    public void addBack(int num) {
        // 큐에 이미 있는 값이면 추가하면 안 된다
        // 큐에는 cursor 이상의 연속된 값들이 있으니까 cursor보다 작은 값일 때만 추가하면 된다
        if (cursor > num && !pq.contains(num)) {
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
