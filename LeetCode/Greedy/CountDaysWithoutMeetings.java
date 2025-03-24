/**

You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). 
You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.

*/

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Brute force - TLE
        // Set<Integer> set = new HashSet();
        // for (int meeting[]: meetings) {
        //     for (int i = meeting[0]; i <= meeting[1]; i++) {
        //         set.add(i);
        //     }
        // }
        // return days - set.size();

        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int meeting[]: meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);
        }
        freeDays += days - latestEnd;
        return freeDays;
    }
}
