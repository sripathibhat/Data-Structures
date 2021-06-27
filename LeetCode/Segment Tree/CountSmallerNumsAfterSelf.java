class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // Brute force - TLE
        List<Integer> res = new ArrayList<>();
        // for(int i = 0; i < nums.length; i++) {
        //     int cnt = 0;
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[j] < nums[i]) {
        //             cnt++;
        //         }
        //     }
        //     res.add(cnt);
        // }
        // return res;

        // Efficient approach using segment tree, construct the tree from min to max element, iterate over array elements from right to left.
        // Update the current number's count in the tree and then count for numbers between [min, number - 1]
        // Augmented info at each node - Range that this node covers and the count of numbers present in that range
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        SegmentTreeNode root = buildTree(min, max);
        for(int i = nums.length - 1; i >= 0; i--) {
            update(root, nums[i]);
            res.add(getNumsInRange(root, min, nums[i] - 1));
        }
        Collections.reverse(res);
        return res;
    }
    
    class SegmentTreeNode {
        int start;
        int end;
        int val;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        SegmentTreeNode(int st, int en) {
            start = st;
            end = en;
            val = 0;
        }
    }
    
    private SegmentTreeNode buildTree(int start, int end) {
        if(start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) {
            return node;
        }
        int mid = start + (end-start) / 2;
        node.left = buildTree(start, mid);
        node.right = buildTree(mid+1, end);
        return node;
    }
    
    private void update(SegmentTreeNode node, int index) {
        if(node == null) {
            return;
        }
        if(node.start == index && node.end == index) {
            node.val += 1;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(index <= mid) {
            update(node.left, index);
        }
        else {
            update(node.right, index);
        }
        node.val = node.left.val + node.right.val;
    }
    
    private int getNumsInRange(SegmentTreeNode node, int start, int end) {
        if(node == null || start > end) {
            return 0;
        }
        if(node.start == start && node.end == end) {
            return node.val;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(start > mid) {
            return getNumsInRange(node.right, start, end);
        }
        if(end <= mid) {
            return getNumsInRange(node.left, start, end);
        }
        return getNumsInRange(node.left, start, mid) + getNumsInRange(node.right, mid+1, end);
    }
}