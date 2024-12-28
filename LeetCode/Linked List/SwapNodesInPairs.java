/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the
problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

*/

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        dummy.next = head;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode first = dummy.next;
            ListNode second = dummy.next.next;
            dummy.next = second;
            first.next = second.next;
            second.next = first;
            dummy = first;
        }
        return temp.next;
    }
}
