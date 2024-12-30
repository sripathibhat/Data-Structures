/*

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Using max heap
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // });
        // for (int i: nums) {
        //     pq.add(i);
        // }
        // int cnt=1;
        // while (cnt < k) {
        //     pq.poll();
        //     cnt++;
        // }
        // return pq.peek();

        // Quick select
        // int left = 0, right = nums.length - 1;
        // Random rand = new Random();
        // while (true) {
        //     int pivot_index = left + rand.nextInt(right - left + 1);
        //     int new_pivot_index = partition(nums, left, right, pivot_index);
        //     if (new_pivot_index == nums.length - k) {
        //         return nums[new_pivot_index];
        //     } else if (new_pivot_index > nums.length - k) {
        //         right = new_pivot_index - 1;
        //     } else {
        //         left = new_pivot_index + 1;
        //     }
        // }

        // Another implementation for quick select
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private int quickSelect(int nums[], int left, int right, int targetIndex) {
        if (left == right) {
            return nums[left];
        }

        int pivot = nums[left];
        int low = left;
        int high = right;

        while (low <= high) {
            while (low <= high && nums[low] < pivot) {
                low++;
            }
            while (low <= high && nums[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }
        if (targetIndex <= high) {
            return quickSelect(nums, left, high, targetIndex);
        } 
        if (targetIndex >= low) {
            return quickSelect(nums, low, right, targetIndex);
        }
        return nums[targetIndex];
    }

    private int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
