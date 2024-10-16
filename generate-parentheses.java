import java.util.*;

// https://leetcode.com/problems/generate-parentheses

class Solution {
    public static int N;
    public static int LENGTH;

    public List<String> generateParenthesis(int n) {
        N = n;
        LENGTH = 2 * n;
        List<String> answer = new ArrayList<String>();
        dfs(answer, new StringBuilder(), 0, 0);
        return answer;
    }

    public void dfs(List<String> arr, StringBuilder sb, int leftCount, int rightCount) {
        if (sb.length() == LENGTH) {
            arr.add(sb.toString());
            return;
        }

        StringBuilder next;

        if (leftCount < N) {
            next = new StringBuilder(sb);
            dfs(arr, next.append("("), leftCount + 1, rightCount);
        } 
        if (leftCount > rightCount && rightCount < N) {
            next = new StringBuilder(sb);
            dfs(arr, next.append(")"), leftCount, rightCount + 1);
        }
        
    }
}
