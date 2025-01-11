class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> uniqueIntervals = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            // 3 cases
            // 1 - newInterval is to the left of curInterval
            if (newInterval[1] < curInterval[0]) {
                uniqueIntervals.add(newInterval);
                newInterval = curInterval;
            }
            // 2 - newInterval is to the right of curInterval
            else if(curInterval[1] < newInterval[0]) {
                uniqueIntervals.add(curInterval);
            }
            else {
                // 3 - overlap b/n curInterval and newInterval
                newInterval[0] = Math.min(newInterval[0], curInterval[0]);
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);
            }
        }
        uniqueIntervals.add(newInterval);
        return uniqueIntervals.toArray(new int[uniqueIntervals.size()][]);
        // if(intervals.length == 0) {
        //     int res[][] = new int[1][2];
        //     res[0][0] = newInterval[0];
        //     res[0][1] = newInterval[1];
        //     return res;
        // }
        // List<int[]> uniqueIntervals = new ArrayList();
        // boolean overlap = false;
        // for(int i=0; i<intervals.length; i++) {
        //     int[] curInterval = intervals[i];
        //     if(newInterval[1] >= curInterval[0] && newInterval[0] <= curInterval[1]) {
        //         // overlapping
        //         newInterval[0] = Math.min(newInterval[0], curInterval[0]);
        //         newInterval[1] = Math.max(newInterval[1], curInterval[1]);
        //         overlap = true;
        //     }
        //     else if(overlap) {
        //         uniqueIntervals.add(newInterval);
        //         while(i<intervals.length) {
        //             uniqueIntervals.add(intervals[i]);
        //             i++;
        //         }
        //         break;
        //     }
        //     else {
        //         uniqueIntervals.add(curInterval);
        //     }
        // }
        // if(intervals.length == 1) {
        //     if(uniqueIntervals.size() == 1) {
        //         uniqueIntervals.add(newInterval);
        //     }
        //     else {
        //         if(overlap) {
        //             uniqueIntervals.add(newInterval);
        //         }
        //         else {
        //             uniqueIntervals.add(intervals[0]);
        //         }
        //     }
        // }
        // int[][] res = new int[uniqueIntervals.size()][2];
        // for(int i=0; i<res.length; i++) {
        //     res[i] = uniqueIntervals.get(i);
        // }
        // return res;
    }
}
