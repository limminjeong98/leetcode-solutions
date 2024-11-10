import java.util.*;

// https://leetcode.com/problems/binary-tree-preorder-traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return List.of();
        // List<Integer> answer = new ArrayList(root.val); 이렇게 하면 절대 안됨
        List<Integer> answer = new ArrayList();
        answer.add(root.val);
        if (root.left != null) {
            answer.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            System.out.println(root.right.val);
            answer.addAll(preorderTraversal(root.right));
        }
        
        return answer;
    }
}
