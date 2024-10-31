import java.util.*;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    int val = 0;
    // Binary Search Tree의 우측 자식 노드는 항상 부모 노드보다 큰 값임
    // 따라서 자신보다 같거나 큰 ㄱ밧을 구하려면 자기 자신을 포함한 우측 노드의 합을 구하면 된다.
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        // 오른쪽 자식 노드부터 탐색
        bstToGst(root.right);
        // 누적된 값에 현재 노드 값 추가
        val += root.val;
        // 현재 노드 값을 지금까지 누적된 값으로 할당
        root.val = val;
        // 왼쪽 자식 노드 탐색
        bstToGst(root.left);
        return root;
    } 
}
