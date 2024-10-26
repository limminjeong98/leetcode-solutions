import java.util.*;

// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (capacity[i] == 0) {
                result++;
            } else {
                if (capacity[i] <= additionalRocks) {
                    result++;
                    additionalRocks -= capacity[i];
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
