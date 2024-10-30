import java.util.*;

// https://leetcode.com/problems/longest-univalue-path

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int answer;

    public int longestUnivaluePath(TreeNode root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        // 현재 노드가 왼쪽 자식 노드와 동일한 경우 왼쪽 거리 1 증가
        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            // 다르면 거리를 0으로 초기화
            left = 0;
        }
        
        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }

        answer = Math.max(answer, left + right);
        return Math.max(left, right);
    }


}
