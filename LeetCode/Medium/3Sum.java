// 15
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        // working solution - but includes duplicates as well - O(n3)
        // if(nums.length<3) {
        //     return l;
        // }
        // for(int i=0;i<nums.length-2;i++) {
        //     for(int j=i+1;j<nums.length-1;j++) {
        //         for(int k=j+1;k<nums.length;k++) {
        //             List<Integer> sl = new ArrayList<>();
        //             if(nums[i] + nums[j] + nums[k] == 0) {
        //                 sl.add(nums[i]);
        //                 sl.add(nums[j]);
        //                 sl.add(nums[k]);
        //                 if(!l.containsAll(sl)) {
        //                     l.add(sl);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return l;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int sum = 0 - nums[i];
                int low=i+1,high=nums.length-1;
                while(low<high) {
                    if(nums[low] + nums[high] == sum) {
                        l.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return l;
    }
}