import java.util.*;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrder = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inOrder = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        return dfs(preOrder, inOrder);
    }

    public TreeNode dfs(List<Integer> preOrder, List<Integer> inOrder) {
        if (inOrder.isEmpty()) return null;

        // 전위순회 값이 중위순회에서 몇 번째 인덱스인지 확인
        int inIndex = inOrder.indexOf(preOrder.get(0));
        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정
        TreeNode node = new TreeNode(inOrder.get(inIndex));

        // 왼쪽 자식노드
        node.left = dfs(preOrder.subList(1, inIndex + 1), inOrder.subList(0, inIndex));
        // 오른쪽 자식노드
        node.right = dfs(preOrder.subList(inIndex + 1, preOrder.size()), inOrder.subList(inIndex + 1, inOrder.size()));

        return node;
    }
}
