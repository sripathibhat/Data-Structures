/**

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort based on increasing ending values, if ending values are same, sort based on decreasing start values
        // Arrays.sort(intervals, (a,b) -> a[1] == b[1] ? b[0]-a[0] : a[1]-b[1]);
        // int prevEnd = Integer.MIN_VALUE;
        // int cnt = 0;
        // for(int[] in: intervals) {
        //     if(prevEnd > in[0]) {
        //         cnt++;
        //     }
        //     else {
        //         prevEnd = in[1];
        //     }
        // }
        // return cnt;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int cnt = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                cnt++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }
}
