/**

Given an integer array nums, find a 
subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

class Solution {
    public int maxProduct(int[] nums) {
        // int curMax = nums[0];
        // int curMin = nums[0];
        // int finalMax = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     int minWithI = curMin * nums[i];
        //     int maxWithI = curMax * nums[i];
        //     curMax = Math.max(Math.max(maxWithI, minWithI), nums[i]);
        //     curMin = Math.min(Math.min(maxWithI, minWithI), nums[i]);
        //     finalMax = Math.max(curMax, finalMax);
        // }
        // return finalMax;

        // Kadane's algo
        int max = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0) {
                prod = 1;
            }
        }
        return max;
    }
}
