/**

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7. 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.


Example 2:

Input: arr = [11,81,94,43,3]
Output: 444

*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007;
        
        // Arrays to store the distance to the next and previous smaller element
        int[] left = new int[n];  // Distance to previous smaller element
        int[] right = new int[n]; // Distance to next smaller element
        
        // Stack to maintain indices of elements
        Stack<Integer> stack = new Stack<>();
        
        // Find previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        
        // Clear stack for reuse
        stack.clear();
        
        // Find next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        
        // Calculate final sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long)arr[i] * left[i] * right[i]) % MOD;
        }
        
        return (int)sum;
    }
}
