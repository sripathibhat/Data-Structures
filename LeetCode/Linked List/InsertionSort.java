/*

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain. 

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]


Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 
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
    public ListNode insertionSortList(ListNode head) {
        // If list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }
        
        // Create a dummy node to handle case of insertion at head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;  // Node to be inserted
        ListNode prev = head;       // Last sorted node
        
        while (curr != null) {
            if (curr.val >= prev.val) {
                // If current node is greater than previous, 
                // it's already in right position
                prev = curr;
                curr = curr.next;
            } else {
                // Find position to insert current node
                ListNode temp = dummy;
                
                // Find position where node should be inserted
                while (temp.next.val < curr.val) {
                    temp = temp.next;
                }
                
                // Insert current node
                prev.next = curr.next;
                curr.next = temp.next;
                temp.next = curr;
                
                // Move to next node to be inserted
                curr = prev.next;
            }
        }
        
        return dummy.next;
    }
}
