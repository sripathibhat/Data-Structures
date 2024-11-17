class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        //Map based solution
//         Map<Integer, Integer> counts = countNums(nums);

//         Map.Entry<Integer, Integer> majorityEntry = null;
//         for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//             if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                 majorityEntry = entry;
//             }
//         }

        // Voting algorithm
        int count = 1, majorityEle = nums[0], i;
        for(i = 1; i < nums.length; i++) {
            if (majorityEle == nums[i]) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    majorityEle = nums[i];
                    count = 1;
                }
            }
        }
        return majorityEle;
        
    }
}

