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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode res = odd;
        ListNode evenHead = even;
        ListNode cn = head;
        int cnt = 1;
        while(cn != null) {
            if(cnt % 2 == 0) {
                even.next = cn;
                even = even.next;
            }
            else {
                odd.next = cn;
                odd = odd.next;
            }
            cn = cn.next;
            cnt++;
        }
        even.next = null;
        odd.next = evenHead.next;
        return res.next; 
    }
}