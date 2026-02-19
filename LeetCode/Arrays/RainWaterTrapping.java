class Solution {

    // O(n) space
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int mxl[] = new int[n];
        int mxr[] = new int[n];
        mxl[0] = height[0];
        mxr[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            mxl[i] = Math.max(mxl[i-1], height[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            mxr[i] = Math.max(mxr[i+1], height[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(mxl[i], mxr[i]) - height[i];
        }
        return total;
    }

    // O(1) space
    public int trap(int[] height) {
        // Find total water on top of each building
        // WaterAtBuildingI = min(leftMax, rightMax) - ht[i]
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int total = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                total += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                total += rightMax - height[r];
            }
        }
        return total;
    }
}
