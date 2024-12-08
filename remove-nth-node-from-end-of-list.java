import java.util.*;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode answer = head;

        // get list length
        int length = 0;
        while (answer != null) {
            answer = answer.next;
            length++;
        }

        answer = head;

        int count = 0;
        // 앞에서 잘라야하는 경우
        while (count > length - n - 1) {
            answer = answer.next;
            count--;
        }

        // 뒤에서 잘라야하는 경우
        while (count < length - n - 1) {
            head = head.next;
            count++;
        }

        if (head == null) return null;
        if (head.next == null || head.next.next == null) {
            head.next = null;
        } else {
            head.next = head.next.next;
        }

        return answer;
    }
}
