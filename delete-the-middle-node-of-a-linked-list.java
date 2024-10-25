import java.util.*;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

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
    public ListNode deleteMiddle(ListNode head) {
        ListNode tmp = head;
        int n = 0;

        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        if (n == 1) return null;

        ListNode answer = head;
        ListNode mod = head;

        int count = 0;
        while (count <= n / 2 - 2) {
            mod = mod.next;
            count++;
        }

        ListNode remove = mod.next;
        if (remove.next == null) {
            mod.next = null;
        } else {
            mod.next = remove.next;
        }
        return answer;
    }
}
