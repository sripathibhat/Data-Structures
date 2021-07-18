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

 // Reference - coding decoded
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        int totalNodes = 0;
        while(cur != null) {
            totalNodes++;
            cur = cur.next;
        }
        cur = head;
        ListNode prev = dummy;
        ListNode next = null;
        while(totalNodes >= k) {
            cur = prev.next;
            next = cur.next;
            for(int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            totalNodes -= k;
        }
        return dummy.next;
    }
}