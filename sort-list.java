import java.util.*;

// https://leetcode.com/problems/sort-list

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 러너 기법 활용, 빠른 노드가 끝까지 갈때 느린 노드는 중간까지 이동한다
        ListNode half = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // head를 시작으로 하는 노드와 slow를 시작으로 하는 노드의 연결을 끊는다
        half.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeTwoList(l1, l2);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        // l1쪽으로 잡은 노드를 스왑
        l1.next = mergeTwoList(l1.next, l2);
        return l1;
    }
}
