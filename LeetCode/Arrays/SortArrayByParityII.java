/*

    Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

    Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

    Return any answer array that satisfies this condition.

*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        while(evenIndex < nums.length && oddIndex < nums.length) {
            while(evenIndex < nums.length && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            while(oddIndex < nums.length && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            if(evenIndex < nums.length && oddIndex < nums.length) {
                if(evenIndex != oddIndex) {
                    int t = nums[evenIndex];
                    nums[evenIndex] = nums[oddIndex];
                    nums[oddIndex] = t;
                }
            }
        }
        return nums;
    }
}