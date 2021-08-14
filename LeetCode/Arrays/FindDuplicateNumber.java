class Solution {
    public int findDuplicate(int[] nums) {
        /* Swap sort technique
            Sort the array such that nums[i] = i + 1
            i.e. [1,3,4,2,2] => 1,2,2,3,4
        */

        // int i = 0;
        // while(i < nums.length) {
        //     if(nums[i] != i + 1) {
        //         int t = nums[nums[i] - 1];
        //         if(t == nums[i]) {
        //             return nums[i];
        //         }
        //         nums[nums[i] - 1] = nums[i];
        //         nums[i] = t;
        //     } else {
        //         i++;
        //     }
        // }
        // return -1;
        
        
        // Negation
        /*
            1,-3,4,2,2
            1,-3,4,-2,2
            1,-3,4,-2,-2
            1,-3,-4,-2,-2
            nums[2] = -4 < 0 => Math.abs(nums[i]) is duplicate
        */
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        return -1;
    }
}