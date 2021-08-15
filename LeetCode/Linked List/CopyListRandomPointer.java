/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Extra space - Map
        /*HashMap<Node, Node> map = new HashMap<>();
        Node cn = head;
        while(cn != null) {
            Node newNode = new Node(cn.val);
            map.put(cn, newNode);
            cn = cn.next;
        }
        cn = head;
        Node clone;
        while(cn != null) {
            clone = map.get(cn);
            clone.next = map.get(cn.next);
            clone.random = map.get(cn.random);
            cn = cn.next;
        }
        return map.get(head);
        */
        
        // Without extra space - O(1)
        if(head == null) {
            return head;
        }
        Node cur = head, temp = null;
        // step 1 - add new nodes in between original nodes
        while(cur != null) {
            temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        // step 2 - adjust random pointer of new nodes
        cur = head;
        while(cur != null) {
            if(cur.next != null) {
                cur.next.random = cur.random != null ? cur.random.next : cur.random;
            }
            cur = cur.next != null ? cur.next.next : cur.next;
        }
        //step 3 - split list into original and copy, adjust next pointers of both list nodes
        cur = head;
        Node copy = head.next;
        temp = copy;
        while(cur != null && copy != null) {
            cur.next = cur.next != null ? cur.next.next : cur.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            cur = cur.next;
            copy = copy.next;
        }
        return temp;
    }
}