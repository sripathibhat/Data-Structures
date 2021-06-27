class NumArray {

    // Each node contains sum of elements between nums[start] and nums[end] where start and end represent range and are stored as part of node itself
    // For update, check if index to be updated lies within the current node, if yes, then call update on its left and right childs and take the sum to update
    // current node value
    // updates are done bottom to top, leaf gets updated and then all nodes along the path till root will get updated
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }
    
    private SegmentTreeNode buildTree(int nums[], int start, int end) {
        if(start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) {
            node.val = nums[start];
            return node;
        }
        int mid = start + (end-start) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid+1, end);
        node.val = node.left.val + node.right.val;
        return node;
    }
    
    private void updateHelper(SegmentTreeNode node, int index, int val) {
        if(node == null) {
            return;
        }
        if(node.start == index && node.end == index) {
            node.val = val;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(index <= mid) {
            updateHelper(node.left, index, val);
        }
        else {
            updateHelper(node.right, index, val);
        }
        node.val = node.left.val + node.right.val;
    }
    
    private int sumRangeHelper(SegmentTreeNode node, int start, int end) {
        if(node == null || start > end) {
            return 0;
        }
        if(node.start == start && node.end == end) {
            return node.val;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(start > mid) {
            return sumRangeHelper(node.right, start, end);
        }
        if(end <= mid) {
            return sumRangeHelper(node.left, start, end);
        }
        return sumRangeHelper(node.left, start, mid) + sumRangeHelper(node.right, mid+1, end);
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
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */