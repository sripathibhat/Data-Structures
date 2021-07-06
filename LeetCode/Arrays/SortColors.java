class Solution {
    // Dutch national flag algorithm
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while(left < right && i <= right) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            }
            else if(nums[i] == 1) {
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
        }
    }
    
    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}