import java.util.*;

// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        
        for (int row = 1; row < numRows; row++) {
            List<Integer> arr = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int sum = 0;
                int left = 0;
                int right = 0;
                if (col == 0) {
                    right = answer.get(row - 1).get(col);
                } else if (col == row) {
                    left = answer.get(row - 1).get(col - 1);
                } else {
                    left = answer.get(row - 1).get(col - 1);
                    right = answer.get(row - 1).get(col);
                }
                sum = left + right;
                arr.add(sum);
            }
            answer.add(arr);
        }
        
        return answer;
    }
}
