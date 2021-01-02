// 1470
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            res[i] = i%2==0 ? nums[i/2] : nums[n+i/2];
        }
        return res;
    }
}