import java.util.*;

// https://leetcode.com/problems/triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);

        Integer currentValue;
        Integer prevLeftValue;
        Integer prevRightValue;

        List<Integer> prevRows;
        List<Integer> rows;

        for (int i = 1; i < n; i++) {
            prevRows = triangle.get(i - 1);
            rows = triangle.get(i);
            int col = rows.size();
            for (int j = 0; j < col; j++) {
                currentValue = rows.get(j);
                if (j == 0) {
                    prevRightValue = prevRows.get(j);
                    rows.set(j, currentValue + prevRightValue);
                } else if (j == col - 1) {
                    prevLeftValue = prevRows.get(j - 1);
                    rows.set(j, currentValue + prevLeftValue);
                } else {
                    prevLeftValue = prevRows.get(j - 1);
                    prevRightValue = prevRows.get(j);
                    rows.set(j, currentValue + Math.min(prevLeftValue, prevRightValue));
                }
            }
        }

        return triangle.get(n - 1).stream().sorted().findFirst().get().intValue();
    }
}
