// 41
class Solution {
    public int firstMissingPositive(int[] nums) {
        // if(nums.length==0) return 1;
        // HashSet<Integer> s = new HashSet<>();
        // s.add(nums[0]);
        // for(int i=1;i<nums.length;i++) {
        //     //max = Math.max(nums[i],max);
        //     s.add(nums[i]);
        // }
        // //System.out.println(Integer.MAX_VALUE);
        // // if(max<=0) {
        // //     return 1;
        // // }
        // //if(max==Integer.MAX_VALUE) max = max-1;
        // for(int i=1;i<=302;i++) {
        //     if(!s.contains(i)) {
        //         return i;
        //     }
        // }
        // return 1;
        
        // swap sort
        int i=0;
        while(i<nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }
        boolean positive = false;
        for(i=0; i<nums.length; i++) {
            if(!positive && nums[i] > 0) 
                positive = true;
            if(nums[i] != i+1) 
                return i+1;
            
        }
        return positive ? nums.length+1 : 1;
    }
}