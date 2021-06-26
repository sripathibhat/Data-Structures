// 152
class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int finalMax = nums[0];
        for(int i=1;i<nums.length;i++) {
            int temp = curMax;
            curMax = Math.max(Math.max(curMax*nums[i], curMin*nums[i]), nums[i]);
            curMin = Math.min(Math.min(temp*nums[i], curMin*nums[i]), nums[i]);
            finalMax = Math.max(curMax, finalMax);
        }
        return finalMax;
    }
}