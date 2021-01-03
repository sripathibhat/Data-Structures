// 312
// TLE for 1 test case
class Solution {
    Map<StringBuilder, Integer> map = new TreeMap<StringBuilder, Integer>();
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int A[] = new int[n];
        A[0] = A[n-1] = 1;
        for(int i=0; i<nums.length; i++) {
            A[i+1] = nums[i];
        }
        return solve(A, 0, n-1);
    }
    
    private int solve(int A[], int l, int r) {
        StringBuilder key = new StringBuilder(l + "|" + r);
        if(!map.containsKey(key)) {
            int max = 0;
            for(int i=l+1; i<r; i++) {
                int score = A[i] * A[l] * A[r];
                StringBuilder lkey = new StringBuilder(l + "_" + i);
                StringBuilder rkey = new StringBuilder(i + "_" + r);
                int left, right;
                if(map.containsKey(lkey)) {
                    left = map.get(lkey);
                }
                else {
                    left = solve(A, l, i);
                    map.put(lkey, left);
                }
                if(map.containsKey(rkey)) {
                    right = map.get(rkey);
                }
                else {
                    right = solve(A, i, r);
                    map.put(rkey, right);
                }
                max = Math.max(max, score + left + right);
            }
            map.put(key, max);
        }
        return map.get(key);
    }
}