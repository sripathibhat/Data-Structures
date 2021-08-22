/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int i = 0;
        for(; i < k; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        int j = 0;
        int res[] = new int[nums.length - k + 1];
        for(; i < nums.length; i++) {
            res[j++] = nums[q.peek()];
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            while(!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }
            q.addLast(i);
        }
        res[j] = nums[q.peek()];
        return res;
    }
}