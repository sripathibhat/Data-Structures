/*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1.

    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Optimized approach
        // int n = nums2.length;
        // Stack<Integer> st = new Stack<>();
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = n - 1; i >= 0; i--) {
        //     if(st.isEmpty()) {
        //         map.put(nums2[i], -1);
        //     }
        //     else if(st.peek() > nums2[i]) {
        //         map.put(nums2[i], st.peek());
        //     }
        //     else {
        //         while(!st.isEmpty() && st.peek() <= nums2[i]) {
        //             st.pop();
        //         }
        //         if(st.isEmpty()) {
        //             map.put(nums2[i], -1);
        //         } else {
        //             map.put(nums2[i], st.peek());
        //         }
        //     }
        //     st.push(nums2[i]);
        // }
        // int ans[] = new int[nums1.length];
        // for(int i = 0; i < nums1.length; i++) {
        //     ans[i] = map.get(nums1[i]);
        // }
        // return ans;


        int res[] = new int[nums2.length];
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = n - 1; i >= 0; i--) {
            if(st.isEmpty()) {
                res[n - i - 1] = -1;
            }
            else if(st.peek() > nums2[i]) {
                res[n - i - 1] = st.peek();
            }
            else {
                while(!st.isEmpty() && st.peek() <= nums2[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    res[n - i - 1] = -1;
                } else {
                    res[n - i - 1] = st.peek();
                }
            }
            st.push(nums2[i]);
            map.put(nums2[i], i);
        }
        reverse(res);
        int ans[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = res[map.get(nums1[i])];
        }
        return ans;
    }
    
    private void reverse(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}