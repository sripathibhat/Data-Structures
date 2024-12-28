/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

*/

class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        // brute force - TLE
        // for (int i = 0; i < nums.length; i++) {
        //     int cnt0 = 0;
        //     int cnt1 = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         if (nums[j] == 0) {
        //             cnt0++;
        //         } else {
        //             cnt1++;
        //         }
        //         if (cnt1 == cnt0) {
        //             max = Math.max(max, cnt0 + cnt1);
        //         }
        //     }
        // }

        // Efficient - using Map, store unique sum
        // We make an entry for a count in the map whenever the sum is encountered first, and
        // later on use the corresponding index to find the length of the largest subarray with
        // equal no. of zeros and ones when the same sum is encountered again.
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
