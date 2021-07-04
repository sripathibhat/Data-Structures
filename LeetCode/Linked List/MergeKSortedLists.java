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
    public ListNode mergeKLists(ListNode[] lists) {
    
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node: lists) {
            if(node != null) {
                pq.add(node);
            }
        }
        ListNode res = new ListNode();
        ListNode dummy = res;
        while(!pq.isEmpty()) {
            ListNode next = pq.poll();
            res.next = next;
            if(next.next != null) {
                pq.add(next.next);
            }
            res = res.next;
        }
        return dummy.next;
    }
}