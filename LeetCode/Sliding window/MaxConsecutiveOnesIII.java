class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int  i = 0, j = 0;
        int zeroCnt = 0;
        boolean onePresent = false;
        while(j < nums.length) {
            if(nums[j] == 0) {
                zeroCnt++;
                if(zeroCnt > k) {
                    max = Math.max(max, j - i);
                    while(nums[i] == 1) {
                        i++;
                    }
                    zeroCnt--;
                    i++;
                    
                }
            }
            else {
                onePresent = true;
            }
            j++;
        }
        return max == 0 && onePresent ? nums.length : Math.max(max, j - i);
    }
}