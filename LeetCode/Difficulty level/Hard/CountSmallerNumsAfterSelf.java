// 315
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
         if(nums.length == 0) {
            return res;
        }
        for(int i=0; i<nums.length-1; i++) {
            int cnt = 0;
            for(int j=i+1; j<nums.length;j++) {
                if(nums[j]<nums[i]) {
                    cnt++;
                }
            }
            res.add(cnt);
        }
        res.add(0);
        return res;
    }
}