/**

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cn = dummy;
        int cnt = 0;
        while (cn != null) {
            cnt++;
            cn = cn.next;
        }
        int len = cnt;
        cnt = 0;
        cn = dummy;
        while (cnt < len - n - 1) {
            cnt++;
            cn = cn.next;
        }
        cn.next = cn.next.next;
        return dummy.next;


        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode slow = dummy, fast = dummy;
        // for (int i = 0; i <= n; i++) {
        //     fast = fast.next;
        // }
        // while (fast != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // slow.next = slow.next.next;
        // return dummy.next;
    }
}
