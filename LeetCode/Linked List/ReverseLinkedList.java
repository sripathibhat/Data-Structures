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
    public ListNode reverseList(ListNode head) {
        // ListNode cn=head, pn=null, next;
        // while(cn!=null) {
        //     next=cn.next;
        //     cn.next=pn;
        //     pn=cn;
        //     cn=next;
        // }
        // return pn;
        
        // recursive
        ListNode newHead = reverse(head);
        return newHead;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode newHead;
        if(head == null || head.next==null) {
            return head;
        }
        newHead = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}