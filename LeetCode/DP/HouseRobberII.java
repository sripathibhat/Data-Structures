/*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
    All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have
    a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without
    alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        /*
            [1,2,3,4,5]
            first consider robbing 1,2,3,4 and then 2,3,4,5 as 1 and 5 cannot be robbed on the same day
            take max of these 2
        */

        int dp[] = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        int m1 = dp[nums.length - 1];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        int m2 = dp[nums.length - 2];

        return Math.max(m1, m2);
    }
}