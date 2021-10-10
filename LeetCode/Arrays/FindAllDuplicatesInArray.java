/*

    Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
    each integer appears once or twice, return an array of all the integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant extra space.

*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // HashSet - Extra space
        // Set<Integer> set = new HashSet<>();;
        // for(int i: nums) {
        //     if(set.contains(i)) {
        //         res.add(i);
        //     } else {
        //         set.add(i);
        //     }
        // }
        
        
        // swap sort - No extra space
        // int i = 0;
        // while(i < nums.length) {
        //     if(nums[nums[i] - 1] != nums[i]) {
        //         swap(nums, i, nums[i] - 1);
        //     } else {
        //         i++;
        //     }
        // }
        // for(i = 0; i < nums.length; i++) {
        //     if(nums[i] != i + 1) {
        //         res.add(nums[i]);
        //     }
        // }

        // Negation logic
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        return res;
    }
    
    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}