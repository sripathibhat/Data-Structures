/**

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.


Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        while (j < n) {
            sum += nums[j];
            while (sum >= s && i <= j) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
