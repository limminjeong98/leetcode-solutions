import java.util.*;

// https://leetcode.com/problems/search-in-a-binary-search-tree

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.left != null) {
            TreeNode result = searchBST(root.left, val);
            if (result != null) return result;
        }
        if (root.right != null) {
            TreeNode result = searchBST(root.right, val);
            if (result != null) return result;
        }
        
        return null;
    }
}
