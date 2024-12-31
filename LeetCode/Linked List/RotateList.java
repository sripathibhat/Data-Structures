/**

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k==0) {
            return head;
        }
        int n = 0;
        ListNode cn = head;
        while (cn != null) {
            n++;
            cn = cn.next;
        }
        k = k % n;
        n = 0;
        ListNode fast = head, slow = head;
        while (n < k) {
            n++;
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        cn = slow.next;
        slow.next = null;
        return cn;
    }
}
