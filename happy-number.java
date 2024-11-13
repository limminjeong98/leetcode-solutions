import java.util.*;

// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        String number;
        Set<Integer> visited = new HashSet<>();
        int sum;

        while (true) {
            if (n == 1) return true;
            if (visited.contains(n)) return false;
            visited.add(n);
            
            number = String.valueOf(n);
            sum = 0;
            for (char c : number.toCharArray()) {
                sum += (int)Math.pow(Integer.valueOf(String.valueOf(c)), 2);
            }
            n = sum;
        }
        
    }
}
