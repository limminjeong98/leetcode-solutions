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

// https://leetcode.com/problems/add-two-numbers/

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode answer = new ListNode();
        ListNode result = answer;
        
        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }

            sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            answer.val = sum;
            sum = 0;

            if (l1 != null || l2 != null || carry > 0) {
                answer.next = new ListNode();
                answer = answer.next;
            }
        }

        if (carry > 0) {
            answer.val = carry;
        }
        
        return result;
    }
}
