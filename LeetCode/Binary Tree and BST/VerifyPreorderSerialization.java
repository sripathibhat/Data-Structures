/*
One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.


For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".
Note: You are not allowed to reconstruct the tree.

*/


class Solution {
    public boolean isValidSerialization(String preorder) {
        // check the number of vacancies at any node
        // number indicates - it can create 2 more vacanices as it is a binary tree and can have 2 children
        // # represents null node so it cannot create any new new nodes/children
        int vacancy = 1;
        String nodes[] = preorder.split(",");
        for(String node: nodes) {
            vacancy--;
            if(vacancy < 0) {
                return false;
            }
            if(!node.equals("#")) {
                vacancy += 2;
            }
        }
        // System.out.println(vacancy);
        return vacancy == 0;
    }
}