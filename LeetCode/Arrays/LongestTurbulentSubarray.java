/*

    Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

    A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

    More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

    For i <= k < j:
    arr[k] > arr[k + 1] when k is odd, and
    arr[k] < arr[k + 1] when k is even.
    Or, for i <= k < j:
    arr[k] > arr[k + 1] when k is even, and
    arr[k] < arr[k + 1] when k is odd.

*/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 0;
        int max = 1;
        while(l + 1 < arr.length) {
            if(arr[l] == arr[l + 1]) {
                l++;
                continue;
            }
            r = l + 1;
            while(r + 1 < arr.length && isTur(arr, r)) {
                r++;
            }
            max = Math.max(r - l + 1, max);
            l = r;
        }
        return max;
    }
    
    private boolean isTur(int arr[], int k) {
        return (arr[k] > arr[k - 1] && arr[k] > arr[k + 1]) || (arr[k] < arr[k - 1] && arr[k] < arr[k + 1]);
    }
}