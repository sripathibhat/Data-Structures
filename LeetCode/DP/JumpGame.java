class Solution {
    public boolean canJump(int[] nums) {
        int lastGoodPos = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= lastGoodPos) {
                lastGoodPos = i;
            }
        }
        return lastGoodPos == 0;
    }
}