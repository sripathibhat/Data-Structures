// 4
class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length; // min elements array
        int y = nums2.length;
        int start = 0;
        int end = x;
        while (start <= end) {
            int px = (start + end) / 2;
            int py = (x + y + 1) / 2 - px;
            int maxLeftX = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int minRightX = (px == x) ? Integer.MAX_VALUE : nums1[px];
            int maxLeftY = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];
            int minRightY = (py == y) ? Integer.MAX_VALUE : nums2[py];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Perfect partition, calculate med
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if (maxLeftX < minRightY) {
                start = px + 1;
            }
            else {
                end = px - 1;
            }
        }
        return 0.0;
    }
    
}