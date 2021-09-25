/*

    Given a Binary Tree where each node has the following structure, write a function to populate the next pointer for all nodes.
    The next pointer for every node should be set to point to inorder successor.

*/

class Node
{
    int data;
    Node left, right, next;
  
    Node(int item)
    {
        data = item;
        left = right = next = null;
    }
}

class Solution {
    Node next = null;
    public void populateNext(Node root){
        //code here
        if(root != null) {
            populateNext(root.right);
            root.next = next;
            next = root;
            populateNext(root.left);
        }
    }
}