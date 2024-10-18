import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        for (int i : nums) {
            queue.offer(Integer.valueOf(i));
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
