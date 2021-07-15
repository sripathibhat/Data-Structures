class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 2; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}