import java.util.*;

// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, root.val);
    }

    public boolean dfs(TreeNode node, int targetSum, int sum) {
        if (node.left == null && node.right == null) {
            if (targetSum == sum) {
                return true;
            }
        } else {
            boolean result = false;

            if (node.left != null) {
                result = dfs(node.left, targetSum, sum + node.left.val);
                if (result) return true;
            }
            
            if (node.right != null) {
                result = dfs(node.right, targetSum, sum + node.right.val);
                if (result) return true;
            }
            
        }

        return false;
    }


}
