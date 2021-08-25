/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that
their sum is equal to the given target.
*/

// Using inorder traversal, convert tree into sorted array and then use 2 pointer technique
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0;
        int j = list.size() - 1;
        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum == k) {
                return true;
            }
            if(sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}


// Using hashset
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return preorder(root, k, set);
    }
    
    private boolean preorder(TreeNode node, int target, Set<Integer> set) {
        if(node == null) {
            return false;
        }
        if(set.contains(target - node.val)) {
            return true;
        }
        set.add(node.val);
        return preorder(node.left, target, set) || preorder(node.right, target, set);
    }
}