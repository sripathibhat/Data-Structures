/**
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0

*/


// Memoization
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return solve(target, nums, map);
    }

    private int solve(int target, int nums[], Map<Integer, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int count = 0;
        for (int num: nums) {
            if (num <= target) {
                count += solve(target - num, nums, map);
            }
        }
        map.put(target, count);
        return map.get(target);
    }
}

// Memoization - using sorting
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return solve(target, nums, dp);
    }

    private int solve(int target, int nums[], int dp[]) {
        if (dp[target] != -1) {
            return dp[target];
        }
        if (target < nums[0]) {
            return 0;
        }
        int count = 0;
        for (int num: nums) {
            if (num <= target) {
                count += solve(target - num, nums, dp);
            }
        }
        dp[target] = count;
        return dp[target];
    }
}

