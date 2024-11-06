import java.util.*;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode tmp = new ListNode(101);
        int prevVal = 101;

        ListNode answer = tmp;

        while (head != null) {
            if (head.val != prevVal) {
                prevVal = head.val;
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
            } 
            head = head.next;
        }
        return answer.next;
    }
}
