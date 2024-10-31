import java.util.*;

// https://leetcode.com/problems/range-sum-of-bst

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        // 노드 값이 high보다 크다면 왼쪽 트리만 탐색
        if (root.val > high) return rangeSumBST(root.left, low, high);
        // 노드 값이 low보다 작다면 오른쪽 트리만 탐색
        if (root.val < low) return rangeSumBST(root.right, low, high);
        // 노드 값이 low ~ high 범위 내에 있다면
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
