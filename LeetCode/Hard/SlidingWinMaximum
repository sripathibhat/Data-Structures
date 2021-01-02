// 239
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<Integer>();
        int i;
        for(i=0;i<k;i++) {
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        int j = 0;
        for(;i<nums.length;i++) {
            res[j++]=nums[q.peek()];
            while(!q.isEmpty() && q.peek()<=i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        res[j]=nums[q.peek()];
        return res;
        
    }
}