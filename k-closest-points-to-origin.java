import java.util.*;

// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    static class Point {
        long distance;
        int[] point;

        public Point(long distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.distance));

        for (int[] p : points) {
            long distance = (long)Math.pow(p[0], 2) + (long)Math.pow(p[1], 2);
            pq.add(new Point(distance, p));
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().point;
        }
        return result;
    }
}
