// 324
class Solution {
    public void wiggleSort(int[] nums) {
        // int temp[] = Arrays.copyOf(nums, nums.length);
        // Arrays.sort(temp);
        // int n = nums.length-1;
        // for(int i=1; i<nums.length; i+=2) {
        //     nums[i] = temp[n--];
        // }
        // for(int i=0; i<nums.length; i+=2) {
        //     nums[i] = temp[n--];
        // }
        
        int n = nums.length;
        int temp[] = Arrays.copyOf(nums, n);
        int mid = n%2 == 0 ? n/2 : n/2+1;
        
        Arrays.sort(temp);
        for(int i=0; i<nums.length; i++) {
            nums[i] = i%2==0 ? temp[--mid] : temp[--n];
        }
        
    }
}