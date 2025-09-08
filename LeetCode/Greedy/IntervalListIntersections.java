/**

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. 
For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 

Example 1:

Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0; // pointer for firstList
        int j = 0; // pointer for secondList
        
        while (i < firstList.length && j < secondList.length) {
            // Find the intersection points
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            // If there is an intersection, add it to result
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            // Move the pointer of the interval that ends earlier
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
