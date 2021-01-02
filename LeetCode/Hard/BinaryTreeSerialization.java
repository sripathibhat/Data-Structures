// 297
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // static TreeNode root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        if (root == null) {
            return "*";
        }
        res.append(root.val);
        res.append(",").append(serialize(root.left));
        res.append(",").append(serialize(root.right));
        return res.toString();
        // dummy solution which is working
        // this.root = root;
        // return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        return helper(data.split(","), new int[1]);
        // dummy solution
        // return root;
    }
    
    private TreeNode helper(String[] nums, int[] i) {
        if (nums.length == i[0]) {
            return null;
        }
        String num = nums[i[0]++];
        if (num.equals("*")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(num));
        root.left = helper(nums, i);
        root.right = helper(nums, i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));