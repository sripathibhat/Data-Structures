// 45
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps[] = new int[n];
        if(n==1 && nums[0]==0) {
            return 0;
        }
        if (nums[0] == 0) 
            return Integer.MAX_VALUE;
        // left to right jumps[i] => min # of jumps to reach i from nums[0]
        // for(int i=1;i<n;i++) {
        //     jumps[i] = Integer.MAX_VALUE;
        //     for(int j=0;j<i;j++) {
        //         if(i<=j+nums[j] && jumps[j]!=Integer.MAX_VALUE) {
        //             jumps[i] = Math.min(jumps[i], jumps[j]+1);
        //         }
        //     }
        // }
        // return jumps[n-1];
        
        // right to left jumps[i] => min # of jumps to reach end from i
        jumps[n-1] = 0;
        for(int i=n-2; i>= 0; i--) {
            if(nums[i] == 0) {
                jumps[i] = Integer.MAX_VALUE;
            }
            else if(nums[i] >= n-i-1) {
                jumps[i] = 1;
            }
            else {
                int min = Integer.MAX_VALUE;
                for(int j=i+1; j<n && i + nums[i] >= j; j++) {
                    if(min>jumps[j]) {
                        min = jumps[j];
                    }
                }
                if(min != Integer.MAX_VALUE) {
                    jumps[i] = min + 1;
                } else {
                    jumps[i] = min;
                }
            }
        }
        return jumps[0];
        // recursive solution
        // int res = minJumps(nums,0,nums.length-1);
        // return res;
    }
    
    private int minJumps(int a[], int l, int h) {
        if(h == l) {
            return 0;
        }
        if(a[l] == 0) {
            return Integer.MAX_VALUE; // cant reach end if no of jumps at start index is 0
        }
        int min = Integer.MAX_VALUE;
        for(int i=l+1; i<=h && i<=l+a[l]; i++) {
            int jumps = minJumps(a,i,h);
            if(jumps != Integer.MAX_VALUE && jumps+1 < min) {
                min = jumps+1;
            }
        }
        return min;
    }
}