/**
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                l1.add(nums[i] * nums[i]);
            } else {
                l2.add(nums[i] * nums[i]);
            }
        }

        int i = l1.size() - 1;
        int j = 0;
        int k = 0;
        int res[] = new int[nums.length];
        while (i >= 0 && j < l2.size()) {
            res[k++] = l1.get(i) <= l2.get(j) ? l1.get(i--) : l2.get(j++);
        }

        while (i >= 0) {
            res[k++] = l1.get(i--);
        }
        while (j < l2.size()) {
            res[k++] = l2.get(j++);
        }
        return res;
    }
}

