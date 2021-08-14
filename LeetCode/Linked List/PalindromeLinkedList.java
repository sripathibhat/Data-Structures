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
    public boolean isPalindrome(ListNode head) {
        // Stack
        /*
        ListNode cn = head;
        Stack<ListNode> st = new Stack<>();
        while(cn != null) {
            st.push(cn);
            cn = cn.next;
        }
        ListNode cur = head;
        while(!st.isEmpty()) {
            cn = st.pop();
            if(cn.val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
        */
        
        
        
        // Better approach - split into 2, reverse 2nd half and compare the 2 halves
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode fp = head, sp = head, prevsp = null;
        while(fp != null && fp.next != null) {
            prevsp = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        ListNode sec = null;
        if(fp == null) {
            // even length list
            sec = reverse(sp);
        }
        else {
            sec = reverse(sp.next);
        }
        prevsp.next = null;
        ListNode first = head;
        // compare first and sec
        while(first != null && sec != null) {
            if(first.val != sec.val) {
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        if(first != null || sec != null) {
            return false;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cn = head, prev = null;
        while(cn != null) {
            ListNode next = cn.next;
            cn.next = prev;
            prev = cn;
            cn = next;
        }
        return prev;
    }
}