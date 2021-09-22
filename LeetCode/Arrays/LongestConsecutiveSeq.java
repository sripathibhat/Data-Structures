/*

    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        
        // Sorting based sol - O(nlogn)
        // int max = 1;
        // Arrays.sort(nums);
        // int cnt = 1;
        // for(int i = 1; i < nums.length; i++) {
        //     if(nums[i] == nums[i - 1] + 1) {
        //         cnt++;
        //     } else if(nums[i] != nums[i - 1]) {
        //         cnt = 1;
        //     }
        //     max = Math.max(max, cnt);
        // }
        // return max;
        
        
        // TreeSet based sol
        // Set<Integer> set = new TreeSet<>();
        // for(int i: nums) {
        //     set.add(i);
        // }
        // int cnt = 0;
        // int max = 0;
        // Integer prev = null;
        // for(Integer entry: set) {
        //     Integer key = entry;
        //     if(prev == null) {
        //         cnt = 1;
        //         max = 1;
        //     } else if(key == prev + 1) {
        //         cnt++;
        //     } else {
        //         cnt = 1;
        //     }
        //     prev = key;
        //     max = Math.max(max, cnt);
        // }
        // return max;
        
        
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        int max = 0;
        for(int i: nums) {
            int cnt = 1;
            int left = i;
            int right = i;
            while(set.contains(left - 1)) {
                cnt++;
                set.remove(left - 1);
                left--;
            }
            while(set.contains(right + 1)) {
                cnt++;
                set.remove(right + 1);
                right++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}