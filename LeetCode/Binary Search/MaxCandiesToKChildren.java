/*

You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. 
You can divide each pile into any number of sub piles, but you cannot merge two piles together.

You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies.
Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.

Return the maximum number of candies each child can get.

Example 1:

Input: candies = [5,8,6], k = 3
Output: 5
Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five 
piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
Example 2:

Input: candies = [2,5], k = 11
Output: 0
Explanation: There are 11 children but only 7 candies in total, so it is impossible to ensure each child receives at least one candy.
Thus, each child gets no candy and the answer is 0.

*/

class Solution {
    public int maximumCandies(int[] candies, long k) {
        // Find the maximum number of candies in any pile
        long sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }

        // Set the initial search range for binary search
        long left = 1;
        long right = sum / k;
        long result = 0;

        // Binary search to find the maximum number of candies each child can get
        while (left <= right) {
            // Calculate the middle value of the current range
            long middle = (left + right) / 2;

            // Check if it's possible to allocate candies so that each child gets 'middle' candies
            if (canAllocateCandies(candies, k, middle)) {
                // If possible, move to the upper half to search for a larger number
                left = middle + 1;
                result = middle;
            } else {
                // Otherwise, move to the lower half
                right = middle - 1;
            }
        }
        return (int) result;
    }

    private boolean canAllocateCandies(int[] candies, long k, long numOfCandies) {
        // Initialize the total number of children that can be served
        long maxNumOfChildren = 0;
        if (numOfCandies <= 0) {
            return false;
        }

        // Iterate over all piles to calculate how many children each pile can serve
        for (int pileIndex = 0; pileIndex < candies.length; pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }
}
