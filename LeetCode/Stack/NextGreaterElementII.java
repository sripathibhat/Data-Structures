/*

    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element
    in nums.

    The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search
    circularly to find its next greater number. If it doesn't exist, return -1 for this number.

*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // brute force
        // int res[] = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     int j = (i + 1) % nums.length;
        //     while(j != i && nums[j] <= nums[i]) {
        //         j = (j + 1) % nums.length;
        //     }
        //     if(j == i) {
        //         res[i] = -1;
        //     } else {
        //         res[i] = nums[j];
        //     }
        // }
        // return res;
        
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}