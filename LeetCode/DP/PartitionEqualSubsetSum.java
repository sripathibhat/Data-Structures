class Solution {
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int i: nums) {
            tot += i;
        }
        if (tot % 2 != 0) {
            return false;
        }
        // bottom up DP or tabulation method
        // return solve(nums, tot / 2);

        // top down DP or memoization
        int dp[][] = new int[nums.length][tot / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memo(nums, tot / 2, 0, dp);
    }

    private boolean memo(int arr[], int sum, int i, int dp[][]) {
        if (sum == 0) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean chooseArrAtI = false;
        boolean dontChooseArrAtI = false;
        if (arr[i] <= sum) {
            chooseArrAtI = memo(arr, sum - arr[i], i + 1, dp);
            if (!chooseArrAtI) {
                dontChooseArrAtI = memo(arr, sum, i + 1, dp);
            }
        } else {
            dontChooseArrAtI = memo(arr, sum, i + 1, dp);
        }
        dp[i][sum] = chooseArrAtI || dontChooseArrAtI ? 1 : 0;
        return dp[i][sum] == 1;
    }
    
    private boolean solve(int arr[], int sum) {
        int n = arr.length;
        boolean t[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = true;
                } else if (i == 0) {
                    t[i][j] = false;
                } else if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
