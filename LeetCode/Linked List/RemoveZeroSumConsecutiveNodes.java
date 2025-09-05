/**

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.


Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]


Example 3:

Input: head = [1,2,3,-3,-2]
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
    public ListNode removeZeroSumSublists(ListNode head) {
        // Create a dummy node to handle edge cases where the head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use HashMap to store prefix sums and their corresponding nodes
        Map<Integer, ListNode> prefixSums = new HashMap<>();
        
        // Calculate running sum
        int sum = 0;
        ListNode current = dummy;
        
        // First pass: Store prefix sums
        while (current != null) {
            sum += current.val;
            
            // If we've seen this sum before, we found a zero-sum sequence
            if (prefixSums.containsKey(sum)) {
                // Remove all nodes between the previous occurrence of this sum
                // and the current node from our map
                ListNode prev = prefixSums.get(sum);
                int tempSum = sum;
                ListNode temp = prev.next;
                while (temp != current) {
                    tempSum += temp.val;
                    prefixSums.remove(tempSum);
                    temp = temp.next;
                }
                // Connect the previous node to the node after current
                prev.next = current.next;
            } else {
                prefixSums.put(sum, current);
            }
            current = current.next;
        }
        
        return dummy.next;
    }
}
