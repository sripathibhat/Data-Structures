/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

*/

class Solution {
    public int search(int[] nums, int target) {
        // for(int i=0;i<nums.length;i++) {
        //     if(target == nums[i]) return i;
        // }
        // return -1; // Linear search worked fine
        int start = 0;
        int end = nums.length - 1;
        int prev, next, mid, minIndex = 0;
        while (start <= end) {
            if (nums[start] <= nums[end]) {
                minIndex = start;
                break;
            }
            mid = (start + end) / 2;
            prev = (mid + nums.length - 1) % nums.length;
            next = (mid + 1) % nums.length;
            // System.out.println(prev + " " + next);
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                minIndex = mid;
                break;
            } 
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // System.out.println(minIndex);
        int res = binarySearch(nums, 0, minIndex - 1, target);
        if (res == -1) {
            res = binarySearch(nums, minIndex, nums.length - 1, target);
        }
        return res;
    }
    
    private int binarySearch(int a[], int start, int end, int ele) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == ele) {
                return mid;
            } else if (a[mid] < ele) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

