import java.util.*;

// https://leetcode.com/problems/same-tree

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } 
        // 한쪽만 null이거나 현재 노드의 val이 다른 경우
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // recursive
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
