import java.util.*;

// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 홀수 개일때 느린 러너가 한 칸 더 앞으로 가도록 처리
        if (fast != null) {
            slow = slow.next;
        }

        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다
        ListNode reverse = null;
        ListNode next;
        while (slow != null) {
            // 느린 러너로 역순 연결 리스트 reverse를 만들어 나간다
            next = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = next;
        }

        // reverse 연결 리스트를 끝까지 이동하며 비교
        while (reverse != null) {
            // 역순 연결 리스트 reverse와 기존 연결 리스트 head를 비교
            if (reverse.val != head.val) return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }
}
