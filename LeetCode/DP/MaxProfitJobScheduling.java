/**

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no
two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Example 2:

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

Example 3:

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6

**/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList();
        for (int i = 0; i < n; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        // Sort by end time
        Collections.sort(jobs, (a, b) -> a.end - b.end);
        // dp[i] = max profit considering jobs 0..i
        int dp[] = new int[n];
        // Base case - take the first job
        dp[0] = jobs.get(0).profit;
        for (int i = 1; i < n; i++) {
            int skipProfit = dp[i - 1];
            int takeProfit = jobs.get(i).profit;
            int lastNonConflictingIndex = binarySearch(jobs, i, jobs.get(i).start);
            if (lastNonConflictingIndex != -1) {
                takeProfit += dp[lastNonConflictingIndex];
            }

            dp[i] = Math.max(skipProfit, takeProfit);
        }
        return dp[n - 1];
    }

    /**
        Binary search: find the latest job index whose end time <= targetStart
        Returns -1 if no such job exists
     */
    private int binarySearch(List<Job> jobs, int curIndex, int targetStartTime) {
        int low = 0;
        int high = curIndex - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs.get(mid).end <= targetStartTime) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private class Job {
        private int start;
        private int end;
        private int profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
}
