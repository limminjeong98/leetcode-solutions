import java.util.*;

// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;

        // 노드 끝으로 이동할 때까지 순회
        while (node != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = node.next;
            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }
        // 뒤집힌 연결 리스트의 첫 번째 노드
        return prev;
    }
}
