// 128
class Solution {
    public int longestConsecutive(int[] nums) {
        // O(nlogn)
        // Arrays.sort(nums);
        // if(nums.length == 0) {
        //     return 0;
        // }
        // int max = 1;
        // int cmax = 1;
        // for(int i=0; i<nums.length-1; i++) {
        //     if(nums[i+1] == nums[i]+1) {
        //         cmax++;
        //         max = Math.max(max, cmax);
        //     } else if(nums[i+1] != nums[i]) {
        //         cmax = 1;
        //     }
        // }
        // return max;
        
        // O(n) solution
        int max = 0, cmax = 0;
        HashSet<Integer> s = new HashSet();
        for(int i: nums) {
            s.add(i);
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!s.contains(nums[i]-1)) {
                cmax = 1;
                int k = 1;
                while(s.contains(nums[i] + k)) {
                    cmax++;
                    k++;
                }
                max = Math.max(cmax, max);
            }
        }
        
        return max;
    }
}