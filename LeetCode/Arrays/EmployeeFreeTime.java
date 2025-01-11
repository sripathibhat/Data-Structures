/*

Given a list of employee work schedules with each employee having a list of non-overlapping intervals representing their working hours, 
we are tasked with finding the common free time for all employees, or in other words, the times when all employees are not working.

The input is a nested list of intervals, each interval as [start, end], with start < end. The intervals are non-overlapping and are already sorted in ascending order.
The output should also be a list of sorted intervals.

For example, consider schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]. Here, Employee 1 works from 1 to 3 and 6 to 7. 
Employee 2 works from 2 to 4 and Employee 3 works from 2 to 5 and 9 to 12. The common free time for all employees is [5,6] and [7,9] as these are the intervals
when all employees are free.

*/

public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        // Flattening the schedule
        for (List<Interval> employee : schedule)
            for (Interval interval : employee)
                intervals.add(interval);
        // Sorting by start of each Interval
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int end = intervals.get(0).end;
        // Checking for free time between intervals
        for (Interval interval : intervals) {
            if (interval.start > end)
                res.add(new Interval(end, interval.start));
            end = Math.max(end, interval.end);
        }
        return res;
    }
}
