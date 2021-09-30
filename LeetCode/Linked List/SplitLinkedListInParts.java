/*

    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

    The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
    This may lead to some parts being null.

    The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than
    or equal to parts occurring later.

    Return an array of the k parts.

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total = 0;
        ListNode cn = head;
        ListNode prev = null;
        while(cn != null) {
            total++;
            cn = cn.next;
        }
        ListNode res[] = new ListNode[k];
        int extra = total % k;
        int len = total / k;
        
        cn = head;
        int i = 0;
        while(cn != null && i < k) {
            res[i] = cn;
            for(int j = 0; j < len + (extra > 0 ? 1: 0); j++) {
                prev = cn;
                cn = cn.next;
            }
            prev.next = null;
            i++;
            extra--;
        }
        return res;
    }
}