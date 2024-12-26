// Kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cmax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cmax = cmax + nums[i];
            if(cmax < nums[i]) {
                cmax = nums[i];
            }
            max = Math.max(max, cmax);
        }
        return max;
    }
}
