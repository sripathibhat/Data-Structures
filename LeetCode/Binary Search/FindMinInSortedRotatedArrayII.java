/*

    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    For example, the array nums = [0,1,4,4,5,6,7] might become:

    [4,5,6,7,0,1,4] if it was rotated 4 times.
    [0,1,4,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
    [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

    You must decrease the overall operation steps as much as possible.

*/

class Solution {
    public int findMin(int[] nums) {
        // brute force
        // int min = nums[0];
        // for(int i = 1; i < nums.length; i++) {
        //     min = Math.min(min, nums[i]);
        // }
        // return min;
        
        int l = 0; 
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[r] == nums[mid]) {
                r = r - 1;
            } else if(nums[r] > nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}