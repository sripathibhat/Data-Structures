// 42
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int mxl[] = new int[height.length];
        int mxr[] = new int[height.length];
        //int water[] = new int[height.length];
        int totalWater = 0;
        mxl[0] = height[0];
        mxr[height.length-1] = height[height.length-1];
        for(int i = 1; i < height.length; i++) {
            mxl[i] = Math.max(height[i], mxl[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--) {
            mxr[i] = Math.max(height[i], mxr[i+1]);
        }
        for(int i = 0; i < height.length; i++) {
            //water[i] = Math.min(mxl[i], mxr[i]) - height[i];
            totalWater += Math.min(mxl[i], mxr[i]) - height[i];
        }
        return totalWater;
    }
}