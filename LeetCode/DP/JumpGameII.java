class Solution {
    public int jump(int[] nums) {
        // Not efficient
        /*
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
        */
        
        // Efficient
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 0;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            else if(nums[i] >= nums.length - i - 1) {
                dp[i] = 1;
            }
            else {
                int min = Integer.MAX_VALUE;
                for(int j = i + 1; j < nums.length && i + nums[i] >= j; j++) {
                    if(dp[j] < min) {
                        min = dp[j];
                    }
                }
                dp[i] = min != Integer.MAX_VALUE ? min + 1 : min;
            }
        }
        return dp[0];
    }
}