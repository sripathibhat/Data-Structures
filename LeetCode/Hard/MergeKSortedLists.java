// 23
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
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        // add first node from each list to pq
        for (int i=0;i<lists.length;i++) {
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        // poll nodes from pq, add next of removed node
        ListNode t = null, res = null;
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if(temp.next != null) {
                pq.add(temp.next);
            }
            if(res == null) {
                res = temp;
                t = temp;
            } else {
                t.next = temp;
                t = t.next;
            }
        }
        return res;
    }
}