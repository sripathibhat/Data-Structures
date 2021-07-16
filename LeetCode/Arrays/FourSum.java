class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if(j == i + 1 || (j > 0 && nums[j] != nums[j - 1])) {
                        int sum = target - (nums[i] + nums[j]);
                        int low = j + 1;
                        int high = nums.length - 1;
                        while(low < high) {
                            if(nums[low] + nums[high] == sum) {
                                List<Integer> l = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                                list.add(l);
                                while(low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while(low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            }
                            else if(nums[low] + nums[high] > sum) {
                                high--;
                            }
                            else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}