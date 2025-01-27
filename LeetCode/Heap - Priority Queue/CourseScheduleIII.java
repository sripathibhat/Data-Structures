/**

There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi]
indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.
 

Example 1:

Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
Explanation: 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
Example 2:

Input: courses = [[1,2]]
Output: 1
Example 3:

Input: courses = [[3,2],[4,3]]
Output: 0


*/

class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort based on deadline, complete the ones which have shorter deadline first
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Store the duration of the courses that can be completed in the max heap.
        // If the current course's duration is smaller than the top of max heap, replace it with current course duration.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int timeElapsed = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] + timeElapsed <= courses[i][1]) {
                pq.add(courses[i][0]);
                timeElapsed += courses[i][0];
            } else if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                timeElapsed -= pq.poll();
                pq.add(courses[i][0]);
                timeElapsed += courses[i][0];
            } else {
                // reject the course
            }
        }
        return pq.size();
    }
}
