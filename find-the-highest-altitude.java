import java.util.*;

// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int currentAltitude = 0;
        for (int g : gain) {
            currentAltitude += g;
            if (highestAltitude < currentAltitude) {
                highestAltitude = currentAltitude;
            }
        }
        return highestAltitude;
    }
}
