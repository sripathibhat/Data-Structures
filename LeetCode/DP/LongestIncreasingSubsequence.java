class Solution {

    // dp state 
    // dp[i] = LIS if nums[i] is included in the subsequence 
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}