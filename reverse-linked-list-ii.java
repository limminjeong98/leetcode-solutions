import java.util.*;

// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;

        // 임시 노드부터 시작해 변경 필요한 위치 앞으로 이동
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        // 변경 필요한 마지막 위치
        ListNode end = start.next;

        ListNode tmp;
        // right - left만큼 위치 변경 진행
        for (int i = 0; i < right - left; i++) {
            tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return dummy.next;
    }
}
