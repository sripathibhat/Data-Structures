// Fisher Yates algorithm
class Solution {

    int arr[];
    int shuffle[];
    Random random;
    public Solution(int[] nums) {
        arr = new int[nums.length];
        shuffle = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            shuffle[i] = nums[i];
        }
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = shuffle.length - 1; i > 0; i--) {
            int r = random.nextInt(i + 1);
            int t = shuffle[i];
            shuffle[i] = shuffle[r];
            shuffle[r] = t;
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */