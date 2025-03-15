/*

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23

*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1;
        for (int i: piles) {
            end = Math.max(i, end);
        }
        int k;
        int res = end;
        while (start <= end) {
            k = start + (end - start) / 2;
            if (canFinish(piles, k, h)) {
                res = k;
                end = k - 1;
            } else {
                start = k + 1;
            }
        }
        return res;
    }

    /**
      Check if Koko can finish eating bananas from piles with 'k' speed within 'h' hours.
     */
    private boolean canFinish(int piles[], int k, int h) {
        int totalTime = 0;
        for (int i: piles) {
            totalTime += Math.ceil(i / (double) k);
        }
        return totalTime <= h;
    }
}
