/**

Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        ListNode mergedList = sortedMerge(left, right);
        return mergedList;
    }

    private ListNode getMid(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        if (a.val <= b.val) {
            res.next = a;
            res = res.next;
            res.next = sortedMerge(a.next, b);
        }
        else {
            res.next = b;
            res = res.next;
            res.next = sortedMerge(a, b.next);
        }
        return dummy.next;
    }
}
