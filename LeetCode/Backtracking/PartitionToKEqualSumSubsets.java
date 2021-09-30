/*

    Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

*/

// Reference - coding decoded
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i: nums) {
            total += i;
        }
        if(total % k != 0 || nums.length < k) {
            return false;
        }
        int sum = total / k;
        Set<Integer> visited = new HashSet<>();
        return solve(nums, k, sum, 0, 0, visited);
    }
    
    private boolean solve(int nums[], int k, int target, int start, int curSum, Set<Integer> visited) {
        if(k == 0) {
            return true;
        }
        if(curSum > target) {
            return false;
        }
        if(curSum == target) {
            return solve(nums, k - 1, target, 0, 0, visited);
        }
        
        for(int i = start; i < nums.length; i++) {
            if(visited.contains(i)) {
                continue;
            }
            visited.add(i);
            if(solve(nums, k, target, i + 1, curSum + nums[i], visited)) {
                return true;
            }
            visited.remove(i);
        }
        return false;
    }
}