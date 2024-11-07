import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        if (!left.isEmpty()) result.addAll(left);

        result.add(root.val);

        List<Integer> right = inorderTraversal(root.right);
        if (!right.isEmpty()) result.addAll(right);
        
        return result;
    }
}
