/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // permutations code
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sl = new ArrayList<>();
        helper(nums, 0, sl, res);
        return res;
    }
    
    private void helper(int nums[],  int l, List<Integer> sl, List<List<Integer>> res) {
        if(l == nums.length) {
            res.add(new ArrayList<>(sl));
        }
        else {
            for(int i = l; i <= nums.length-1; i++) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                
                sl.add(nums[l]);
                
                helper(nums, l+1, sl, res);
                
                sl.remove(new Integer(nums[l]));
                t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
            }
        }
    }
}