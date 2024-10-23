import java.util.*;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = candies[0];
        int n = candies.length;

        for (int i = 1; i < n; i++) {
            if (candies[i] > maxCandy) {
                maxCandy = candies[i];
            }
        }
        // int maxCandy = Arrays.stream(candies).max().getAsInt(); 성능이 느림
        
        Boolean[] answer = new Boolean[n];
        Arrays.fill(answer, false);
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= maxCandy) {
                answer[i] = true;
            } 
        }
        return Arrays.asList(answer);
    }
}
