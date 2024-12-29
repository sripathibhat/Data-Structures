/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

*/

class Solution {
    public void moveZeroes(int[] nums) {
        // if (nums.length <= 1) {
        //     return;
        // }
        // int i; 
        // int j = 0;
        // for (i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         nums[j++] = nums[i];
        //     }
        // }
        // while (j < nums.length) {
        //     nums[j++] = 0;
        // }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
