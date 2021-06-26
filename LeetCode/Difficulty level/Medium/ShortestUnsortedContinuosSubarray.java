// 581
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // if(nums.length==1) {
        //     return 0;
        // }
        // int minIndex = Integer.MAX_VALUE, range=0;
        // for(int i=0; i<nums.length-1; i++) {
        //     if(nums[i+1] < nums[i]) {
        //         // unsorted
        //         minIndex = Math.min(minIndex, i);
        //         range = i+1-minIndex+1;
        //     } else if(nums[i+1] == nums[i] && minIndex < i) {
        //         range = nums[i] < nums[minIndex] ? i+1-minIndex+1: range;
        //     }
        // }
        // return range;
        
        // sorting and copying
//         int l = nums.length, r = 0;
//         int snums[] = nums.clone();
//         Arrays.sort(snums);
//         for (int i = 0; i < nums.length; i++) {
            
//             if (nums[i] != snums[i]) {
//                 r = Math.max(r, i);
//                 l = Math.min(l, i);
//             }
            
//         }
//         return r - l < 0 ? 0 : r - l + 1;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
