import java.util.*;

// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        if (rowIndex == 0) return answer.get(0);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int col = 0; col <= i; col++) {
                int left = 0;
                int right = 0;
                if (col > 0) {
                    left = answer.get(i - 1).get(col - 1);
                }
                if (col < i) {
                    right = answer.get(i - 1).get(col);
                }
                
                row.add(left + right);
            }
            answer.add(row);
        }
        return answer.get(answer.size() - 1);
    }
}
