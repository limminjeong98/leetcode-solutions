import java.util.*;

// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // 홀짝 노드의 다음 노드로 다음 다음 노드 지정
            odd.next = odd.next.next;
            even.next = even.next.next;
            // 홀짝 한 칸씩 진행
            odd = odd.next;
            even = even.next;
        }
        // 홀수 노드 마지막을 짝수 첫 번째와 연결
        odd.next = evenHead;
        return head;
    }
}
