/*

    You are given a doubly linked list which in addition to the next and previous pointers,
    it could have a child pointer, which may or may not point to a separate doubly linked list.
    These child lists may have one or more children of their own, and so on, to produce a multilevel
    data structure, as shown in the example below.

    Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given
    the head of the first level of the list.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();
        Node cn = head;
        while(cn != null) {
            if(cn.child != null) {
                if(cn.next != null) {
                    st.push(cn.next);
                }
                cn.next = cn.child;
                cn.next.prev = cn;
                cn.child = null;
            } else if(cn.next == null && !st.isEmpty()) {
                cn.next = st.pop();
                cn.next.prev = cn;
            }
            cn = cn.next;
        }
        return head;
    }
}