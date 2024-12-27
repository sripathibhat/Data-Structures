/**

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]


*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist == b.dist ? b.ele - a.ele : b.dist - a.dist);
        for (int ele: arr) {
            int dist = Math.abs(ele - x);
            Pair pair = new Pair(dist, ele);
            pq.add(pair);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().ele);
        }
        Collections.sort(res);
        return res;
    }

    class Pair {
        int dist;
        int ele;
        Pair(int dist, int ele) {
            this.dist = dist;
            this.ele = ele;
        }
    }
}
