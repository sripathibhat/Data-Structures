// 1658
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        if(sum == x) {
            return nums.length;
        }
        int target = sum - x; 
        // max subarray with sum = target
        // subtract len(nums)-len(max subarray)
        int left=0, right=0;
        int curSum = 0;
        int len=0;
        while(right<nums.length) {
            curSum += nums[right];  
            while(left<right && curSum > target) {
                curSum -= nums[left++];
            }
            if(curSum == target) {
                // got a candidate for max subarray
                len = Math.max(len, right-left+1);
            }
            right++;
        }
        return len == 0 ? -1 : nums.length-len;
    }
}